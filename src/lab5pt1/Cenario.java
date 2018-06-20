package lab5pt1;

import java.util.ArrayList;

public class Cenario {

	// Atributos

	private ArrayList<Aposta> favoravel;

	private ArrayList<Aposta> contra;

	private String descricao;

	private Estado estado;

	private int caixaFavoravel;

	private int caixaContra;

	private double porcentagem;

	private int rateio;

	private int caixaCenario;

	private Validador valida;

	// Construtor

	/**
	 * Construtor da classe, recebe apenas a descrição do cenário como parâmetro.
	 * Inicializa o cenário como não finalizado, inicializa os ArrayLists que
	 * armazenarão os apostadores favoráveis e contra o cenário. Além disso,
	 * determina que as variáveis que guardam os caixas totais e o rateio das
	 * apostas iniciam em 0 e o caixaCenario inicializa em uma flag (-1) indicando
	 * que o cenário não foi fechado e ainda não há dinheiro separado para o caixa
	 * do Sistema.
	 * 
	 * @param descricao
	 *            É a descrição do cenário.
	 * @param porcentagem
	 *            A porcentagem para calcular o montante de dinheiro que vai pro
	 *            caixa do sistema e o que vai para os ganhadores da aposta.
	 */
	public Cenario(String descricao, double porcentagem) {
		valida = new Validador();
		
		this.descricao = valida.descricaoCenario(descricao);
		this.porcentagem = valida.porcentagemCenario(porcentagem);
		estado = Estado.N_FINALIZADO;
		favoravel = new ArrayList<>();
		contra = new ArrayList<>();
		caixaFavoravel = 0;
		caixaContra = 0;
		caixaCenario = -1;
		rateio = 0;
	}

	// Métodos

	/**
	 * Verifica se o cenário ainda está aberto para apostas, se não estiver, nada
	 * acontece. Se estiver, cadastra a aposta de acordo com a previsão do
	 * apostador, se for favorável, a aposta é adicionada ao ArrayList de favoráveis
	 * e o valor é somado ao caixa de favoráveis, análogamente, há um ArrayList e um
	 * caixa para apostas contra o cenário.
	 * 
	 * @param nome
	 *            Nome do apostador.
	 * @param valor
	 *            Valor da Aposta.
	 * @param previsao
	 *            Previsão da Aposta.
	 */
	public void cadastraAposta(String nome, int valor, String previsao) {
		if (estado.toString().equals("Não finalizado")) {

			Aposta aux = new Aposta(nome, valor, previsao);

			if (previsao == "VAI ACONTECER") {
				favoravel.add(aux);
				caixaFavoravel += valor;
			} else {
				contra.add(aux);
				caixaContra += valor;
			}
		}
	}

	/**
	 * Método que cria uma String que armazena uma representação textual de todos
	 * que apostaram nesse cenário, em formato de lista.
	 * 
	 * @return String em forma de lista com todas as apostas.
	 */
	public String exibeApostas() {
		String lista = "";

		for (Aposta item : favoravel) {
			lista += item.toString() + System.lineSeparator();
		}

		lista.trim();

		for (Aposta item : contra) {
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
		if (estado.toString().equals("Não finalizado")) {

			if (ocorreu) {
				estado = Estado.OCORREU;
				caixaCenario = (int) Math.floor(caixaContra * porcentagem);
				rateio = caixaContra - caixaCenario;

			} else {
				estado = Estado.N_OCORREU;
				caixaCenario = (int) Math.floor(caixaFavoravel * porcentagem);
				rateio = caixaFavoravel - caixaCenario;
			}
		}
	}

	/**
	 * Método que calcula o número total de apostas, somando o tamanho dos dois
	 * ArrayList que armazenam todas as apostas.
	 * 
	 * @return Quantidade total de apostas.
	 */
	public int totalDeApostas() {
		return favoravel.size() + contra.size();
	}

	/**
	 * Método que retorna a quantidade de dinheiro que irá para o caixa do Sistema
	 * quando as apostas forem encerradas, antes disso o caixaCenario é -1 indicando
	 * que a quantia do Sistema ainda não foi determinada.
	 * 
	 * @return a quantia de dinheiro que irá para o sistema ou -1.
	 */
	public int getCaixaCenario() {
		return caixaCenario;
	}

	/**
	 * Método que calcula o caixa total do cenário, somando o caixa das apostas
	 * favoráveis com o das apostas contra.
	 * 
	 * @return Caixa total do cenário.
	 */
	public int valorTotalDeAposta() {
		return caixaFavoravel + caixaContra;
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
	 * Retorna o rateio das apostas.
	 * 
	 * @return rateio das apostas.
	 */
	public int getRateio() {
		return rateio;
	}

	/**
	 * Representação textual do cenário, contém a descrição e o estado atual do
	 * cenário. A String se dá no seguinte formato: DESCRIÇÃO - ESTADO
	 */
	@Override
	public String toString() {
		return getDescricao() + " - " + getEstado();
	}

}
