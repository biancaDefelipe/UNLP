package tp2.ejercicio5;
/*
 Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de
instancia un árbol binario de números enteros y un método de instancia
sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del árbol
que se encuentren a la profundidad pasada como argumento.
 * 
 */
import tp2.BinaryTree;
public class ProfundidadDeArbolBinario {
	private BinaryTree <Integer>arbol; 
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer>bt) {
		this.arbol= bt; 
	}
	private static int sumaElementosProfundidad(BinaryTree<Integer>bt, int p, int nivel) {
		if (p==nivel) {
			return bt.getData(); 
		}
		else {
			int total=0;
			if (bt.hasLeftChild()) {
				total += sumaElementosProfundidad(bt.getLeftChild(), p, nivel+1);
			}
			if (bt.hasRightChild()) {
				total += sumaElementosProfundidad(bt.getRightChild(), p, nivel+1); 
			}
			return total; 
		}
			
	}
	public int sumaElementosProfundidad(int p) {
		return (!this.arbol.isEmpty())? sumaElementosProfundidad(this.arbol, p, 0) : 0; 
	}
	 public static void main (String[] args) {
		 BinaryTree<Integer>bt = new BinaryTree<Integer>(10); 
			bt.addLeftChild(new BinaryTree<Integer>(2));
			bt.addRightChild(new BinaryTree<Integer>(3));
			
			bt.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
			bt.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
			bt.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
			bt.getRightChild().addRightChild(new BinaryTree<Integer>(8));
			
			bt.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
			bt.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
			bt.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
			bt.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
			
			bt.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
			bt.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
			bt.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(2));
			bt.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(1));
			
			ProfundidadDeArbolBinario arbol= new ProfundidadDeArbolBinario(bt);
			System.out.println(" suma de los elementos en la profundidad 2: " + arbol.sumaElementosProfundidad(2));
			System.out.println(" suma de los elementos en la profundidad 0: " + arbol.sumaElementosProfundidad(0));
	 }
}
