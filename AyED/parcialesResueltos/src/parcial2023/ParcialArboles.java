package parcial2023;
import general.GeneralTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class ParcialArboles {
	private GeneralTree<Integer>arbol; 
	
	public ParcialArboles(GeneralTree<Integer>gt) {
		this.arbol=gt; 
	}
	
	public List<Integer> camino(int num){
		List<Integer> cam= new LinkedList<Integer>(); 
		if (!this.arbol.isEmpty()&& num>0) {
			camino(this.arbol, cam, num, 0); 
		}
		return cam; 
	}
	private static boolean camino(GeneralTree<Integer>arbol, List<Integer>cam, int num, int total) {
		boolean sigo= true; 
		cam.add(arbol.getData()); 
		
		List<GeneralTree<Integer>>hijos= arbol.getChildren();
		Iterator<GeneralTree<Integer>> it= hijos.iterator(); 
		
		int subTotal= total+arbol.getData(); 
		while (sigo && it.hasNext()) {
			GeneralTree<Integer>aux=it.next();
			sigo= camino(aux,cam, num, subTotal);
		}
		if(!it.hasNext() && sigo) {
			cam.remove(cam.size()-1); 
		}
		else {
			if(subTotal %num== 0) {
				sigo= false; 
			}
		}
		return sigo; 
	
	}
}
