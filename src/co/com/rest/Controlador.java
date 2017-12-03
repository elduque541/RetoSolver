package co.com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import co.com.clases.ServicioEtiqueta;

@Path("/servicio")
public class Controlador {

	@POST
	@Consumes("text/plain")
	@Path("/textoUsuario")
	public String textoUsuario(String textoUsuario) {
		return new ServicioEtiqueta(textoUsuario).crearEtiqueta();
	}

}
