package lab5pt2;

public class SeguroTaxa extends Seguro {
	
	private int valorAposta;
	private double taxa;
	
	public SeguroTaxa(int valorAposta, double taxa) {
		super();
		this.valorAposta = valorAposta;
		this.taxa = taxa;
	}
	
	@Override
	public int getValorSeguro() {
		return (int) (valorAposta * taxa);
	} 
	
	public String toString() {
		int aux = (int) (taxa * 100);
		return " - ASSEGURADA (TAXA) - " + String.format("%d%%", aux);
	}
}
