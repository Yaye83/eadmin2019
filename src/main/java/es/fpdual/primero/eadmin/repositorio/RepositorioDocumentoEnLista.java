package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {
	
	private final List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		
		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento ya existe");
		}
		documentos.add(documento);
		
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		
		//solucion 1
		Documento documentoAEliminar = new Documento(codigoDocumento, null, null, null, null);
		final int indice = documentos.indexOf(documentoAEliminar);
		documentos.remove(indice);
		
		//solucion2
		documentoAEliminar = documentos.stream().filter(d -> d.getId().intValue==codigoDocumento)findAny().orElse(null);
		final int indice = documentos.indexOf(documentoAEliminar);
		documento.remove(indice);
			
		}
			
	@Override
	public List<Documento> obtenerTodosDocumentos() {
		
		return null;
	}

	@Override
	public int getSiguienteId() {
		
		return 0;
	}

}
