package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5pt2.Sistema;

public class SistemaTest {
		
	Sistema sis;
	@Before
	public void inicia() {
		sis = new Sistema(1000000, 0.1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalCaixa() {
		Sistema erro = new Sistema(-9, 0.9);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalTax() {
		Sistema erro = new Sistema(100000, -3);
	}
	
	@Test
	public void testCadastraCenario() {
		sis.cadastraCenario("ALAAO EU TO COM MTO SONO");
	}
	
	@Test(expected=NullPointerException.class)
	public void cenarioNull() { 
		sis.cadastraCenario(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cenarioIllegadsdl() { 
		sis.cadastraCenario("  ");
	}
	
	@Test(expected=IllegalAccessError.class)
	public void cenarioNaoEXiste() {
		sis.cadastraAposta(80, "girls wanna have some fun", 200, "we like to party");
	}
	
	@Test(expected=IllegalAccessError.class)
	public void cenarioNaoPode() {
		sis.cadastraAposta(0, "we go dumb dumb dumb", 202, "what you want want want");
	}
	
	@Test
	public void testCadastraAposta() {
		sis.cadastraCenario("ALAAO EU TO COM MTO SONO");
		sis.cadastraAposta(1, "rafa", 500, "VAI ACONTECER");
	}
	
	@Test
	public void testExibirCenario() {
		sis.cadastraCenario("ALAAO EU TO COM MTO SONO");

		assertEquals("ALAAO EU TO COM MTO SONO - Não finalizado"
					, sis.exibirCenario(1));
	}
	
	@Test
	public void testExibirCenarios() {
		sis.cadastraCenario("ALAAO EU TO COM MTO SONO");
		sis.cadastraCenario("Meu pescoço dói e meu braço e dedos tbm");
		sis.cadastraCenario("ahahaha amanhã tem prova de cálculo");
		
		assertEquals("1 - ALAAO EU TO COM MTO SONO - Não finalizado\n" + 
					 "2 - Meu pescoço dói e meu braço e dedos tbm - Não finalizado\n" + 
					 "3 - ahahaha amanhã tem prova de cálculo - Não finalizado", sis.exibirCenarios());
	}
	
	
	@Test
	public void testValorTotalDeApostas() {
		sis.cadastraCenario("whatta bom bom whatta bom bom let's go");
		sis.cadastraAposta(1, "rafa", 500, "VAI ACONTECER");
		sis.cadastraAposta(1, "minha mão", 202, "VAI ACONTECER");
		
		assertEquals(702, sis.valorTotalDeApostas(1));
	}
	
	@Test
	public void testTotalDeApostas() {
		sis.cadastraCenario("Meu pescoço dói e meu braço e dedos tbm");
		sis.cadastraAposta(1, "rafa", 500, "VAI ACONTECER");
		sis.cadastraAposta(1, "minha mão", 20, "VAI ACONTECER");
		
		assertEquals(2, sis.totalDeApostas(1));
	}

	@Test
	public void testExibeApostas() {
		sis.cadastraCenario("Meu pescoço dói e meu braço e dedos tbm");
		sis.cadastraAposta(1, "rafa", 500, "VAI ACONTECER");
		sis.cadastraAposta(1, "minha mão", 200, "VAI ACONTECER");
		
		assertEquals("rafa - R$5,00 - VAI ACONTECER\n" + 
					 "minha mão - R$2,00 - VAI ACONTECER", sis.exibeApostas(1));
	}

	@Test
	public void testFecharAposta() {
		sis.cadastraCenario("Meu pescoço dói e meu braço e dedos tbm");
		sis.cadastraAposta(1, "rafa", 500, "VAI ACONTECER");
		sis.cadastraAposta(1, "minha mão", 20, "VAI ACONTECER");
		
		sis.fecharAposta(1, true);
	}

	@Test
	public void testGetTotalRateioCenario() {
		sis.cadastraCenario("Meu pescoço dói e meu braço e dedos tbm");
		sis.cadastraAposta(1, "rafa", 500, "VAI ACONTECER");
		sis.cadastraAposta(1, "minha mão", 20, "VAI ACONTECER");
		
		sis.fecharAposta(1, true);
		
		assertEquals(00, sis.getTotalRateioCenario(1));
	}

	@Test
	public void testGetCaixa() {
		assertEquals(1000000, sis.getCaixa());
	}

	@Test
	public void testGetCaixaCenario() {
		sis.cadastraCenario("Meu pescoço dói e meu braço e dedos tbm");
		sis.cadastraAposta(1, "rafa", 500, "N VAI ACONTECER");
		sis.cadastraAposta(1, "minha mão", 20, "VAI ACONTECER");
		
		sis.fecharAposta(1, true);
		
		assertEquals(50, sis.getCaixaCenario(1));
	}

}
