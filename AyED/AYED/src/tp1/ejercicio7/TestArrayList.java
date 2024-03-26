package tp1.ejercicio7;
/*Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
números a la lista, imprime el contenido de la misma iterando sobre cada elemento.
b. Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué
diferencia encuentra respecto de la implementación? Justifique

c. ¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.?
   //RTA: si, com un iterador
*/
/*Escriba un método que realice las siguientes acciones:
■ cree una lista que contenga 3 estudiantes
■ genere una nueva lista que sea una copia de la lista del inciso i
■ imprima el contenido de la lista original y el contenido de la nueva lista
■ modifique algún dato de los estudiantes
■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista.
¿Qué conclusiones obtiene a partir de lo realizado?
//RTA: en la listas no se guardan objetos, sino que se guardan referecias a objetos 
■ ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre
ellas?
//RTA: 1) mediante su constructor, pasandole la lista que quiero copiar como argumento
 	   2) creando una nueva lista y usando el metodo addAll
 	   3) usando el metodo clone() pero no es recomendable 
*/

import java.util.ArrayList;
import java.util.List;
import practica1.Estudiante;
import java.util.Scanner;
public class TestArrayList {
	

	//String nombre, String apellido, String comision, String email, String direccion
	public static void incisoDyE() {
		List <Estudiante> estudiantes = new ArrayList<Estudiante>(); 
		Estudiante e1= new Estudiante("pepe", "perez", "1A", "pepeperez@gmail.com", "1 y 50"); 
		estudiantes.add(e1); 
		Estudiante e2= new Estudiante("moni", "perez", "1b", "moniperez@gmail.com", "1 y 50"); 
		estudiantes.add(e2); 
		Estudiante e3= new Estudiante("taylor", "swift", "13", "taylorswift@gmail.com", "LA"); 
		estudiantes.add(e3); 
		
		//imprimo lista original
		for (Estudiante e: estudiantes)
			System.out.println(e.tusDatos());
		//creo e imprimo la copia 
		ArrayList<Estudiante> estudiantesCopia = new ArrayList<Estudiante>(estudiantes);
		for (Estudiante e: estudiantesCopia)
			System.out.println(e.tusDatos());
		
		e3.setDireccion("Londres");
		for (Estudiante e: estudiantes)
			System.out.println(e.tusDatos());
		for (Estudiante e: estudiantesCopia)
			System.out.println(e.tusDatos());
		
		
		//incisoE
		Scanner s= new Scanner(System.in); 
		Estudiante e4= new Estudiante(); 
		System.out.print("nombre del nuevo estudiante: "); 
		e4.setNombre(s.nextLine());
		System.out.print("apellido del nuevo estudiante: "); 
		e4.setApellido(s.nextLine());
		System.out.print("comision del nuevo estudiante: "); 
		e4.setComision(s.nextLine());
		System.out.print("direccion del nuevo estudiante: "); 
		e4.setDireccion(s.nextLine());
		System.out.print("mail del nuevo estudiante: "); 
		e4.setEmail(s.nextLine());
		
		boolean esta= false; 
		int i=0; 
		while ((esta == false) && !(estudiantes.isEmpty())) {
			
			Estudiante e= estudiantes.get(i); 
			esta = (e.getApellido().equals(e4.getApellido()) && e.getNombre().equals(e4.getNombre())) ? true : false; 
		}
		if (!(esta)){
			estudiantes.add(e4); 
		}
		s.close();
	
	}
	public static boolean esCapicua(ArrayList<Integer> lista) {
		int ini=0; 
		int fin= lista.size()-1;
		boolean sigo= true; 
		while (sigo &&( ini<fin)) {
			sigo =  lista.get(ini)== lista.get(fin)? true : false; 
			ini++; 
			fin--; 
		}
		return sigo; 
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

		
		incisoDyE(); 
		
		
		//inciso f
		ArrayList <Integer> secuencia= new ArrayList<Integer>(); 
		secuencia.add(3); secuencia.add(2); secuencia.add(1);  secuencia.add(2); secuencia.add(3); 
		System.out.println(" ¿la secuencia es capicua? " + esCapicua(secuencia)); 
		
		}
}
