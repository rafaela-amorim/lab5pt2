package lab5pt2;

public abstract class ApostaAssegurada extends Aposta {
	
	private int custoSeguro;
	private static int index;
	
	public ApostaAssegurada(String apostador, int valor, String previsao, int custoSeguro) {
		super(apostador, valor, previsao);
		this.custoSeguro = super.valida.custoAposta(custoSeguro);
		index = 1; //?
	}
	
	/**
	 * @return o valor do custo do seguro da Aposta Assegurada.
	 */
	public int getCustoSeguro() {
		return custoSeguro;
	}
	
	/**
	 * @return Retorna o índice da Aposta Assegurada em uso.
	 */
	public static int getIndex() {
		return index;
	}
	
	/**
	 * Representação textual da Aposta Assegurada, incompleta nessa forma.
	 */
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA ";
	}
}