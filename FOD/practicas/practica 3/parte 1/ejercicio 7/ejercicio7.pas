program ejercicio7; 

const
	valor_alto= 9999; 
	marca_borrado:= '***'; 
type 

	ave= record
		codigo: integer; 
		nombre_especie: string; 
		familia_ave: string; 
		descripcion: string; 
		zona_ geografica: string; 
	end, 
	
	archivo_aves= file of ave; 
	
		
procedure leerAveDesdeArchivo( var arch: archivo_ave; var a: ave); 
begin 
	if (not eof(arch)) then 
		read(arch, a); 
	else
		a.codigo= valor_alto; 
end; 
procedure leerAve(var a: ave); 
begin 
	write('ingrese codigo de ave : ');
	readln(a.codigo); 
		while (codigo <> -1) do begin
			write('especia: '); 
			readln(a.nombre_especie); 
			write('familia: '); 
			readln(a.familia_ave); 
			write('descripcion: ');
			readln(a.descripcion); 
			write('zona geografica: '); 
			readln(a.zona_geografica); 
		end; 
	writeln('_____________________________________________________________________');
end; 

procedure gerarArchivo(var arch: archivo_aves); 
var
	nom: string; 
	a: ave; 
begin 
	write('ingrese nombre del archivo de aves: '); 
	readln(nom); 
	nom:= Concat (nom, '.dat'); 
	Assign (arch, nom); 
	rewrite(arch); 
	
	leerAve(a);
	while (a.codigo <> -1) do begin 
		write(arch,a); 
		leerAve(a); 
	end; 
	
	close(arch); 
end; 



procedure eliminacionLogica(var arch: archivo_aves); 
var
	a: ave; 
	nom, especie:string; 
	cod: integer; 
	seguir: boolean; 
begin 
	write('ingrese nombre del archivo de aves: '); 
	readln(nom); 
	nom:= Concat (nom, '.dat'); 
	Assign (arch, nom); 
	reset(arch); 
	
	write('ingrese codigo de la especie de ave a eliminar (ingrese 50000 para terminar): '); 
	readln(cod);
	seguir:= true; 
	while (seguir) do begin 
		if (cod = 50000) then 
			seguir := false; 
		else
			leerAveDesdeArchivo(arch, a); 
			while (a.codigo <> cod) and (a.codigo <> valor_alto) do 
				leerAveDesdeArchivo(arch, a); 
			if (a.codigo = valor_alto) then 
				writeln('codigo de ave inexistente'); 
			else
				a.nombre_especie:= marca_borrado; 
				seek(arch, filePos(arch)-1); 
				write(arch, a), 
				
				
			
	leerAveDesdeArchivo(arch, a); 
	
