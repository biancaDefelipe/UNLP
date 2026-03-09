package tp1.ejercicio9;

public class TestBalanceoPrueba {
		
	public static void main(String[] args) {
		
		TestBalanceo tester = new TestBalanceo(); 
		
		String desbalanceado = new String ("{()[(]}"); 
		String balanceado =new String ("{()[()]}"); 
		System.out.println("jfijfjei"); 
		System.out.println("El string "+ desbalanceado+ " esta balanceado? "+ tester.estaBaleanceado(desbalanceado)); 
		System.out.println("El string "+ balanceado+ " esta balanceado? "+ tester.estaBaleanceado(balanceado)); 
		
	
		
}
}
