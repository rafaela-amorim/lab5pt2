package lab5pt1;

import java.util.ArrayList;

public class Cenario {

	// Atributos

	private ArrayList<Aposta> favoravel;

	private ArrayList<Aposta> contra;

	private String descricao;

	private Estado estado;

	private double porcentagem;

	private int caixaPerdedor;

	private Validador valida;

	// Construtor


	public Cenario(String descricao, double porcentagem) {
		valida = new Validador();

		this.descricao = valida.descricaoCenario(descricao);
		this.porcentagem = valida.porcentagemCenario(porcentagem);
		
		estado = Estado.N_FINALIZADO;
		favoravel = new ArrayList<>();
		contra = new ArrayList<>();
		caixaPerdedor = -1;
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
			} else {
				contra.add(aux);
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
		if (estado.toString().equals("Não finalizado")) {
			return (int) Math.floor(caixaPerdedor * porcentagem);
		}
		return -1;
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
	 * Calcula o valor a ser distribuido entre os vencedores.
	 * 
	 * @param caixaPerdedor
	 *            o dinheiro das apostas perdedoras.
	 * @return Retorna o valor para distribuir entre os ganhadores.
	 */
	public int calculaRateio() {
		if (estado.toString().equals("Não finalizado")) {
			return (int) Math.floor(caixaPerdedor * porcentagem);
		}
		return 0;
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

		for (Aposta ap : favoravel) {
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

		for (Aposta ap : contra) {
			caixa += ap.getValor();
		}
		return caixa;
	}
	
}
