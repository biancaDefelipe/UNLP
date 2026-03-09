program finalImperativo2024;
type

	alumno= record
		nombre: string; 
		legajo: integer; 
		autoevaluaciones_aprobadas: integer; 
	end; 
	
	arbol= ^nodo; 
	
	nodo= record
		dato: alumno; 
		HI: arbol; 
		HD: arbol; 
	end; 
	
	lista =^nodo2; 
	nodo2= record
		dato: alumno; 
		sig: lista; 
	end; 
	
procedure leerAlumno (var alu: alumno); 
begin 
	write(' legajo: '); 
	readln(alu.legajo); 
	
	if(alu.legajo <>0) then begin
		write(' nombre: '); 
		readln(alu.nombre); 
		alu.autoevaluaciones_aprobadas:=0; 
		
	end; 
end; 

procedure insertarNodo(var abb: arbol; alu: alumno); 
begin 
	if (abb= nil) then begin
		new(abb); 
		abb^.dato:= alu; 
		abb^.HI:= nil; 
		abb^.HD:= nil; 
	end
	else begin 
		if (alu.legajo < abb^.dato.legajo) then 
			insertarNodo(abb^.HI, alu)
		else
			insertarNodo(abb^.HD, alu); 
	end; 
end; 

procedure crearArbol(var abb: arbol); 
var
	alu: alumno; 
begin 
	leerAlumno(alu); 
	while (alu.legajo <> 0) do begin 
		insertarNodo(abb, alu); 
		leerAlumno(alu); 
	end; 
end; 

procedure imprimirArbolEnOrden(abb: arbol); 
begin
	if (abb <> nil) then begin 
		imprimirArbolEnOrden(abb^.HI); 
		writeln(' alumno : ', abb^.dato.legajo, ' nombre: ', abb^.dato.nombre);
		imprimirArbolEnOrden(abb^.HD); 
	end; 
end; 

function buscar (a: arbol; num: integer): arbol; 
begin 
	if (a= nil) then 
		buscar:= nil 
	else
		if (a^.dato.legajo = num) then 
			buscar:= a
		else
			if (a^.dato.legajo > num) then 
				buscar:=buscar(a^.HI, num)
			else
				buscar:= buscar(a^.HD, num); 
end; 
procedure incisoB(var abb: arbol); 
var 
	num: integer; 
	nodoAlu: arbol; 
begin 
	write('ingrese el numero de legajo a buscar: '); 
	readln(num); 
	nodoAlu:= buscar(abb, num); 
	if (nodoAlu <> nil) then begin
		nodoAlu^.dato.autoevaluaciones_aprobadas:= nodoAlu^.dato.autoevaluaciones_aprobadas + 1; 
		writeln(' se han incrementado las autoevaluaciones aprobadas de ', nodoAlu^.dato.legajo); 
	end
	else
		writeln(' no existe el alumno con el legajo ingresado'); 
end; 

function cumpleCondicion(alu: alumno): boolean; 
begin
	cumpleCondicion:=(alu.autoevaluaciones_aprobadas >=3); 
end; 

procedure insertarOrdenado(var l: lista; alu: alumno); 
var 
	act, ant, nue: lista; 
begin 
	new(nue); 
	nue^.dato:= alu; 
	nue^.sig:= nil; 

	act:= l; 
	ant:= l; 
	while (act <> nil) and (act^.dato.nombre < alu.nombre) do begin 
		ant:= act; 
		act:=act^.sig; 
	end; 
	if (act= ant) then 
		l:= nue
	else 
		ant^.sig:= nue; 
	nue^.sig:= act;
end; 


procedure incisoC(abb: arbol; var l: lista); 
begin 
	if (abb <> nil) then begin 
		incisoC(abb^.HI, l); 
		if (cumpleCondicion(abb^.dato)) then 
			insertarOrdenado(l, abb^.dato); 
		incisoC(abb^.HD, l); 
	end; 
end; 

procedure imprimirLista(l: lista); 
begin 
	if (l<> nil) then begin	
		writeln(' alumno : ', l^.dato.legajo, ' nombre: ', l^.dato.nombre, ' evaluaciones aprobadas: ', l^.dato.autoevaluaciones_aprobadas);
		imprimirLista(l^.sig); 
	end; 
end; 

{programa principal}
var
	abb: arbol;
	l: lista  ; 
	i: integer; 
begin 
	crearArbol(abb); 
	imprimirArbolEnOrden(abb); 
	for i:= 1 to 15 do
	  incisoB(abb); 

	l:=nil; 
	incisoc(abb, l); 
	imprimirLista(l); 
end.
