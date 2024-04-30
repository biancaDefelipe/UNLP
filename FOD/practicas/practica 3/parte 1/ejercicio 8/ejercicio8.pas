{
* 
Se cuenta con un archivo con información de las diferentes distribuciones de linux
existentes. De cada distribución se conoce: nombre, año de lanzamiento, número de
versión del kernel, cantidad de desarrolladores y descripción. El nombre de las
distribuciones no puede repetirse. Este archivo debe ser mantenido realizando bajas
lógicas y utilizando la técnica de reutilización de espacio libre llamada lista invertida
*Escriba la definición de las estructuras de datos necesarias y los siguientes
procedimientos:
a. ExisteDistribucion: módulo que recibe por parámetro un nombre y devuelve
verdadero si la distribución existe en el archivo o falso en caso contrario.
b. AltaDistribución: módulo que lee por teclado los datos de una nueva
distribución y la agrega al archivo reutilizando espacio disponible en caso
de que exista. (El control de unicidad lo debe realizar utilizando el módulo
anterior). En caso de que la distribución que se quiere agregar ya exista se
debe informar “ya existe la distribución”.
c. BajaDistribución: módulo que da de baja lógicamente una distribución 
cuyo nombre se lee por teclado. Para marcar una distribución como
borrada se debe utilizar el campo cantidad de desarrolladores para
mantener actualizada la lista invertida. Para verificar que la distribución a
borrar exista debe utilizar el módulo ExisteDistribucion. En caso de no existir
se debe informar “Distribución no existente”.
* 
*}
program ejercicio8; 


const
	valor_alto= 'zzz';

type 
	distribucion_linux= record
		nombre: string; 
		anio_lanzamiento: integer; 
		version_kernel: real; 
		cant_desarrolladores: integer; 
		descripcion: string[30]; 
	end; 
	
	archivo_maestro= file of distribucion_linux;
	
	
procedure leerDistribucion(var d: distribucion_linux); 
begin 
	write('ingrese nombre de la distribucion: '); 
	readln(d.nombre); 
	if (d.nombre <> 'zzz') then begin 
		write('ingrese anio de lanzamiento: '); 
		readln(d.anio_lanzamiento); 
		write('ingrese version de kernel: '); 
		readln(d.version_kernel); 
		write('ingrese cantidad de desarrolladores: '); 
		readln(d.cant_desarrolladores); 
		write('ingrese descripcion: '); 
		readln(d.descripcion); 
	end;
	writeln('_____________________________________________________________');
end;

procedure leerDistribucionDesdeArchivo(var arch:archivo_maestro; var d:distribucion_linux);
begin
	if (not eof(arch))then 
		read(arch,d)
	else
		d.nombre:= 'zzz'; 
end; 
	

procedure generarArchivoMaestro (var arch: archivo_maestro); 
var
	nom: string; 
	d:distribucion_linux; 
