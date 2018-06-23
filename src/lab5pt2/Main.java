package lab5pt2;

public class Main {

	public static void main(String[] args) {
		Aposta ap = new Aposta("rafa", 250, "VAI ACONTECER");
		System.out.println(ap.getNomeApostador());
		
		CenarioBonus cb = new CenarioBonus("jhjh", 0.1, 10090);
		cb.fecharAposta(true);
		System.out.println(cb.calculaRateio());

	}

}
