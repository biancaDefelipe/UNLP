package practica1;

public class ejercicio1 {
	
	public static void main(String[] args) {
		
		int a = 3; 
		int b= 13; 
		
		//con for 
		System.out.println("imprimiendo con for "); 
		imprimirNumerosEntreConFor(a, b); 
		
		
		//con while 
		System.out.println("imprimiendo con while "); 
		imprimirNumerosEntreConWhile(a, b); 
		
		//con recursion
		System.out.println("imprimiendo con recursion "); 
		imprimirNumerosRecursivo(a, b); 
		
		
		
	}
		public static void imprimirNumerosEntreConFor (int a, int b) {
		for (int i = a; i<=b;i++ ) {
		
			System.out.println(i); 
		}
	}
	
	public static void imprimirNumerosEntreConWhile(int a, int b) {
		int num = a;
		while (num <= b ) {
			System.out.println(num); 
			num++; 
		}
	}
	public static void imprimirNumerosRecursivo(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			a++; 
			imprimirNumerosRecursivo(a, b);
		}
	}

}
