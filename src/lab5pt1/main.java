package lab5pt1;

public class main {
	public static int caixaFavoraveis = 90;
	public static int caixaContra = 90;
	
	public static void main(String[] args) {
		Estado estado = Estado.N_FINALIZADO;
		
		if (estado.toString().equals("Não finalizado")) {
			System.out.println("isso");
		} else {
			System.out.println("nope");
		}
		
		System.out.println(estado);
	}
	
	public static int getCaixa() {
		return caixaFavoraveis + caixaContra;
	}


}
