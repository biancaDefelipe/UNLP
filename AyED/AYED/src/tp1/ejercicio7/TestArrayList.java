package tp1.ejercicio7;
/*Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
números a la lista, imprime el contenido de la misma iterando sobre cada elemento.
b. Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué
diferencia encuentra respecto de la implementación? Justifique*/

import java.util.ArrayList;
import java.util.List;
import practica1.Estudiante;
import java.util.Scanner;
public class TestArrayList {
	
	/*Escriba un método que realice las siguientes acciones:
■ cree una lista que contenga 3 estudiantes
■ genere una nueva lista que sea una copia de la lista del inciso i
■ imprima el contenido de la lista original y el contenido de la nueva lista
■ modifique algún dato de los estudiantes
■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
¿Qué conclusiones obtiene a partir de lo realizado?
■ ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre
ellas?
*/
	//String nombre, String apellido, String comision, String email, String direccion
	public static void incisoD(List<Integer>) {
		
	}
	
	public static void main(String[] args) {
		
	
		List<Integer> numeros= new ArrayList<Integer>(); 
		
		for(String x: args) {
			int num= Integer.parseInt(x);
			numeros.add(num); 
		}
		for (Integer numero: numeros) {
			System.out.println(numero);
		}
		Scanner s= new Scanner(System.in) ;
		for (int i=0; i<3; i++) {
			Estudiante e= new Estudiante(); 
			System.out.print("nombre: "); 
			e.setNombre(s.nextLine());
			System.out.print("apellido: "); 
			e.setNombre(s.nextLine());
		}
		
		
		
		}
}
