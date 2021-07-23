package co.edu.estructuras.taller;

import java.util.Arrays;

import co.edu.estructura.grafo.exception.GrafoException;
import co.edu.estructura.grafo.exception.NodoException;
import co.edu.estructuras.grafo.GrafoModificado;
import co.edu.estructuras.modelo.Tarea;

/**
 * @author Stiven Herrera Sierra.
 * Acá se resuelve cada uno de los puntos del taller, haciendo uso de las funciones del grafo modificado.
*/
public class Principal {
	public static void main(String[] args) {
		GrafoModificado<Tarea> grafo = new GrafoModificado<>();
		Tarea tareaA = new Tarea("A");
		Tarea tareaB = new Tarea("B");
		Tarea tareaC = new Tarea("C");
		Tarea tareaD = new Tarea("D");
		Tarea tareaE = new Tarea("E");
		
		//Punto 1. Creando el grafo.
		try {			
			grafo.agregarNodo(tareaA);
			grafo.agregarNodo(tareaB);
			grafo.agregarNodo(tareaC);
			grafo.agregarNodo(tareaD);
			grafo.agregarNodo(tareaE);
			
			grafo.conectarNodos(tareaA, tareaB, 10);
			grafo.conectarNodos(tareaA, tareaC, 3);
			
			grafo.conectarNodos(tareaB, tareaC, 1);
			grafo.conectarNodos(tareaB, tareaD, 2);
			
			grafo.conectarNodos(tareaC, tareaB, 4);
			grafo.conectarNodos(tareaC, tareaD, 8);
			grafo.conectarNodos(tareaC, tareaE, 2);
			
			grafo.conectarNodos(tareaD, tareaE, 7);
			
			grafo.conectarNodos(tareaE, tareaD, 9);
			
			System.out.println(grafo);
		} catch (GrafoException | NodoException e) {
			System.err.println(e.getMessage());
		}
		
		//Punto 2. Obtener el grado de entrada y salida de un nodo.
		try {
			System.out.println("El nodo " + tareaA + " tiene un grado de entrada: " + grafo.getGradoEntradaNodo(tareaA));
			System.out.println("El nodo " + tareaA + " tiene un grado de salida: " + grafo.getGradoSalidaNodo(tareaA));
			
			System.out.println("El nodo " + tareaB + " tiene un grado de entrada: " + grafo.getGradoEntradaNodo(tareaB));
			System.out.println("El nodo " + tareaB + " tiene un grado de salida: " + grafo.getGradoSalidaNodo(tareaB));
			
			System.out.println("El nodo " + tareaC + " tiene un grado de entrada: " + grafo.getGradoEntradaNodo(tareaC));
			System.out.println("El nodo " + tareaC + " tiene un grado de salida: " + grafo.getGradoSalidaNodo(tareaC));
			
			System.out.println("El nodo " + tareaD + " tiene un grado de entrada: " + grafo.getGradoEntradaNodo(tareaD));
			System.out.println("El nodo " + tareaD + " tiene un grado de salida: " + grafo.getGradoSalidaNodo(tareaD));
			
			System.out.println("El nodo " + tareaE + " tiene un grado de entrada: " + grafo.getGradoEntradaNodo(tareaE));
			System.out.println("El nodo " + tareaE + " tiene un grado de salida: " + grafo.getGradoSalidaNodo(tareaE));
		} catch (GrafoException e) {
			System.err.println(e.getMessage());
		}
		
		//Punto 3. Obtener el grado de un grafo (mayor grado de los vértices).
		try {
			System.out.println("El grado del grafo es: " + grafo.getGradoGrafo());
		} catch (GrafoException e) {
			System.err.println(e.getMessage());
		}
		
		//Punto 4. Subgrafo con los nodos conectados directamente a otro.
		try {
			System.out.println("Subgrafo de C:\n");
			System.out.println(grafo.getSubgrafo(tareaC));
			System.out.println(grafo);
		} catch (GrafoException | NodoException e) {
			System.err.println(e.getMessage());
		}
		
		//Punto 5. Comprobar si dos nodos están conectados.
		try {
			System.out.println("Los nodos D y E están conectados: " + grafo.estanConectados(tareaD, tareaE));
			System.out.println("Los nodos D y A están conectados: " + grafo.estanConectados(tareaD, tareaA));
		} catch (GrafoException e) {
			System.err.println(e.getMessage());
		}
		
		//Punto 6. Obtener nodos que preceden otro (llegan a él).
		try {
			System.out.println("Los nodos que preceden a D son:");
			System.out.println(grafo.nodosPrecedentesDe(tareaD));
			
			System.out.println(grafo);
		} catch (GrafoException e) {
			System.err.println(e.getMessage());
		}
		
		//Punto 7. Obtener matriz de adyacencias.
		System.out.println(Arrays.deepToString(grafo.getMatrizAdyacencias()).replace("], ", "]\n"));
	}
}
