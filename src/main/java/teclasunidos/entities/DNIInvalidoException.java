package teclasunidos.entities;

public class DNIInvalidoException extends Exception {
    public static final String MSG = "El DNI debe estar compuesto de 6 o 7 números y sin puntos";
    public DNIInvalidoException(){
        super(MSG);
    }
}
