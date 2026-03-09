package tp3.ejercicio9;
import tp3.GeneralTree;
import tp1.ejercicio8.*;

public class ParcialArboles {

public class ParcialArboles9 {

	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) throws Exception {
		
		Queue<GeneralTree<Integer>> c = new Queue<GeneralTree<Integer>>();

		boolean ok = true;
		
		// Caso arbol vacío.
		if((!arbol.isEmpty()) && (!arbol.isLeaf())) {
			
			c.enqueue(arbol);
			
			while((!c.isEmpty()) && ok) {
				
				GeneralTree<Integer> elem = c.dequeue();
					
				int min = Integer.MAX_VALUE; // Inicializo en un valor muy grande y positivo.
				
				// Foreach hijo en la lista de hijos del nodo que desencolé...
				for(GeneralTree<Integer> hijo : elem.getChildren()){
				
					// Lo encolo solo si no es hoja, porque si es hoja, cuando me toque desencolarlo y
					// procesarlo, no entrará a este for, ni al if que sigue... o sea, no hace nada.
					// Sería sacarlo para que no haga nada. Entonces así evito ese tiempo perdido.
					if(!hijo.isLeaf()) {
						
						c.enqueue(hijo); // Encolo el hijo.
					}
					
					min = Math.min(min,  hijo.getData()); // Dame el minimo entre minimo y el valor del hijo actual.
				}
				
				if((!elem.isLeaf()) && (min != elem.getData())) {
				
					ok = false;
				}
			}
		}
		
		return ok;
	}
}
}

