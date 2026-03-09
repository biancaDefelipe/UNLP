package tp1.ejercicio7;
/*
h. Implemente un método recursivo que invierta el orden de los elementos en un
ArrayList.
public void invertirArrayList(ArrayList<Integer> lista)
i. Implemente un método recursivo que calcule la suma de los elementos en un
LinkedList.
public int sumarLinkedList(LinkedList<Integer> lista)
j. Implemente el método “combinarOrdenado” que reciba 2 listas de números ordenados
y devuelva una nueva lista también ordenada conteniendo los elementos de las 2 listas.
public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,
ArrayList<Integer> lista2);
 */
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class Ejercicio7Colecciones {

	public static ArrayList<Integer> invertirArrayList (ArrayList<Integer> lista, Integer cant, Integer pos) {
		if (cant>pos) {
			int temp = lista.get(pos);// tomo elemento de adelante
			lista.set(pos, lista.get(cant)); //pongo el elemento de adelante al final
			lista.set(cant, temp); //pongo el elemnto que estaba adelante al final
			return invertirArrayList(lista, --cant, ++pos);
		}
		return lista;
	}
	public static void invertirRecursivo (ArrayList<Integer>lista) {
		
		invertirArrayList(lista, lista.size()-1, 0); 
	}
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		if (lista.size()<=0) {
			return 0; 
		}else {
			return lista.removeFirst()+ sumarLinkedList(lista);
			
		}
	}
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1,ArrayList<Integer> lista2){
		ArrayList<Integer> listaCombinada= new ArrayList<Integer>(); 
		int indice1=0; int indice2=0; 
		if(!(lista1.isEmpty())  && (!(lista2.isEmpty() ))) {
		
			while ((indice1<lista1.size()) && (indice2< lista2.size())){
				if (lista1.get(indice1)<lista2.get(indice2)) {
					listaCombinada.add(lista1.get(indice1)); 
					indice1++; 
				}
				else { if (lista2.get(indice2)< lista1.get(indice1)) {
					listaCombinada.add(lista2.get(indice2)); 
					indice2++; }
				else {
					listaCombinada.add(lista1.get(indice1)); 
					indice1++; indice2++; 
				}
				}
			}
			while (indice1<lista1.size()) {
	
				listaCombinada.add(lista1.get(indice1)); 
				indice1++;
			}
			while (indice2<lista2.size()) {
				listaCombinada.add(lista2.get(indice2)); 
				indice2++;
			}
		}
		else{
			if(lista1.isEmpty()) {
				listaCombinada.addAll(lista2.subList(indice2, lista2.size()-1)); }
			else {if(lista2.isEmpty()) {
					listaCombinada.addAll(lista1.subList(indice1, lista1.size()-1));}
			}
		}
		
		return listaCombinada;
		
		
	}
	
		public static void main(String[] args) {
			//inciso h( invertir lista)
				System.out.println("lista antes de invertir");
				ArrayList<Integer> listaH = new ArrayList<Integer>();
				listaH.addAll(List.of(1, 2, 3, 4, 5));
				for (Integer num : listaH) {
					System.out.println(num);
				}
				System.out.println("lista despues de invertir ");
				invertirRecursivo(listaH);
				for (Integer num : listaH) {
					System.out.println(num);
				}
				
			//inciso i
			LinkedList <Integer>listaI= new LinkedList <Integer>(); 
			listaI.addAll(List.of(5, 5, 5, 5, 5)); 
			System.out.println("resultado de sumar los elementos de la lista I: "+sumarLinkedList(listaI));
			
			//inciso j 
			System.out.println("inciso j ");
			ArrayList<Integer>lista1 = new ArrayList<Integer>(); 
			lista1.addAll(List.of(2,4,6,8,10));

			ArrayList <Integer>lista2= new ArrayList<Integer>(); 
			
			//lista2.addAll(List.of(1,3,5,6,7,9));
			lista2.addAll(List.of());
			ArrayList<Integer>listaCombinada= new ArrayList<Integer>(); 
			listaCombinada= combinarOrdenado(lista1, lista2);
			for (Integer num: listaCombinada) {
				System.out.println(num);
			}
			System.out.print("fin");
		}
	}

