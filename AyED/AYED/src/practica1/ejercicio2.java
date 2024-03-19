package practica1;
/*
Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n
con los n primeros múltiplos enteros de n mayores o iguales que 1.
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}
*/

import java.util.Scanner;
public class ejercicio2 {
	
	public static void main(String[] args) {
		
		Scanner s= new Scanner (System.in); 
		int num; 
		System.out.print(" ingrese un numero: "); 
		num= s.nextInt(); 
		int[] multiplos = new int[num];
		while (num != 0 ) {
			 
			multiplos= calcularMultiplos (multiplos, num); 
			imprimir(multiplos, num);
			System.out.println(" ingrese un numero: "); 
			num= s.nextInt(); 
			
		}
		System.out.println("fin");
		s.close();
		
	}
	
	public static int[] calcularMultiplos(int[] multiplos, int num) {
		int[] multiplosNuevo= new int[num];
		for (int i= 0; i < num ;i++) {
			multiplosNuevo[i]= (i+1)* num; 
		}
		return multiplosNuevo;

	}
	public static void imprimir (int[] multiplos,  int num) {
		String aux= " | "; 
		for (int i= 0; i< num; i++) {
			aux= aux + multiplos[i]+" | "; 
		}
		System.out.println(aux);
	}
}
