package br.com.workgame.obfuscate.model;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.workgame.obfuscate.interfaces.Embaralhador;

public class EmbaralhadorTest {

	@Test
	public void testEmbaralhadorAnalogico() {
		Embaralhador analogico = new EmbaralhadorAnalogico();
		try {
			String original = "Lorem Ipsum";
			String altered = analogico.embaralhar(original);
			assertFalse(altered.equals(original));
		} finally {
			analogico = null;
		}
	}

	
	@Test
	public void testEmbaralhadorDigital() {		
		Embaralhador digital = new EmbaralhadorDigital();
		try {
			String original = "Lorem Ipsum";
			String altered = digital.embaralhar(original);
			assertFalse(altered.equals(original));
		} finally {
			digital = null;
		}
	}
	
	
	@Test
	public void testEmbaralhadorReverso() {
		Embaralhador reverso = new EmbaralhadorReverso();
		try {			
			String original = "Lorem Ipsum";
			String altered = reverso.embaralhar(original);
			assertTrue(altered.equals("muspI meroL"));
		} finally {
			reverso = null;
		}
	}						  
}
