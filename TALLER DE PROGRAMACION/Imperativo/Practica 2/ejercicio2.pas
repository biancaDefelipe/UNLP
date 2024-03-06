{ Realizar un programa que lea números hasta leer el valor 0 e imprima, 
para cada número leído, sus dígitos en el orden en que aparecen en el número. 
Debe implementarse un módulo recursivo que reciba el número e imprima lo pedido. 
Ejemplo si se lee el valor 256, se debe imprimir 2  5  6}

program ejercicio2; 

procedure dividendo(num: integer; var divisor: integer);
//devuelve un divisor con la misma cantidad de digitos que num
begin	
	if num >= divisor*10 then begin
		divisor:= divisor*10;
		dividendo(num, divisor);
	end;
end;

procedure descomponer(var num: integer; var divisor: integer);
var
	digito: integer;
begin
	if (divisor <> 0) then begin
		digito:= num DIV divisor;
		num:= num - (digito * divisor);
		divisor:= divisor DIV 10;
		write(digito, ' ');		
		descomponer(num, divisor);
	end;
end;

procedure leerNumero(var num: integer);
var
	divisor: integer;
begin
	write('Ingrese un numero: '); 
	readln(num);
	if (num <> 0) then begin
		divisor:= 1;
		dividendo(num, divisor);
		descomponer(num, divisor);
		writeln('');
		leerNumero(num);
	end;
end;

var
	num: integer;
begin
	leerNumero(num);
end.
