package lab5pt2;

public class Validador {

	/**
	 * Testa se o nome do Apostador, usado na classe Aposta, não é nulo nem um
	 * argumento vazio.
	 * 
	 * @param nomeAp
	 *            nome do apostador
	 * @return Retorna a própria String se for válida.
	 */
	public String nomeApostador(String nomeAp) {
		if (nomeAp == null) {
			throw new NullPointerException();
		}
		if (nomeAp.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return nomeAp;
	}

	/**
	 * Testa a previsão da classe Aposta, se não é nem nula nem argumento vazio.
	 * 
	 * @param previsao
	 *            Previsão da aposta
	 * @return Retorna a própria String se for válida.
	 */
	public String previsaoAposta(String previsao) {
		if (previsao == null) {
			throw new NullPointerException();
		}
		if (previsao.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return previsao;
	}

	/**
	 * Testa se o valor da aposta é um número válido, no caso, um valor positivo.
	 * 
	 * @param valor
	 *            valor da aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public int valorAposta(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException();
		}
		return valor;
	}

	/**
	 * Testa se a descrição do cenário é um argumento válido, não é nulo nem vazio.
	 * 
	 * @param descricao
	 *            descrição do cenário.
	 * @return Retorna a própria String se for válida.
	 */
	public String descricaoCenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException();
		}
		if (descricao.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return descricao;
	}

	/**
	 * Testa se a taxa do caixa é um valor válido, no caso, um valor positivo.
	 * 
	 * @param porcentagem
	 *            A porcentagem usada para calcular o montante do sistema em cima do
	 *            valor total das apostas perdedoras.
	 * @return Retorna o próprio valor se for válido.
	 */
	public double porcentagemCenario(double porcentagem) {
		if (porcentagem < 0) {
			throw new IllegalArgumentException();
		}
		return porcentagem;
	}

	/**
	 * Testa se o valor inicial do caixa é um número válido, no caso, um valor
	 * positivo.
	 * 
	 * @param caixa
	 *            O valor, em centavos, inicial do caixa.
	 * @return Retorna o próprio valor se for válido.
	 */
	public int caixaSistema(int caixa) {
		if (caixa < 0) {
			throw new IllegalArgumentException();
		}
		return caixa;
	}

	/**
	 * Testa se a taxa do Sistema é um número válido, no caso, um valor positivo.
	 * 
	 * @param taxa
	 *            A porcentagem usada para calcular o montante do sistema em cima do
	 *            valor total das apostas perdedoras.
	 * @return Retorna o próprio valor se for válido.
	 */
	public double taxaSistema(double taxa) {
		if (taxa < 0) {
			throw new IllegalArgumentException();
		}
		return taxa;
	}

	/**
	 * Testa se o bonus do Cenário Bônus é válido, isto é, um número positivo.
	 * 
	 * @param bonus
	 *            O bônus do cenário.
	 * @return Retorna o próprio valor se for válido.
	 */
	public int bonusCenario(int bonus) {
		if (bonus < 0) {
			throw new IllegalArgumentException();
		}
		return bonus;
	}

	/**
	 * Testa se o custo do seguro da Aposta Assegurada é válido, i.e., um número
	 * positivo.
	 * 
	 * @param custoSeguro
	 *            Custo do seguro da aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public int custoAposta(int custoSeguro) {
		if (custoSeguro < 0) {
			throw new IllegalArgumentException();
		}
		return custoSeguro;
	}

	/**
	 * Testa se o valor do seguro da Aposta Assegurada é válido, i.e., um número
	 * positivo.
	 * 
	 * @param valorSeguro
	 *            Valor do seguro da aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public int valorSeguroAposta(int valorSeguro) {
		if (valorSeguro < 0) {
			throw new IllegalArgumentException();
		}
		return valorSeguro;
	}

	/**
	 * Testa se a taxa do seguro da Aposta Assegurada é válida, i.e., um número
	 * positivo.
	 * 
	 * @param taxa
	 *            Taxa do seguro da Aposta
	 * @return Retorna o próprio valor se for válido.
	 */
	public double taxaSeguroAposta(double taxa) {
		if (taxa < 0) {
			throw new IllegalArgumentException();
		}
		return taxa;
	}
}
