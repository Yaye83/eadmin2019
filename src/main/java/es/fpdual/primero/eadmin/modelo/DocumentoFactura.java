package es.fpdual.primero.eadmin.modelo;

import java.util.Date;

public class DocumentoFactura extends Documento {
	
	private final double importeFactura;

	public DocumentoFactura(int id, String nombre, Usuario usuario, Date fechaCreacion, TipoDocumento tipoDocumento, double importeFactura) {
		super(id, nombre, usuario, fechaCreacion, tipoDocumento);
		this.importeFactura = importeFactura;
		
	}

	public double getImporteFactura() {
		return importeFactura;
	}

	@Override
	public boolean equals (Object object) {
		if (object instanceof Documento) {
			final Documento documento = (Documento) object;
			return this.id == documento.getId();
}
		return false;
	}

	
}
