package lab5pt2;

public class ApostaSeguraValor extends ApostaAssegurada {

	private int valorSeguro;

	/**
	 * Construtor da classe, recebe o nome do apostador, valor da aposta, previsao
	 * pra aposta, além disso recebe o valor do seguro no caso de perder a aposta,
	 * esse valor será subtraído do caixa do Sistema e devolvido ao apostador, e o
	 * custo do seguro que é o preço do seguro pago pelo apostador.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor apostado
	 * @param previsao
	 *            Previsao para a aposta
	 * @param valorSeguro
	 *            Valor pago pelo seguro ao jogador no caso de perder a aposta
	 * @param custoSeguro
	 *            Custo do seguro
	 */
	public ApostaSeguraValor(String apostador, int valor, String previsao, int valorSeguro, int custoSeguro) {
		super(apostador, valor, previsao, custoSeguro);
		this.valorSeguro = super.valida.valorSeguroAposta(valorSeguro);
	}

	/**
	 * @return Retorna o valor do Seguro da aposta
	 */
	public int getValorSeguro() {
		return valorSeguro;
	}

	/**
	 * Representação textual da aposta assegurada por valor, se apresenta no
	 * seguinte formato: NOME - VALOR - PREVISÃO - ASSEGURADA (VALOR) - VALOR DO SEGURO
	 */
	@Override
	public String toString() {
		double aux = (double) valorSeguro / 100.0;
		return super.toString() + "(VALOR) - R$" + String.format("%1$,.2f", aux);
	}
}
