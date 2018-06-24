package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5pt2.ApostaSeguraValor;

public class ApostaSeguraValorTest {

	ApostaSeguraValor av;
	@Before
	public void inicia() {
		av = new ApostaSeguraValor("ANPANMAN", 54321, "N VAI ACONTECER", 20000, 10000);
	}

	@Test
	public void testToString() {
		assertEquals("ANPANMAN - R$543,21 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$200,00", av.toString());
	}

	@Test(expected=NullPointerException.class)
	public void testNomeNull() {
		ApostaSeguraValor erro = new ApostaSeguraValor(null, 10, "VAI ACONTECER", 10, 10); 
	}
	
	@Test(expected=NullPointerException.class)
	public void testPrevNull() {
		ApostaSeguraValor erro = new ApostaSeguraValor("preto rosa na sua área", 10, null, 40, 10); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPrevIllegal() {
		ApostaSeguraValor erro = new ApostaSeguraValor("assovie como um míssil", 10, "   ", 40, 4); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNomeIllegal() {
		ApostaSeguraValor erro = new ApostaSeguraValor("    ", 10, "BLACKPINK IS THE REVOLUTION", 40, 40); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorIllegal() {
		ApostaSeguraValor erro = new ApostaSeguraValor("HEY BOY", -520, "Lalalalalisa", 40, 40);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testVSeguroIllegal() {
		ApostaSeguraValor erro = new ApostaSeguraValor("U wrong me right", 7, "ddaeng", -9999, 40); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCustoSeguroIllegal() {
		ApostaSeguraValor erro = new ApostaSeguraValor("did you see my bag??", 7, "it's hella trophies and it's hella thick", 9999, -5620); 
	}
	
	@Test
	public void testGetValorSeguro() {
		assertEquals(20000, av.getValorSeguro());
	}

	@Test
	public void testGetCustoSeguro() {
		assertEquals(10000, av.getCustoSeguro());
	}

	@Test
	public void testGetNomeApostador() {
		assertEquals("ANPANMAN", av.getNomeApostador());
	}

	@Test
	public void testGetValor() {
		assertEquals(54321, av.getValor());
	}

	@Test
	public void testGetPrevisao() {
		assertEquals("N VAI ACONTECER", av.getPrevisao());
	}

}
