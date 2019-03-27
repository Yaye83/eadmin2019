package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class DocumentoTest  {

	@Test
	public void deberiaDevolverTrueSiLosDocumentosSonIguales() {
		
		//inicializacion
		final Documento documento1 = new Documento(20, null, null, null, null);
		final Documento documento2 = new Documento(20, null, null, null, null);
		
		//ejecucion
		final boolean resultado = documento1.equals(documento2);
		
		//comprobacion de los resultados
		assertTrue(resultado);
}
	@Test
	public void calcularHashCode() {
		final Documento documento = new Documento(20, null, null, null, null);
		final int resultado = documento.hashCode();
		
		assertEquals (20, resultado);
}
		
}