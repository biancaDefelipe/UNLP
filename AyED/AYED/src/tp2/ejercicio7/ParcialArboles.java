package tp2.ejercicio7;
import tp2.BinaryTree;
public class ParcialArboles {

	private BinaryTree <Integer> arbol; 
	
	public ParcialArboles (BinaryTree<Integer>bt) {
		this.arbol= bt; 
	}
	
	private static BinaryTree<Integer>buscar(BinaryTree<Integer>arbol, int num){
		
		if(arbol == null) {return null;}
		
		BinaryTree<Integer> arbol2 = buscar(arbol.getLeftChild(), num);
		
		if(arbol2 != null) {return arbol2;}		
		
		if(arbol.getData() == num) {return arbol;}
		
		arbol2 = buscar(arbol.getRightChild(), num);
		
		if(arbol2 != null) {return arbol2;}
		
		return null;
			
	}
	private int contarHojas(BinaryTree<Integer>arbol) {
		int total=0;  
		if ((arbol== null )||(arbol.isLeaf())){return 0;}
		if ((arbol.hasLeftChild() && !arbol.hasRightChild()) || 
			(arbol.hasRightChild()&& !arbol.hasLeftChild())) {
			total++; 
			System.out.println("nodo "+ arbol.getData() + " cumple condicion"); }
			
		total+=contarHojas(arbol.getLeftChild()); 
		total+= contarHojas(arbol.getRightChild()); 
		
		return total;
	}
	public boolean isLeftTree (int num) {
		int totIzq=0; int totDer=0;
		BinaryTree<Integer>bt= buscar(this.arbol, num); 
		//CORREGIR => no preguntar si es distinto de null, preguntar si no isEmpty()
		if ((bt != null )) {
			System.out.println(" encontre el nodo: "+ bt.getData());
			totIzq= contarHojas(bt.getLeftChild()); 
			System.out.println(" tot izq "+ totIzq);
			totDer= contarHojas(bt.getRightChild()); 
			System.out.println(" tot der: "+ totDer);
		}
		return (totIzq > totDer)? true: false; 
		
	}
	public static void main (String[] args) {
		BinaryTree<Integer>bt = new BinaryTree<Integer>(2); 
		bt.addLeftChild(new BinaryTree<Integer>(7));
		bt.addRightChild(new BinaryTree<Integer>(-5));
		
		bt.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
		bt.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
		bt.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
		
		bt.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		bt.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
		bt.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
		bt.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		bt.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
		
		ParcialArboles pa = new ParcialArboles(bt); 
		pa.arbol.imprimirInOrden();
		System.out.println(); 
		/*
		 El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
contrario
		 */
		System.out.println("cumple condicion el sub-arbol de raiz 7: "+pa.isLeftTree(7)); 
		System.out.println("cumple condicion el sub-arbol de raiz 2: "+pa.isLeftTree(2));
		System.out.println("cumple condicion el sub-arbol de raiz -5: "+pa.isLeftTree(-5));
		System.out.println("cumple condicion el sub-arbol de raiz 19: "+pa.isLeftTree(19));
		System.out.println("cumple condicion el sub-arbol de raiz -3: "+pa.isLeftTree(-3));
		System.out.println("cumple condicion el sub-arbol de raiz 10: "+pa.isLeftTree(10));
		
	}
}
