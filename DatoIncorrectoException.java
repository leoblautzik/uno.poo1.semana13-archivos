package uno.poo1.getPersonas;

import java.io.IOException;

public class DatoIncorrectoException extends IOException {
	public DatoIncorrectoException(String mensaje) {
		super(mensaje);
	}
}
