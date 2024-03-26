package practica1;
/*5. Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return" */



public class ejercicio5 {
	
	
	public static double[] incisoA (int[] numeros) {
		double valores[]= new double [3]; 
		valores[0]= 0; //maximo
		valores[1]= 1000; // minimo; 
		int total= 0; 
		for (int i=0; i <numeros.length; i++) {
			if (numeros[i]> valores[0]) {
				valores[0]= numeros[i]; 
			}
			if (numeros[i]< valores[1]) {
				valores[1]= numeros [i]; 
			}
			total= total+ numeros[i]; 
		}
		valores[2]= (total / numeros.length); 
		return valores; 
	}

	public static void incisoB (int[] numeros, Dato dat) {
		double total=0; 
		int min=99999; 
		int max=0; 
		for (int i=0; i <numeros.length; i++) {
			if (numeros[i]> max) {
				max= numeros[i]; 
			}
			if (numeros[i]<min) {
				min= numeros[i]; 
			}
			total= total+ numeros[i]; 
		}
		dat.setMax(max);
		dat.setMin(min);
		dat.setProm((total/numeros.length));
		
	}
	public static void main(String[] args) {
		int[] numeros= {10, 15, 55, 40, 110, 5}; 
		double[] valores = new double [3]; 
		
		//inciso a
		System.out.println("______________________________________________________");
		valores = incisoA(numeros); 
		System.out.println(" maximo "+ valores[0]);
		System.out.println(" minimo "+ valores[1]);
		System.out.println(" promedio "+ valores[2]);
		
		
		//inciso b
		System.out.println("______________________________________________________");
		Dato dat1 = new Dato(); 
		incisoB(numeros, dat1);
		System.out.println(" maximo "+ dat1.getMax());
		System.out.println(" minimo "+ dat1.getMin());
		System.out.println(" promedio "+ dat1.getProm());
		
		
		//inciso c
		System.out.println("______________________________________________________");
		Dato dat2= new Dato(); 
		dat2.calcular(numeros);
		System.out.println("maximo:"+dat2.getMax());
		System.out.println("minimo:"+dat2.getMin());
		System.out.println("promedio:"+dat2.getProm() );
		
		/*correcion: el inciso b deberia implementarse como el c y el c se hace con una variable global (mala practica)*/
	}
}
