{1.Escribir un programa que:
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol binario de búsqueda. 
   De cada socio se lee número de socio, nombre y edad. La lectura finaliza con el número de socio 0 y el árbol debe quedar ordenado por número de socio.
b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como parámetro y que : 
	i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.
	ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un módulo recursivo que retorne dicho socio.
	iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
	iv. Aumente en 1 la edad de todos los socios.
	v. Lea un valor entero e informe si existe o no existe un socio con ese valor. 
	Debe invocar a un módulo recursivo que reciba el valor leído y retorne verdadero o falso.
	vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. 
	Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
	vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
	viii. Informe el promedio de edad de los socios. 
	Debe invocar al módulo recursivo del inciso vii e invocar a un módulo recursivo que retorne la suma de las edades de los socios.
	ix. Informe, a partir de dos valores que se leen, la cantidad de socios en el árbol cuyo número de socio se encuentra entre los dos valores ingresados. 
	Debe invocar a un módulo recursivo que reciba los dos valores leídos y retorne dicha cantidad.
x. Informe los números de socio en orden creciente. 
xi. Informe los números de socio pares en orden decreciente. }


program ejercicio1; 

type
	socio= record 
		num:integer; 
		nombre:string; 
		edad:integer; 
	end; 
	
	arbol= ^nodo; 
	nodo= record
		dato:socio; 
		HI:arbol; 
		HD:arbol; 
	end;  
	
	
	
procedure crear (var a: arbol; s:socio); 
begin
	if (a = nil) then begin 
		new(a);
		a^.dato:= s; 
		a^.HI:= nil; 
		a^.HD:= nil; 
	end
	else 
	if (s.num< a^.dato.num) then
		crear(a^.HI, s)
	else 
		crear(a^.HD, s);
end;

procedure leerSocio(var s: socio); 
begin 
	write('numero de socio: '); 
	readln(s.num); 
	if (s.num <> 0) then begin
		write('nombre: '); 
		readln(s.nombre); 
		write('edad: '); 
		readln(s.edad); 
	end;
end; 
procedure leerYcrear( var a: arbol);
var 
	s:socio; 
begin 
	a:=nil;
	 
	leerSocio(s); 
	while (s.num <> 0)do  begin   
		crear(a,s);   
		writeln('---------------------------------------------'); 
		leerSocio(s);  
	end; 
end; 

procedure imprimirEnorden(a:arbol); 
begin 
	if (a <> nil) then begin 
		imprimirEnOrden (a^.HI); 
		write ('| ', a^.dato.num, '| ', a^.dato.nombre, '| ', a^.dato.edad);
		writeln('----');
		imprimirEnOrden(a^.HD); 
	end; 
end; 

//inciso b i

function maximo (a:arbol): integer; 
begin 
	if (a= nil) then 
		maximo:= -1
	else
		if (a^.HD = nil) then 
			maximo := a^.dato.num
		else 
			maximo := maximo(a^.HD); 
	end; 


//inciso b ii
function minimo (a:arbol): arbol; 
begin 
	if (a= nil) then 
		minimo:= nil
	else
		if (a^.HI = nil) then 
			minimo := a
		else 
			minimo := minimo(a^.HI); 
	end; 

procedure informarMinimo (a:arbol); 
var 
	min:arbol; 
begin 
	min:= minimo(a); 
	writeln('numero de socio mas chico: ', min^.dato.num, ' | nombre: ', min^.dato.nombre,' | edad: ', min^.dato.edad); 
end; 

//inciso b iii
procedure buscarEdadMaxima(a: arbol; var max: integer; var maxSocio:integer); 
begin 
	if (a <> nil) then begin
		if (a^.dato.edad > max) then  begin
			max := a^.dato.edad;
			maxSocio:=a^.dato.num;
		end;  
		buscarEdadMaxima(a^.HI, max,maxSocio); 
		buscarEdadMaxima(a^.HD, max, maxSocio); 
	end; 
end; 
	
procedure aumentarEdadSocios (var a: arbol); 
begin
	if (a <> nil) then begin
		aumentarEdadSocios(a^.HI); 
		aumentarEdadSocios(a^.HD); 
		a^.dato.edad:= a^.dato.edad +1; 
	end;
end; 

//inciso b v
function buscarPorNumero(a: arbol; num: integer): arbol;  
begin
	if (a =  nil) then 
		buscarPorNumero:= nil
	else
		if(num= a^.dato.num) then
			buscarPorNumero:= a
		else
			if (num < a^.dato.num) then 
				buscarPorNumero:= buscarPorNumero (a^.HI, num)
			else 
				buscarPorNumero := buscarPorNumero(a^.HD, num); 
end; 
				
	


procedure buscarSocioPorNumero (a: arbol); 
var
	num: integer; 
	socio:arbol; 
begin 
	write('numero de socio a buscar: '); 
	readln(num); 
	socio:= buscarPorNumero(a, num); 
	if (socio <> nil) then 
		writeln('el socio ', num, ' se encentra registrado')
	else 
		writeln('el socio ', num, ' no se encuentra registrado'); 

end;

// inciso vi


