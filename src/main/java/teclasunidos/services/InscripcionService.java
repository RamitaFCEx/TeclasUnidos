package teclasunidos.services;

import teclasunidos.entities.Actividad;
import teclasunidos.entities.Socio;

public class InscripcionService {
    public boolean inscribir(Socio socio, Actividad actividad) {
        return actividad.agregarInscripcion(socio);
    }

    public boolean eliminarInscripcion(Socio socio, Actividad actividad) {
        return actividad.eliminarInscripcion(socio);
    }
}

