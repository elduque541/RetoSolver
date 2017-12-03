package co.com.clases;

public class ServicioEtiqueta {
    
    private static final int UNO = 1;
    private static final int SIETE = 7;
    
    private static final String ETIQUETA_CIERRE_RESUMIDA = "</";
    private static final String ETIQUETA_ABRE = "<";
    private static final String ETIQUETA_CIERRE = ">";
    
    private static final String VACIO = "";
    private static final String ESPACION_EN_BLANCO = " ";
    
    private static final String ETIQUETA_H = "h";
    
    private static final String NUMERAL = "#";
    
    private String textoIngresado;

	public ServicioEtiqueta(String textoIngresado) {
        this.textoIngresado = textoIngresado;
    }

    public String crearEtiqueta() {
	    String respuesta = this.textoIngresado;
		String cadenaModificada = this.quitarEspaciosEnBlanco(respuesta);

		int numeralesEncabezado = this.buscarNumeral(cadenaModificada);
		if (this.buenaSintaxis(cadenaModificada, numeralesEncabezado) && (numeralesEncabezado > 0 && numeralesEncabezado < SIETE)) {
			respuesta = this.crearEtiqueta(cadenaModificada, numeralesEncabezado);
		}
		return respuesta;
	}

	private String quitarEspaciosEnBlanco(String texto) {
		int contador = 0;
		while (ESPACION_EN_BLANCO.equals(texto.substring(contador, contador + UNO))) {
			contador += UNO;
		}
		return texto.substring(contador, texto.length());
	}

	private int buscarNumeral(String texto) {
		int longitudCadena = texto.length();
		int contadorNumeral = 0;
		while (contadorNumeral < longitudCadena) {
			if (NUMERAL.equals(texto.substring(contadorNumeral, contadorNumeral + UNO))) {
				contadorNumeral += UNO;
			} else
				break;
		}

		return contadorNumeral;
	}

	private boolean buenaSintaxis(String texto, int numeralesEncabezado) {
		boolean respuesta = false;
		if (texto.length() > numeralesEncabezado && ESPACION_EN_BLANCO.equals(texto.substring(numeralesEncabezado, numeralesEncabezado + UNO))) {
		    respuesta = true;
		}
		return respuesta;
	}

	private String crearEtiqueta(String texto, int numeralesEncabezado) {
		String etiqueta = ETIQUETA_H + numeralesEncabezado + ETIQUETA_CIERRE;
		return ETIQUETA_ABRE + etiqueta + VACIO + texto.substring(numeralesEncabezado + UNO, texto.length()) + ETIQUETA_CIERRE_RESUMIDA + etiqueta;
	}

}
