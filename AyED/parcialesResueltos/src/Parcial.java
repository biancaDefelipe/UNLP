import general.BinaryTree;
import general.Queue;

public class Parcial {

	private BinaryTree<Integer>arbol; 
	
	
	public BinaryTree<Integer>minEnNivelAB(int nivel){
		BinaryTree<Integer>nodo; 
		
		if (!this.arbol.isEmpty()&& this.arbol.hasLeftChild() || this.arbol.hasRightChild()) {
			int n=0; 
			Queue<BinaryTree<Integer>>cola= new Queue<BinaryTree<Integer>>(); 
			cola.enqueue(this.arbol);
			cola.enqueue(null);
			boolean encontre = false; //?
			BinaryTree<Integer>aux;
			while (!cola.isEmpty() && n< nivel) {
				aux= cola.dequeue();
				if (aux!= null) {
					
				}else {
					n++; 
					cola.enqueue(null);
				}
			}
			aux= cola.dequeue();
			while (aux!= null) {
				int min= Integer.MAX_VALUE;
					if (aux.isLeaf()&& aux.getData()< min) {
						min=aux.getData(); 	
						nodo= new BinaryTree<Integer>(aux.getData()); 
					}
				aux= cola.dequeue();
			}
		}
		return nodo; 
	
		
	}
	
}
