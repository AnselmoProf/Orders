package order;

import java.util.Date;

//Produto: informações sobre o produto (nome, categoria, peso, preço, data de criação, ...)
public class Produto {
	
	private String nomeProduto;
	private double peso;
	private double preco;
	private Date dataCricaoProduto;
	
	public Produto(String nomeProduto, double peso, double preco, Date dataCricaoProduto) {
		
		this.nomeProduto = nomeProduto;
		
		this.peso = peso;
		this.preco = preco;
		this.dataCricaoProduto = dataCricaoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getDataCricaoProduto() {
		return dataCricaoProduto;
	}

	public void setDataCricaoProduto(Date dataCricaoProduto) {
		this.dataCricaoProduto = dataCricaoProduto;
	}

}
