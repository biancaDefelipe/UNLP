package practica1;
/*Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los
respectivos métodos setters.

*/
public class Test {
	public static void main (String[] args){
		Estudiante[] estudiantes = new Estudiante[2]; 
		Profesor [] profesores = new Profesor [3]; 
		
		//public Estudiante(String nombre, String apellido, String comision, String email, String direccion) {
		estudiantes[0]= new Estudiante("Swift", "Taylor", "2B", "taylortears@gmail.com", "usa"); 
		estudiantes[1]= new Estudiante ("Lana", "del Rey", "1A", "lonelylana@gmail.com", "nose"); 
		
		//public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
		profesores[0]= new Profesor ("Mariana", "Enriquez", "mariEnriquez@hotmail.com", "Literaratura argentina", "humanidades"); 
		profesores[1]= new Profesor ("Einstein", "Albert", "elPeloDeEinstein@gmail.com", "Quimica Organica", "Exactas"); 
		profesores[2]= new Profesor ("Charly", "Garcia", "sayNoMore@gmail.com", "Lenguaje Musical", "Artes"); 
		
		for (int i=0; i< 2 ; i++) {
			System.out.println(estudiantes[i].tusDatos()); 
		}
		for (int i= 0; i< 3; i++) {
			System.out.println(profesores[i].tusDatos()); 
		}
		
		
	}
	
}
