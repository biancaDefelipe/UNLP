program ejercicio4; 
const
	valor_alto=9999; 
type
	reg_flor = record
		nombre: String[45];
		codigo:integer;
	end;
	tArchFlores = file of reg_flor;

procedure leerFlor (var f: reg_flor); 
begin
	write('ingrese codigo de flor: '); 
	readln(f.codigo); 
	if (f.codigo <>-1) then begin 
		write('ingrese nombre de flor: '); 
		readln(f.nombre); 
	end; 
end; 

procedure leerFlorDesdeArchivo (var arch: tArchFlores; var f: reg_flor); 
begin
	if (not eof(arch)) then 
		read(arch, f)
	else
		f.codigo:= valor_alto; 
end; 

procedure generarArchivo(var arch: tArchFlores); 
var
	nom: string; 
	f: reg_flor; 
begin 
	write('ingrese nombre del archivo de flores: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	
	Assign(arch, nom); 
	rewrite(arch); 
	
	f.codigo:=0; 
	f.nombre:= ''; 
	write(arch, f);
	leerFlor(f); 
	while (f.codigo <> -1) do begin 
		write(arch, f); 
		leerFlor(f); 
	end; 
	close(arch); 
end; 

procedure agregarFlor (var a: tArchFlores ; nombre: string; codigo:integer);
var 
	f, aux: reg_flor; 
	nomFisico,nom: string;
begin
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (a, nom); 
	reset (a); 
	f.codigo:= codigo; 
	f.nombre:= nombre; 
	
	reset(a); 
	read(a, aux); 
	if (aux.codigo = 0) then begin
		Seek(a, fileSize(a)); 
		write(a, f); 
	end
	else begin
		seek(a, aux.codigo* -1);
		read(a, aux); 
		seek(a, filePos(a) -1);
		write(a, f); 
		seek (a, 0); 
		write(a, aux); 
	end; 
	close(a); 
end; 

function buscarFlor(var a : tArchFlores; codigo: integer): integer; 
var
	f: reg_flor; 
begin 

	leerFlorDesdeArchivo(a, f); 
	while (f.codigo <> valor_alto) and(f.codigo <> codigo) do 
		leerFlorDesdeArchivo(a, f); 
	if (f.codigo= codigo) then 
		buscarFlor:= filepos(a)-1
	else
		buscarFlor:= -1; 
end; 

procedure eliminarFlor(var a: tArchFlores );
var 
	f, aux: reg_flor; 
	nomFisico, nom: string; 
	codigo, pos: integer; 
begin
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (a, nom); 
	reset (a);
	leerFlorDesdeArchivo(a, aux); 
	
	write('ingrese codigo de la flor que desea eliminar: '); 
	readln(codigo); 
	pos:= buscarFlor(a, codigo) ;
	if (pos <> -1) then begin 

		//me fuardo novela a borrar en n
		seek(a, pos); 
		read(a,f); 
	
		//escribo antiguo registro cabecera en la pos que elimine
		seek(a, filePos(a) -1); 
		write(a, aux); 
		
		//copsio en la cabecera
		f.codigo:= pos* -1; 
		seek(a, 0); 
		write(a, f); 
	end
	else
		writeln('no se encontro una flor con el codigo ingresado'); 

	close(a); 
end; 
procedure imprimirFlor(f: reg_flor); 
begin 
	writeln('                   nombre: ', f.nombre      ); 
	writeln('                   codigo: ', f.codigo      ); 
	writeln(); 
end; 
procedure imprimirFlores(var a: tArchFlores); 
var 
	f: reg_flor; 
	nomFisico,nom: string;
begin
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (a, nom); 
	reset (a);
	leerFlorDesdeArchivo(a, f); 
	while (f.codigo <> valor_alto) do begin
		if (f.codigo > 0) then 
			imprimirFlor(f); 
		leerFlorDesdeArchivo(a,f); 
	end; 
	close (a); 
end; 

procedure mostrarMenu(var op: integer); 
begin 
	writeln('               SELECCIONE UNA OPCION: '); 
	writeln(' 1: crear un archivo de flores'); 
	writeln(' 2: agregar una flor a un archivo existente'); 
	writeln(' 3: eliminar una flor de un archivo existente'); 
	writeln(' 4: listar flores de un archivo'); 
	writeln(' 0: SALIR'); 
	readln(op); 
	writeln(); 
end; 
	
{programa principal}
var 
	a: tArchFlores; 
	op, cod: integer; 
	 nom:string ; 
begin 
	mostrarMenu(op); 
	while (op <> 0) do begin 
		case op of 
			1: generarArchivo(a); 
			2: begin
				write('nombre: '); 
				readln(nom); 
				write('codigo: '); 
				readln(cod); 
				agregarFlor(a, nom, cod);
				end; 
			3: eliminarFlor(a); 
			4: imprimirFlores(a) ; 
		end; 
	mostrarMenu(op); 
	end; 
end.
