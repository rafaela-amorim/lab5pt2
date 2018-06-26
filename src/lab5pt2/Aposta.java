package lab5pt2;

public class Aposta {

	// Atributos
	private String nomeApostador;

	private int valor;

	private String previsao;

	protected Validador valida;

	private Seguro seguro;

	// Construtores

	/**
	 * Construtor da classe, recebe o número do cenário, o nome do apostador, o
	 * valor e a previsão da aposta.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário que será apostado.
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor a ser apostado.
	 * @param previsao
	 *            Previsão da aposta, se vai acontecer ou não.
	 */
	public Aposta(String nome, int valor, String previsao) {
		valida = new Validador();

		try {
			this.nomeApostador = valida.nomeApostador(nome);
			this.valor = valida.valorAposta(valor);
			this.previsao = valida.previsaoAposta(previsao);
			seguro = new SemSeguro();
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de aposta: " + n);
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + i);
		}
	}

	/**
	 * Constrói a Aposta com seguro, recebe um valor, em centavos, do seguro.
	 * 
	 * @param nome
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta;
	 * @param valorSeguro
	 *            Valor do seguro da aposta.
	 */
	public Aposta(String nome, int valor, String previsao, int valorSeguro) {
		this(nome, valor, previsao);
		try {
			seguro = new SeguroValor(valida.valorSeguroAposta(valorSeguro));
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: " + n);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: " + e);
		}
	}

	/**
	 * Constrói a Aposta com seguro, recebe um double que será a taxa para o cálculo
	 * do valor do seguro da aposta.
	 * 
	 * @param nome
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta;
	 * @param taxaSeguro
	 *            Taxa do seguro da aposta.
	 */
	public Aposta(String nome, int valor, String previsao, double taxaSeguro) {
		this(nome, valor, previsao);
		try {
			seguro = new SeguroTaxa(valor, taxaSeguro);
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + n);
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + i);
		}
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
	 * Retorna o valor do Seguro.
	 * 
	 * @return valor do seguro.
	 */
	public int getValorSeguro() {
		return seguro.getValorSeguro();
	}

	/**
	 * Retorna a representação textual da aposta.
	 */
	@Override
	public String toString() {
		double aux = (double) valor / 100.0;
		return nomeApostador + " - " + "R$" + String.format("%1$,.2f", aux) + " - " + previsao + seguro.toString();
	}

}
