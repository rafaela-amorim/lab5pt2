package lab5pt2;

public class SeguroValor extends Seguro {
	
	private int valor;
	
	public SeguroValor(int valor) {
		super();
		this.valor = valor;
	}
	
	@Override
	public int getValorSeguro() {
		return valor;
	}
	
	@Override
	public String toString() {
		double aux = (double) valor / 100.0;
		return " - ASSEGURADA (VALOR) - R$" + String.format("%1$,.2f", aux);
	}
}
