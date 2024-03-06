program ejercicio1; 

const 
	dimF= 10; 

type 
	vector =array [1..dimF] of char; 
	lista=^nodo; 
	nodo= record
		dato: char; 
		sig: lista; 
	end; 
	
// inciso a
procedure cargarVectorRecursivo ( var vec: vector; var dimL: integer); 
var
	car:char;
begin
	write('ingrese un caracter: '); 
	readln(car); 
	if((car <> '.') and (dimL < dimF)) then begin 

		dimL := dimL +1; 
		vec[dimL]:= car; 
		cargarVectorRecursivo(vec, dimL);
	end;
	
end; 

//inciso b
procedure imprimirVector(vec:vector;  dimL: integer); 
var 
	i: integer; 
begin
	for i:= 1 to dimL do 
		write(' | ', vec[i]); 
	writeln(); 
	writeln(); 
end; 
//inciso c
procedure imprimirVectorRecursivo (vec:vector; dimL: integer); 
	
begin 
	if (dimL <>0) then begin
		
		imprimirVectorRecursivo(vec, dimL -1); 
		write(' | ', vec[dimL ]); 
	end; 

end; 

//inciso d
function contarCaracteres(): integer; 
var
	car: char; 
begin 
	write('ingrese un caracter: '); 
	readln(car); 
	if (car <>'.') then 
		contarCaracteres:= contarCaracteres() +1
	else 
		contarCaracteres:= 0;
end; 

//inciso e
procedure cargarListaRecursivo(var L: lista); 
var
	car:char; 
	nue:lista; 
begin
	write('ingrese un caracter: '); 
	readln(car); 
	if (car <> '.') then begin
		new (nue); 
		nue^.dato:= car; 
		nue^.sig:= nil; 
		if (L=nil) then begin
			L:= nue;
			cargarListaRecursivo(L);
		end
		else begin
			L^.sig:= nue;
			cargarListaRecursivo(L^.sig);
		end;
		
		
		
	end; 
end;

//inciso f
procedure imprimirListaRecursivo (L: lista); 
begin 
	if (L <> nil) then begin
		write(' | ', L^.dato); 
		imprimirListaRecursivo(L^.sig); 
		
	end; 
end; 


//inciso g 
procedure imprimirListaInversoRecursivo (L: lista); 
begin 
	if (L <> nil) then begin
		imprimirListaInversoRecursivo(L^.sig); 
		write(' | ', L^.dato); 
		
	end; 
end; 
{programa principal}

var
	vec:vector; 
	dimL: integer; 
	cant: integer; 
	L: lista; 
	
begin 
	dimL:= 0; 
	L:= nil; 
	writeln('-------------------------------------------------------------');
	cargarVectorRecursivo( vec, dimL);
	writeln('-------------------------------------------------------------');
	imprimirVector(vec, dimL); 
	writeln('-------------------------------------------------------------');
	imprimirVectorRecursivo(vec, dimL); 
	writeln('-------------------------------------------------------------');
	cant:=contarCaracteres(); 
	writeln ('cantidad de caracteres ingresados: ', cant); 
	writeln('-------------------------------------------------------------');
	cargarListaRecursivo(L); 
	writeln('-------------------------------------------------------------');
	imprimirListaRecursivo(L); 
	writeln('-------------------------------------------------------------');
	imprimirListaInversoRecursivo(L);
end.

