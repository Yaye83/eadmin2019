package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		System.out.println("Documento " + documento.getNombre() + " almacenado correctamente"); 
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int id) {
		
		//solucion 1, mejor solución
		Documento documentoAEliminar = new Documento(id, null, null, null, null);
		
		//solucion2
		//documentoAEliminar = documentos.stream().filter(d -> d.getId() == id).findAny().orElse(null);
		
		final int indice = documentos.indexOf(documentoAEliminar);
		if (indice >=0) {
			documentos.remove(indice);
		
		}
	}
			
	@Override
	public List<Documento> obtenerTodosDocumentos() {
	
		return this.documentos.stream().collect(Collectors.toList());
		//así sería más conveniente pues se crea una copia del repositorio y no se perderían ni modificarían
		//datos del repositorio original
	}

	@Override
	public int getSiguienteId() {
		if(documentos.isEmpty()) { //para comprobar si la vista está vacía
			return 1;
		}
		return documentos.get(documentos.size()-1).getId()+1;
		
		//documento que esté en la última posición y a ese se le suma 1, y ese será el 
		//siguiente id
		 
	}

}
