package es.fpdual.primero.eadmin.modelo.servicio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


import java.util.ArrayList;
import java.util.List;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumentoImpl;

public class ServicioDocumentoImplTest {

	
	RepositorioDocumento repositorioDocumento; 
	ServicioDocumentoImpl servicioDocumento;
	Documento documento = mock(Documento.class);
	
	@Before
	public void inicializarAntesDeCadaTest() {
		this.repositorioDocumento =  mock (RepositorioDocumento.class);
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}
	
	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		
		List<Documento> listaDevueltaPorElRepositorio = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosDocumentos()).thenReturn(listaDevueltaPorElRepositorio);
		
		final List<Documento> resultado = servicioDocumento.obtenerTodosDocumentos();
		
		assertEquals(listaDevueltaPorElRepositorio, resultado);
		
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		
		servicioDocumento.modificarDocumento(documento);
		
		verify(this.repositorioDocumento).modificarDocumento(documento);
			
	}
	
	@Test
	public void deberiaEliminarDocumentoConCodigoFacilitado() {
		
		this.servicioDocumento.eliminarDocumento(20);
		
		verify(this.repositorioDocumento).eliminarDocumento(20);
	}
	@Test
	public void deberiaAlmacenarDocumentos() {
		
		when(this.repositorioDocumento.getSiguienteId()).thenReturn(22);
		
		final Documento resultado = this.servicioDocumento.altaDocumento(documento);
		
	}
}
