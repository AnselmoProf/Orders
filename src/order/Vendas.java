package order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vendas {
	
	List<Pedidos> pedidos = new ArrayList<>();
	
	public void criaPedido() throws ParseException {
		
		//Produto: informações sobre o produto (nome, categoria, peso, preço, data de criação, ...)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  date0 = format.parse ("2021-11-25 10:00:00");
		Date  date1 = format.parse ("2021-10-24 10:00:00");
		Date  date2 = format.parse ("2021-07-25 10:00:00");
		Date  date3 = format.parse ("2021-05-25 10:00:00");
		Date  date4 = format.parse ("2021-01-25 10:00:00");
		
		
		Produto p1 = new Produto("aaaa", 5, 500, date1);
		Produto p2= new Produto("bbbb", 10, 100, date2);
		Produto p3 = new Produto("ccccc", 15, 150, date3);
		Produto p4 = new Produto("dddd", 20, 2000, date4);
		Produto p5 = new Produto("eeee", 20, 2000, date0);
		
		//Item: informações sobre o item comprado (custo, taxa de envio, valor do imposto, ...)
		Item item1 = new Item(10, 3.5, 12, p4);
		Item item2 = new Item(300, 0, 0, p1);
		Item item3 = new Item(0, 54, 0, p2);
		Item item4 = new Item(0, 0, 6, p3);
		Item item5 = new Item(23, 0, 23, p5);
		
		
		//contém informações gerais sobre o pedido (nome e contato do cliente, endereço de entrega, total geral, data em que o pedido foi feito, ...)
		Pedidos pedidos1 = new Pedidos("Antonio", 0, "Lisboa", 0, date1);
		Pedidos pedidos2 = new Pedidos("Joao", 0, "Porto", 0, date1);
		Pedidos pedidos3 = new Pedidos("Manuel", 0, "Braga", 0, date2);
		Pedidos pedidos4 = new Pedidos("Gilberto", 0, null, 0, date3);
		Pedidos pedidos5 = new Pedidos("Ferreira", 0, null, 0, date4);
		
		pedidos1.addItem(item1);
		pedidos1.addItem(item2);
		pedidos1.addItem(item3);
		pedidos1.addItem(item5);
		
		pedidos2.addItem(item1);
		pedidos2.addItem(item2);
		pedidos2.addItem(item3);
		pedidos2.addItem(item4);
		
		pedidos3.addItem(item1);
		pedidos3.addItem(item2);
		pedidos3.addItem(item3);
		pedidos3.addItem(item5);
		
		pedidos4.addItem(item1);
		pedidos4.addItem(item2);
		pedidos4.addItem(item3);
		pedidos4.addItem(item5);
		
		pedidos5.addItem(item1);
		pedidos5.addItem(item2);
		pedidos5.addItem(item5);
		pedidos5.addItem(item4);
		
		pedidos.add(pedidos1);
		pedidos.add(pedidos2);
		pedidos.add(pedidos3);
		pedidos.add(pedidos4);
		pedidos.add(pedidos5);
		
	}
	
	public void pesquisarVendas(Date date1, Date date2) throws InterruptedException {
		
		List<Pedidos> dateFiltrados = new ArrayList<>();
		
		for(Pedidos p: pedidos) {
			if(p.getDataPedido().after(date1) && p.getDataPedido().before(date2)) {
				dateFiltrados.add(p);
			}
		}
		
		/*
		 *  Exemplo; $ java -jar orders.jar "2018-01-01 00:00:00" "2021-11-25 17:48:00"
		 * Resultado: 
		 * 1-3 meses: 200 pedidos 
		 * 4-6 meses: 150 pedidos 
		 * 7-12 meses: 50 pedidos 
		 * > 12 meses: 20 pedidos
		 */
		
		Date date1m = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		Date date3m = Date.from(ZonedDateTime.now().minusMonths(4).toInstant());
		IntervaloThread t13m = new IntervaloThread(dateFiltrados, date3m, date1m);
		t13m.start();
	
		Date date4m = Date.from(ZonedDateTime.now().minusMonths(4).toInstant());
		Date date6m = Date.from(ZonedDateTime.now().minusMonths(7).toInstant());
		IntervaloThread t46m = new IntervaloThread(dateFiltrados, date6m,date4m);
		t46m.start();
		
		Date date7m = Date.from(ZonedDateTime.now().minusMonths(7).toInstant());
		Date date12m = Date.from(ZonedDateTime.now().minusMonths(12).toInstant());
		IntervaloThread t712m = new IntervaloThread(dateFiltrados, date12m,date7m);
		t712m.start();
		
		IntervaloThread t12m = new IntervaloThread(dateFiltrados, null, date12m);
		t12m.start();
		
		t13m.join();
		t46m.join();
		t712m.join();
		t12m.join();
 		
		System.out.println("Resultado: ");
		System.out.println("1-3 meses: "+t13m.getContador()+" pedidos");
		System.out.println("4-6 meses: "+t46m.getContador()+" pedidos");
		System.out.println("7-12 meses: "+t712m.getContador()+" pedidos");
		System.out.println("> 12 meses: "+t12m.getContador()+" pedidos");
		
	}
	
	
	 public static void main(String[] args) throws ParseException, InterruptedException {

		 Vendas vendas = new Vendas();
		 vendas.criaPedido();
		 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date  date1 = format.parse ( args[0] );
		 Date  date2 = format.parse ( args[1] );
		 
		 vendas.pesquisarVendas(date1,date2);
				 
	}
	 
}
