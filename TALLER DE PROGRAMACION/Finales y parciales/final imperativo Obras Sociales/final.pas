program final; 
const 
	dimF= 10; 
	dimF2= 200; 
type 
	rangoCategorias= 1..dimF; 
	
	afiliado= record
		nro_afiliado: integer; 
		nro_dni: integer; 
		categoria: rangoCategorias; 
		anio_ingreso: integer; 
	end; 
	
	arbol=^nodo;
	
	nodo= record 
		dato: afiliado; 
		HI: arbol; 
		HD:arbol; 
	end; 
	datoVector= record
		nro_afiliado: integer; 
		nro_dni: integer; 
	end;
	vector= array[1..dimF2]of datoVector; 


procedure iniciarVector(var vec: vector); 
var
	i: integer; 
begin
   	for i:= 1 to dimF2 do begin
		vec[i].nro_dni:= 0; 
	end; 
end;

function buscarPosicionEnVector(dni: integer; dimL: integer; vec: vector): integer; 
var
	pos: integer; 
begin
	pos:= 1;
	while (pos<= dimL) and (vec[pos].nro_dni < dni) do 
		pos := pos +1; 
	buscarPosicionEnVector:= pos; 
end; 

	
	

procedure armarDatoEInsertar(var vec: vector; a: afiliado; var dimL: integer);
var
	dato: datoVector; 
	pos, i: integer; 
begin 
	dato.nro_afiliado:=a.nro_afiliado; 
	dato.nro_dni:= a.nro_dni; 
	pos:= buscarPosicionEnVector(a.nro_dni, dimL, vec); 
	
	{debugging}
	writeln('posicion del vec ', pos); 
	writeln(' SOCIO      ', dato.nro_dni); 
	
	for i := dimL downto pos do
		vec[i+1] := vec[i]; 
	vec[pos]:= dato; 
	dimL:= dimL +1; 
	
end; 

function enRango (dni1, dni2, dni: integer): boolean;
begin 
	enRango:=((dni>= dni1) and (dni <= dni2)); 
end; 

procedure insertarEnVector(var vec: vector; var dimL: integer;abb: arbol; inf, sup: integer; cate: rangoCategorias ); 
begin 
	if (abb <> nil) then begin
		writeln('dni del socio: ', abb^.dato.nro_dni); 
		writeln('categoria del socio: ', abb^.dato.categoria); 
		if ((abb^.dato.categoria= cate) and ( enRango(inf, sup, abb^.dato.nro_dni))) then begin
			{debugging}
			writeln('socio en rango');
			
			armarDatoEInsertar(vec, abb^.dato, dimL); 
			
			{debugin}
			writeln('agregado correctamente'); 
		end; 
		insertarEnVector(vec, dimL, abb^.HI, inf, sup, cate); 
		insertarEnVector(vec, dimL, abb^.HD, inf, sup, cate); 		
	end; 	
end; 

procedure crearVector(var vec: vector; abb: arbol;var dimL : integer);
var 
	cate: rangoCategorias;
	inf, sup: integer;
	
begin
	write('ingrese una categoria: '); 
	readln(cate); 
	write('ingrese un dni como valor inferior: '); 
	readln(inf) ;
	write('inrgese un dni como valor superior: '); 
	readln(sup);
	insertarEnVector(vec, dimL, abb, inf, sup, cate ); 
	
end; 
procedure imprimirVector(vec: vector; dimL : integer); 
var 
	i: integer; 
begin 
	for  i:=1 to dimL do begin
		write('pos ', i, ' : ',' dni: ', vec[i].nro_dni,' , nro afiliado: ',vec[i].nro_afiliado); 
		writeln(); 
	end; 
end; 

procedure leerAfiliado(var a: afiliado);
begin
	a.nro_afiliado:= random(100); 
	writeln(' numero de afiliado: ', a.nro_afiliado); 
	a.nro_dni:= 1+ random (4000); 
	writeln(' numero de dni: ', a.nro_dni); 
	a.anio_ingreso:= 1990 +random(33);
	writeln(' anio ingreso: ', a.anio_ingreso); 
	a.categoria:= 1+random(10);
	writeln(' categoria: ', a.categoria); 
end; 
procedure insertarNodo(var abb: arbol; a: afiliado); 
begin
	if(abb=nil) then begin
		new(abb);
		abb^.dato:= a; 
		abb^.HI:= nil; 
		abb^.HD:= nil; 
	end
	else 
		if (a.nro_afiliado < abb^.dato.nro_afiliado) then 
			insertarNodo(abb^.HI, a)
		else
			insertarNodo(abb^.HD, a); 
end; 

procedure crearArbol(var abb: arbol); 
var
	a: afiliado; 
	i: integer;
	//cargo solo 12 afiliados para probar 
begin 

	for i:= 1 to 12 do begin
		leerAfiliado(a);
		insertarNodo(abb, a); 
	end; 
end; 

procedure imprimirEnOrden(a: arbol); 
begin 
	if (a<> nil) then begin
		imprimirEnOrden(a^.HI); 
		writeln('nro afiliado: ', a^.dato.nro_afiliado, ' |dni: ', a^.dato.nro_dni, '| ingreso: ', a^.dato.anio_ingreso,'| categoria: ', a^.dato.categoria);
		imprimirEnOrden(a^.HD); 
	end;  
end; 






{programa principal}
var
	abb: arbol; 
	vec:vector; 
	dimL: integer; 
begin 
	crearArbol(abb); 
	imprimirEnOrden(abb); 
	iniciarVector(vec); 
	dimL:= 0; 
	crearVector(vec,abb,dimL); 
	imprimirVector(vec, dimL); 
end.
		
