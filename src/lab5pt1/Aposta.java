package lab5pt1;

public class Aposta {

	// Atributos
	private String nomeApostador;

	private int cenario;

	private int valor;

	private String previsao;

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
	public Aposta(int cenario, String nomeApostador, int valor, String previsao) {
		if (nomeApostador == null || previsao == null) {
			throw new NullPointerException();
		}

		if (nomeApostador.trim().length() == 0) {
			throw new IllegalArgumentException();
		}

		if (previsao.trim().length() == 0) {
			throw new IllegalArgumentException();
		}

		this.cenario = cenario;
		this.nomeApostador = nomeApostador;
		this.valor = valor;
		this.previsao = previsao;
	}

	// Métodos
	public String getNomeApostador() {
		return nomeApostador;
	}

	public int getCenario() {
		return cenario;
	}

	public int getValor() {
		return valor;
	}

	public String getPrevisao() {
		return previsao;
	}

	@Override
	public String toString() {
		return nomeApostador + " - " + "R$" + valor + ",00" + " - " + previsao;
	}

}
