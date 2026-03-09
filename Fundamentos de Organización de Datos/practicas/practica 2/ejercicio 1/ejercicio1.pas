{
Una empresa posee un archivo con información de los ingresos percibidos por diferentes
empleados en concepto de comisión, de cada uno de ellos se conoce: código de empleado,
nombre y monto de la comisión. La información del archivo se encuentra ordenada por
código de empleado y cada empleado puede aparecer más de una vez en el archivo de
comisiones.
Realice un procedimiento que reciba el archivo anteriormente descripto y lo compacte. En
consecuencia, deberá generar un nuevo archivo en el cual, cada empleado aparezca una
única vez con el valor total de sus comisiones.
NOTA: No se conoce a priori la cantidad de empleados. Además, el archivo debe ser
recorrido una única vez 
*} 
program ejercicio1;
const 
	valor_alto=9999;
type 
	empleado= record
		codigo: integer; 
		nombre: string; 
		comision: real; 
	end;
	archivo_comisiones = file of empleado; 
	archivo_compactado= file of empleado; 
	
procedure leer(var
procedure leerEmpleado(var e: empleado)
begin 
	write('nombre: '); 
	readln(e.nombre); 
	if (e.nombre <> 'zzz') then begin 
		write('codigo: '); 
		readln(e.codigo);
		write('comision: '); 
		readln(e.comision);
		writeln('--------------------------------');
	end; 
end; 
procedure crearArchivoComisiones(var arch: archivo_comisiones); 
var 
	emp:empleado; 
begin 
	Assign(arch,'archivo_comisiones');
	rewrite(arch); 
	leerEmpleado(emp); 
	while (emp.nombre <> 'zzz') do begin 
		write(arch, emp); 
		leerEmpleado(emp); 
	end; 
	close (arch); 
end; 

procedure imprimirEmpleado(emp: empleado); 
begin 
	writeln(); 
	write('nombre: ', emp.nombre, 'codigo: ', emp.codigo, ' comision: 'emp.comision); 
	writeln(); 
end; 

procedure imprimirArchivoComisiones(var arch: archivo_comisiones); 
var 
	emp: empleado; 
begin 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		imprimirEmpleado(emp); 
	end; 
	close(arch); 
end; 

// compactacion
procedure leer(var arch: archivo_comisiones; var emp: empleado);
begin
    if not eof(arch) then
        read(arch,emp)
    else 
        emp.codigo := valor_alto;
end;
procedure compactar(var arch:archivo_comisiones; var archCompactado: archivo_compactado); 
var 
	emp, actual: empleado; 
	total: real; 
begin 
	Assign (archCompactado, 'archivo_comisiones_compactado'); 
	reset(arch); 
	rewrite(archCompactado); 
	
	leer(arch, emp); 
	while (emp.cod<> valor_alto) do begin
		emp:= actual; 
		total:=0; 
		while (emp.cod = actual.cod) do begin
			total:= total + emp.comision
			leer(arch, emp); 
		end; 
		with act do begin
			write(archCompactado, cod, nom, total); 
		end; 
	end;
	close(arch);
	close(archCompactado); 
end; 
procedure imprimirArchivoCompactado(var arch: archivo_compactado); 
var 
	emp: empleado; 
begin 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		imprimirEmpleado(emp); 
	end; 
	close(arch); 
end; 
{programa principal} 
var 
	arch: archivo_comisiones; 
	archCompactado: archivo_compactado; 
begin 

	crearArchivoComisiones(arch); 
	writeln('creando el archivo de comisiones...'); 
	imprimirArchivoComisiones(arch); 
	writeln(); 
	writeln('compactando...')
	compactar(arch, archCompactado); 
	imprimirArchivoCompactado(archCompactado); 
end.
	
	
