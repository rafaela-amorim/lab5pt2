package lab5pt2;

public class ApostaSeguraTaxa extends ApostaAssegurada {
	private double taxaSeguro;

	/**
	 * Construtor da classe, recebe o nome do apostador, valor da aposta, previsao
	 * pra aposta, além disso recebe a taxa que será calculada em cima do valor
	 * apostado e será devolvido ao jogador no caso de perder a aposta, e recebe o
	 * custo do seguro que é o preço do seguro pago pelo apostador.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor apostado
	 * @param previsao
	 *            Previsao para a aposta
	 * @param taxaSeguro
	 *            Taxa do seguro no caso de perder a aposta
	 * @param custoSeguro
	 *            Preço do seguro
	 */
	public ApostaSeguraTaxa(String apostador, int valor, String previsao, double taxaSeguro, int custoSeguro) {
		super(apostador, valor, previsao, custoSeguro);
		this.taxaSeguro = super.valida.taxaSeguroAposta(taxaSeguro);
	}

	/**
	 * @return Retorna a taxa da Aposta Assegurada.
	 */
	public double getTaxaSeguro() {
		return taxaSeguro;
	}

	/**
	 * Representação textual da aposta assegurada por taxa, se apresenta no seguinte
	 * formato: NOME - VALOR - PREVISÃO - ASSEGURADA (TAXA) - TAXA DO SEGURO
	 */
	@Override
	public String toString() {
		return super.toString() + "(TAXA) - " + String.format("%2.2f", taxaSeguro) + "%";
	}
}
