package teclasunidos.entities;

public class NombreMuyLargoException extends Exception {
        public static final String MSG = "El nombre no puede exceder los 50 caracteres";
        public NombreMuyLargoException(){
            super(MSG);
        }
}
