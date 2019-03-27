package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ExpedienteTest {
	
	@Test
	public void deberiaDevolverTrueSiLosExpedientesSonIguales() {
		
		final Expediente expediente1 = new Expediente(10, null, null, null, null, null);
		final Expediente expediente2 = new Expediente(10, null, null, null, null, null);
		
		final boolean resultado = expediente1.equals(expediente2);
		
		assertTrue(resultado);
	}
		@Test
		public void calcularHashCode() {
			final Expediente expediente = new Expediente(22, null, null, null, null, null);
			final int resultado = expediente.hashCode();
			
			assertEquals (22, resultado);
}
		@Test
		public void deberiaConstruirUnExpedienteConDocumentos() {
			
			final Usuario usuario = new Usuario(1, "Juan", "Alcalde");
			
			//inicialización
			final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario, new Date(), "254130287");
			final Documento documento = new DocumentoContable (15, "operacion", usuario, new Date(), "5479996633");
			final Documento documentoNuevo = new Documento(20, "nuevo documento", usuario, new Date(), TipoDocumento.DOCUMENTO_PADRON);
			
			final List<Documento> documentos = new ArrayList<Documento>();
			documentos.add(documentoContable);
			documentos.add(documentoNuevo);
			documentos.add(documento);
			
			
			
			for(Documento documentoActual: documentos) {
				if (esDocumentoContable(documentoActual)) {
				System.out.println(documentoActual);
			}
			}
			
			documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);	
			final List<Documento> documentosContables = documentos.stream().filter(this::esDocumentoContable).collect(Collectors.toList());			
			
			documentos.stream().map(documentoActual -> documentoActual.getNombre()).map(nombre -> nombre.length()).forEach(longitud -> System.out.println(longitud));			
		//	documentos.stream().map(Documento::getNombre).map(String::lenght).forEach(System.out.println);
			
			for(Documento documentoActual: documentos) {
				System.out.println(documentoActual.getNombre().length());
			}
			
			//ejecución
			final Expediente expediente = new Expediente(1, "expediente 1", usuario, new Date(), TipoExpediente.EXPEDIENTE_LICENCIA_OBRAS, documentos);
		
			//comprobación
		
			assertEquals(documentos, expediente.getDocumentos());
			assertTrue(expediente.getDocumentos().contains(documentoContable));
			assertEquals(3, expediente.getDocumentos().size());
			
			}
			public boolean esDocumentoContable(Documento documento) {
				return documento.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
			}
		
	@Test
	public void deberiaObtenerLongitudNombresDocumentos() {
		
		//Inicialización
		final Usuario usuario = new Usuario(2, "usu", "c");
		final Date fechaCreacion = new Date();
		final Documento doc1 = new Documento(1, "uno", usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		final Documento doc2 = new Documento(2, "cuatro", usuario, fechaCreacion, TipoDocumento.DOCUMENTO_CONTABLE);
		
		final List<Documento> documentos = new ArrayList<>();
		documentos.add(doc1);
		documentos.add(doc2);
		
		final Expediente expediente = new Expediente(1, "nombre", usuario, fechaCreacion, TipoExpediente.EXPEDIENTE_SUBVENCIONES, documentos);
		
		//Ejecución
		final List<Integer> resultado = expediente.obtenerLongitudNombresDocumentos();
		
		//comprobación de los resultados
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		assertEquals(6, resultado.get(1).intValue());
	}
	
	
}
