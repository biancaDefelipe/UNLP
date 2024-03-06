{
1. Una biblioteca nos ha encargado procesar la información de los préstamos realizados durante cada el año 2021. 
De cada préstamo se conoce el ISBN del libro, el número de socio, día y mes del préstamo y cantidad de días prestados. 
Implementar un programa con:
	a.Un módulo que lea préstamos y retorne en una estructura adecuada la información de los préstamos organizada por mes. 
	  Para cada mes, los préstamos deben quedar ordenados por ISBN. La lectura de los préstamos finaliza con ISBN -1.
	b.Un módulo recursivo que reciba la estructura generada en a. y muestre, para cada mes, ISBN y numero de socio.
	c.Un módulo que reciba la estructura generada en a. y retorne una nueva estructura con todos los préstamos ordenados por ISBN.
	d.Un módulo recursivo que reciba la estructura generada en c. y muestre todos los ISBN y número de socio correspondiente.
	e.Un módulo que reciba la estructura generada en a. 
		y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces que se prestó durante el año 2021.
	f.Un módulo recursivo que reciba la estructura generada en e. y muestre su contenido.}

program ejercicio4.pas; 

const 
	constAnio= 2021; 
type 
	rangoMeses= 1..12; 
	rangoDias= 1..31;
	fecha= record 
		dia: rangoDias; 
		mes: rangoMeses; 
		anio:integer; 
	end; 
		
	prestamo= record
		isbn: integer; 
		socio: integer; 
		fecha: fecha; 
		cantDias: integer; 
	end; 
	
	arbol= ^nodo; 
	nodo= record
		dato:prestamo; 
		HI: arbol; 
		HD: arbol; 
	end; 
	
	datosPrestamo= record
		isbn: integer; 
		cant_prestadas: integer; 
	end;
	listaPrestamo=^nodo2
	nodo2= record
		dato: datosPrestamo; 
		sig: lista; 
	end; 
	
	
	
procedure leerFecha (var f: fecha); 
begin 
	write('dia(1..31): ') ;
	readln(f.dia); 
	write('mes(1..12): '); 
	readln(f.mes); 
end; 
	
procedure leerPrestamo (var p: prestamo); 
begin 
	write('isbn: '); 
	readln(p.isbn); 
	if (p.isbn <> -1) then begin 
		write('numero de socio: '); 
		readln(p.socio); 
		leerFecha(p.fecha); 
		write('dias prestados: '); 
		readln(p.cantDias); 
		p.fecha.anio:= constAnio;  
	end; 
end; 

procedure insertarNodo(var a: arbol; p: prestamo); 
begin 
	if (a = nil) then begin
		new(a); 
		a^.dato:= p; 
		a^.HI:= nil; 
		a^.HD:= nil;
	end
	else 
		if (a^.dato.fecha.mes <= p.fecha.mes) then 
			insertarNodo(a^.HD, p)
		else 
			insertarNodo(a^.HI, p); 
end; 

procedure crearArbol (var a: arbol); 
var
	p: prestamo; 
begin
	leerPrestamo(p); 
	while (p.isbn <> -1) do begin
		insertarNodo(a, p); 
		writeln('_____________________________'); 
		leerPrestamo(p); 
	end; 
end; 

procedure imprimirEnorden(a:arbol); 
begin 
	if (a <> nil) then begin 
		imprimirEnOrden (a^.HI); 
		write ('| isbn: ', a^.dato.isbn, ' | numero de socio: ', a^.dato.socio, ' | fecha : ', a^.dato.fecha.dia, '/', a^.dato.fecha.mes,'/', a^.dato.fecha.anio,' | ', a^.dato.cantDias);
		writeln(); 
		imprimirEnOrden(a^.HD); 
	end; 
end; 


///b.Un módulo recursivo que reciba la estructura generada en a. y muestre, para cada mes, ISBN y numero de socio.


//c.Un módulo que reciba la estructura generada en a. y retorne una nueva estructura con todos los préstamos ordenados por ISBN.
procedure insertarNodo2(var a: arbol; p: prestamo); 
begin 
	if (a = nil) then begin
		new(a); 
		a^.dato:= p; 
		a^.HI:= nil; 
		a^.HD:= nil; 
	end
	else 
		if (a^.dato.isbn<=p.isbn )then 
			insertarNodo2(a^.HD, p)
		else 
			insertarNodo2(a^.HI, p); 
end; 
procedure crearArbolISBN(var arb2: arbol; a: arbol); 
begin 
	if (a<> nil) then begin
		insertarNodo2(arb2, a^.dato); 
		crearArbolISBN(arb2,a^.HI); 
		crearArbolISBN (arb2, a^.HD); 
	end; 
end; 
//e.Un módulo que reciba la estructura generada en a. 
//y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces que se prestó durante el año 2021.

procedure insertarOrdenado(var l: lista;  p: prestamo); 
var
	nue: lista; 
	dato: datosPrestamo; 
begin 
	new (nue); 
	nue^.dato.isbn:= p.isbn; 
	nue^.sig:= nil ; 
	
	act:= l; 
	ant:= l; 
	
	while ((act <> nil) and (act^.dato.isbn < p.isbn)) do begin
		ant:= act; 
		act:= act^.sig; 
	end; 
	if (act= l) then 
		nue^.dato.cant_prestadas := 1; 
		l:= nue; 
	else 
	//si ya esta en a lista actualizo la cantidad de veces que se presto
	if a(ct^.dato.isbn = p.isbn) then 
		act^.dato.cant_prestadas:= act^.dato.cant_prestadas +1; 
	else
		nue^.dato.cant_prestadas := p; 
		ant^.sig:= nue; 
		nue^.sig:= act; 
		 
		
		

procedure crearListaPrestamos(var l: lista; a: arbol); 
begin 
	if  (a <> nil) do begin 
		insertarOrdenado(l, a^.dato); 
		crearListaPrestamos(l, a^.HI); 
		crearListaPrestamos(a, añ.HD); 
	end; 
end; 


{prorama principal}

var
	a, arb2:arbol; 

begin
	writeln('--------------------------------------------------------------------------------------'); 
	crearArbol(a); 
	
	writeln('--------------------------------------------------------------------------------------'); 
	imprimirEnorden(a); 
	
	
	writeln('--------------------------------------------------------------------------------------'); 
	crearArbolISBN(arb2, a); 
	
	writeln('--------------------------------------------------------------------------------------'); 
	imprimirEnorden(arb2); 

end.
