program parcialImperativo2023; 

const 
	dimF=5; 
	cantFlores=10; 
	cantPapeles= 10; 
	cantAvenidas=100; 
	cantCalles=100; 
	
type 
	rangoId= 1..dimF; 
	rangoFlores= 1..cantFlores; 
	rangoPapeles= 1..cantPapeles; 
	rangoAvenidas= 1..cantAvenidas; 
	rangoCalles=1..cantCalles; 
	
	mensaje= record 
		id: rango1; 
		cantFlores: rangoFlores; 
		cantPapeles: rangoPapeles; 
		av: rangoAvenidas;
		ca: rangoCalles; 
	end; 
	
	lista= ^nodo; 
	nodo=record
		dato: mensaje; 
		sig: lista; 
	end; 

	dato2= record; 
		av: rangoAvenias; 
		cantFlores:integer; 
		esquinasSinPapeles: integer; 
	end;
	lista2= ^nodo2
	nodo2= record
		dato:= dato2; 
		sig:= lista2; 
	end; 
	
		
		
procedure leerMensaje(var m:mensaje); 
begin
	write('id : '); 
	readln(m.id); 
	write ('cantidad de flores juntadas: ');
	readln(m.cantFlores); 
	write('cantidad de papeles juntados: '); 
	readln(m.cantPapeles); 
	write('avenida: '); 
	readln(m.av); 
	write('calle: '); 
	readln(m.calle);
end; 

procedure insertarOrdenado(var l: lista; m :mensaje)
var
	nue, ant, act: lista; 
begin 
	new(nue); 
	nue^.dato:=m; 
	nue^.sig:= nil; 
	if (l=nil) then 
		l:= nue; 
	else begin
		act:= l; 
		ant:= l; 
		while ((act <> nil)and(m.av >act^.dato.av)) do begin 
			ant:= act; 
			act:= act^.sig; 
		end; 
		if(act= l) then begin
			nue^.sig:= l; 
			l:= nue; 
		end; 
		else begin
			ant^.sig:= nue; 
			nue^.sig:= act;
		end; 
	end; 
end; 
		
procedure recibirMensajes(var vec: vector)
var
	i: integer; 
	m: mensaje; 
begin
	for i:=1 to 100 do begin 
		leerMensaje(m); 
		insertarOrdenado(vec[m^.id], m); 
	end; 
	
end; 

procedure imprimirMensaje(m: mensaje)

procedure imprimirLista
procedure imprimirVector 
		

procedure incisoB(var l2: lista2; vec: vector); 
var
	floresTotales, esquinasSinPapeles: integer;
	i: integer;  
begin
	for i:= 1 to dimF
		if (vec

{programa princicpal}
var
  vec: vector; 
  listaNueva: lista2;
 begin
   recibirMensajes(vec); 
   
   listaNueva:= nil
		
		
		
		
		
		
		
		
		
		
		
		
