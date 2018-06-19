package lab5pt1;

public class Facade {
	private Sistema sistema;
	
	public void incializa(int caixa, double taxa) {
		sistema = new Sistema(caixa, taxa);
	}
	
	public int getCaixa() {
		return sistema.getCaixa();
	}

	public int cadastraCenario(String descricao) {
		return sistema.cadastraCenario(descricao);
	}
	
	public String exibirCenario(int cenario) {
		return sistema.exibirCenario(cenario);
	}
	
	public String exibirCenarios() {
		return sistema.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		sistema.cadastraAposta(cenario, apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}
	
	public void fechaAposta(int cenario, boolean ocorreu) {
		sistema.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return sistema.getTotalRateioCenario(cenario);
	}
}
