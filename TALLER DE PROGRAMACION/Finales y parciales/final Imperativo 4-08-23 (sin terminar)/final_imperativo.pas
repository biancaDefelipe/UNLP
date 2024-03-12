program finalImperativo; 

const
	dimF= 6; 
type
	rangoCategorias= 1..dimF; 
	fecha= record
		mes: 1..12; 
		dia: 1..31; 
		anio: integer; 
	end; 
	direccion= record
		nro_calle: int;
		nro_altura: int; 
	end; 
	denuncia = record
		categoria: rangoCategorias; 
		dni: integer; 
		direccion: direccion; 
		fecha; 
	end; 
	
	lista= ^nodo; 
	nodo= record 
		dato: denuncia
		sig: lista; 
	end; 
	
	vector= array[rangoCategorias] of lista; 
	
	dato2= record
		calle: integer; 
		denuncias_totales: integer; 
		denuncias_julio: integer; 
	end;
	listaNueva= ^nodo2; 
	nodo2= record
		dato: dato2; 
		sig: lista; 
	end; 
procedure leerDenuncia(var d: denuncia); 
begin 
	write(' dni: '); 
	readln(d.dni); 
	if (d.dni <> 0) then begin 
		d.categoria := 1+random (6); 
		writeln(' categoria: ', d.categoria); 
		d.direcion.calle:= 1+ random (599); 
		writeln(' calle: ', d.direccion.calle);
		d.fecha.mes:= 1+ random (12); 
		writeln('mes : ', d.fecha.mes); 
	end; 
end; 

procedure insertarOrdenado (var l: lista; d: denuncia); 
var 
	nue, act, ant: lista;
begin 
	new(nue); 
	nue^.dato:= d; 
	nue^.sig:= nil; 
	
	ant:= l; 
	act:=l; 
	while ((act<> nil) and (act^.dato.direccion.calle < d.direccion.calle)) do begin 
		ant:= act; 
		act:= act^.sig; 
	end
	if (act= ant) then 
		l:= nue; 
	else
		ant^.sig:= nue; 
	nue^.sig:= act; 
end; 
procedure iniciarVector(var vec: vector); 
var
	i: integer; 
begin
	for i:= 1 to dimF do 
		vec[i]:= nil; 
end; 

procedure cargarVector(var vec: vector); 
var 
	d: denuncia; 
begin 
	leerDenuncia(d); 
	while (d.dni<> 0) do begin 
		insertarOrdenado(vec[d.categoria], d); 
		leerDenuncia(d); 
	end; 
end; 




procedure imprimirDenuncia(d: denuncia); 
begin 
	writeln(' calle: ' , d.direccion.calle, ' mes: ', d.fecha.mes, ' dni: ', d.dni); 
end; 
procedure imprimirLista(l: lista); 
var
	aux: lista; 
begin
	aux:= l; 
	while (aux <> nil) do begin 
		imprimirDenuncia(aux^.dato); 
		aux:= aux^.sig; 
	end; 
end; 
procedure imprimirVector(vec : vector); 
var 
	i: integer; 
begin 
	for (i:= 1 to dimF ) do begin 
		writeln('                CATEGORIA ', i); 
		imprimirLista(vec[i]); 
	end; 
end; 
procedure inicializarMin(var min:denuncia);
begin
    min.dni:=9999;
    min.categoria:=1;
    min.direccion.calle:=9999;
    min.direccion.nro:=9999;
    min.fecha.mes:=9999;
    min.fecha.dia:=9999;
    min.fecha.hora:=9999;
end;
procedure minimo(var vd:vectorDenuncias; var min:denuncia);
var
    posMin:integer;
    i:cat;
begin
    posMin:=9999;
    inicializarMin(min);
    for i:=1 to DIMF do
    begin
        if (vd[i] <> nil) and (vd[i]^.dato.direccion.calle < min.direccion.calle) then
        begin
            posMin:=i;
            min:=vd[i]^.dato;
        end;
    end;
    if (posMin <> 9999) then
    begin
        vd[posMin]:=vd[posMin]^.sig;
    end;
end;
procedure mergeAcumulador(vec: vector;  var l:listaNueva);
var
    min:denuncia;
    actual:nuevo;
    ult:listaNueva;
begin
    ult:=nil;
    minimo(vec,min);
    while min.direccion.calle <> 9999 do
    begin
        actual.nroCalle:=min.direccion.calle;
        actual.totales:=0;
        actual.julio:=0;
        while (actual.nroCalle = min.direccion.calle) do
        begin
            if (min.fecha.mes = 7) then
                actual.julio:=actual.julio+1;
            actual.totales:=actual.totales+1;
            minimo(vd,min);  
        end;
        agregarAtras(l,ult,actual);
    end;
end;
{progrsama principal}
var 
	vec: vector; 
	dimL: integer; 
	listaNueva: listaNueva; 
begin 
	iniciarVector(vec); 
	cargarVector(vec); 
	imprimirVector(vec); 
	
	listaNueva:= nil; 

