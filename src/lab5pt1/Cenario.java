package lab5pt1;

public class Cenario {
	
	// Atributos
	
	private String descricao;
	
	private Estado estado;
	
	// Construtor
	
	public Cenario (String descricao) {
		if (descricao == null) {
			throw new NullPointerException();
		} 
		
		if (descricao.trim().length() == 0) {
			throw new IllegalArgumentException();
		}
		
		this.descricao = descricao;
		estado = Estado.N_FINALIZADO;
	}
	
	// Métodos
	
	public String getDescricao() {
		return descricao;
	}

	public String getEstado() {
		return estado.getDescricao();
	}
	
	public String toString() {
		return descricao + " - " + estado;
	}
	
}
