package teclasunidos.entities;

public class Recurso {
    private String nombre;
    private String ubicacion;

    public Recurso(String nombre, String ubicacion) {
    	if (nombre!=null && nombre.equalsIgnoreCase("Oficina"))
    		return ;

        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

	public String getNombre() {
		return nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}

    // Getters y setters
}

