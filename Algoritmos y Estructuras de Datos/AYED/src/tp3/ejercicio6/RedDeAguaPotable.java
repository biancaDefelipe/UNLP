package tp3.ejercicio6;
import tp3.GeneralTree;

import java.util.List;

import tp1.ejercicio8.Queue;
public class RedDeAguaPotable {
	private  GeneralTree<Character> arbol;

	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		super();
		this.arbol = arbol;
	} 
	private double minimoCaudal(GeneralTree<Character> arbol,double caudal) {
		if(arbol.isLeaf()) {
			return caudal; 
		}
			double min= Double.MAX_VALUE; 
			System.out.println("caudal del hijo "+ arbol.getData()+" "+ caudal); 
			double caudalAct= caudal/ arbol.getChildren().size(); 
			List<GeneralTree<Character>>hijos= arbol.getChildren(); 
			for(GeneralTree<Character>hijo: hijos) {
				double totHijo= minimoCaudal(hijo, caudalAct); 
				System.out.println("caudal minimo de los hijos de  "+ arbol.getData()+" "+ caudal);
				min= Math.min(min, totHijo); 
				
			}
			System.out.println("min " + min); 
			return min; 
		}
		
	
	public double minimoCaudal(double caudal) {
		if (this.arbol.isEmpty()) {return 0;}
		return (this.arbol.isLeaf()) ? caudal : minimoCaudal(this.arbol, caudal);
		
	}
	public static void main (String args[]) {
		//nivel 0
		GeneralTree<Character>gt = new GeneralTree<Character>('A'); 
		
		//nivel 1
		gt.addChild(new GeneralTree<Character>('B'));
		gt.addChild(new GeneralTree<Character>('C'));
		gt.addChild(new GeneralTree<Character>('D'));
		gt.addChild(new GeneralTree<Character>('E'));
	
		//nivel 2
		gt.getChildren().get(1).addChild(new GeneralTree<Character>('F'));
		gt.getChildren().get(1).addChild(new GeneralTree<Character>('G'));
		
		gt.getChildren().get(2).addChild(new GeneralTree<Character>('H'));
		gt.getChildren().get(2).addChild(new GeneralTree<Character>('I'));
		gt.getChildren().get(2).addChild(new GeneralTree<Character>('J'));
		gt.getChildren().get(2).addChild(new GeneralTree<Character>('K'));
		gt.getChildren().get(2).addChild(new GeneralTree<Character>('P'));
		
		//nivel 3
		gt.getChildren().get(2).getChildren().get(2).addChild(new GeneralTree<Character>('M'));
		gt.getChildren().get(2).getChildren().get(2).addChild(new GeneralTree<Character>('N'));
		
		RedDeAguaPotable red= new RedDeAguaPotable (gt); 
		System.out.println("el caudal minimo que recibe una casa es "+ red.minimoCaudal(1000.0));
	}
}
