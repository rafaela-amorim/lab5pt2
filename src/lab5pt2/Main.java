package lab5pt2;

public class Main {

	public static void main(String[] args) {
		try {
			Aposta ap = new Aposta(null, 250, "VAI ACONTECER", 0.63);
		} catch (NullPointerException n) {
			System.out.println(n.getMessage());
		}
		
		
	}

}
