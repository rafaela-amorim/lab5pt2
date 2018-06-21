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
		valida = new Validador();
		cenarios = new HashMap<>();
		indiceCenarios = 1;
		this.caixa = valida.caixaSistema(caixa);
		this.taxa = valida.taxaSistema(taxa);
	}

	// Métodos

	/**
	 * verifica a existencia do cenário no sistema, ou se o índice passado é válido.
	 * 
	 * @param index
	 *            numeração do cenário.
	 */
	private void verificaCenario(int index) {
		if (index < 1) {
			throw new IllegalAccessError("Cenario invalido");
		}
		if (!(cenarios.containsKey(index))) {
			throw new IllegalAccessError("Cenario nao cadastrado");
		}
	}

	/**
	 * Cadastra um novo cenário no Sistema.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @return O índice do cenário cadastrado.
	 */
	public int cadastraCenario(String descricao) {
		Cenario aux = new Cenario(descricao, taxa);
		cenarios.put(indiceCenarios++, aux);
		return indiceCenarios;
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
		verificaCenario(cenario);
		cenarios.get(cenario).cadastraAposta(nome, valor, previsao);
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
		verificaCenario(cenario);
		return cenarios.get(cenario).toString();
	}

	/**
	 * Retorna uma lista com todos os cenários cadastrados no Sistema precedidos
	 * pelo número que representa a ordem em que foram cadastrados.
	 * 
	 * @return String em forma de lista com todos os cenários cadastrados.
	 */
	public String exibirCenarios() {
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
		verificaCenario(cenario);
		return cenarios.get(cenario).valorTotalDeAposta();
	}

	/**
	 * Retorna a quantidade de apostas que foram feitas em determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return A quantidade de apostas que foram feitas nesse cenário.
	 */
	public int totalDeApostas(int cenario) {
		verificaCenario(cenario);
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
		verificaCenario(cenario);
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
		verificaCenario(cenario);
		cenarios.get(cenario).fecharAposta(ocorreu);

		int caixaCenario = cenarios.get(cenario).getCaixaCenario();

		if (caixaCenario != -1) {
			caixa += caixaCenario;
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
		verificaCenario(cenario);
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
	 * Retorna a quantia de dinheiro que irá para o caixa do Sistema quando as
	 * apostas forem encerradas, se isso ainda não tiver ocorrido, então retorna -1.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return O dinheiro que irá para o Sistema ou -1.
	 */
	public int getCaixaCenario(int cenario) {
		verificaCenario(cenario);
		return cenarios.get(cenario).getCaixaCenario();
	}
}
