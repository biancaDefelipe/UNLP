package tp2.ejercicio6;
/*
 Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros.
 * 
 */
import tp2.BinaryTree;
public class Transformacion {
	private BinaryTree<Integer>arbol; 
	
	public Transformacion (BinaryTree<Integer>arbol) {
		this.arbol= arbol; 
		
	}
	private static int suma(BinaryTree<Integer>bt) {
		int total=0; 
		if (bt.hasLeftChild()) { total+= suma(bt.getLeftChild());}
		if (bt.hasRightChild()) {total += suma(bt.getRightChild()); }
		int oldData= bt.getData();
		bt.setData(total);
		return oldData+ total; 
		}
		
	
	public BinaryTree<Integer> suma (){
		if (this.arbol.isEmpty()){return arbol; }
		else {
			suma(this.arbol); 
			return this.arbol; 
		}
	}
	
	public static void main (String[] args) {
		BinaryTree<Integer>bt= new BinaryTree(1); 
		bt.addLeftChild(new BinaryTree<Integer>(2));
		bt.addRightChild(new BinaryTree<Integer>(3));
		
		bt.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		bt.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		bt.getRightChild().addRightChild(new BinaryTree<Integer>(6));
		bt.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		bt.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		
		Transformacion t= new Transformacion(bt); 
		t.arbol.imprimirInOrden();
		System.out.println();
		BinaryTree<Integer>btTransformado= t.suma(); 
		btTransformado.imprimirInOrden();
	}
}
