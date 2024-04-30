package tp3.ejercicio2;
import java.util.*;
import tp3.GeneralTree;
import tp1.ejercicio8.Queue;
public class RecorridoAG {
	private GeneralTree<Integer> arbol; 
	
	public RecorridoAG() {
		
	}
	public RecorridoAG(GeneralTree<Integer>arb) {
		this.arbol= arb; 
	}
	
	private static void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n, List <Integer>nums) {
		if ((a.getData() % 2 != 0) && (a.getData()>n)){nums.add(a.getData()); }
		List<GeneralTree<Integer>>hijos = a.getChildren(); 
		for (GeneralTree<Integer> hijo: hijos) {
			numerosImparesMayoresQuePreOrden(hijo, n, nums); 
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		/* Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
			pasados como parámetros, recorrido en preorden. */
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!a.isEmpty()) {numerosImparesMayoresQuePreOrden(a, n, numeros); }
		return numeros; 
	}
	
	
	
	private static void  numerosImparesMayoresQueInOrden(GeneralTree <Integer> a,Integer n, List <Integer>nums){
		List<GeneralTree<Integer>>hijos = a.getChildren(); 
		if (!hijos.isEmpty()) {numerosImparesMayoresQueInOrden( hijos.get(0), n, nums); }
		if ((a.getData() % 2 != 0) && (a.getData()>n)){nums.add(a.getData()); }
		for (int i= 1 ; i< hijos.size(); i++) {
			numerosImparesMayoresQueInOrden(hijos.get(i), n, nums); 
		}
		
	}
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
		pasados como parámetros, recorrido en inorden*/
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!a.isEmpty()) {numerosImparesMayoresQueInOrden(a, n, numeros); }
		return numeros; 
	}
	
	private static void numerosImparesMayoresQuePostOrden(GeneralTree<Integer>a, Integer n, List <Integer>nums) {
		List <GeneralTree<Integer>>hijos= a.getChildren(); 
		if (!hijos.isEmpty()) {
			for (GeneralTree<Integer>hijo: hijos) {
				numerosImparesMayoresQuePostOrden(hijo, n, nums); }
		}
		if ((a.getData() % 2 != 0) && (a.getData()>n)){nums.add(a.getData()); }
	}
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
			pasados como parámetros, recorrido en postorden */
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!a.isEmpty()) {numerosImparesMayoresQuePostOrden(a, n, numeros); }
		return numeros; 
	}
	
	
	private static void numerosImparesMayoresQuePorNiveles(GeneralTree<Integer>a, Integer n, List <Integer>nums) throws Exception {
		Queue<GeneralTree<Integer>>cola= new Queue<GeneralTree<Integer>>(); 
		GeneralTree<Integer> aux; 
		cola.enqueue(a);
		while (!cola.isEmpty()) {
			aux= cola.dequeue(); 
			if ((aux.getData() % 2 != 0) && (aux.getData()>n)){
				nums.add(aux.getData()); 
			}
			List<GeneralTree<Integer>>hijos= aux.getChildren(); 
			for (GeneralTree<Integer> hijo: hijos) {
				cola.enqueue(hijo);
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n) throws Exception{
			/*Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
			pasados como parámetros, recorrido por niveles.*/
		List<Integer>numeros = new LinkedList<Integer>(); 
		if (!a.isEmpty()) {numerosImparesMayoresQuePorNiveles(a, n, numeros); }
		return numeros;
	}
	
	public static void main (String [] args) throws Exception {
		
		GeneralTree<Integer> gt10= new GeneralTree<Integer>(10);
		gt10.addChild(new GeneralTree<Integer>(19));
		
		
		GeneralTree<Integer> gt90= new GeneralTree<Integer>(90); 
		gt90.addChild(new GeneralTree<Integer>(16));
		//                 16                       
		gt90.getChildren().get(0).addChild(new GeneralTree<Integer>(18));
		//                 16                   18
		gt90.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer>(34));
		gt90.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer>(33));


		GeneralTree<Integer>gt121= new GeneralTree<Integer>(121); 
		gt121.addChild(new GeneralTree<Integer>(12));
		gt121.addChild(new GeneralTree<Integer>(100));
		gt121.addChild(new GeneralTree<Integer>(15));
		//                  100                    
		gt121.getChildren().get(1).addChild(new GeneralTree<Integer>(27));
		//                  100                  27                   
		gt121.getChildren().get(1).getChildren().get(0).addChild(new GeneralTree<Integer>(22));
		
		
		GeneralTree<Integer>gt25= new GeneralTree<Integer>(25); 
		gt25.addChild(gt10);
		gt25.addChild(gt90);
		gt25.addChild(gt121);
		gt25.addChild(new GeneralTree<Integer>(11));
		
		RecorridoAG recorrido= new RecorridoAG(gt25); 
		System.out.println(" RECORRIDO PRE ORDEN MOSTRANDO VALORES IMPARES MAYORES A 20: ");
		List<Integer>listaPreOrden= recorrido.numerosImparesMayoresQuePreOrden(gt25, 20);
		for (Integer num: listaPreOrden) {
			System.out.print(" " + num);
		}
		System.out.println(); 
		System.out.println("_______________________________________________________________");
		
		System.out.println(" RECORRIDO IN ORDEN MOSTRANDO VALORES IMPARES MAYORES A 20: ");
		List<Integer>listaInOrden= recorrido.numerosImparesMayoresQueInOrden(gt25, 20);
		for (Integer num: listaInOrden) {
			System.out.print(" " + num);
		}
		System.out.println(); 
		System.out.println("_______________________________________________________________");
		
		System.out.println(" RECORRIDO POST ORDEN MOSTRANDO VALORES IMPARES MAYORES A 20: ");
		List<Integer>listaPostOrden= recorrido.numerosImparesMayoresQuePostOrden(gt25, 20);
		for (Integer num: listaPostOrden) {
			System.out.print(" " + num);
		}
		System.out.println(); 
		System.out.println("_______________________________________________________________");
		
		System.out.println(" RECORRIDO POR NIVELS MOSTRANDO VALORES IMPARES MAYORES A 20: ");
		List<Integer>listaPorNiveles= recorrido.numerosImparesMayoresQuePorNiveles(gt25, 20);
		for (Integer num: listaPorNiveles) {
			System.out.print(" " + num);
		}
		System.out.println(); 
		System.out.println("_______________________________________________________________");
	}
}

