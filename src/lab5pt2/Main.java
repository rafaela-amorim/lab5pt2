package lab5pt2;

public class Main {

	public static void main(String[] args) {
		Aposta ap = new Aposta("rafa", 250, "VAI ACONTECER", 0.63);
		System.out.println(ap.getNomeApostador());
		
		CenarioBonus cb = new CenarioBonus("jhjh", 0.1, 10090);
		cb.fecharAposta(true);
		System.out.println(cb.calculaRateio());
		
		
		SeguroValor sv = new SeguroValor(10502);
		System.out.println(sv.toString());
		
		SeguroTaxa tx = new SeguroTaxa(10505, 0.5);
		System.out.println(tx.toString());
		
		System.out.println(ap.toString());
	}

}
