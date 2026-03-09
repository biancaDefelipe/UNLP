package parcial1;

import java.util.List;
import java.util.LinkedList;

import general.GeneralTree;

public class Caminos {
	private GeneralTree<Dato>arbol; 
	
	
	
	public Caminos(GeneralTree<Dato>ab) {
		this.arbol= ab; 
	}
	
	
	private static void caminoRecursivo(GeneralTree<Dato>ab,List <GeneralTree<Dato>> camino ) {
		if (ab.hasChildren()) {
			if (ab.getData().getNumero()<= (ab.getChildren().size())) {
				camino.add(ab); 
			
				System.out.println("llamada1");
				caminoRecursivo(ab.getChildren().get((ab.getData().getNumero())-1), camino); }
			else {System.out.println("ERROR! el valor contenido en el arbol supera la cantidad de hijos del mismo");}
		}else {
			camino.add(ab);
		}
	}
	public List<GeneralTree<Dato>>CaminoDeterminado(GeneralTree<Dato>ab){
		List <GeneralTree<Dato>> camino = new LinkedList<GeneralTree<Dato>>(); 
		if (!ab.isEmpty()){
			caminoRecursivo(ab, camino); 
		}
		return camino; 
	}
	
	
	public static void main (String args[]) {
		GeneralTree<Dato>raizArbol= new GeneralTree<Dato>(new Dato("G", 1)); 
		GeneralTree<Dato>hijo1=new GeneralTree<Dato>(new Dato ("E", 3));
		GeneralTree<Dato>hijo2=new GeneralTree<Dato>(new Dato ("F", 2));
		GeneralTree<Dato>hijo3=new GeneralTree<Dato>(new Dato ("J", 5));
		
		hijo1.addChild(new GeneralTree<Dato>(new Dato("A", 2)));
		hijo1.addChild(new GeneralTree<Dato>(new Dato("B", 9)));
		hijo1.addChild(new GeneralTree<Dato>(new Dato("C", 5)));
		
		hijo2.addChild(new GeneralTree<Dato>(new Dato("D", 10)));
		
		hijo3.addChild(new GeneralTree<Dato>(new Dato("H", 5)));
		hijo3.addChild(new GeneralTree<Dato>(new Dato("I", 10)));
		
		raizArbol.addChild(hijo1);
		raizArbol.addChild(hijo2);
		raizArbol.addChild(hijo3);
		System.out.println(raizArbol.getChildren().size());
		
		Caminos c= new Caminos(raizArbol);//me sirve de algo que el arbol sea un atributo de la clase Caminos
		List<GeneralTree<Dato>>caminoDeterminado= c.CaminoDeterminado(raizArbol);
		
		for (GeneralTree<Dato> elem: caminoDeterminado) {
			System.out.println(" ---------------------------------------  ");
			System.out.println(elem.getData().getLetra());
		}
		
	}

	
	
}

