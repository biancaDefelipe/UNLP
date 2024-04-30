package tp3;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree <T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	private int alturaRecursivo(){
		if( this.isLeaf()){return 0; }
		else { 
			int max= -1; 
			List<GeneralTree<T>> hijos= this.getChildren(); 
			for (GeneralTree<T> hijo: hijos) {
				max= Math.max(hijo.alturaRecursivo(), max); 
			}
			max++;
			return max; 	
		}
	}
	public int altura() {	 
		/* devuelve la altura del árbol, es decir, la longitud del camino más largo desde el nodo raíz hasta una hoja.*/
		if (! this.isEmpty()) {return alturaRecursivo(); }
		return 0;
	}
	
	
	public int nivelIterativo(T dato) throws Exception {
		int nivel=0; 
		if (this.getData().equals(dato)){
			return nivel;
		}
		else {
			GeneralTree<T> aux= new GeneralTree<T>(); 
			Queue<GeneralTree<T>> cola= new Queue <GeneralTree<T>>(); 
			cola.enqueue(this);
			cola.enqueue(null); //marca de fin de nivel
			boolean encontre= false; 
			while (!cola.isEmpty() ) {
				aux= cola.dequeue(); 
				if (aux!=null) {
					if (aux.getData().equals(dato)){
						return nivel;
					}else {
						List<GeneralTree<T>>hijos= aux.getChildren(); 
						for (GeneralTree<T>hijo: hijos) {
							cola.enqueue(hijo);
						}
					}
					
				}else {
					if (! cola.isEmpty()) {
						nivel++; 
						cola.enqueue(null);
					}
				}
			}
		}
		return nivel;
	}
	public int nivel(T dato) throws Exception{
		if (!this.isEmpty()) {return nivelIterativo(dato);}
		/* devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo es la longitud del único camino de la raíz al nodo. */
		return -1;
	  }
	
	public int anchoIterativo() throws Exception {
		if (this.isLeaf()) {return 0; }
		else {
			//hacer un recorrido por niveles e ir actualizando un max
			Queue <GeneralTree<T>>cola = new Queue <GeneralTree<T>>(); 
			GeneralTree<T> aux= new GeneralTree<T>(); 
			int max=-1; 
			int total= 0; 
			cola.enqueue(this);
			cola.enqueue(null);
			
			while (!cola.isEmpty() ) {
				aux=cola.dequeue(); 
				if (aux!= null) {
					List<GeneralTree<T>>hijos= aux.getChildren(); 
					for (GeneralTree<T>hijo: hijos) {
						total++; 
						cola.enqueue(hijo);  //tengo q encolar todos los hijos pq tengo q recorrer todo el arbol si o si
					}
				}else {
					if (!cola.isEmpty()) {
						cola.enqueue(null);
						max= Math.max(max, total); 
						total=0; 
					}
				}
			}return max; 
			
		}
			
	}
	public int ancho() throws Exception{
		/* la amplitud (ancho) de un árbol se define como la cantidad de nodos que 
		    se encuentran en el nivel que posee la mayor cantidad de nodos.
		 */
		if (!this.isEmpty()) {return anchoIterativo(); }
		return 0;
	}
	
	private void numerosImparesMayoresQuePreOrden(Integer n, List <Integer>nums) {
		Integer numero= (Integer) this.getData(); 
		if ((numero % 2 != 0) && (numero >n)){nums.add(numero); }
		List<GeneralTree<T>>hijos = this.getChildren(); 
		for (GeneralTree<T> hijo: hijos) {
			hijo.numerosImparesMayoresQuePreOrden(n, nums); 
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePreOrden (Integer n){
		/* Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
			pasados como parámetros, recorrido en preorden. */
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!this.isEmpty()) {numerosImparesMayoresQuePreOrden( n, numeros); }
		return numeros; 
	}
	
	private void  numerosImparesMayoresQueInOrden(Integer n, List <Integer>nums){
		List<GeneralTree<T>>hijos = this.getChildren(); 
		if (!hijos.isEmpty()) {
			hijos.get(0).numerosImparesMayoresQueInOrden(n, nums); }
		Integer numero= (Integer) this.getData(); 
		if ((numero % 2 != 0) && (numero>n)){nums.add(numero); }
		for (int i= 1 ; i< hijos.size(); i++) {
			hijos.get(i).numerosImparesMayoresQueInOrden( n, nums); 
		}
		
	}
	public List<Integer> numerosImparesMayoresQueInOrden (Integer n){
		/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
		pasados como parámetros, recorrido en inorden*/
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!this.isEmpty()) {numerosImparesMayoresQueInOrden(n, numeros); }
		return numeros; 
	}

	
	private void numerosImparesMayoresQuePostOrden( Integer n, List <Integer>nums) {
		List<GeneralTree<T>>hijos= this.getChildren(); 
		if (!hijos.isEmpty()) {
			for (GeneralTree<T> hijo: hijos) {
				hijo.numerosImparesMayoresQuePostOrden( n, nums); }
		}
		Integer numero= (Integer) this.getData(); 
		if ((numero % 2 != 0) && (numero>n)){nums.add(numero); }
	}
	public List<Integer> numerosImparesMayoresQuePostOrden (Integer n){
		/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
			pasados como parámetros, recorrido en postorden */
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!this.isEmpty()) {numerosImparesMayoresQuePostOrden( n, numeros); }
		return numeros; 
	}
	
	private void numerosImparesMayoresQuePorNiveles( Integer n, List <Integer>nums) throws Exception {
		Queue<GeneralTree<T>>cola= new Queue<GeneralTree<T>>(); 
		GeneralTree<T> aux; 
		cola.enqueue(this);
		while (!cola.isEmpty()) {
			aux= cola.dequeue(); 
			Integer numero= (Integer) this.getData(); 
			if ((numero % 2 != 0) && (numero>n)){
				nums.add(numero); 
			}
			List<GeneralTree<T>>hijos= aux.getChildren(); 
			for (GeneralTree<T> hijo: hijos) {
				cola.enqueue(hijo);
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n) throws Exception{
			/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
			pasados como parámetros, recorrido por niveles.*/
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!this.isEmpty()) {numerosImparesMayoresQuePorNiveles( n, numeros); }
		return numeros;
	}
	
	
	
	//ejercicio5
	private boolean busquedaHijo(GeneralTree<T> arbol, T b) throws Exception {
		Queue <GeneralTree<T>> cola= new Queue<GeneralTree<T>>(); 
		cola.enqueue(arbol);
		
		while (!cola.isEmpty()) {
			GeneralTree<T> aux= cola.dequeue();
			if (aux.getData().equals(b)) {
				return true;
			}else {
				List<GeneralTree<T>>hijos = aux.getChildren(); 
				for (GeneralTree<T>hijo: hijos) {
					
					cola.enqueue(hijo); 
				}
		
			}			
		}
		return false;
	}
	private boolean busquedaPadre(T a, T b) throws Exception {
		if (this.isLeaf()) {return false;}
		else {
			boolean encontre= false; 
			GeneralTree<T> aux; 
			GeneralTree<T> padre=null; 
			Queue <GeneralTree<T>> cola= new Queue<GeneralTree<T>>(); 
			cola.enqueue(this);
			
			while (!cola.isEmpty() && !encontre) {
				aux= cola.dequeue(); 
				if (aux.getData().equals(b)) {
					return false;            //si encontre b primero ya retorno false
				}
				if (aux.getData().equals(a) ) {   //si encontre el padre y tiene hijos llamo a buscarRecursivo con el subarbol
					padre= aux; 
			
					encontre=true;
					
				}else { 
					 if (!encontre){// si no encontre al padre sigo buscando
				
					List<GeneralTree<T>>hijos = aux.getChildren(); 
					for (GeneralTree<T>hijo: hijos) {
						cola.enqueue(hijo);
					}
					 }
				}
			}return busquedaHijo(padre, b);  
		}
	}
	public boolean esAncestro(T a, T b) throws Exception {
		//devuelve true si el valor “a” es ancestro del valor “b”.
		if (this.isEmpty() ) {return false;} 
		else {
			return busquedaPadre(a, b); 
		}
	}
	
	
}