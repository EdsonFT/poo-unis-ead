
public class Guitarra {
	
	private String numeroSerie, fabricante, modelo, tipo, madeira;
	private double preco;
	  
	  public Guitarra( String numeroSerie, String fabricante, String modelo, String tipo,String madeira, double preco) {
	    this.numeroSerie = numeroSerie;
	    this.fabricante = fabricante;
	    this.modelo = modelo;
	    this.tipo = tipo;
	    this.madeira = madeira;
	    this.preco = preco;
	   }

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public String getMadeira() {
		return madeira;
	}

	public double getPreco() {
		return preco;
	}
}
