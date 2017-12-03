package test;

import org.junit.Assert;
import org.junit.Test;

import co.com.clases.ServicioEtiqueta;

public class ServicioEtiquetaTest {

	@Test
	public void validarEtiquetaCreadaH1() {
		// Arrange
		ServicioEtiqueta servicioEtiqueta = new ServicioEtiqueta("# hola");
		// Act
		String respuesta = servicioEtiqueta.crearEtiqueta();
		// Assert
		Assert.assertEquals(respuesta, "<h1>hola</h1>");
	}
	
	@Test
	public void validarEtiquetaCreadaH5ConEspacios() {
		// Arrange
		ServicioEtiqueta servicioEtiqueta = new ServicioEtiqueta("  ##### hola");
		// Act
		String respuesta = servicioEtiqueta.crearEtiqueta();
		// Assert
		Assert.assertEquals(respuesta, "<h5>hola</h5>");
	}

	@Test
	public void validarEtiquetaCreadaH1ConEspacios() {
		// Arrange
		ServicioEtiqueta servicioEtiqueta = new ServicioEtiqueta("  # hola");
		// Act
		String respuesta = servicioEtiqueta.crearEtiqueta();
		// Assert
		Assert.assertEquals(respuesta, "<h1>hola</h1>");
	}

	@Test
	public void validarEtiquetaCreadaH1SinEspacios() {
		// Arrange
		ServicioEtiqueta servicioEtiqueta = new ServicioEtiqueta("#hola");
		// Act
		String respuesta = servicioEtiqueta.crearEtiqueta();
		// Assert
		Assert.assertEquals(respuesta, "#hola");
	}
}
