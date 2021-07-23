package co.edu.estructuras.modelo;

/**
 * @author Stiven Herrera Sierra.
 * Representa una tarea.
*/
public class Tarea {
	private static int CONTADOR_TAREAS = 0;
	private int id;
	private String nombre;

	public Tarea(String nombre) {
		this.id = CONTADOR_TAREAS;
		this.nombre = nombre;
		CONTADOR_TAREAS++;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Tarea [nombre=" + nombre + "]";
	}
}
