package tp3.ejercicio10;
import java.util.*;
import tp3.GeneralTree;
public class ParcialArboles {

	private static int buscar(GeneralTree<Integer> arbol, List<Integer>caminoActual, List<Integer>caminoFiltradoMaximo, int nivel, int costo, int costoMaximo) {
	
		if (arbol.getData() == 1) {
			caminoActual.add(1); 
			costo+= nivel; 
		}
		if (arbol.isLeaf()) {
			if (costo> costoMaximo) {
				costoMaximo= costo; 
				caminoFiltradoMaximo.removeAll(caminoFiltradoMaximo); 
				//caminoFiltradoMaximo.clear(); 
				for (Integer e: caminoActual) {
					caminoFiltradoMaximo.add(e); 
				}
			}
			//opcion 1
			if (arbol.getData()==1 ) {
				caminoActual.remove(caminoActual.size()-1); }
		}
		else {
			for(GeneralTree<Integer>hijo: arbol.getChildren()) {
				costoMaximo= buscar(hijo, caminoActual, caminoFiltradoMaximo, nivel++, costo, costoMaximo); 
				//opcion 3
				if(hijo.getData()==1) {caminoActual.remove(caminoActual.size()-1);}
			}
			//opcion 1
			if(arbol.getData()==1) {
				caminoActual.remove(caminoActual.size()-1); }
		}
		//opcion 2
		if (arbol.getData()== 1) {caminoActual.remove(caminoActual.size()-1);}
		return costoMaximo;
		
		}
	
		 
		
		
		
	
	
	public static List<Integer> resolver(GeneralTree<Integer>arbol){
		
		List<Integer>caminoFiltradoMaximo=new LinkedList<Integer>(); 
		
		if (!arbol.isEmpty()) {
			//                                               nivel, costo, costoMaximo
			List<Integer>caminoActual=new LinkedList<Integer>(); 
			int costo= buscar(arbol, caminoActual, caminoFiltradoMaximo, 0, 0, 0); 
		}
		
		
		
		return caminoFiltradoMaximo; 
		
	}
}

