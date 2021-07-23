package co.edu.estructura;

import co.edu.estructura.grafo.Grafo;
import co.edu.estructura.grafo.exception.GrafoException;
import co.edu.estructura.grafo.exception.NodoException;

/**
 * @author Stiven Herrera Sierra.
 * En esta clase se hacen las pruebas de funcionamiento del grafo.
 */
public class Principal {

	public static void main(String[] args) throws NodoException {
		Grafo<String> grafo = new Grafo<>();
		try {
			grafo.agregarNodo("A");
			grafo.agregarNodo("B");
			grafo.agregarNodo("C");
			grafo.agregarNodo("D");
			grafo.agregarNodo("E");
			
			grafo.conectarNodos("A", "B", 10);
			grafo.conectarNodos("A", "C", 3);
			
			grafo.conectarNodos("B", "C", 1);
			grafo.conectarNodos("B", "D", 2);
			
			grafo.conectarNodos("C", "B", 4);
			grafo.conectarNodos("C", "D", 8);
			grafo.conectarNodos("C", "E", 2);
			
			grafo.conectarNodos("D", "E", 7);
			
			grafo.conectarNodos("E", "D", 9);
			
			grafo.setValorNodo("C", "NuevoC");
			
			System.out.println(grafo);
			
			System.out.println(grafo.totalEnlacesNodo("NuevoC"));
		} catch (GrafoException e) {
			System.err.println(e.getMessage());
		}
		
		/*
		 * Grafo [nodos={A=Nodo [valor=A], B=Nodo [valor=B], D=Nodo [valor=D], E=Nodo [valor=E]}, raiz=null]
Nodo A -> [Enlace [nodoDestino=Nodo [valor=B], peso=10]]
Nodo B -> [Enlace [nodoDestino=Nodo [valor=D], peso=2]]
Nodo D -> [Enlace [nodoDestino=Nodo [valor=E], peso=7]]
Nodo E -> [Enlace [nodoDestino=Nodo [valor=D], peso=9]]
		 */
	}

}
