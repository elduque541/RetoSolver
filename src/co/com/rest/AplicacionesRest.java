package co.com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import co.com.clases.Controlador;

@Path("/servicios")
public class AplicacionesRest {

	@GET
	@Path("/test")
	public String test() {
		return "TestOK";
	}

	@POST
	@Consumes("text/plain")
	@Path("/textoUsuario")
	public String textoUsuario(String texto) {
		return new Controlador().etiqueta(texto);
	}

}
