package lab5pt1;

public class Validador {
	
	public String nomeApostador(String nomeAp) {
		if (nomeAp == null) {
			throw new NullPointerException();
		}
		if (nomeAp.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return nomeAp;
	}
	
	public String previsaoAposta(String previsao) {
		if (previsao == null) {
			throw new NullPointerException();
		}
		if (previsao.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return previsao;
	}
	
	public int valorAposta(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException();
		}
		return valor;
	}
	
	public String descricaoCenario(String descricao) {
		if (descricao == null) {
			throw new NullPointerException();
		}
		if (descricao.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		return descricao;
	}
	
	public double porcentagemCenario(double porcentagem) {
		if (porcentagem < 0) {
			throw new IllegalArgumentException();
		}
		return porcentagem;
	}
	
	public int caixaSistema(int caixa) {
		if (caixa < 0) {
			throw new IllegalArgumentException();
		}
		return caixa;
	}
	
	public double taxaSistema(double taxa) {
		if (taxa < 0) {
			throw new IllegalArgumentException();
		}
		return taxa;
	}
}
