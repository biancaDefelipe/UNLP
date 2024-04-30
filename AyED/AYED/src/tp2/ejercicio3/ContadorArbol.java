package tp2.ejercicio3;
/*
Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden
 * 
 */
import tp2.BinaryTree;
import java.util.*;
public class ContadorArbol {

	private BinaryTree<Integer>arbol; 
	
	public ContadorArbol(BinaryTree<Integer>arbol) {
		this.arbol= arbol; 
	}
	private void numerosParesInOrden(BinaryTree<Integer>arbol,List<Integer>pares) {
		if (arbol.hasLeftChild()) {numerosParesInOrden(arbol.getLeftChild(), pares);}
		if ((arbol.getData()% 2) == 0) {
			pares.add(arbol.getData()); 
		}
		if (arbol.hasRightChild()) {numerosParesInOrden(arbol.getRightChild(), pares); }
		
		
	}
	public List<Integer> numerosParesInOrden(){
		if (this.arbol.isEmpty()) {return null;}
		else {	
			List<Integer> pares= new ArrayList<Integer>(); 
			this.numerosParesInOrden(this.arbol, pares); 
			return pares; 
		}
		
	}
	
	private void numerosParesPostOrden(BinaryTree<Integer>arbol, List<Integer>pares) {
		if(arbol.hasLeftChild()) {
			numerosParesPostOrden(arbol.getLeftChild(), pares); 
		}
		if (arbol.hasRightChild()) {
			numerosParesPostOrden(arbol.getRightChild(), pares); 
		}
		if (Math.floorMod(arbol.getData(), 2)== 0) {
			pares.add(arbol.getData()); 
		}
	}
	public List<Integer> numerosParesPostOrden(){
		if (this.arbol.isEmpty()) {return null; }
		else {
			List<Integer>pares= new ArrayList<Integer>(); 
			this.numerosParesPostOrden(this.arbol, pares); 
			return pares;
		}
	}
	
		
		
		
		
		public static void main(String[] args) {
			BinaryTree<Integer> arbolB= new BinaryTree<Integer>(1); 
			arbolB.addLeftChild(new BinaryTree<Integer>(2));
			arbolB.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
			arbolB.getLeftChild().addRightChild(new BinaryTree<Integer>(5));
			arbolB.addRightChild(new BinaryTree<Integer>(3));
			arbolB.getRightChild().addLeftChild(new BinaryTree <Integer>(6));
			
			ContadorArbol c= new ContadorArbol(arbolB); 
		
			
			System.out.println(); 
			List<Integer>lista1= c.numerosParesInOrden(); 
			List<Integer>lista2= c.numerosParesPostOrden();
			
			System.out.println(" impresion y recorrido in orden ");
			arbolB.imprimirInOrden();
			System.out.println();
			System.out.println("--------------------------------------"); 
			
			for (Integer num: lista1) {
				System.out.print(num+ "|");
			}
			System.out.println(); 
			System.out.println(" impresion y recorrido in orden ");
			arbolB.imprimirPostOrden();
			System.out.println();
			for (Integer num: lista2) {
				System.out.print(num+ "|");
			}
			
	}		
	
}
