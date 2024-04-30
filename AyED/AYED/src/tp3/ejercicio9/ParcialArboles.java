package tp3.ejercicio9;
import tp3.GeneralTree;
public class ParcialArboles {
	GeneralTree<Integer>arbol;

	public ParcialArboles(GeneralTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	} 
	
	private static int hijoMasPequeño(GeneralTree<Integer>arb, boolean seguir) {
		if (seguir) {
			if( arb.isLeaf()){return arb.getData(); }
			else {
				int min = Integer.MAX_VALUE; 
				for (GeneralTree<Integer>hijo: arb.getChildren()) {
					int act= hijoMasPequeño(hijo, seguir);
					min= Math.min(act, min); 
					
				}
				if (arb.getData().equals(min)) {
					return min; 
				}
				else {
					seguir = false; 
					return -1; 
				}
			}
	}else {
		return -1; 
	}
}
	private static void esDeSeleccion(GeneralTree<Integer>arb, boolean seguir) {
		if (! arb.isLeaf()) {
			hijoMasPequeño(arb, seguir); 
		}
	}
	
	public static boolean esDeSeleccion(GeneralTree<Integer>arb) {
		if (arb.isEmpty()) {
			return false; 
		}
		else { 
			boolean seguir= true; 
			esDeSeleccion(arb, seguir); 
			return seguir; 
			}
		
	}
}
