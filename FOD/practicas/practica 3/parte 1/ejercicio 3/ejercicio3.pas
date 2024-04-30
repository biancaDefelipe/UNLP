
program ejercicio3;
const 
	valor_alto= 9999; 
type 
	novela= record 
		codigo: integer; 
		genero: string; 
		nombre: string;
		duracion: integer; 
		director: string; 
		precio: real; 
	end; 
	archivo_novelas= file of novela; 
	
procedure leerNovelaDesdeArchivo(var arch: archivo_novelas; var n : novela);
begin 
	if (not eof(arch)) then 
		read(arch, n)
	else	
		n.codigo:=valor_alto; 
end; 

procedure leerNovela (var n: novela); 
begin
	write(' ingrese codigo de novela: '); 
	readln(n.codigo); 
	
	if (n.codigo <> -1) then begin 
		write(' ingrese nombre novela: '); 
		readln(n.nombre); 
		write(' ingrese genero de novela: '); 
		readln(n.genero); 
		write(' ingrese duracion: '); 
		readln(n.duracion); 
		write(' ingrese director: '); 
		readln(n.director); 
		write(' precio '); 
		readln(n.precio);
	end; 
end;


procedure generarArchivo(var arch: archivo_novelas; var nomFisico: string ); 
var
	n: novela; 
	nom: string; 
begin
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	rewrite(arch); 
	//registro de cabecera
	n.codigo:= 0; 
	write(arch, n);
	 
	leerNovela(n); 
	while (n.codigo <> -1) do begin 
		write(arch, n); 
		leerNovela(n);
	end; 
	close(arch); 
end; 
procedure agregarNovela(var arch: archivo_novelas); 
var
	nueva, aux: novela; 
	pos: integer; 
	nomFisico, nom: string; 
begin 
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	reset (arch); 
	leerNovelaDesdeArchivo(arch, aux); 
	leerNovela(nueva); 
	if (aux.codigo <> valor_alto) and (aux.codigo <> 0) then begin
		//me ubico en la posicion que indica la cabecera
		seek(arch, aux.codigo* -1); 
		//leo la novela de la cabecera
		read(arch, aux); 
		//retrocedo 1 vez pq se me movio el puntero
		seek(arch, filePos(arch) -1); 
		//escribo la nueva novela en la posicion q decia la cabecera
		write(arch, nueva); 
		//me ubico en la cabecera
		seek (arch, 0); 
		write(arch, aux); 
	 end
	 else 
		if (aux.codigo = 0)then begin
			seek(arch, fileSize (arcH)); 
			write(arch, nueva);
		end; 
	close(arch); 
	end; 
	
function buscarNovela(var arch: archivo_novelas; cod: integer): integer;
var 
	n: novela; 
begin
	leerNovelaDesdeArchivo(arch, n); 
	while ((n.codigo <> valor_alto) and (n.codigo <> cod)) do 
		leerNovelaDesdeArchivo(arch, n); 
	if (n.codigo = cod) then 
		buscarNovela:= filePos(arch)-1
	else
		buscarNovela:= -1
end; 
procedure editarNovela (var arch: archivo_novelas); 
var 
	n: novela; 
	cod, pos: integer; 
	nomFisico, nom: string; 
begin
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	write('ingrese el codigo de la novela que desea editar : '); 
	readln(cod); 
	reset(arch); 
	pos:= buscarNovela(arch, cod); 
	if (cod <> -1) then begin 
		write(' nombre: '); 
		readln(n.nombre); 
		write(' genero: '); 
		readln(n.genero); 
		write(' duracion: '); 
		readln(n.duracion); 
		write(' director: '); 
		readln(n.director); 
		write(' precio: '); 
		readln(n.precio);  
		
		seek(arch, pos); 
		write(arch, n); 
	end
	else
		writeln(' no se encontro una novela con el codigo ingresado '); 
	close (arch); 
end; 
	 

procedure eliminarNovela(var arch: archivo_novelas); 
var 
	pos, cod: integer; 	
	aux, n: novela; 
	nomFisico, nom: string; 
begin
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:=concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	write('ingrese el codigo de la novela que desea eliminar : '); 
	readln(cod); 
	reset(arch); 
	leerNovelaDesdeArchivo(arch, aux); 
	pos:= buscarNovela(arch, cod); 
	if (pos <> -1) then begin 
		//me fuardo novela a borrar en n
		seek(arch, pos); 
		read(arch,n); 
	
		//escribo antiguo registro cabecera en la pos que elimine
		seek(arch, filePos(arch) -1); 
		write(arch, aux); 
		
		//copsio en la cabecera
		n.codigo:= pos* -1; 
		seek(arch, 0); 
		write(arch, n); 
	end
	else
		writeln(' no se encontro una novela con el codigo ingresado'); 
	close(arch); 
end; 

procedure exportarTodas(var arch: archivo_novelas); 
var
	txt: text; 
	n: novela; 
	nomFisico, nom:string;  
begin 
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	reset(arch); 
	Assign (txt, 'novelas.txt'); 
	rewrite(txt); 
	
	leerNovelaDesdeArchivo(arch, n); 
	leerNovelaDesdeArchivo(arch, n);
	while (n.codigo <> valor_alto) do begin 
		with n do begin
		
			writeln('---------------------------------------------------------------------------');
			writeln(txt, 'codigo: ', codigo, ' duracion: ', duracion, ' precio: ', precio:2:2); 

			writeln(txt, 'nombre: ',  nombre,' genero: ', genero, ' director: ', director); 

			writeln('---------------------------------------------------------------------------'); 
		end; 
		leerNovelaDesdeArchivo(arch, n); 
	end; 
	close(txt);
	close (arch); 
end; 

	
		
	

		
procedure mostrarMenu (var op: integer); 
begin 
	writeln(' SELECCIONE UNA OPCION'); 
	writeln(' 1: crear archivo binario '); 
	writeln(' 2: agregar novela  '); 
	writeln(' 3: editar datos de una novela '); 
	writeln(' 4: eliminar novela  '); 
	writeln(' 5: exportar todas las novelas '); 
	
	writeln(' 0: SALIR  '); 
	readln(op); 
end; 


var
	arch: archivo_novelas; 
	op: integer; 
	nomFisico: string; 
begin
	
	mostrarMenu(op); 
	while (op <> 0) do begin
		case op of 
			1: generarArchivo(arch, nomFisico); 
			2: agregarNovela(arch); 
			3: editarNovela(arch); 
			4: eliminarNovela(arch); 
			5: exportarTodas(arch); 


		end; 
		mostrarMenu(op); 
	end; 
	
END.
