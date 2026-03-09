{
Realizar un algoritmo que cree un archivo de números enteros no ordenados y permita
incorporar datos al archivo. Los números son ingresados desde teclado. La carga finaliza
cuando se ingresa el número 30000, que no debe incorporarse al archivo. El nombre del
archivo debe ser proporcionado por el usuario desde teclado.
}

program ejercicio1; 


type 
	archivo_numeros= file of integer;
	

var
	arch_fisico: string;
	arch: archivo_numeros; 
	num: integer; 
	

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
	
end.
