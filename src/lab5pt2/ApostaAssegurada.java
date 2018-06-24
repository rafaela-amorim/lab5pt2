package lab5pt2;

public abstract class ApostaAssegurada extends Aposta {

	private int custoSeguro;

	/**
	 * Construtor da classe, recebe nome do apostador, valor apostado, previsao da
	 * aposta, e além disso recebe o custo do seguro que é o preço pago pelo
	 * apostador pelo seguro da aposta, esse dinheiro será direcionado ao caixa do
	 * sistema.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor apostado
	 * @param previsao
	 *            Previsão da aposta
	 * @param custoSeguro
	 *            Preço do Seguro da aposta
	 */
	public ApostaAssegurada(String apostador, int valor, String previsao, int custoSeguro) {
		super(apostador, valor, previsao);
		this.custoSeguro = super.valida.custoAposta(custoSeguro);
	}

	/**
	 * @return o valor do custo do seguro da Aposta Assegurada.
	 */
	public int getCustoSeguro() {
		return custoSeguro;
	}

	/**
	 * Representação textual da Aposta Assegurada, incompleta nessa forma.
	 */
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA ";
	}
}