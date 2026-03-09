package tp2.ejercicio4;
import tp2.BinaryTree;
public class RedBinariaLlena {
	BinaryTree<Integer>arbolB; 
	
	
	public RedBinariaLlena(BinaryTree<Integer>arbol) {
		this.arbolB= arbol; 
	}
	private static int retardoReenvio(BinaryTree<Integer>arbol) {
		int retI=0; int retD=0; 
		if (arbol.hasLeftChild()) { retI = retardoReenvio(arbol.getLeftChild());}
		if (arbol.hasRightChild()) {retD= retardoReenvio(arbol.getRightChild());}
		return (Math.max(retI, retD)+arbol.getData()); 
		}
	
	public int retardoReenvio() {
		return !(this.arbolB.isEmpty())? retardoReenvio(this.arbolB): 0; 
		
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
		
		RedBinariaLlena rb= new RedBinariaLlena(bt); 
		int maxRet= rb.retardoReenvio();
		System.out.println(" mayor retardo de reenvio: "+ maxRet); 
		
	}
}