begin 
	write('ingrese nombre del archivo: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	
	Assign(arch, nom); 
	rewrite(arch); 
	d.cant_desarrolladores:= 0; 
	write(arch, d); 
	leerDistribucion(d);
	while (d.nombre <> valor_alto) do begin 
		write(arch, d); 
		leerDistribucion(d);
	end; 
	close(arch); 
end; 

//a. ExisteDistribucion: módulo que recibe por parámetro un nombre y devuelve
//verdadero si la distribución existe en el archivo o falso en caso contrario.

function existeDistribucion(var arch: archivo_maestro; nombre:string): boolean;
var 
	nom:string; 
	d: distribucion_linux; 
	existe: boolean; 
begin 
	write('ingrese nombre del archivo: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	
	Assign(arch, nom); 
	reset(arch);
	leerDistribucionDesdeArchivo(arch, d); 
	leerDistribucionDesdeArchivo(arch,d); 
	existe:= false; 
	while (d.nombre <> 'zzz') and (d.nombre <> nombre)do 
		leerDistribucionDesdeArchivo(arch, d);
	if (d.nombre= nombre) then
		existe:= true; 	

	writeln('termine');
	existeDistribucion:= existe; 
end; 
//b. AltaDistribución: módulo que lee por teclado los datos de una nueva
//distribución y la agrega al archivo reutilizando espacio disponible en caso
//de que exista. (El control de unicidad lo debe realizar utilizando el módulo
//anterior). En caso de que la distribución que se quiere agregar ya exista se
//debe informar “ya existe la distribución”.

procedure altaDistribucion (var arch: archivo_maestro); 
var 
	d, aux: distribucion_linux; 
	pos, posLibre: integer; 
begin 
	writeln('AGREGAR DISTRIBUCION: '); 
	leerDistribucion(d);
	if (existeDistribucion(arch, d.nombre)) then 
		writeln('ya existe la distribución')
	else begin
		writeln('no existe, la agrego');
		reset (arch); 
		leerDistribucionDesdeArchivo(arch, aux); 
		if (aux.cant_desarrolladores> 0) then begin
		    seek(arch, aux.cant_desarrolladores *-1); 
		    posLibre:= filepos(arch);  
			
			read(arch, aux); 
			seek(arch, filepos(arch)-1); 
			write(arch, d); 
			seek(arch, 0); 
			write(arch, aux); 	
		end
		else begin 
			seek(arch,filesize(arch));
			write(arch, d); 
		end; 
	end; 
	close(arch); 
end; 

//c. BajaDistribución: módulo que da de baja lógicamente una distribución 
//cuyo nombre se lee por teclado. Para marcar una distribución como
//borrada se debe utilizar el campo cantidad de desarrolladores para
//mantener actualizada la lista invertida. Para verificar que la distribución a
//borrar exista debe utilizar el módulo ExisteDistribucion. En caso de no existir
//se debe informar “Distribución no existente”.
procedure bajaFisica(var arch: archivo_maestro; nombre: string); 
var
	d, aux: distribucion_linux; 
	pos: integer; 
begin
	reset(arch);
	leerDistribucionDesdeArchivo(arch,aux); 
	pos:= aux.cant_desarrolladores; 
	
	while (aux.nombre <> valor_alto) and (aux.nombre <> nombre) do 
		leerDistribucionDesdeArchivo(arch, aux); 
	if (aux.nombre= nombre) then begin 
		aux.cant_desarrolladores:= pos; // guardo en el aux la posicion que tenia la cabecera ( ya es negativa)
		pos:= (filePos(arch )-1) * -1;  //guardo la posicion en donde esta el registro que quiero eliminar
		seek(arch, filePos(arch)-1);    //retrocedo un lugar
		write(arch, aux);               // guardo la cabecera vieja en la posicion que elimino 
		seek(arch, 0);               // me posiciono en la cabecera
		aux.cant_desarrolladores:=pos; 
		write(arch, aux);
	end;
end; 
	
procedure bajaDistribucion(var arch: archivo_maestro); 
var 
	posLibre: integer; 
	aux, cabecera: distribucion_linux; 
	nombre:string; 
begin 
	write('ingrese el nombre de la distribucion que desea eliminar: '); 
	readln(nombre); 
	
	if (existeDistribucion(arch, nombre) )then 
		bajaFisica(arch, nombre)		
	else
		writeln('distribucion no existente');
	close (arch); 
end; 

procedure exportarMaestro(var arch: archivo_maestro); 
var
	txt: text; 
	d:distribucion_linux; 
	nomFisico, nom:string;  
begin 
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	reset(arch); 
	Assign (txt, 'distribuciones linux.txt'); 
	rewrite(txt); 
	
	leerDistribucionDesdeArchivo(arch, d);
	leerDistribucionDesdeArchivo(arch, d); 
	while (d.nombre <> valor_alto) do begin 
		if (d.cant_desarrolladores >0) then begin 
			with d do begin
		
				writeln(txt, '---------------------------------------------------------------------------');
				
				writeln(txt, '||anio de lanzamiento  ', anio_lanzamiento, ' || version de kernel ', version_kernel: 2:2,  ' || cantidad de desarrolladores', cant_desarrolladores); 
				writeln(txt, '|| nombre ', nombre,'|| descripcion', descripcion ); 

				writeln(txt, '---------------------------------------------------------------------------'); 
			end; 
		end; 
		leerDistribucionDesdeArchivo(arch, d); 

	end; 
	close(txt);
	close (arch); 
end; 

{programa principal}
var 
	arch: archivo_maestro; 

begin 
//	generarArchivoMaestro(arch); 
//	writeln('archivo maestro creado exitosamente');

		
	altaDistribucion(arch); 
	writeln('distribucion agregada ');
	bajaDistribucion(arch); 
	writeln('distribucion eliminada'); 
	
	exportarMaestro(arch); 
	
end.
END.
