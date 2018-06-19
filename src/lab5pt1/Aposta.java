package lab5pt1;

public class Aposta {

	// Atributos
	private String nomeApostador;

	private int valor;

	private String previsao;
	
	private Validador valida;

	// Construtor

	/**
	 * Construtor da classe, recebe o número do cenário, o nome do apostador, o
	 * valor e a previsão da aposta.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário que será apostado.
	 * @param nomeApostador
	 *            Nome do apostador.
	 * @param valor
	 *            Valor a ser apostado.
	 * @param previsao
	 *            Previsão da aposta, se vai acontecer ou não.
	 */
	public Aposta(String nomeApostador, int valor, String previsao) {
		this.nomeApostador = valida.nomeApostador(nomeApostador);
		this.valor = valida.valorAposta(valor);
		this.previsao = valida.previsaoAposta(previsao);
	}

	// Métodos

	/**
	 * Retorna o nome do apostador.
	 * 
	 * @return nome do apostador
	 */
	public String getNomeApostador() {
		return nomeApostador;
	}

	/**
	 * Retorna o valor da aposta.
	 * 
	 * @return Valor da aposta.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Retorna a previsão da aposta.
	 * 
	 * @return Previsão da aposta
	 */
	public String getPrevisao() {
		return previsao;
	}

	/**
	 * Retorna a representação textual da aposta, no seguinte formato: NOME
	 * APOSTADOR - R$ VALOR,00 - PREVISÃO
	 */
	@Override
	public String toString() {
		return nomeApostador + " - " + "R$" + (valor / 100) + ",00" + " - " + previsao;
	}

}
