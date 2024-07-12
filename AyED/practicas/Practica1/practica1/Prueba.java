package practica1;

public class Prueba {
	
	 public static  int calcular(int n) {
		 int i, j, r = 0;
		 System.out.println("HOLA"); 
		 	for ( i = 1; i < n; i= i+2) {
		 		System.out.println(" en el primer for i: "+i); 
		 		
		 		for (j = 1; j <= i; j++ ) {
		 			System.out.println("                        en el segundo for j: "+j); 
		 			r = r + 1;
		 		}
		 	}
		 	return r; 
	 }
		 		public static void main(String[] args) {
		 			System.out.println(calcular(10)); 
		 		}
	 
		 
}
