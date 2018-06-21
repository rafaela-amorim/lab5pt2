package lab5pt1;

public class main {
	
	public static void main(String[] args) {
		
		Aposta ap = new Aposta("rafa", 250, "VAI ACONTECER");
		System.out.println(ap.getNomeApostador());
		
		CenarioBonus cb = new CenarioBonus("jhjh", 0.1, 10090);
		System.out.println(cb.toString());
		
	}
}