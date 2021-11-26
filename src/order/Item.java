package order;

//Item: informações sobre o item comprado (custo, taxa de envio, valor do imposto, ...)
public class Item {
	
	private double custo;
	private double taxaEnvio;
	private double valorImposto;
	private Produto produto;
	
	Item(double custo, double taxaEnvio, double valorImposto, Produto produto){
		this.produto = produto;
		this.custo = custo;
		this.taxaEnvio = taxaEnvio;
		this.valorImposto = valorImposto;
		
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public double getTaxaEnvio() {
		return taxaEnvio;
	}

	public void setTaxaEnvio(double taxaEnvio) {
		this.taxaEnvio = taxaEnvio;
	}

	public double getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(double valorImposto) {
		this.valorImposto = valorImposto;
	}

	public Produto getProduto() {
		return produto;
	}

	
}
