program probandoArboles; 
type 
	arbol = ^nodo;  
	nodo = record   
		dato: integer;   
		HI: arbol;   
		HD: arbol;  
	end;
	
procedure imprimirEnorden(a:arbol); 
begin 
	if (a <> nil) then begin 
		imprimirEnOrden (a^.HI); 
		write ('| ', a^.dato);
		imprimirEnOrden(a^.HD); 
	end; 
end; 

procedure crear (var a: arbol; num:integer); 
begin
	if (a = nil) then begin 
		new(a);
		a^.dato:= num; 
		a^.HI:= nil; 
		a^.HD:= nil; 
	end
	else 
	if (num < a^.dato) then
		crear(a^.HI, num)
	else 
		crear(a^.HD, num);
end;


procedure imprimirPreOrden(a:arbol); 
begin 
	if (a <> nil) then begin
		write(' |', a^.dato); 
		imprimirPreOrden (a^.HI); 
		imprimirPreOrden(a^.HD); 
	end; 
end; 


procedure imprimirPosOrden (a:arbol); 
begin 
	if (a <> nil) then begin 
		imprimirPosOrden(a^.HI);
		imprimirPosOrden(a^.HD); 
		write(' | ', a^.dato);
	end; 
end; 


function Maximo (a:arbol): arbol;
begin
	if (a = nil) then
		Maximo := nil
	else
		if (a^.HD = nil) then
			Maximo := a
		else
			Maximo := Maximo(a^.HD); 
end;

		
		

{programa principal}

var 
	abb:arbol; 
	x:integer;
Begin
	abb:=nil; 
	read (x); 
	while (x<>0)do  begin   
		crear(abb,x);   
		read(x);  
	end;
	writeln('-----------------------------------');
	writeln('imprimiendo en orden: '); 
	imprimirEnorden(abb); 
	writeln('-----------------------------------');
	writeln('imprimiendo preOrden: ');
	imprimirPreOrden(abb); 
	writeln('-----------------------------------');
	writeln('imprimiendo posOrden: '); 
	imprimirPosOrden(abb);
	writeln('-----------------------------------');
End.
