package tp3.ejercicio8;

import tp3.GeneralTree;
public class Navidad {
	private GeneralTree<Integer> arbol; 
	
	
	
	public Navidad(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	

	private int esAbeto(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf()) {return 1;}
		if (arbol.getChildren().size()< 3) {return 0;}
		else {
			int hijosAbetos=0; 
			for (GeneralTree<Integer>hijo: arbol.getChildren()) {
				hijosAbetos+=(esAbeto(hijo)); 
			}
			if (arbol.getChildren().size() == hijosAbetos) {
				return 1; }
			else {
				return 0; 
			}
		}
	}
	public String esAbetoNavidenio() {
		if (this.arbol.isEmpty()) {
			return "no es abeto";
		}
		if (this.arbol.getChildren().size()<3) {
			return " no es abeto"; 
		}
		else {
			//El vértice 1 es la raíz. Está garantizado que la raíz tiene al menos 2 hijos.
			//esAbeto(this.arbol) ? " El arbol es un abeto " : " El arbol no es un abeto"; 
			int hijosAbetos=0;
			for (GeneralTree<Integer>hijo: this.arbol.getChildren()) {
				hijosAbetos += esAbeto(hijo); 
			}
			if (this.arbol.getChildren().size()== hijosAbetos) {return " es abeto "; }
			else {
				return " no es abeto";}
			}
		}
		
	
	public static void main(String args[]) {
		
		// ARBOL 1 (NO ES ABETO)
		//nivel 0 
		GeneralTree<Integer>arb1= new GeneralTree<Integer>(0); 
		
		//nivel 1
		arb1.addChild(new GeneralTree<Integer>(1));
		arb1.addChild(new GeneralTree<Integer>(1));
		arb1.addChild(new GeneralTree<Integer>(1));
		
		//nivel 2
		arb1.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		arb1.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		arb1.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		
		arb1.getChildren().get(1).addChild(new GeneralTree<Integer>(2));
		arb1.getChildren().get(1).addChild(new GeneralTree<Integer>(2));
		
		//nivel 3
		arb1.getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer>(3));
		arb1.getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer>(3));
		
		
		
		// ARBOL 2 (SI ES ABETO)
		//nivel 0
		GeneralTree<Integer>arb2= new GeneralTree<Integer>(0); 
	
		//nivel 1
		arb2.addChild(new GeneralTree<Integer>(1));
		arb2.addChild(new GeneralTree<Integer>(1));
		arb2.addChild(new GeneralTree<Integer>(1));
		
		//nivel 2
		arb2.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		arb2.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		arb2.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		arb2.getChildren().get(0).addChild(new GeneralTree<Integer>(2));
		
		arb2.getChildren().get(1).addChild(new GeneralTree<Integer>(2));
		arb2.getChildren().get(1).addChild(new GeneralTree<Integer>(2));
		arb2.getChildren().get(1).addChild(new GeneralTree<Integer>(2));
		
		
		//ARBOL 3 (ES ABETO)
		//nivel 0
		GeneralTree<Integer> arb3= new GeneralTree(0); 
		
		//nivel 1
		arb3.addChild(new GeneralTree<Integer>(1));
		arb3.addChild(new GeneralTree<Integer>(1));
		arb3.addChild(new GeneralTree<Integer>(1));
		arb3.addChild(new GeneralTree<Integer>(1));
		
				
		Navidad nav1= new Navidad(arb1); 
		Navidad nav2= new Navidad(arb2); 
		Navidad nav3= new Navidad (arb3); 
		
		System.out.println(nav1.esAbetoNavidenio()); 
		System.out.println(nav2.esAbetoNavidenio()); 
		System.out.println(nav3.esAbetoNavidenio()); 
		
	}
	}
	

