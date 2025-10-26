package teclasunidos.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Recurso {
    private String nombre;
    private String ubicacion;

    public Recurso(String nombre, String ubicacion) {
    	if (nombre!=null && nombre.equalsIgnoreCase("Oficina"))
    		return ;

        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
}

