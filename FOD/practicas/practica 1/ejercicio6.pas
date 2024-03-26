{
6. Agregar al menú del programa del ejercicio 5, opciones para:
a. Añadir uno o más celulares al final del archivo con sus datos ingresados por
teclado.
b. Modificar el stock de un celular dado.
c. Exportar el contenido del archivo binario a un archivo de texto denominado:
”SinStock.txt”, con aquellos celulares que tengan stock 0.
NOTA: Las búsquedas deben realizarse por nombre de celular.
*}

program ejercicio6; 


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
	writeln('                     5 | Añadir celular '); 
	writeln('                     6 | Modificar el stock de un celular ');
	writeln('                     7 | Exportar a txt celulares sin stock ');  
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
	reset (txt);
	crearBinario(arch_fisico, arch); 
	rewrite(arch); 
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
	writeln('cod: ', celu.cod, ' precio: ', celu.precio:2:2, ' marca: ', celu.marca); 
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
			writeln(txt, stock_actual, ' ', stock_min, ' ', desc); 
			writeln(txt, nom);
		end; 
	end; 
	close(txt); 
	close(arch); 
end; 



{
a. Añadir uno o más celulares al final del archivo con sus datos ingresados por
teclado.
*}
procedure leerCelular (var celu: celular); 
begin 
	write(' codigo de celular: '); 
	readln(celu.cod); 
	write(' precio: '); 
	readln(celu.precio); 
	write(' marca: '); 
	readln(celu.marca); 
	write(' stock actual: '); 
	readln(celu.stock_actual);
	write(' stock minimo: '); 
	readln(celu.stock_min);  
	write(' descripcion: '); 
	readln(celu.desc); 
	write(' cnombre: '); 
	readln(celu.nom);
end;  
	
procedure agregar_celular(var arch: archivo_celulares); 
var 
	celu: celular; 
	
begin 
	leerCelular(celu);
	reset(arch); 
	Seek(arch, fileSize(arch)); 
	 
	write(arch,celu); 
	close(arch); 
end;	

{
b. Modificar el stock de un celular dado.
}
procedure buscarCelu(nom: string; var arch: archivo_celulares; var pos: integer); 
var 
	celu: celular; 
	encontre: boolean; 
begin 
	reset (arch); 
	encontre:= false; 
	while (not eof(arch))and (not encontre) do begin 
		read(arch, celu); 
		if (celu.nom= nom) then begin 
			encontre:= true; 
			pos:= filePos(arch)-1; 
		end; 
	end; 
end; 
procedure modificar_stock(var arch: archivo_celulares); 
var 
	nom: string; 
	pos:integer;
	celu: celular; 
begin 
	write('ingrese el nombre del celular al cual desea modificarle el stock: '); 
	readln(nom); 
	pos:=-1; 
	buscarCelu(nom, arch, pos);
	if (pos <>-1) then begin
		Seek(arch, pos); 
		read(arch, celu);
		write(' stock atualizado: '); 
		readln(celu.stock_actual); 
		Seek(arch, pos); 
		write(arch, celu); 
	end
	else
		writeln(' no se encontro el celular buscado: '); 
	close(arch); 
end; 
{
c. Exportar el contenido del archivo binario a un archivo de texto denominado:
”SinStock.txt”, con aquellos celulares que tengan stock 0.
}
procedure exportar_sinStock(var arch: archivo_celulares; var txtNuevo: Text); 
var 	
	celu: celular; 
begin 
	reset(arch); 
	Assign(txtNuevo, 'SinStock.txt');
	rewrite(txtNuevo); 
	while (not eof(arch)) do begin 
		read(arch, celu); 
		if (celu.stock_actual = 0) then 
			with celu do begin 
				writeln(txtNuevo, cod, ' ', precio, ' ', marca); 
				writeln(txtNuevo, stock_actual, ' ', stock_min, ' ', desc); 
				writeln(txtNuevo, nom);
			end; 
	end; 
	close (arch); 
	close(txtNuevo); 
end; 		

{programa principal}

var
	arch: archivo_celulares; 
	arch_fisico: string; 
	txt, txtNuevo: Text; 
	op: integer; 
begin
	mostrarMenu(op); 
	while (op <> 0) do begin
		
		case op of
			1 : importar_celulares(arch, txt, arch_fisico); 
			2 : imprimir_sin_stock(arch); 
			3 : imprimir_con_descripcion(arch); 
			4 : exportarAtxt(arch); 
			5 : agregar_celular(arch); 
			6 : modificar_stock(arch); 
			7 : exportar_sinStock(arch, txtNuevo); 
		end; 	
		mostrarMenu(op); 
	end;
end.
