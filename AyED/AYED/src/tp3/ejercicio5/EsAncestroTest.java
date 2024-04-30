package tp3.ejercicio5;
import tp3.GeneralTree;
import tp3.ejercicio4.AreaEmpresa;

public class EsAncestroTest {
	private GeneralTree<Integer> arbol;

	public EsAncestroTest(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	} 
	
	public GeneralTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public static void main (String args[]) throws Exception {

		//nivel 0
		GeneralTree<Integer> gt= new GeneralTree<Integer>( 14);
		
		//nivel 1
		gt.addChild(new GeneralTree<Integer>(13));
		gt.addChild(new GeneralTree<Integer>(25));
		gt.addChild(new GeneralTree<Integer>(11));
		
		//nivel 2
		gt.getChildren().get(0).addChild(new GeneralTree<Integer>(4));
		gt.getChildren().get(0).addChild(new GeneralTree<Integer>(7));
		gt.getChildren().get(0).addChild(new GeneralTree<Integer>(5));
		
		gt.getChildren().get(1).addChild(new GeneralTree<Integer>(6));
		gt.getChildren().get(1).addChild(new GeneralTree<Integer>(10));
		gt.getChildren().get(1).addChild(new GeneralTree<Integer>(18));
		
		gt.getChildren().get(2).addChild(new GeneralTree<Integer>(9));
		gt.getChildren().get(2).addChild(new GeneralTree<Integer>(12));
		gt.getChildren().get(2).addChild(new GeneralTree<Integer>(19));

		
		//nivel 3
		gt.getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer>(40));
		gt.getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer>(30));
		gt.getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer>(33));
		
		
		//nivel 4
		gt.getChildren().get(1).getChildren().get(2).getChildren().get(0).addChild(new GeneralTree<Integer>(24));
		
		EsAncestroTest tester= new EsAncestroTest(gt); 
		
		System.out.println("10 es ancestro de 25? -> " + tester.getArbol().esAncestro(10, 25)); //no 
		System.out.println("25 es ancestro de 33? -> " + tester.getArbol().esAncestro(25, 33)); //si
		System.out.println("13 es ancestro de 10? -> " + tester.getArbol().esAncestro(13, 10)); //no
		System.out.println("14 es ancestro de 12? -> " + tester.getArbol().esAncestro(14, 12)); //si
		System.out.println("78 es ancestro de 25? -> " + tester.getArbol().esAncestro(78, 25)); // no (no existe arb 78)



		
		
	}
}
