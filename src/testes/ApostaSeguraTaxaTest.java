package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5pt2.ApostaSeguraTaxa;

public class ApostaSeguraTaxaTest {
	
	ApostaSeguraTaxa at;
	@Before
	public void inicia() {
		at = new ApostaSeguraTaxa("BÁTIMA", 10000, "VAI ACONTECER", 0.29, 5000);
	}

	@Test
	public void testToString() {
		assertEquals("BÁTIMA - R$100,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 0,29%", at.toString());
	}
	
	@Test
	public void testCustoSeguro() {
		assertEquals(5000, at.getCustoSeguro());
	}

	@Test
	public void testGetTaxaSeguro() {
		assertEquals(0.29, at.getTaxaSeguro(), 0.001);
	}
	
	@Test(expected=NullPointerException.class)
	public void testNomeNull() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa(null, 40, "dskd", 40, 40);
	}
	
	@Test(expected=NullPointerException.class)
	public void testPreviNull() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa("um nome", 40, null, 04, 40);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPreviIlle() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa("um nome", 40, "    ", 40, 04);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNomeIlle() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa("   ", 40, "meu braço doi", 40, 04);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValorIlle() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa("eu quero férias", -545121, "meu braço doi", 40, 04);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTaxaIlle() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa("yolo yolo yolo yo", 121, "my babyyy~~", -90, 40);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCustoIlle() {
		ApostaSeguraTaxa erro = new ApostaSeguraTaxa("não se matricule em aa e calc 2 ao mesmo tempo", 121, "meu braço doi", 80, -1);
	}
	
	@Test
	public void testGetNomeApostador() {
		assertEquals("BÁTIMA", at.getNomeApostador());
	}

	@Test
	public void testGetValor() {
		assertEquals(10000, at.getValor());
	}

	@Test
	public void testGetPrevisao() {
		assertEquals("VAI ACONTECER", at.getPrevisao());
	}
}
