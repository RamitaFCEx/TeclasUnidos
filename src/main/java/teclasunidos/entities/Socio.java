package teclasunidos.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Socio {
    private String nombre;
    private int edad;
    private String direccion;
    private String dni;

    public Socio(String nombre, int edad, String direccion, String dni) throws NombreMuyLargoException, EdadInvalidaException, DNIInvalidoException {
    	if (nombre.length()>50)
    		throw new NombreMuyLargoException();
        this.nombre = nombre;
        if (edad <0 ||edad >100) 
        	throw new EdadInvalidaException();
        this.edad = edad;
        this.direccion = direccion;
		if (!Socio.esNumerosDeLongitudValida(dni))
			throw new DNIInvalidoException();
        this.dni = dni;
    }

	private static boolean esNumerosDeLongitudValida(String cadena) {
		if (cadena == null) {
			return false;
		}

		int longitud = cadena.length();

		// 1. Verificar la longitud (de 6 a 7 caracteres)
		if (longitud < 6 || longitud > 7) {
			return false;
		}

		// 2. Verificar el contenido (solo dígitos y ningún punto)
		for (int i = 0; i < longitud; i++) {
			char caracter = cadena.charAt(i);

			// Usamos Character.isDigit(char) para verificar si es un dígito
			if (!Character.isDigit(caracter)) {
				// Si el carácter no es un dígito, la verificación falla
				return false;
			}
		}

		// Si pasa las verificaciones de longitud y contenido, es válido
		return true;
	}

    // Getters y setters
}

