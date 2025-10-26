package teclasunidos.repositories;

import teclasunidos.entities.Recurso;
import java.util.HashMap;
import java.util.Map;


public class RecursoRepository {
    private Map<String, Recurso> recursos = new HashMap<>();
	public Recurso buscarPorNombre(String nombreRecurso) {
		return recursos.get(nombreRecurso);
	}

	public void agregar(Recurso recurso) {
	     recursos.put(recurso.getNombre(),recurso);
	}

	public void eliminar(String nombre) {
		recursos.remove(nombre);
	}

	public void actualizar(Recurso recurso) {
		recursos.put(recurso.getNombre(), recurso);
	}

}
