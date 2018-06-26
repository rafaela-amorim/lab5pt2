package lab5pt2;

import java.util.HashMap;

public class Cenario {

	// Atributos

	private HashMap<Integer, Aposta> favoravel;
	private HashMap<Integer, Aposta> contra;
	private String descricao;
	private Estado estado;
	private double porcentagem;
	private int caixaPerdedor;
	private int index;
	protected Validador valida;

	// Construtor

	/**
	 * Construtor da classe, recebe a descrição do cenário e a porcentagem para o
	 * cálculo do montante destinado ao caixa do Sistema quando as apostas forem
	 * encerradas.
	 * 
	 * O estado do cenário inicia em Não finalizado, o caixa perdedor inicia em -1,
	 * o index, ou índice, inicia em 1 e o validador e os dois hashmaps são
	 * inicializados
	 * 
	 * @param descricao
	 *            Descrição do cenário
	 * @param porcentagem
	 *            taxa para calcular o dinheiro para o caixa do Sistema
	 */
	public Cenario(String descricao, double porcentagem) {
		valida = new Validador();

		try {
			this.descricao = valida.descricaoCenario(descricao);
			this.porcentagem = valida.taxaSistema(porcentagem);

			estado = Estado.N_FINALIZADO;
			favoravel = new HashMap<>();
			contra = new HashMap<>();
			index = 1;
			caixaPerdedor = -1;
		} catch (NullPointerException n) {
			throw new NullPointerException("Erro no cadastro de cenario: " + n);
		} catch (IllegalArgumentException i) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: " + i);
		}
	}

	// Métodos

	/**
	 * Método auxiliar que cadastra uma nova aposta em seu respectivo HashMap,
	 * dependendo da previsão da aposta.
	 * 
	 * @param aposta
	 *            A Aposta que será cadastrada no Cenário;
	 * @return Retorna o índice da aposta.
	 */
	private int cadastraApostaAux(Aposta aposta) {
		valida.cenarioFechado(getEstado());

		if (aposta.getPrevisao().equals("VAI ACONTECER")) {
			favoravel.put(index++, aposta);
		} else {
			contra.put(index++, aposta);
		}
		return index;
	}

	/**
	 * Cadastra aposta comum sem seguro, recebe nome do apostador, valor da aposta e
	 * a previsão da aposta.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		cadastraApostaAux(aposta);
	}

	/**
	 * Cadastra Aposta assegurada por valor, recebe nome do apostador, valor da
	 * aposta, previsão e o valor do seguro, retorna o número identificador da
	 * aposta.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param valorSeguro
	 *            Valor do seguro da Aposta.
	 * @return Número de identificação da aposta
	 */
	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int valorSeguro) {
		Aposta aposta = new Aposta(apostador, valor, previsao, valorSeguro);
		return cadastraApostaAux(aposta);
	}
	
	/**
	 * Cadastra Aposta assegurada por taxa, recebe nome do apostador, valor da
	 * aposta, previsão e a taxa do seguro, retorna o número identificador da
	 * aposta.
	 * 
	 * @param apostador
	 *            Nome do apostador
	 * @param valor
	 *            Valor da aposta
	 * @param previsao
	 *            Previsão da aposta
	 * @param taxaSeguro
	 *            Taxa do seguro da Aposta.
	 * @return Número de identificação da aposta
	 */
	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxaSeguro) {
		Aposta aposta = new Aposta(apostador, valor, previsao, taxaSeguro);
		return cadastraApostaAux(aposta);
	}

	/**
	 * Método que cria uma String que armazena uma representação textual de todos
	 * que apostaram nesse cenário, em formato de lista.
	 * 
	 * @return String em forma de lista com todas as apostas.
	 */
	public String exibeApostas() {
		String lista = "";

		for (Aposta item : favoravel.values()) {
			lista += item.toString() + System.lineSeparator();
		}

		lista.trim();

		for (Aposta item : contra.values()) {
			lista += item.toString() + System.lineSeparator();
		}

		return lista.trim();
	}

	/**
	 * Verifica se o cenário já foi fechado, se sim, retorna uma flag. Senão, muda o
	 * estado de acordo com o boolean se o cenário ocorreu ou não, calcula a
	 * porcentagem do caixa adquirido que vai para o Sistema e o que vai para os
	 * vencedores.
	 * 
	 * @param ocorreu
	 *            Boolean que indica se o cenário ocorreu ou não.
	 * @return Retorna o valor do caixa que vai para o Sistema, ou -1 caso o cenário
	 *         já tivesse sido fechado.
	 */
	public void fecharAposta(boolean ocorreu) {
		valida.cenarioFechado(getEstado());

		int caixaAux;

		if (ocorreu) {
			caixaAux = caixaContra();
			estado = Estado.OCORREU;
		} else {
			caixaAux = caixaFavoravel();
			estado = Estado.N_OCORREU;
		}
		caixaPerdedor = caixaAux;
	}

	/**
	 * Método que retorna a quantidade total de apostas ao retornar o número da
	 * ultima aposta adicionada, já que seus índices são números crescentes
	 * ordenados a partir do 1.
	 * 
	 * @return Quantidade total de apostas.
	 */
	public int totalDeApostas() {
		return index - 1;
	}

	/**
	 * Método que retorna a quantidade de dinheiro que irá para o caixa do Sistema
	 * quando as apostas forem encerradas.
	 * 
	 * @return a quantia de dinheiro que irá para o sistema.
	 */
	public int getCaixaCenario() {
		try {
			valida.cenarioAberto(getEstado());
			return (int) Math.floor(caixaPerdedor * porcentagem);
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro na consulta do caixa do cenario: " + e);
		}

	}

	/**
	 * Método que calcula o caixa total do cenário, somando o caixa das apostas
	 * favoráveis com o das apostas contra.
	 * 
	 * @return Caixa total do cenário.
	 */
	public int valorTotalDeAposta() {
		return caixaFavoravel() + caixaContra();
	}

	/**
	 * Calcula o valor a ser distribuido entre os vencedores se as apostas tiverem
	 * sido encerradas.
	 * 
	 * @param caixaPerdedor
	 *            o dinheiro das apostas perdedoras.
	 * @return Retorna o valor para distribuir entre os ganhadores, ou 0.
	 */
	public int calculaRateio() {
		try {
			valida.cenarioAberto(getEstado());
			return caixaPerdedor - getCaixaCenario();
		} catch (IllegalAccessError e) {
			throw new IllegalAccessError("Erro na consulta do total de rateio do cenario: " + e);
		}
	}

	/**
	 * Retorna a descrição do cenário.
	 * 
	 * @return Descrição do cenário.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna a representação do estado atual do cenário.
	 * 
	 * @return Estado atual do cenário.
	 */
	public String getEstado() {
		return estado.toString();
	}

	/**
	 * Representação textual do cenário, contém a descrição e o estado atual do
	 * cenário. A String se dá no seguinte formato: DESCRIÇÃO - ESTADO
	 */
	@Override
	public String toString() {
		return getDescricao() + " - " + getEstado();
	}

	/**
	 * Calcula o caixa total das apostas favoráveis.
	 * 
	 * @return Retorna o valor total de apostas favoráveis.
	 */
	private int caixaFavoravel() {
		int caixa = 0;

		for (Aposta ap : favoravel.values()) {
			caixa += ap.getValor();
		}
		return caixa;
	}

	/**
	 * Calcula o caixa total das apostas contra.
	 * 
	 * @return Retorna o valor total de apostas contra.
	 */
	private int caixaContra() {
		int caixa = 0;

		for (Aposta ap : contra.values()) {
			caixa += ap.getValor();
		}
		return caixa;
	}

}
