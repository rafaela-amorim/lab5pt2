package lab5pt2;

import java.util.ArrayList;
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

		this.descricao = valida.descricaoCenario(descricao);
		this.porcentagem = valida.taxaSistema(porcentagem);

		estado = Estado.N_FINALIZADO;
		favoravel = new HashMap<>();
		contra = new HashMap<>();
		index = 1;
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
		valida.cenarioFechado(getEstado());
		
		Aposta aux = new Aposta(nome, valor, previsao);

		if (previsao == "VAI ACONTECER") {
			favoravel.put(index++, aux);
		} else {
			contra.put(index++, aux);
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
		valida.cenarioAberto(getEstado());
		return (int) Math.floor(caixaPerdedor * porcentagem);
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
		valida.cenarioAberto(getEstado());
		return caixaPerdedor - getCaixaCenario();
	}
	
	/**
	 * 
	 * @param apostaSegura
	 * @param taxa
	 * @return
	 */
	public int alterarSeguroTaxa(int indiceAposta, double taxa) {
		if (favoravel.containsKey(indiceAposta)) {
			if (favoravel.get(indiceAposta) instanceof ApostaSeguraValor) {
				
			}
		}
		return -1;
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
