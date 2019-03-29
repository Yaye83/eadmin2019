package es.fpdual.primero.eadmin.repositorio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

public class RepositorioDocumentoEnListaTest {

	private RepositorioDocumentoEnLista repositorioDocumento; //lo vamos a necesitar en cada test, por eso lo instanciamos aquí
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoEnLista();
		this.documento = mock(Documento.class);
	}
	
	@Test
	public void deberiaAlmacenarNuevoDocumento() {
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue (this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
		
	}
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExceptionAlAlmacenarDocumentoYaExistente() {
		
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
	
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		
		Documento documentoAlmacenado = new Documento (20, "documento1", null, null, null);
		Documento documentoModificado = new Documento (20, "documento2", null, null, null);
		
		this.repositorioDocumento.altaDocumento(documentoAlmacenado);
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		
		assertEquals("documento2", this.repositorioDocumento.obtenerTodosDocumentos().get(0).getNombre());
	}
	
	
	@Test(expected = AdministracionElectronicaException.class)
	public void deberiaLanzarUnaExcepcionAlModificarDocumento() {
		
		Documento documentoAlmacenado = new Documento (20, "documento1", null, null, null);
		this.repositorioDocumento.modificarDocumento(documentoAlmacenado);
		
		
	}
	@Test
	public void deberiaEliminarUnDocumento() {
		
		when(documento.getId()).thenReturn(2);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(2);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().isEmpty());
	}
	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEliminarNoExiste() {
		this.repositorioDocumento.eliminarDocumento(2);
	}
	
	@Test
	public void deberiaDevolver1SiLaListaEstaVacia() {
		
		assertEquals(1, this.repositorioDocumento.getSiguienteId());
	
	}
	@Test
	public void deberiaDevolverElSiguienteId() {
		
		when(documento.getId()).thenReturn(2);
		when(documento.getNombre()).thenReturn("documento1");
		this.repositorioDocumento.altaDocumento(documento);
		final int resultado = this.repositorioDocumento.getSiguienteId();
		assertEquals(3, resultado);
	}
}

