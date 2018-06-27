package lab5pt2;

public class Main {

	public static void main(String[] args) {
		Sistema s = new Sistema(100000, 0.01);
		
		s.cadastrarCenario("O aluno Viktor Borgino vai pagar PLP");
		s.cadastrarCenario("Hoje vai fazer -30 graus em Campina");
		s.cadastrarCenario("Todos os alunos comparecerao a aula de LP2 nessa terca");
		
		s.cadastrarAposta(1, "Matheus Melanio", 10000, "N VAI ACONTECER");
		s.cadastrarAposta(1, "Viktor Borgino", 10000, "VAI ACONTECER");
		
		s.cadastrarAposta(2, "Mandela Ursula", 100000, "VAI ACONTECER");
		s.cadastrarAposta(2, "Davson Sadman", 150000, "VAI ACONTECER");
		s.cadastrarAposta(2, "Taigo Leonel", 10000, "N VAI ACONTECER");
		
		s.cadastrarAposta(3, "Viktor Borgino", 20000, "VAI ACONTECER");
		s.cadastrarAposta(3,"Matheus Gaudencio", 2000000, "VAI ACONTECER");
		s.cadastrarAposta(3, "Higo Addommati", 200000, "N VAI ACONTECER");
		
		s.fecharAposta(1, false);
		s.fecharAposta(2, true);
		
		System.out.println(s.getCaixa());
		
		
		
		
	}

}
