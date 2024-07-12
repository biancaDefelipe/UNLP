package parcialArbol;

import java.util.List;
import java.util.LinkedList;

import general.BinaryTree;

public class Parcial {

	
	public List<Integer>resolver(BinaryTree<Integer>arbol, int min){
		
		List<Integer>camino= new LinkedList<Integer>(); 
		
		if (!arbol.isEmpty()&& min >0) {
			this.resolver(arbol, camino, min);
		}
		return camino; 
	}


	private boolean resolver(BinaryTree<Integer>arbol,List<Integer>camino, int min) {
		
		boolean  sigo = true;
		int data= arbol.getData();
		camino.add(data); 
		if( sigo && !arbol.isLeaf()) {
			if (data%2==0) {
				min--; 
			}
			if (arbol.hasLeftChild()) {
				sigo=resolver (arbol.getLeftChild(), camino, min); 
			}
			if (sigo && arbol.hasRightChild()) {
				sigo= resolver(arbol.getRightChild(), camino, min); 
			}
			
		}else{
			if(min<= 0) {
				sigo= false;
			} else {
				camino.remove(camino.size()-1);
			}
		}
		return sigo; 
		
	}
}
