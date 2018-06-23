package lab5pt2;

public class CenarioBonus extends Cenario {

	private int bonus;

	/**
	 * Construtor da classe, recebe a descrição do cenário, a porcentagem que é a
	 * taxa usada para calcular o dinheiro do caixa do Sistema quando as apostas
	 * forem fechadas, e o bônus que é o dinheiro distribuído pelo Sistema aos
	 * vencedores da aposta.
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @param porcentagem
	 *            Porcentagem direcionada ao caixa do Sistema
	 * @param bonus
	 *            Bônus de dinheiro somado ao rateio para os vencedores da aposta.
	 */
	public CenarioBonus(String descricao, double porcentagem, int bonus) {
		super(descricao, porcentagem);
		this.bonus = super.valida.bonusCenario(bonus);
	}

	/**
	 * @return Retorna o bônus do cenário
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * Calcula o rateio que é o valor que será distribuído entre os vencedores da
	 * aposta, esse valor só pode ser calculado após as apostas terem sido fechadas.
	 * O rateio é o caixa dos perdedores menos a porcentagem desse valor que vai
	 * para o sistema mais o bônus do cenário.
	 * 
	 * Se as apostas não tiverem sido fechadas ainda, retorna 0.
	 */
	@Override
	public int calculaRateio() {
		if (super.calculaRateio() != 0) {
			return super.calculaRateio() + bonus;
		}
		return 0;
	}

	/**
	 * Representação textual do cenário, se apresenta no seguinte formato: NUMERAÇÃO
	 * - DESCRIÇÃO - ESTADO - BÔNUS
	 */
	@Override
	public String toString() {
		double aux = bonus / 100.0;
		return super.toString() + " - R$" + String.format("%1$,.2f", aux);
	}
}
