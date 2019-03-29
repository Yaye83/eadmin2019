package es.fpdual.primero.eadmin.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;


@RestController
public class ControladorDocumento {

	ServicioDocumento servicioDocumento;
	
	public ControladorDocumento (ServicioDocumento servicioDocumento) {
	this.servicioDocumento = servicioDocumento;
	
}
@PostMapping("/documentos")
public Documento altaDocumento(@RequestBody DocumentoRequest documentoRequest) {
	final Documento documentoAInsertar = DocumentoRequestMapper.toDocumento(documentoRequest);
	return this.servicioDocumento.altaDocumento(documentoAInsertar);
}

}
	

