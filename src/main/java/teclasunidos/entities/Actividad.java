package teclasunidos.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String encargado;

    @Getter @Setter
    private String horario;

    @Getter @Setter
    private int edadMinima;

    @Getter @Setter
    private String lugar;

    @Getter @Setter
    private int cupo;
    private List<Socio> inscriptos = new ArrayList<>();

    public Actividad(String nombre, String encargado, String horario, int edadMinima, String lugar, int cupo) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.horario = horario;
        this.edadMinima = edadMinima;
        this.lugar = lugar;
        this.cupo = cupo;
    }

    // Getters, setters y métodos auxiliares
    public boolean agregarInscripcion(Socio socio) {
        if (socio.getEdad() <= edadMinima || inscriptos.size() >= cupo) {
            return false;
        }
        return inscriptos.add(socio);
    }

    public boolean eliminarInscripcion(Socio socio) {
        return inscriptos.remove(socio);
    }

    public String toString() {
		return nombre+"-"+lugar;
	}
}

