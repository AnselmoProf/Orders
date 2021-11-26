package order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//contém informações gerais sobre o pedido (nome e contato do cliente, endereço de entrega, total geral, data em que o pedido foi feito, ...)
public class Pedidos {
	
	private String nome;
	private long contacto;
	private String endereco;
	private int totalPago = 0;
	private Date dataPedido;
	private List<Item> itens =  new ArrayList<>();
	
	public Pedidos(String nome,long contacto,String endereco,int totalPago,Date dataPedido) {
		
		this.nome = nome;
		this.contacto = contacto;
		this.endereco = endereco;
		this.totalPago = totalPago;
		this.dataPedido = dataPedido;
		
	}
	
	public void addItem(Item item) {
		
		itens.add(item);
	}
	
	public  String getNome() {
		return nome;
	}

	public  void setNome(String nome) {
		this.nome = nome;
	}

	public  long getContacto() {
		return contacto;
	}

	public  void setContacto(long contacto) {
		this.contacto = contacto;
	}

	public  String getEndereco() {
		return endereco;
	}

	public  void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public  Date getDataPedido() {
		return dataPedido;
	}

	public  void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Item> getItens() {
		return itens;
	}

	public int getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(int totalPago) {
		this.totalPago = totalPago;
	}

}
