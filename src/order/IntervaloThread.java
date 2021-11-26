package order;

import java.util.Date;
import java.util.List;

public class IntervaloThread extends Thread{

	private List<Pedidos> pedidos;
	private int contador =0;
	private Date date1 ;
	private Date date2 ;
	
	
	
	IntervaloThread(List<Pedidos> pedidos, Date date1, Date date2 ){
		
		this.pedidos = pedidos;
		this.date1 = date1;
		this.date2 = date2;
		
		//System.out.println("Date1 " +date1);
		//System.out.println("Date2 " +date2);
		
	}

	public int getContador() {
		return contador;
	}



	@Override
	public void run() {
		
		for(Pedidos p: pedidos) {
			for(Item it: p.getItens()) {
				if(it.getProduto().getDataCricaoProduto().before(date2)) {
					System.out.println("items "+it.getProduto().getDataCricaoProduto());
					if( date1 == null || it.getProduto().getDataCricaoProduto().after(date1)) {
						contador ++;
						break;
					}
				}
				
			}
		}
	}
	

}
