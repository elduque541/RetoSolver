package co.com.clases;

public class Etiqueta {

	public Etiqueta(String texto) {
		this.setTexto(texto);
	}

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String etiqueta() {
		String respuesta = this.texto;
		String cadenaModificada = this.quitarEspaciosEnBlanco(texto);

		int numeralesEncabezado = this.buscarNumeral(cadenaModificada);
		if (this.buenaSintaxis(cadenaModificada, numeralesEncabezado)) {
			if (numeralesEncabezado > 0 && numeralesEncabezado < 7)
				respuesta = this.crearEtiqueta(cadenaModificada, numeralesEncabezado);
		}
		return respuesta;
	}

	private String quitarEspaciosEnBlanco(String texto) {
		int contador = 0;
		while (" ".equals(texto.substring(contador, contador + 1))) {
			contador += 1;
		}
		return texto.substring(contador, texto.length());
	}

	private int buscarNumeral(String texto) {
		int longitudCadena = texto.length();
		int contadorNumeral = 0;
		while (contadorNumeral < longitudCadena) {
			if ("#".equals(texto.substring(contadorNumeral, contadorNumeral + 1))) {
				contadorNumeral += 1;
				continue;
			} else
				break;
		}

		return contadorNumeral;
	}

	private boolean buenaSintaxis(String texto, int numeralesEncabezado) {
		boolean respuesta = false;
		if (texto.length() > numeralesEncabezado) {
			if (" ".equals(texto.substring(numeralesEncabezado, numeralesEncabezado + 1))) {
				respuesta = true;
			}
		}
		return respuesta;
	}

	private String crearEtiqueta(String texto, int numeralesEncabezado) {
		String etiqueta = "h" + numeralesEncabezado + ">";
		String respuesta = "<" + etiqueta + "" + texto.substring(numeralesEncabezado + 1, texto.length()) + "</"
				+ etiqueta;
		return respuesta;
	}

}
