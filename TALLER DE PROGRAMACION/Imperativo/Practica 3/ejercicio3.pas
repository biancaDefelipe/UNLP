{3.Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación 
	y almacene en una estructura de datos sólo a aquellos alumnos que posean año de ingreso posterior al 2010. 
	De cada alumno se lee legajo, DNI y año de ingreso. La estructura generada debe ser eficiente para la búsqueda por número de legajo. 
b. Un módulo que reciba la estructura generada en a. e informe 
	el DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro. 
c. Un módulo que reciba la estructura generada en a. e informe 
	el DNI y año de ingreso de aquellos alumnos cuyo legajo esté comprendido entre dos valores que se reciben como parámetro. 
d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.
e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.

}
program ejercicio3; 

type
	alumno= record
		legajo:integer; 
		dni:integer; 
		ingreso:integer; 
	end; 	
	
	arbol= ^nodo;
	nodo= record
		dato:alumno;
		HI: arbol; 
		HD: arbol;
	end; 
	
procedure leerAlumno (var a : alumno); 
begin
	write('legajo: '); 
	readln(a.legajo); 
	if (a.legajo <> 0) then begin 
		write('dni: '); 
		readln(a.dni); 
		write('ingreso: '); 
		readln(a.ingreso); 
	end; 
end; 
procedure insertarNodo(var a: arbol; alu: alumno); 
begin 
	if (a= nil) then begin 
		new (a); 
		a^.dato:= alu; 
		a^.HI:= nil; 
		a^.HD:= nil; 
	end
	else 
		if (a^.dato.legajo > alu.legajo) then 
			insertarNodo(a^.HI, alu)
		else 
			insertarNodo(a^.HD, alu); 
end; 


procedure crearArbol (var a: arbol);
var
	alu: alumno; 
begin 
	
	leerAlumno(alu); 
	while (alu.legajo <> 0) do begin
		insertarNodo(a, alu); 
		writeln('_____________________'); 
		leerAlumno(alu); 
		
	end; 
end; 



//b. Un módulo que reciba la estructura generada en a. e informe 
//el DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro. 
procedure alumnosConLegajoMenor(a: arbol;valor:integer); 
begin
	if (a <> nil) then 
		if (a^.dato.legajo >= valor) then 
			alumnosConLegajoMenor(a^.HI, valor)
		
		if (a^.dato.legajo < valor ) then begin
			writeln ('________________________');
			writeln('    DNI : ', a^.dato.dni); 
			writeln('    ANIO: ', a^.dato.ingreso); 
			writeln ('________________________');
		end
		else 
			if 	(a^.dato.legajo >= valor) then 
				alumnosConLegajoMenor(a^.HI, valor)
			
end; 
procedure informarAlumnosConLegajoMenor(a: arbol); 
var 
	valor: integer; 
begin 
	write('ingrese un valor: '); 
	readln(valor); 
	alumnosConLegajoMenor(a, valor); 
end; 


//c. Un módulo que reciba la estructura generada en a. e informe 
//el DNI y año de ingreso de aquellos alumnos cuyo legajo esté comprendido entre dos valores que se reciben como parámetro. 
procedure alumnosConLegajoEnRango (a: arbol; inf, sup: integer); 
begin
	if (a <> nil) then 
		if (a^.dato.legajo < sup ) and (a^.dato.legajo > inf) then begin
			writeln ('________________________');
			writeln('    DNI : ', a^.dato.dni); 
			writeln('    ANIO: ', a^.dato.ingreso); 
			writeln ('________________________');
		end
		else begin
			alumnosConLegajoEnRango(a^.HI, inf, sup); 
			alumnosConLegajoEnRango (a^.HD, inf, sup); 
		end
end; 
			
procedure informarAlumnosConLegajoEnRango(a: arbol); 
var 
	inf, sup: integer; 
begin 
	write('ingrese valor inferior: '); 
	readln(inf); 
	write('ingrese valor superior: '); 
	readln(sup); 
	
	alumnosConLegajoEnRango(a, inf, sup); 
end; 

//d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.

		
procedure maximo (a: arbol; var max:integer); 
begin
	if (a<> nil) then begin
		if (a^.dato.dni > max )then  
			max:= a^.dato.dni; 
		maximo(a^.HI, max); 
		maximo(a^.HD, max); 
	end; 
end;
procedure buscarDNIMaximo(a:arbol); 
var 
	max: integer; 
begin 
	max:= 0; 
	maximo(a, max); 
	writeln('el dni mas grande es : ',max); 
end; 


//e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.
function esImpar (num: integer): boolean; 
begin
	esImpar:= ((num mod 2 )<>0); 
end;
procedure contarImpares(a: arbol; var cant: integer);
begin
	if (a<> nil) then begin
		if (esImpar(a^.dato.legajo)) then
			cant:= cant +1; 
		contarImpares(a^.HI, cant); 
		contarImpares(a^.HD, cant); 
	end; 
end; 

procedure informarAlumnosConLegajoImpar(a:arbol);
var 
	cant: integer;
begin 
	cant:= 0;
	contarImpares(a, cant); 
	writeln('la cantidad de alumnos con legajo impar es: ', cant); 
end; 

	
	
procedure imprimirEnorden(a:arbol); 
begin 
	if (a <> nil) then begin 
		imprimirEnOrden (a^.HI); 
		write ('| legajo: ', a^.dato.legajo, ' | dni: ', a^.dato.dni, ' | ingreso: ', a^.dato.ingreso);
		writeln(); 
		imprimirEnOrden(a^.HD); 
	end; 
end; 

{programa principal}

var
	a: arbol;
begin
	writeln('---------------------------------------------');
	crearArbol(a); 
	
	writeln('---------------------------------------------'); 
	imprimirEnorden(a); 
	
	writeln('---------------------------------------------');
	informarAlumnosConLegajoMenor(a); 
	
	writeln('---------------------------------------------');
	informarAlumnosConLegajoEnRango(a); 
	
	writeln('---------------------------------------------');
	buscarDNIMaximo(a); 
	
	writeln('---------------------------------------------');
	informarAlumnosConLegajoImpar(a);  
	
	
end.

