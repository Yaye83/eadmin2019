package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoSubvencion extends Documento {
	
	private final double importeSubvencion;
	
	public DocumentoSubvencion(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoDocumento tipoDocumento, double importeSubvencion) {
		super(id, nombre, usuario, fechaCreacion, tipoDocumento);
		this.importeSubvencion = importeSubvencion;
		
	}

	public double getImporteSubvencion() {
		return importeSubvencion;
	}

	
	
	

}
