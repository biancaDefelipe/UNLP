package tp1.ejercicio9;
/*
 Implemente una clase llamada tp1.ejercicio9.TestBalanceo, cuyo objetivo es
determinar si un String dado está balanceado. El String a verificar es un parámetro de
entrada (no es un dato predefinido).
 */

import tp1.ejercicio8.Stack;
public class TestBalanceo   {
	private char[] cierre=  {')', ']' ,'}' }; 
	//private char [] apertura= {'(', '[', '{'};
	
	
	private boolean esApertura(char caracter) {
		boolean ok= true; 
		for (char c: this.cierre) {
			if(c== caracter) {
				ok= false; 
			}
		}
		return ok; 
	}
	private boolean coinciden(char apertura, char cierre) {
		if ((apertura== '(') && (cierre==')')){System.out.println("coinciden"); return true;}
		if ((apertura== '[') && (cierre==']')){System.out.println("coinciden"); return true;}
		if ((apertura== '{') && (cierre=='}')){System.out.println("coinciden"); return true;}
		return false; 
	}
	public boolean estaBaleanceado (String cadena) {
		boolean sigo = true; 
		Stack <Character> pila = new Stack <Character>();
		char [] caracteres= cadena.toCharArray(); 
		int i=0; 
		while (sigo) {
			if ((i<caracteres.length) && (esApertura(caracteres[i]))){
				pila.push(caracteres[i]);     //si es apertura lo apilo
				System.out.println(pila.top());
				i++;
			}
			else {
				if(!(i == caracteres.length)) {   //si no llegue al final o esta vacia entonces es de cierre
					try {						
						if(coinciden(pila.top(), caracteres[i])) {	//me fijo si el ultimo que guarde coincide 
							pila.pop(); 
							i++; 
						}
						else {
							sigo= false; 
						}
					}
					catch (Exception e) {
						System.out.print("el string esta vacio");
						sigo= false;
					}
				}
			}
		}
		return sigo; 
	}
	
	
}
