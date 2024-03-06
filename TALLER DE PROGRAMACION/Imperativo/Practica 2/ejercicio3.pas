{3.- Escribir un programa que:
a. Implemente un módulo recursivo que genere una lista de números enteros “random” mayores a 0 y menores a 100. Finalizar con el número 0.
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista. 
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista. 
d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se encuentra en la lista o falso en caso contrario. }
program ejercicio3; 

const 
	min= 0; 
	max= 100; 
type 
	rangoNumeros= min..max; 
	lista= ^nodo; 
	nodo= record 
		dato: integer; 
		sig: lista; 
	end; 

	

function generarNumero():rangoNumeros; 
begin
	generarNumero := Random (max); 
end; 

procedure agregarAdelante(var li: lista; num: integer); 
var
	nue: lista; 
begin 
	new(nue); 
	nue^.dato:= num;
	nue^.sig:= li; 
	
	li:= nue; 
end;


procedure crearListaRecursivo (var li:lista); 
var 
	num: rangoNumeros; 
begin
	
	num:= generarNumero(); 
	if (num <> 0) then begin
		agregarAdelante(li, num); 
		crearListaRecursivo(li); 
	end; 
end; 
procedure imprimirListaRecursivo (L: lista); 
begin 
	if (L <> nil) then begin
		writeln(' | ', L^.dato); 
		imprimirListaRecursivo(L^.sig); 
		
	end; 
end; 

procedure buscarMinimoRecursivo (li: lista; var min: rangoNumeros); 
begin
	if (li<> nil) then begin
		if (li^.dato < min)then 
			min:= li^.dato; 
		buscarMinimoRecursivo(li^.sig, min); 
	end; 
end; 
	
procedure buscarMaximoRecursivo (li: lista; var max: rangoNumeros); 
begin
	if (li<> nil) then begin
		if (li^.dato > max)then 
			max:= li^.dato; 
		buscarMaximoRecursivo(li^.sig, max); 
	end; 
end; 
	

function buscarNumero(li: lista; num:integer): boolean;
begin
	if (li^.sig <> nil) then begin
		if (li^.dato = num) then 
			buscarNumero:= true; 
		buscarNumero(li^.sig, num); 
	end; 
	if (li^.sig = nil) and (li^.dato <> num) then
        buscarNumero := false;
	
end;
{programa principal}
var
	li: lista; 
	minimo, maximo, num: rangoNumeros; 
begin 
	writeln('-------------------------------------------------------------');
	
	li:= nil; 
	crearListaRecursivo(li); 
	imprimirListaRecursivo(li);
	writeln(); 
	writeln('-------------------------------------------------------------');
	
	minimo:=100; 
	buscarMinimoRecursivo(li, minimo); 
	write('minimo de la lista: ', minimo); 
	writeln(); 
	writeln('-------------------------------------------------------------');
	
	maximo:=0; 
	buscarMaximoRecursivo(li, maximo);  
	write('maximo de la lista: ', maximo); 
	writeln(); 
	writeln('-------------------------------------------------------------');
	
	write(' ingrese un numero a buscar: '); 
	readln(num); 
	write(' el numero se encuentra en la lista: ', buscarNumero(li, num));
end.

		
	
