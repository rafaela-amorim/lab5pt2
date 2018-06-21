package lab5pt1;

public class CenarioBonus extends Cenario{
	
	private int bonus;
	
	public CenarioBonus(String descricao, double porcentagem, int bonus) {
		super(descricao, porcentagem);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {
		double aux = bonus / 100.0;
		return super.toString() + " - R$" + String.format("%1$,.2f", aux);
	}
}
