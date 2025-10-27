package tdyv.java;

import java.util.ArrayList;

public class Actividad {
public Actividad(String nombre, Persona encargado, int cupo, int edadMInima) {
		super();
		this.nombre = nombre;
		this.encargado = encargado;
		this.cupo = cupo;
		this.edadMinima = edadMInima;
	}

String nombre;
Persona encargado;
ArrayList<Socio> inscriptos;
int edadMinima;
int cupo;


public int getEdadMinima() {
	return edadMinima;
}
public void setEdadMinima(int edadMinima) {
	this.edadMinima = edadMinima;
}
public int getCupo() {
	return cupo;
}
public void setCupo(int cupo) {
	this.cupo = cupo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Persona getEncargado() {
	return encargado;
}
public void setEncargado(Persona encargado) {
	this.encargado = encargado;
}
public ArrayList<Socio> getInscriptos() {
	return inscriptos;
}
public void setInscriptos(ArrayList<Socio> inscriptos) {
	this.inscriptos = inscriptos;
}
public int getCantidadLimiteParticipantes() {
	return cupo;
}
public void setCantidadLimiteParticipantes(int cupo) {
	this.cupo = cupo;
}
public void inscribirSocio(Socio s) throws CupoExcedidoException, EdadInsuficienteException{
	if(inscriptos== null) inscriptos = new ArrayList<Socio>();
	if(s.getPersona().getEdad()<edadMinima)  throw new EdadInsuficienteException();
	if(this.getInscriptos().size() < this.getCupo()) throw new CupoExcedidoException();
		
		inscriptos.add(s);
}
public String toString() {
	return this.getNombre()+"  a cargo de "+this.getEncargado().getNombre();
}
}
