package lab5pt1;

import java.util.HashMap;
import java.util.Map;

public class Sistema {
	
	// Atributos
	
	private int indiceCenarios;

	private int caixa;

	private double taxa;

	private HashMap<Integer, Cenario> cenarios;
	
	private Validador valida;

	// Construtores

	/**
	 * Construtor da classe, inicializa o mapa que armazenará os cenários
	 * cadastrados, inicializa o índice que representa a ordem de cadastro dos
	 * cenários e recebe o caixa inicial do Sistema e a taxa para calcular o quanto
	 * o Sistema ganha em cada aposta encerrada.
	 * 
	 * @param caixa
	 *            Dinheiro total inicial do Sistema.
	 * @param taxa
	 *            Taxa para calcular o ganho do Sistema.
	 */
	public Sistema(int caixa, double taxa) {
		cenarios = new HashMap<>();
		indiceCenarios = 1;
		this.caixa = valida.caixaSistema(caixa);
		this.taxa = valida.taxaSistema(taxa);
	}

	// Métodos

	/**
	 * Cadastra um novo cenário no Sistema.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 */
	public void cadastraCenario(String descricao) {
		Cenario aux = new Cenario(descricao, taxa);
		cenarios.put(indiceCenarios++, aux);
	}

	/**
	 * Cadastra uma nova aposta no cenário equivalente ao índice passado no
	 * parâmetro.
	 * 
	 * @param cenario
	 *            Inteiro que indica a posição do cenário por ordem de cadastro.
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da aposta.
	 * @param previsao
	 *            Previsão da aposta.
	 */
	public void cadastraAposta(int cenario, String nome, int valor, String previsao) {
		if (cenario < cenarios.size() && cenario > 0) {
			cenarios.get(cenario).cadastraAposta(nome, valor, previsao);
		}
	}

	/**
	 * Retorna a representação textual do cenário a partir do número que representa
	 * a posição do cenário no conjunto.
	 * 
	 * @param cenario
	 *            Representa a posição do cenário por ordem de cadastro.
	 * @return Representação textual do cenário.
	 */
	public String exibirCenario(int cenario) {
		return cenarios.get(cenario).toString();
	}

	/**
	 * Retorna uma lista com todos os cenários cadastrados no Sistema precedidos
	 * pelo número que representa a ordem em que foram cadastrados.
	 * 
	 * @return String em forma de lista com todos os cenários cadastrados.
	 */
	public String exibeCenarios() {
		String lista = "";

		for (Map.Entry<Integer, Cenario> par : cenarios.entrySet()) {
			lista += par.getKey() + " - " + par.getValue().toString() + System.lineSeparator();
		}

		return lista.trim();
	}

	/**
	 * Retorna o montante total das apostas de determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return Retorna o valor total que foi apostado nesse cenário.
	 */
	public int valorTotalDeApostas(int cenario) {
		return cenarios.get(cenario).getCaixa();
	}

	/**
	 * Retorna a quantidade de apostas que foram feitas em determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return A quantidade de apostas que foram feitas nesse cenário.
	 */
	public int totalDeApostas(int cenario) {
		return cenarios.get(cenario).totalDeApostas();
	}

	/**
	 * Retorna uma lista de todas as apostas feitas em determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return String em forma de lista com todas as apostas do cenário.
	 */
	public String exibeApostas(int cenario) {
		return cenarios.get(cenario).exibeApostas();
	}

	/**
	 * Fecha as apostas para determinado cenário e acrescenta ao caixa do Sistema a
	 * porcentagem adequada do montante adquirido no cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @param ocorreu
	 *            Boolean que indica se o cenário ocorreu ou não.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		int porcentagemCaixa = cenarios.get(cenario).fecharAposta(ocorreu);

		if (porcentagemCaixa != -1) {
			caixa += porcentagemCaixa;
		}
	}

	/**
	 * Retorna o montante de dinheiro que vai ser distribuído entre os vencedores da
	 * Aposta do Cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return Retorna o valor a ser distribuído entre os ganhadores.
	 */
	public int getTotalRateioCenario(int cenario) {
		return cenarios.get(cenario).getRateio();
	}

	/**
	 * Retorna o caixa total do Sistema.
	 * 
	 * @return Caixa do Sistema.
	 */
	public int getCaixa() {
		return caixa;
	}

	/**
	 * Retorna o caixa de um determinado cenário.
	 * 
	 * @param cenario
	 *            Representa o cenário em questão.
	 * @return Retorna o total do caixa do cenário.
	 */
	public int getCaixaCenario(int cenario) {
		return cenarios.get(cenario).getCaixa();
	}
}
