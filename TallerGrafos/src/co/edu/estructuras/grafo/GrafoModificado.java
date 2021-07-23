package co.edu.estructuras.grafo;

/**
 * @author Stiven Herrera Sierra.
 * Representa un grafo dirigido, pero con funciones especiales para el taller.
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import co.edu.estructura.grafo.Enlace;
import co.edu.estructura.grafo.Grafo;
import co.edu.estructura.grafo.Nodo;
import co.edu.estructura.grafo.exception.GrafoException;
import co.edu.estructura.grafo.exception.NodoException;

public class GrafoModificado<T> extends Grafo<T> {
	
	public long getGradoEntradaNodo(T valor) throws GrafoException {
		if(!super.existeNodo(valor))
			throw new GrafoException("Error obteniendo el grado de salida: el nodo no está en el grafo.");
		
		Nodo<T> nodoDestino = getNodo(valor);
		Collection<Nodo<T>> nodos = super.getNodos().values();
		
		return nodos.stream().filter(nodo -> nodo.estaConectadoCon(nodoDestino)).count();
	}
	
	public int getGradoSalidaNodo(T valor) throws GrafoException {
		if(!super.existeNodo(valor))
			throw new GrafoException("Error obteniendo el grado de salida: el nodo no está en el grafo.");
		
		Nodo<T> nodo = getNodo(valor);
		return nodo.getGrado();
	}
	
	private Nodo<T> getNodo(T valor) throws GrafoException {
		if(!super.existeNodo(valor))
			throw new GrafoException("Error obteniendo el nodo: el nodo no está en el grafo.");
		
		return super.getNodos().get(String.valueOf(valor));
	}
	
	public long getGradoGrafo() throws GrafoException {
		long grado = 0;
		
		Collection<Nodo<T>> nodos = super.getNodos().values();
		long gradoAux;
		
		for(Nodo<T> aux : nodos) {
			gradoAux = getGradoEntradaNodo(aux.getValor()) + getGradoSalidaNodo(aux.getValor());
			
			if(gradoAux > grado)
				grado = gradoAux;
		}
		
		return grado;
	}
	
	public GrafoModificado<T> getSubgrafo(T raiz) throws GrafoException, NodoException {
		if(!super.existeNodo(raiz))
			throw new GrafoException("Error obteniendo el subgrafo: el nodo no está en el grafo.");
		
		GrafoModificado<T> grafo = new GrafoModificado<>();
		grafo.agregarNodo(raiz);
		grafo.setRaiz(raiz);
		
		Nodo<T> nodoRaiz = getNodo(raiz);
		T valorAux;
		
		for(Enlace<T> enlaceAux : nodoRaiz.getListaEnlaces()) {
			valorAux = enlaceAux.getNodoDestino().getValor();
			grafo.agregarNodo(valorAux);
			grafo.conectarNodos(raiz, valorAux, enlaceAux.getPeso());
		}
		
		return grafo;
	}
	
	public List<T> nodosPrecedentesDe(T valor) throws GrafoException {
		if(!super.existeNodo(valor))
			throw new GrafoException("Error obteniendo los nodos predecentes: el nodo no está en el grafo.");
		
		Nodo<T> nodo = getNodo(valor);
		
		Collection<Nodo<T>> nodos = super.getNodos().values();
		
		Stream<Nodo<T>> nodosPrecedentes = nodos.stream().filter(nodoAux -> nodoAux.estaConectadoCon(nodo));
		Stream<T> valorNodosPrecedentes = nodosPrecedentes.map(nodoAux -> nodoAux.getValor());
		
		List<T> listaPrecedentes = valorNodosPrecedentes.collect(Collectors.toList()); 
		
		return listaPrecedentes;
	}
	
	public int[][] getMatrizAdyacencias() {
		int size = super.size();
		int[][] matriz = new int[size][size];
		
		if(esVacia())
			return matriz;
		
		ArrayList<Nodo<T>> nodos = new ArrayList<>(super.getNodos().values());
		ArrayList<Enlace<T>> enlaces;
		Nodo<T> nodoAux;
		int posicionNodo;
		
		for (int i = 0; i < matriz.length; i++) {
			nodoAux = nodos.get(i);
			enlaces = nodoAux.getListaEnlaces();
			for (int j = 0; j < enlaces.size(); j++) {
				posicionNodo = getIndiceNodo(enlaces.get(j).getNodoDestino());
				matriz[i][posicionNodo] = enlaces.get(j).getPeso();
			}
		}
		
		return matriz;
	}
	
	private int getIndiceNodo(Nodo<T> nodo) {
		ArrayList<Nodo<T>> nodos = new ArrayList<>(super.getNodos().values());
		return (nodos.contains(nodo)) ? nodos.indexOf(nodo) : -1;
	}
	
	public boolean esVacia() {
		return super.size() == 0;
	}
}