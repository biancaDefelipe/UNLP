program ejercicio4; 
const
	dimF= 8; 
	
	dimF2= 30; 
type
	rangoRubros= 1..dimF;
	rangoRubro3=1..dimF2; 
	
	producto =record
		cod_prod:integer; 
		cod_rubro: rangoRubros;
		precio:real; 
	end; 
	
	lista=  ^nodo; 
	nodo= record
		dato:producto; 
		sig:lista;
	end;
	
	vectorRubros= array[rangoRubros] of lista; 
	vectorRubro3= array[rangoRubro3] of producto; 
	
	
procedure leerProducto (var p:producto); 
begin 
	write(' precio: '); 
	readln(p.precio); 
	if (p.precio <> 0) then begin
		write(' codigo de producto: '); 
		readln(p.cod_prod); 
		write(' codigo de rubro: '); 
		readln(p.cod_rubro); 
	end; 
end; 

procedure insertarOrdenado (var l: lista; p: producto); 
var
	nue, actual, anterior:lista; 
begin 
	new(nue); 
	nue^.dato:=p; 
	nue^.sig:= nil; 
	
	if (l = nil ) then {la lista esta vacia}
		l:= nue
	else begin 
		actual:= l; 
		anterior:= l; 
		while (actual <> nil) and (actual^.dato.cod_prod < nue^.dato.cod_prod) do begin
			anterior:= actual; 
			actual:=actual^.sig; 
		end; 
		if (actual= l) then begin {el elemento va adelante}
			nue^.sig:= l; 
			l:= nue; 
		end
		else begin
			if (actual <> nil) then
				nue^.sig:= actual; 
			anterior^.sig:= nue; 
		end; 
	end; 
end; 

procedure procesarProductos (var vec: vectorRubros); 
var 
	prod: producto; 
begin
	leerProducto(prod); 
	while (prod.precio <>0) do begin
		insertarOrdenado(vec[prod.cod_rubro], prod);
		leerProducto(prod); 
	end; 
end; 


procedure imprimirVector(vec: vectorRubros); 
var 
	i: integer; 
	act:lista; 
begin 
	for i:= 1 to dimF do begin
		writeln ('     RUBRO ', i); 
		act:= vec[i]; 
		while (act <> nil ) do begin 
			
			write ('codigo de producto: ', act^.dato.cod_prod); 
			writeln(); 
			act:=act^.sig;
			
		end; 
	end; 
end; 

procedure cargarVectorRubro3 (var vec: vectorRubro3; li:lista; var dimL: rangoRubro3);
var 
	act: lista; 
begin
	act:= li;
	dimL:=0; 
	while((act <> nil) and (dimL<= 30))do begin 
		dimL:= dimL +1; 
		vec[dimL]:= act^.dato; 
		writeln('vec[',dimL,']', 'cod: ', vec[dimL].cod_prod, '|', 'precio: ', vec[dimL].precio:2:1); 
		act:= act^.sig; 
	end; 
	
	
end; 
procedure ordenarVector(var vec:vectorRubro3; dimL: rangoRubro3); 
var 
	i,j:integer; 
	actual: producto; 
begin 
	for i:= 2 to dimL do begin 
		actual:= vec[i];  
		j:=i-1; 
		while (j>0) and (vec[j].precio > actual.precio) do begin 
			vec[j+1]:= vec[j]; 
			j:= j-1; 
		end; 
		vec[j+1]:= actual;
	end; 
end; 
	
procedure mostrarPrecios( vec:vectorRubro3; dimL: rangoRubro3);
var 
	i:integer; 
begin 
	for i:= 1 to dimL do begin 
		writeln ('precio del producto ', vec[i].cod_prod, ': ', vec[i].precio:2:1); 
		writeln('---------------------------------------------------------'); 
	end; 
end; 


			
	
var
	vec: vectorRubros; 
	vec3: vectorRubro3;
	dimL: rangoRubro3;

begin
	procesarProductos(vec); 
	imprimirVector(vec); 
	cargarVectorRubro3(vec3, vec[3], dimL); 
	ordenarVector(vec3, dimL); 
	mostrarPrecios(vec3, dimL); 
end.
