program parcialAerolineas; 

const 
	dimF= 250; 
type 
	rangoCategorias= 1..20; 
	
	empleado= record
		legajo: integer; 
		dni: integer; 
		categoria: rangoCategorias; 
		ingreso: integer; 
	end; 
	
	arbol= ^nodo; 
	nodo= record
		dato: empleado; 
		HI: arbol; 
		HD: arbol; 
	end; 
	datoVector= record
		dni: integer; 
		legajo: integer; 
	end; 
	vector= array [1.. dimF] of datoVector; 
	
//se disponen	
procedure leerEmpleado(var a: empleado); 
begin 
	writeln();
	write('dni: '); 
	readln(e.dni); 
	if (e.dni <> 0) then begin 
		write('legajo: '); 
		readln(e.lagajo); 
		write('categoria(1 a 20): '); 
		readln(e.categoria); 
		write('anio ingreso: '); 
		readln(e.ingreso); 
	end; 
end; 


procedure crearArbol(var a: arbol; e: empleado);  
begin 
	if (a= nil) then 
		new(a); 
		a^.dato:= e; 
		a^.Hi:= nil; 
		a^.HD:= nil; 
	end
	else begin 
		if (e.dni <a^.dato.dni)
			crearArbol(a^.HI); 
		else 
			crearArbol(a^.HD, e); 
	end; 
end; 
procedure imprimirEmpleado(e: empleado); 
begin
	writeln(); 
	writeln('empleado: ', e.dni); 
	writeln('	- legajo: ',e^.legajo); 
	writeln('	- categoria: ', e^.categoria); 
	writeln('	- anio de ingreso', e^.ingreso); 
end; 

procedure imprimirEnOrden( a: arbol) 
begin 
	if (a<> nil) then begin 
		imprimirEnorden(a^.Hi); 
		imprimirEmpleado(a^.dato); 
		imprimirEnOrden(a^.HD);
	end; 
end; 

///modulos nuevos  

function enRango(dni, sup, inf: integer): boolean 
begin 
	return ((dni>= sup) and (dni <= inf)); 
end; 
procedure crearDatoAGuardar(a: arbol; var dato: datoVector); 
begin 
	dato.dni:= a^.dato.dni; 
	dato.legajo:= a^.dato.legajo; 
end; 
procedure crearVector(var vec: vector; var dimL: integer; a: arbol; sup, inf, cate: integer);  
var 
	sup, inf, cate: integer; 
	dato:datoVector; 
begin
	if (a <> nil) 
		crearVector(vec, dimL, a^.HI, sup, inf, cate);  
		if ((a^.dato.categoria = cate) and( enRango(a^.dato.dni, sup, inf)) then
			crearDatoAGuardar(a, dato); 
			vec[dimL]:= dato; 
			dimL := dimL+1; 
		end; 
		crearVector(vec, dimL, a, sup, inf, cate); 
end; 

procedure incisoA(a: arbol; var vec: vector; var dimL: integer)
var
	cate, sup, inf: integer; 
begin 
	write('ingrese una categoria: '); 
	readln(cate); 
	write('ingrese el valor limite de dni:'); 
	readln(sup); 
	writeln('ingrese en valor inferior de dni: '); 
	readln(inf); 
	 
	crearArbol(a, vec, dimL); 
end;
