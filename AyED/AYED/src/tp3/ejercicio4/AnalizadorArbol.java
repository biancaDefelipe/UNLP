package tp3.ejercicio4;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.GeneralTree;
public class AnalizadorArbol {
	public AnalizadorArbol() {
		
	}
	
	private double promedioPorNiveles(GeneralTree<AreaEmpresa>arbol) throws Exception {
		if (arbol.isLeaf()) {return arbol.getData().getTardanza(); }
		else {
			//hacer un recorrido por niveles e ir actualizando un max
			Queue <GeneralTree<AreaEmpresa>>cola = new Queue <GeneralTree<AreaEmpresa>>(); 
			GeneralTree<AreaEmpresa> aux= new GeneralTree<AreaEmpresa>(); 
			double maxProm=-1; 
			double totalProm=0; 
			int cantHijos=0; 
			cola.enqueue(arbol);
			cola.enqueue(null);
			while (!cola.isEmpty() ) {
				aux=cola.dequeue(); 
				if (aux!= null) {
					cantHijos++; 
					totalProm+= aux.getData().getTardanza();
					List<GeneralTree<AreaEmpresa>>hijos= aux.getChildren(); 
					for (GeneralTree<AreaEmpresa>hijo: hijos) {
						cola.enqueue(hijo);  //tengo q encolar todos los hijos pq tengo q recorrer todo el arbol si o si
					}
				}else {
					if (!cola.isEmpty()) {
	
						totalProm= totalProm/cantHijos; 
						maxProm= Math.max(maxProm,totalProm ); 
						cola.enqueue(null); 					
						totalProm=0; 
						cantHijos=0; 
					}
				}
			}return maxProm; 
			
		}
	}
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) throws Exception {
	
		if (!arbol.isEmpty()) {return promedioPorNiveles(arbol); }
		else{return -1; }
	
}
	public static void main (String ars[] ) throws Exception{
		//nivel 0
		GeneralTree<AreaEmpresa> gt= new GeneralTree<AreaEmpresa>(new AreaEmpresa("M", 14));
		
		
		//nivel 1
		gt.addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("J", 13)));
		gt.addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("K", 25)));
		gt.addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("L", 10)));
		
		
		//nivel 2
		gt.getChildren().get(0).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A", 4)));
		gt.getChildren().get(0).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B", 7)));
		gt.getChildren().get(0).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C", 5)));
		
		gt.getChildren().get(1).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D", 6)));
		gt.getChildren().get(1).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E", 10)));
		gt.getChildren().get(1).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F", 18)));
		
		gt.getChildren().get(2).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G", 9)));
		gt.getChildren().get(2).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H", 12)));
		gt.getChildren().get(2).addChild(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I", 19)));
		
		AnalizadorArbol analizador= new AnalizadorArbol(); 
		
		System.out.println("el mayor promedio es "+ analizador.devolverMaximoPromedio(gt) ); 
	}
}