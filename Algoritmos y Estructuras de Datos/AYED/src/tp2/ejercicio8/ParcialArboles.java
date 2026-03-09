package tp2.ejercicio8;
import tp2.BinaryTree;
public class ParcialArboles {

	public boolean esPrefijo (BinaryTree<Integer>arbol1, BinaryTree<Integer> arbol2) {
		//El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
		if (! arbol1.isEmpty() || !arbol2.isEmpty()) {
			esPrefijo(arbol1, arbol2); 
		}
		return false; 
	}
	private static boolean esPrefijoPrivate (BinaryTree<Integer>arbol1, BinaryTree<Integer> arbol2){
		if (arbol1.getData() != arbol2.getData()) {
			return false; 
		}
		if (arbol1.hasLeftChild())  {
			if (arbol2.hasLeftChild()) {
			return esPrefijoPrivate(arbol1.getLeftChild(), arbol2.getLeftChild()); 
			}
			else return false;
		}
		if (arbol2.hasRightChild()) {
			if (arbol2.hasRightChild()) {
			return esPrefijoPrivate(arbol1.getRightChild(), arbol2.getRightChild());
			}
			else return false; 
		}
		return true;
	}
	
}
