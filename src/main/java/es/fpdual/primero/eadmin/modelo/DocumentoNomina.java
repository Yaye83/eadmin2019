package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoNomina extends Documento {
	
	private final double importeNomina;
	
	public DocumentoNomina(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoDocumento tipoDocumento, double importeNomina) {
		super(id, nombre, usuario, fechaCreacion, tipoDocumento);
		this.importeNomina = importeNomina;
		
	}

	public double getImporteNomina() {
		return importeNomina;
	}

	
	
	

}
