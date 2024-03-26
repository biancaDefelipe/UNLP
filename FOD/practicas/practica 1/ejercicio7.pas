{
7. Realizar un programa que permita:
a) Crear un archivo binario a partir de la información almacenada en un archivo de
texto. El nombre del archivo de texto es: “novelas.txt”. La información en el
archivo de texto consiste en: código de novela, nombre, género y precio de
diferentes novelas argentinas. Los datos de cada novela se almacenan en dos
líneas en el archivo de texto. La primera línea contendrá la siguiente información:
código novela, precio y género, y la segunda línea almacenará el nombre de la
novela.
b) Abrir el archivo binario y permitir la actualización del mismo. Se debe poder
agregar una novela y modificar una existente. Las búsquedas se realizan por
código de novela.
NOTA: El nombre del archivo binario es proporcionado por el usuario desde el teclado.
}

program ejercicio7;

type
	novela=record
		cod:integer; 
		nombre:string; 
		genero: string; 
		precio: real; 
	end; 
	archivo_novelas= file of novela; 


procedure mostrarMenu(var op: integer); 
begin 
	writeln('  							                                                        ');
	writeln('seleccione una opcion:                                   '); 
	writeln('                     1 | Generar un archivo de novelas'); 
	writeln('                     2 | Agregar nueva novela'); 
	writeln('                     3 | modificar novela existente '); 
	writeln('                     0 | SALIR');  
	readln(op); 
end; 


procedure crearBinario(var arch_fisico:string; var arch: archivo_novelas);
begin
	write('ingrese un nombre para el archivo: '); 
	readln(arch_fisico); 
	Assign (arch, arch_fisico); 
end;
procedure importar_novelas(var arch: archivo_novelas; var txt: Text; var arch_fisico: string); 
var 
	novel:novela;
begin 
	Assign (txt, 'novelas.txt'); 
	reset (txt);
	crearBinario(arch_fisico, arch); 
	rewrite(arch); 
	while (not eof(txt)) do begin 
		with novel do begin 
			readln(txt, cod, precio,genero); 
			readln(txt,nombre);
		end; 
		write(arch, novel); 
	end; 
	close(txt); 
	close(arch); 
end; 


procedure leerNovela(var n: novela); 
begin 
	write(' codigo: '); 
	readln(n.cod); 
	if (n. cod <> 1) then begin 
		write(' nombre: '); 
		readln(n.nombre); 
		write(' precio: '); 
		readln(n.precio); 
		write(' genero: '); 
		readln(n.genero); 
	end; 
end; 

procedure agregarNovela(var arch: archivo_novelas); 
var 
	novel: novela; 
begin 
	reset(arch); 
	leerNovela(novel); 
	Seek(arch, fileSize(arch)); 
	write(arch, novel); 
	close(arch); 
end; 

procedure buscar_novela(cod: integer; var arch: archivo_novelas; var pos: integer); 
var 
	novel: novela;  
	encontre: boolean; 
begin 
	reset (arch); 
	encontre:= false; 
	while (not eof(arch))and (not encontre) do begin 
		read(arch, novel); 
		if (novel.cod= cod) then begin 
			encontre:= true; 
			pos:= filePos(arch)-1; 
		end; 
	end; 
end; 

procedure modificar_novela(var arch: archivo_novelas); 
var 
	cod:integer; 
	pos:integer;
	novel:novela;  
begin 
	write('ingrese el codigo de la novela a modificar: '); 
	readln(cod); 
	pos:=-1; 
	buscar_novela(cod, arch, pos);
	if (pos <>-1) then begin
		Seek(arch, pos); 
		read(arch, novel);
		leerNovela(novel); 
		Seek(arch, pos); 
		write(arch, novel); 
	end
	else
		writeln(' no se encontro la novela buscada: '); 
	close(arch); 
end; 


procedure exportarAtxt(var arch: archivo_novelas); 
var 
	txt: Text;
	novel: novela; 
begin 
	Assign (txt, 'novelas.txt'); 
	rewrite(txt); 
	reset (arch); 
	while (not eof(arch)) do begin 
		read(arch, novel); 
		with novel do begin 
			writeln(txt, cod, ' ', precio, ' ', genero); 
			writeln(txt, nombre); 
		end; 
	end; 
	close(txt); 
	close(arch); 
end; 

{programa principal}
var
	arch:archivo_novelas; 
	arch_fisico:string;
	txt:Text;
	op: integer; 
	
begin
	mostrarMenu(op); 
	while (op <> 0) do begin
		
		case op of
			1 : importar_novelas(arch, txt, arch_fisico);
			2 : agregarNovela(arch); 
			3 : modificar_novela(arch);  
			4 : exportarAtxt(arch)
		end; 	
		mostrarMenu(op); 
	end;
end.

