package tp3.ejercicio7;
import tp3.GeneralTree;

import java.util.List;
import java.util.LinkedList;

import tp1.ejercicio8.Queue;

public class Caminos {
	private GeneralTree<Integer>arbol; 
	
	
	 public Caminos(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}

	 private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer>arbol,List<Integer>caminoMax,List<Integer>camino){
		 
		 camino.add(arbol.getData()); 
		 if (!arbol.isLeaf()) {
			 for (GeneralTree<Integer>hijo: arbol.getChildren()) {
				 caminoAHojaMasLejana(hijo, caminoMax, camino); 
				 camino.remove(camino.size()-1);
			 }
		 }
		 else {
			 if (camino.size()> caminoMax.size()) {
				// caminoMax= camino; NO HACER ESTO ESTA SUPER MAL Y NO SIRVE!!!!
				 caminoMax.removeAll(caminoMax); 
				 caminoMax.addAll(camino); 
				 
		 }
		 }
		 return caminoMax; 
	 }

	public List<Integer> caminoAHojaMasLejana (){
		// retorne el camino a la hoja más lejana
		List<Integer>caminoMax= new LinkedList<Integer>();  
	    List<Integer>camino= new LinkedList<Integer>(); 
		if (this.arbol.isEmpty()) {return caminoMax; }
		else {
			caminoAHojaMasLejana(this.arbol, caminoMax, camino); 
			return caminoMax;
		}
	}
	public static void  main(String args[]) {
		//nivel 0
		GeneralTree<Integer>gt= new GeneralTree<Integer>(12); 
		
		//nivel 1
		gt.addChild(new GeneralTree<Integer>(17));
		gt.addChild(new GeneralTree<Integer>(9));
		gt.addChild(new GeneralTree<Integer>(15));
		
		//nivel 2
		gt.getChildren().get(0).addChild(new GeneralTree<Integer>(10));
		gt.getChildren().get(0).addChild(new GeneralTree<Integer>(16));
		
		gt.getChildren().get(1).addChild(new GeneralTree<Integer>(8));
		
		gt.getChildren().get(2).addChild(new GeneralTree<Integer>(14));
		gt.getChildren().get(0).addChild(new GeneralTree<Integer>(18));
		
		
		//nivel 3 
		gt.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer>(1));
		gt.getChildren().get(2).getChildren().get(0).addChild(new GeneralTree<Integer>(16));
		gt.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer>(7));
		
		Caminos camino = new Caminos (gt); 
		
		
		List<Integer>lista= camino.caminoAHojaMasLejana(); 
		for (Integer num: lista) {
			System.out.print(num+ " ");
		}
		
	}
}