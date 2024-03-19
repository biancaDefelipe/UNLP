{
5. Realizar un programa para una tienda de celulares, que presente un menú con
opciones para:
a. Crear un archivo de registros no ordenados de celulares y cargarlo con datos
ingresados desde un archivo de texto denominado “celulares.txt”. Los registros
correspondientes a los celulares deben contener: código de celular, nombre,
descripción, marca, precio, stock mínimo y stock disponible.
b. Listar en pantalla los datos de aquellos celulares que tengan un stock menor al
stock mínimo.
c. Listar en pantalla los celulares del archivo cuya descripción contenga una
cadena de caracteres proporcionada por el usuario.
d. Exportar el archivo creado en el inciso a) a un archivo de texto denominado
“celulares.txt” con todos los celulares del mismo. El archivo de texto generado
podría ser utilizado en un futuro como archivo de carga (ver inciso a), por lo que
debería respetar el formato dado para este tipo de archivos en la NOTA 2.
NOTA 1: El nombre del archivo binario de celulares debe ser proporcionado por el usuario.
NOTA 2: El archivo de carga debe editarse de manera que cada celular se especifique en
tres líneas consecutivas. En la primera se especifica: código de celular, el precio y
marca, en la segunda el stock disponible, stock mínimo y la descripción y en la tercera
nombre en ese orden. Cada celular se carga leyendo tres líneas del archivo
“celulares.txt”.
*}

program ejercicio5; 


type 
	celular= record
		cod: integer; 
		nom: String; 
		desc: String; 
		marca: String; 
		precio: real; 
		stock_min: integer; 
		stock_actual: integer; 
	end; 
	archivo_celulares= file of celular; 



procedure mostrarMenu(var op: integer); 
begin 
	writeln('  							                                                        ');
	writeln('seleccione una opcion:                                   '); 
	writeln('                     1 | Generar un archivo de celulares'); 
	writeln('                     2 | Listar celulares sin stock'); 
	writeln('                     3 | Listar celulares con descripcion buscada '); 
	writeln('                     4 | Exportar a txt '); 
	writeln('                     0 | SALIR');  
	readln(op); 
end; 
{
a. Crear un archivo de registros no ordenados de celulares y cargarlo con datos
ingresados desde un archivo de texto denominado “celulares.txt”. Los registros
correspondientes a los celulares deben contener: código de celular, nombre,
descripción, marca, precio, stock mínimo y stock disponible. 
*}
procedure crearBinario(var arch_fisico:string; var arch: archivo_celulares);
begin
	write('ingrese un nombre para el archivo: '); 
	readln(arch_fisico); 
	Assign (arch, arch_fisico); 
end;
procedure importar_celulares(var arch: archivo_celulares; var txt: Text; var arch_fisico: string); 
var 
	celu: celular;
begin 
	Assign (txt, 'celulares.txt'); 
	rewrite(arch); 
	reset (txt);
	crearBinario(arch_fisico, arch); 
	while (not eof(txt)) do begin 
		with celu do begin 
			readln(txt, cod, precio,  marca); 
			readln(txt,stock_actual, stock_min, desc); 
			readln(txt,nom);
		end; 
		write(arch, celu); 
	end; 
	close(txt); 
	close(arch); 
end; 
{
b. Listar en pantalla los datos de aquellos celulares que tengan un stock menor al
stock mínimo.
}
procedure imprimir_celular(celu: celular); 
begin
	writeln('cod: ', celu.cod, ' precio: ', celu.precio, ' marca: ', celu.marca); 
	writeln('stock actual: ', celu.stock_actual, ' stock minimo: ', celu.stock_min, ' descripcion: ', celu.desc);
	writeln('nombre: ', celu.nom); 
end; 
procedure imprimir_sin_stock(var arch: archivo_celulares); 
var
	celu: celular; 
begin 
	reset (arch); 
	while (not eof(arch)) do begin 
		read(arch, celu); 
		if (celu.stock_actual< celu.stock_min) then 
			imprimir_celular(celu); 
	end; 
	close(arch); 
end; 

{
c. Listar en pantalla los celulares del archivo cuya descripción contenga una
cadena de caracteres proporcionada por el usuario.
}
procedure imprimir_con_descripcion(var arch: archivo_celulares); 
var
	descripcion:string; 
	celu: celular; 
begin 
	write(' ingrese una descripcion: '); 
	readln(descripcion); 
	reset (arch); 
	while (not eof(arch)) do begin 
		read(arch, celu); 	
		{la descripcion tiene que ser igual a la ingresada o alcanza con que tenga la cadena de caracteres proporcionada?}
		if (celu.desc = descripcion) then 
			imprimir_celular(celu); 
	end; 
	close(arch); 
end; 


{
d. Exportar el archivo creado en el inciso a) a un archivo de texto denominado
“celulares.txt” con todos los celulares del mismo. El archivo de texto generado
podría ser utilizado en un futuro como archivo de carga 
* }
procedure exportarAtxt(var arch: archivo_celulares); 
var 
	txt: Text;
	celu: celular; 
begin 
	Assign (txt, 'celulares.txt'); 
	rewrite(txt); 
	reset (arch); 
	while (not eof(arch)) do begin 
		read(arch, celu); 
		with celu do begin 
			writeln(txt, cod, ' ', precio, ' ', marca); 
			writeln(stock_actual, ' ', stock_min, ' ', desc); 
			writeln(nom);
		end; 
	end; 
	close(txt); 
	close(arch); 
end; 
{programa principal}

var
	arch: archivo_celulares; 
	arch_fisico: string; 
	txt: Text; 
	op: integer; 
begin
	mostrarMenu(op); 
	while (op <> 0) do begin
		
		case op of
			1 : importar_celulares(arch, txt, arch_fisico); 
			2 : imprimir_sin_stock(arch); 
			3 : imprimir_con_descripcion(arch); 
			4 : exportarAtxt(arch); 
		end; 	
		mostrarMenu(op); 
	end;
end.
