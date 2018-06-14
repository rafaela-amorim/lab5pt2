package lab5pt1;

public enum Estado {
	
	OCORREU("Finalizado (ocorreu)"),
	N_OCORREU("Finalizado (n ocorreu)"),
	N_FINALIZADO("Não finalizado");
	
	private String descricao;
	
	Estado(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
}