procedure buscar (a:arbol; nombre:string; var ok:boolean);
begin
        if (a=nil)then
                ok:=false
        else
            if (a^.dato.nombre=nombre)then
                    ok:=true
            else begin
              buscar(a^.HI,nombre,ok);
              if (not ok) then
                      buscar(a^.HD,nombre,ok)
            end;
end; 
procedure buscarSocioPorNombre(a:arbol); 
var 
	nom:string; 
	ok:boolean; 
begin 
	write('ingrese el nombre del socio a buscar: '); 
	readln(nom); 
	buscar(a, nom, ok); 
	if (not ok) then 
		writeln( nom, ' no se encuentra registrado')
	else 
		writeln(nom, ' se encuentra registrado'); 

end; 
	
// inciso vii
function contarSocios(a:arbol): integer; 
begin 
	if (a = nil) then 
		contarSocios:= 0
	else 
		contarSocios:=1 + contarSocios(a^.HI) + contarSocios(a^.HD ) ; 
end; 


//inciso b viii
function sumarEdadesSocios (a:arbol): integer; 
begin 
	if (a= nil) then 
		sumarEdadesSocios:= 0
	else 
		sumarEdadesSocios:= a^.dato.edad + sumarEdadesSocios(a^.HI) + sumarEdadesSocios(a^.HD)
end;
function promedioEdad (a:arbol): real;
begin
	promedioEdad:= sumarEdadesSocios(a)/contarSocios(a); 
end; 

//inciso b ix
function cumplen (a:arbol; valorInferior, valorSuperior:integer): integer; 
begin
	if (a= nil) then 
		cumplen := 0
	else begin
		if (a^.dato.num >= valorInferior )and (a^.dato.num <= valorSuperior)  then 
			cumplen:= 1 + cumplen (a^.HI, valorInferior, valorSuperior)
		else if (a^.dato.num < valorInferior) then 
			cumplen:= cumplen (a^.HD, valorInferior, valorSuperior)
		else if (a^.dato.num> valorSuperior) then 
			cumplen:= cumplen(a^.HI, valorinferior, valorSuperior ); 
	end; 
end; 

procedure sociosEnRango (a: arbol); 
var 
	valorInferior, valorSuperior, cant: integer; 
begin
	write(' ingrese valor inferior: '); 
	readln(valorInferior); 
	write(' ingrese valor superior: '); 
	readln(valorSuperior); 
	
	cant:= cumplen(a, valorInferior, valorSuperior); 
	writeln('la cantidad de socios con numero de socio entre ', valorInferior, ' y ',valorSuperior, ' es : ', cant); 
end; 
	
	
//inciso b x
procedure imprimirEnordenCreciente(a:arbol); 
begin 
	if (a <> nil) then begin 
		imprimirEnOrden (a^.HI); 
		write ('| ', a^.dato.num);
		imprimirEnOrden(a^.HD); 
	end; 
end; 

//inciso b xi
procedure imprimirEnordenDecreciente (a: arbol); 
begin 
	if (a <> nil) then begin 
		imprimirEnorden(a^.HD); 
		write ('| ', a^.dato.num);
		imprimirEnOrden(a^.HI);
	end;
end; 
{programa principa} 
var 
	a: arbol;
	maxEdad, maxSocio, cantSocios, flag:integer; 
	
begin 

	writeln('---------------------------------------------'); 
	//inciso a 
	leerYcrear(a); 
	writeln('---------------------------------------------'); 
	
	writeln('arbol actual: '); 
	imprimirEnorden(a); 
	writeln('---------------------------------------------'); 
		
	//inciso b i
	writeln('numero de socio mas grande: ', maximo(a)); 
	writeln('---------------------------------------------');  
	
	//inciso b ii
	informarMinimo(a); 
	writeln('---------------------------------------------');  
	
	//inciso b iii
	maxEdad:= 0; 
	buscarEdadMaxima(a, maxEdad, maxSocio); 
	writeln('numero de socio con mayor edad: ', maxSocio); 
	writeln('---------------------------------------------');  
	
	
	//inciso b iv
	aumentarEdadSocios(a);
	writeln('arbol modificiado: '); 
	imprimirEnorden(a); 
	writeln('---------------------------------------------'); 
	
	
	write('desea continuar: 1= si 0= no: '); 
	readln(flag); 
	while (flag <> 0 ) do begin
		//inciso v
		buscarSocioPorNumero(a); 
		writeln('---------------------------------------------'); 
		
		//inciso b vi
		buscarSocioPorNombre(a); 
		writeln('---------------------------------------------');
		
		//inciso b vii
		cantSocios:=0; 
		cantSocios:= contarSocios(a); 
		writeln('cantidad de socios actuales: ', cantSocios); 
		writeln('---------------------------------------------');
		
		//inciso b viii
		
		writeln('promedio de edad de los socios: ', promedioEdad(a):2:1); 
		writeln('---------------------------------------------');
		
		//inciso b ix
		sociosEnRango(a); 
		writeln('---------------------------------------------');
		
		//inciso b x 
		writeln('arbol en orden creciente: '); 
		imprimirEnordenCreciente(a); 
		writeln('---------------------------------------------');
		
		//inciso b xi
		writeln('arbol en orden decreciente: '); 
		imprimirEnordenDecreciente(a);
		writeln('---------------------------------------------');
		
		
		
		
	end; 
		
end.
