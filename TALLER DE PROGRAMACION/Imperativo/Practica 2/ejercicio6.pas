program ejercicio6; 


type 
	lista= ^nodo; 
	
	nodo= record
		dato: integer; 
		sig:lista; 
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

procedure convertirABinario(num: integer; var digitos:lista); 
var
	cociente, resto:integer; 
	
begin
	cociente:= num div 2;
	resto:= num mod 2; 
	if (num>2) then begin
		
		if (cociente <> 1) then  begin
			
			 
			agregarAdelante(digitos, resto); 
			convertirABinario(cociente, digitos); 
		end
		else begin
			agregarAdelante(digitos, resto);
			
			agregarAdelante(digitos, cociente);
			
		end
	end
	else begin
		agregarAdelante(digitos, resto);
		
		agregarAdelante(digitos, cociente);
		
	end;
	
end;


procedure imprimirListaRecursivo (L: lista); 
begin 
	if (L <> nil) then begin
		write('  ', L^.dato); 
		imprimirListaRecursivo(L^.sig); 
		
	end; 
	writeln(); 
end; 


procedure leerYconvertir(); 
var 
	li:lista; 
	num:integer; 
begin
	li:= nil; 
	write('ingrese el numero que desea convertir a binario: '); 
	readln(num); 
	if (num <> 0) then begin 
		convertirABinario(num, li); 
		imprimirListaRecursivo(li);
		writeln('------------------------------');
		leerYconvertir(); 
	end; 
end; 

	
		
begin
	writeln('-----------------------------------------------------'); 
	leerYconvertir(); 
	writeln('-----------------------------------------------------');

end.

		
