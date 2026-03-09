program final2019; 

type 
	viaje= record 
		id_remisse: integer; 
		cod_loc: string; 
		fecha: string; 
		costo: double; 
	end; 
	

	
	arbol= ^nodo; 
	nodo= record
		cod_loc: string;
		id_remisse: integer; 
		cant_viajes: integer; 
		HI: arbol; 
		HD: arbol; 
	end; 
	
	
	
	
procedure leerViaje(var v: viaje);
begin
	write(' localidad de destino: '); 
	readln(v.cod_loc); 
	if (v.cod_loc <> 'xxx') then begin 
		write(' id remise: '); 
		readln(v.id_remisse); 
		write(' fecha: '); 
		readln(v.fecha); 
		write(' costo: '); 
		readln(v.costo); 
	
	end;
end; 
 

procedure insertarNodo(var a: arbol; v: viaje); 

begin
	if (a= nil) then begin 
		new(a); 
		a^.cant_viajes:= 1; 
		a^.id_remisse:= v.id_remisse; 
		a^.cod_loc:= v.cod_loc; 
	
		a^.HI:= nil; 
		a^.HD:= nil; 
	end
	else begin
		if (a^.cod_loc <v.cod_loc) then 
			insertarNodo(a^.HD, v)
		else
			if (a^.cod_loc >v.cod_loc) then 
				insertarNodo(a^.HI, v) 
			
			else 
				a^.cant_viajes:= a^.cant_viajes +1; 
	end; 
end; 
		
		

procedure crearArbol (var a: arbol); 
var
	v: viaje; 
begin 
	leerViaje(v); 
	while (v.cod_loc <>'xxx') do begin
		insertarNodo(a, v); 
		writeln('---------------------------------------');
		leerViaje(v); 
		
	end;
end; 

function buscarCod (a: arbol; cod: string): integer; 
begin 
	if (a <> nil) then
		if (a^.cod_loc = cod) then 
			buscarCod:= a^.cant_viajes 
		else begin
			if(a^.cod_loc > cod) then 
				buscarCod:= buscarCod (a^.HI, cod)
			else 
				buscarCod:= buscarCod (a^.HD, cod); 
		end
	else
		buscarCod:=0; 
end; 
procedure incisoB(var a: arbol) ; 
var 
	cant: integer; 
	cod: string; 
begin
	write(' ingrese un codigo :  '); 
	readln(cod); 
	cant:=buscarCod(a, cod); 
	if (cant=0) then 
		writeln(' no hay viajes realizados a la localidad ', cod)
	else
		writeln('cantidad de viajes realizados a la localidad ', cod, ' : ', cant); 
end; 


procedure sumarViajes(a: arbol; cod:string; var total: integer); 
begin 
	if(a<>nil) then begin
		if (a^.cod_loc< cod) then 
			total:= total + a^.cant_viajes; 
		sumarViajes(a^.HI, cod, total); 
		sumarViajes(a^.HD, cod, total); 
	end; 
end; 

			
procedure incisoC( a: arbol) ; 
var 
	total: integer; 
	cod:string; 
begin
	write(' ingrese un codigo :  '); 
	readln(cod); 
	total:=0; 
	sumarViajes(a, cod, total); 
	writeln(' cantidad de viajes realizados : ', total); 

end; 
	
	
	
{prorama principal}
var
	a: arbol; 
begin
	crearArbol(a); 
	
	incisoB(a); 
	incisoC(a); 
end.
