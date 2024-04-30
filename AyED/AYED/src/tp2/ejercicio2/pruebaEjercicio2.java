package tp2.ejercicio2;
import tp2.BinaryTree;
public class pruebaEjercicio2 {
	
	
	public static void main(String[] args) throws Exception {
	BinaryTree<Integer> arbol = new BinaryTree<Integer>(1);
	arbol.addLeftChild(new BinaryTree<Integer>(2));
	arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
	arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(5));
	arbol.addRightChild(new BinaryTree<Integer>(3));
	arbol.getRightChild().addLeftChild(new BinaryTree <Integer>(6));
	
	arbol.imprimirInOrden();
	System.out.println(); 
	arbol.imprimirPostOrden();
	System.out.println(); 
	
	BinaryTree<Integer> espejo = arbol.espejo();
	if (!(espejo.equals(null))) {
		System.out.println("espejo in orden");
		espejo.imprimirInOrden();
		System.out.println(); 
		espejo.imprimirPostOrden();
	}
	// 
	BinaryTree<Integer> arbol2 = new BinaryTree<Integer>(1); 
	arbol2.addLeftChild(new BinaryTree<Integer>(2));
	arbol2.addRightChild(new BinaryTree<Integer>(3));
	
	arbol2.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
	arbol2.getLeftChild().addRightChild(new BinaryTree<Integer>(5));
	arbol2.getRightChild().addLeftChild(new BinaryTree<Integer>(6));
	arbol2.getRightChild().addRightChild(new BinaryTree<Integer>(7));
	
	arbol2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(8));
	arbol2.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(9));
	arbol2.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(10));
	arbol2.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
	arbol2.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
	arbol2.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(13));
	arbol2.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(14));
	arbol2.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(15));
	
	arbol2.getLeftChild().getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(16));
	arbol2.getLeftChild().getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(17));
	arbol2.getLeftChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
	
	System.out.println("imprimir entre niveles 2 y 3");
	arbol2.entreNiveles(2, 3);
	System.out.println(); 
	System.out.println("imprimir entre niveles 1 y 3");
	arbol2.entreNiveles(1, 3);
	System.out.println(); 
	System.out.println("imprimir entre niveles 0 y 2");
	arbol2.entreNiveles(0, 3);
	}
}
