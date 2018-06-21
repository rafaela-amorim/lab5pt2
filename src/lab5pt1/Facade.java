package lab5pt1;

public class Facade {
	
	// Atributos 
	
	private Sistema sistema;

	private boolean iniciado;
	
	// Métodos

	/**
	 * Construtor da classe, contém um booleano que indica se o sistema já foi
	 * inicializado ou não, o booleano começa em false.
	 */
	public Facade() {
		iniciado = false;
	}
	
	/**
	 * Método que verifica se o sistema já foi inicializado ou não.
	 */
	private void jaInicializou() {
		if (!(iniciado)) {
			throw new IllegalAccessError("O sistema não foi inicializado");
		}
	}
 	
	/**
	 * Inicializa o Sistema, com uma taxa para o cálculo dos ganhos do sistema e um
	 * caixa que representa o dinheiro que o sistema tem inicialmente.
	 * 
	 * @param caixa
	 *            dinheiro inicial do sistema
	 * @param taxa
	 *            taxa para calcular o quanto o sistema ganha por aposta encerrada.
	 */
	public void inicializa(int caixa, double taxa) {
		sistema = new Sistema(caixa, taxa);
		iniciado = true;
	}

	/**
	 * Retorna a quantidade de dinheiro que o caixa tem atualmente.
	 * 
	 * @return Retorna o dinheiro do sistema
	 */
	public int getCaixa() {
		jaInicializou();
		return sistema.getCaixa();
	}

	/**
	 * Cadastra um novo cenário no sistema, com a descrição passada como parâmetro.
	 * 
	 * @param descricao
	 *            Descrição do cenário.
	 * @return Retorna a numeração do cenário cadastrado.
	 */
	public int cadastraCenario(String descricao) {
		jaInicializou();
		return sistema.cadastraCenario(descricao);
	}

	/**
	 * Retorna a representação textual do cenário de mesma numeração da passada como
	 * parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return Retorna uma String com as informações do cenário.
	 */
	public String exibirCenario(int cenario) {
		jaInicializou();
		return sistema.exibirCenario(cenario);
	}

	/**
	 * Exibe uma lista com a representação textual de todos os cenários cadastrados
	 * no Sistema.
	 * 
	 * @return Retorna uma String em forma de lista.
	 */
	public String exibirCenarios() {
		jaInicializou();
		return sistema.exibirCenarios();
	}

	/**
	 * Cadastra uma nova aposta no cenário de mesma numeração à passada como
	 * parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @param apostador
	 *            nome do apostador
	 * @param valor
	 *            valor da aposta
	 * @param previsao
	 *            previsão da aposta
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		jaInicializou();
		sistema.cadastraAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Retorna um inteiro com o total de dinheiro que foi apostado no cenário de
	 * mesma numeração do parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return Retorna o valor total que foi apostado
	 */
	public int valorTotalDeApostas(int cenario) {
		jaInicializou();
		return sistema.valorTotalDeApostas(cenario);
	}

	/**
	 * Retorna um inteiro que é a quantidade de apostas feitas no cenário de mesma
	 * numeração do parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário.
	 * @return Quantidade de apostas do cenário
	 */
	public int totalDeApostas(int cenario) {
		jaInicializou();
		return sistema.totalDeApostas(cenario);
	}

	/**
	 * Exibe uma lista com a representação textual de todas as apostas feitas no
	 * cenário de mesma numeração do parâmetro.
	 * 
	 * @param cenario
	 *            numeração do cenário
	 * @return Retorna uma String na forma de lista.
	 */
	public String exibeApostas(int cenario) {
		jaInicializou();
		return sistema.exibeApostas(cenario);
	}

	/**
	 * Fecha a aposta do cenário de mesma numeração do parâmetro e calcula a
	 * porcentagem que o Sistema receberá de acordo com o resultado final da aposta.
	 * 
	 * @param cenario
	 *            numeração do cenário.
	 * @param ocorreu
	 *            boolean que representa se a previsão do cenário ocorreu ou não.
	 */
	public void fechaAposta(int cenario, boolean ocorreu) {
		jaInicializou();
		sistema.fecharAposta(cenario, ocorreu);
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
		jaInicializou();
		return sistema.getCaixaCenario(cenario);
	}

	/**
	 * Retorna o montante total das apostas de determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário em questão.
	 * @return Retorna o valor total que foi apostado nesse cenário.
	 */
	public int getTotalRateioCenario(int cenario) {
		jaInicializou();
		return sistema.getTotalRateioCenario(cenario);
	}
}
