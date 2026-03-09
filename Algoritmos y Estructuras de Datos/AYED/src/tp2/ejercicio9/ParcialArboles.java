package tp2.ejercicio9;
import tp2.BinaryTree;
public class ParcialArboles {
	
	public BinaryTree<Dato> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Dato> nuevo= new BinaryTree<Dato>(); 
		if (!arbol.isEmpty()) {
			sumAndDif(arbol, nuevo, arbol.getData(), 0);
		}
		return nuevo;
	}
	private static void sumAndDif(BinaryTree<Integer> arbol, BinaryTree<Dato>nuevo, int sum, int padre) {
		nuevo.setData(new Dato(sum, (arbol.getData()-padre)));
		if(arbol.hasLeftChild()) {
			nuevo.addLeftChild(new BinaryTree<Dato>());
			sumAndDif(arbol.getLeftChild(), nuevo.getLeftChild(), sum+ arbol.getLeftChild().getData(), arbol.getData()); 
		}
		if(arbol.hasRightChild()) {
			nuevo.addRightChild(new BinaryTree<Dato>());
			sumAndDif(arbol.getRightChild(), nuevo.getRightChild(), sum+ arbol.getRightChild().getData(), arbol.getData()); 
		}
	}
	
	public static void main (String[] args) {
		BinaryTree<Integer>bt = new BinaryTree<Integer>(20);
		bt.addLeftChild(new BinaryTree<Integer>(5));
		bt.addRightChild(new BinaryTree<Integer>(30));
		
		bt.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
		bt.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
		
		bt.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
		bt.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
		
		bt.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
		bt.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		
		bt.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
		
		bt.imprimirInOrden();
		BinaryTree<Dato>btNuevo= sumAndDif(bt);
	}
}
