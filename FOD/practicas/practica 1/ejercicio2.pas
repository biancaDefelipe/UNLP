{
Realizar un algoritmo, que utilizando el archivo de números enteros no ordenados
creado en el ejercicio 1, informe por pantalla cantidad de números menores a 1500 y el
promedio de los números ingresados. El nombre del archivo a procesar debe ser
proporcionado por el usuario una única vez. Además, el algoritmo deberá listar el
contenido del archivo en pantalla
*}

program ejercicio2; 

type 
	archivo_numeros= file of integer;
	
procedure recorrerArchivoNumeros(var arch: archivo_numeros; var menores: integer; var prom: double); 
var 
	num: integer; 
	total, cant: integer;
begin 
	reset(arch); 

	cant:= 0; 
	total:= 0; 
	while( not eof(arch))do begin
		read(arch, num); 
		writeln('          num actual: ', num); 
		if (num <1500) then 
			menores:=menores +1; 
		cant:= cant +1; 
		total:= total + num; 
	end;
	
	prom:= total/cant;  
end; 

var 
	arch: archivo_numeros; 
	arch_fisico: string; 
	menores, num: integer; 
	prom: double; 
begin
	write('ingrese el nombre del archivo: '); 
	readln(arch_fisico); 
	Assign (arch, arch_fisico); 
	
	write(' inrgese un numero entero: ');
	readln(num); 
	rewrite(arch);
	
	while ( num <> 3000) do begin
		write(arch, num); 
		write(' inrgese un numero entero: '); 
		readln(num); 
	end; 
	close(arch); 
	
	//punto 2
	menores:=0; 
	prom:= 0; 
	recorrerArchivoNumeros(arch, menores, prom); 
	writeln('la cantidad de numeros enteros menores a 1500 es : ', menores); 
	writeln('el promedio de los numeros ingresados es : ', prom:2:2); 
end.
