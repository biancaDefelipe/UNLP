package tp1.ejercicio7;
import java.util.ArrayList;
import java.util.List;
public class EjercicioSucesion {

	public List<Integer> calcularSucesion (int n) {
		List <Integer> lista = new ArrayList<Integer>(); 
		calculo(lista, n);
		return lista;
		}
		
	
	private Integer calculo (List <Integer> sucesion, int num) {
		sucesion.add(num); 
		if (num!=1) {
			return (num%2 ==0) ? (calculo (sucesion, num/2)):(calculo (sucesion, 3*num +1)); 		  
		}
		else {return 1;}
	}
	public static void main (String []args) {
		
		if (args.length != 0) {
		EjercicioSucesion ej= new EjercicioSucesion(); 
		List<Integer>lista = ej.calcularSucesion(Integer.parseInt(args[0])); 
		lista.forEach(num -> System.out.println(num));
	}else {
		System.out.println("no se recibio ningun parametro"); 
	}
}
}
