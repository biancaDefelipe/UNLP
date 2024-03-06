program ejercicio1; 

const 
	dimF= 10; 

type 
	
	vector =array [1..dimF] of integer; 
	
	
procedure leerCaracter (var car: char; var vec: vector; var dimL: integer); 
var 

begin
	write('ingrese un caracter: '); 
	read(car); 
	writeln(car); 
	while (car <> '.') and (dimL < dimF) do begin 
		dimL := dimL +1; 
		vec [dimL]:= car; 
end; 

{programa principal}

var
	vec:vector; 
	dimL: integer; 
begin 
	dimL:= 0; 
	leerCaracter

