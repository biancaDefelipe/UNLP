{
4. Agregar al menú del programa del ejercicio 3, opciones para:
a. Añadir uno o más empleados al final del archivo con sus datos ingresados por
teclado. Tener en cuenta que no se debe agregar al archivo un empleado con
un número de empleado ya registrado (control de unicidad).
b. Modificar la edad de un empleado dado.
c. Exportar el contenido del archivo a un archivo de texto llamado
“todos_empleados.txt”.
d. Exportar a un archivo de texto llamado: “faltaDNIEmpleado.txt”, los empleados
que no tengan cargado el DNI (DNI en 00).
NOTA: Las búsquedas deben realizarse por número de empleado.

* }


program ejercicio4; 



type 
	empleado= record
		num: integer; 
		apellido: string; 
		nombre: string; 
		edad: integer;
		dni: integer; 
	end; 
	archivo_empleados= file of empleado; 
	
	lista= ^nodo; 
	nodo= record
		dato: integer; 
		sig: lista; 
	end; 

procedure mostrarMenu(var op: integer); 
begin 
	writeln('  							                                                        ');
	writeln('seleccione una opcion:                                   '); 
	writeln('                     1 | Generar un archivo de empleados '); 
	writeln('                     2 | Listar datos de empleados con un nombre/apellido deseado '); 
	writeln('                     3 | Listar todos los empleados '); 
	writeln('                     4 | Listar empleados proximos a jubilarse '); 
	writeln('                     5 | Agregar un nuevo empleado  '); 
	writeln('                     6 | Modificar la edad de un empleado '); 
	writeln('                     7 | Exportar a un archivo de texto todos los empleados  '); 
	writeln('                     8 | Exportar a un archivo de texto aquellos empleados sin dni ');
	writeln('                     0 | SALIR');  
	readln(op); 
end; 

procedure leerEmpleado(var emp: empleado); 
begin 
	write('apellido: '); 
	readln(emp.apellido); 
	if (emp.apellido <> 'fin')then begin
		write('nombre: '); 
		readln(emp.nombre);
		write('edad: '); 
		readln(emp.edad);
		write('numero de empleado: '); 
		readln(emp.num); 
		 
		write('dni: '); 
		readln(emp.dni);
	end; 
end; 
procedure imprimirEmpleado(emp: empleado); 
begin
	writeln('		nombre: ', emp.nombre); 
	writeln('		apellido ', emp.apellido);
	writeln('		edad: ', emp.edad);
	writeln('		numero de empleado: ', emp.num);
	writeln('		dni: ', emp.dni); 
	writeln('---------------------------------------'); 
end; 
function proximoAJubilarse(emp:empleado): boolean; 
begin
	proximoAJubilarse:= emp.edad > 70 ; 
end; 
procedure listarEmpleadosApNom(var arch: archivo_empleados);
var
	emp: empleado; 
	apnom: string; 
begin 
	write('ingrese el apellido/ nombre buscado'); 
	readln(apnom); 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		if ((emp.nombre = apnom) or (emp.apellido= apnom))then 
			imprimirEmpleado(emp); 
	end; 
	close(arch); 
end; 

procedure listarTodosLosEmpleados(var arch: archivo_empleados); 
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

procedure listarProximosAJubilarse(var arch: archivo_empleados); 
var 
	emp: empleado; 
begin 
	reset(arch); 
	while (not eof(arch)) do begin 
		read(arch, emp); 
		if (proximoAJubilarse(emp) )then 
			imprimirEmpleado(emp); 
	end;
	close(arch); 
end; 
procedure crearArchivoEmpleados(var arch: archivo_empleados; var arch_fisico: string); 
var
	emp: empleado; 
begin 
	write('ingrese el nombre del archivo: '); 
	readln(arch_fisico); 
	Assign (arch, arch_fisico); 	
	leerEmpleado(emp); 
	rewrite(arch); 
	while (emp.apellido <> 'fin') do begin 
		write(arch, emp); 
		leerEmpleado(emp); 
	end; 
	close(arch); 
end; 
procedure insertarOrdenado(var l: lista; num: integer); 
var
	nue, act, ant: lista; 
begin 
	new(nue); 
	nue^.dato:= num;  
	nue^.sig:= nil; 

	act:= l; 
	ant:= l; 
	while (act <> nil) and (act^.dato < num) do begin 
		ant:= act; 
		act:=act^.sig; 
	end; 
	if (act= ant) then 
		l:= nue
	else 
		ant^.sig:= nue; 
	nue^.sig:= act;
end; 
function estaRegistrado(num: integer; l: lista): boolean; 
begin 
	if (l<> nil) then begin 
		if (l^.dato= num) then 
			estaRegistrado:= true
		else
			estaRegistrado:= estaRegistrado( num, l^.sig); 
	end; 
	estaRegistrado:= false; 
	
end; 
procedure agregarEmpleado(var arch: archivo_empleados; var l: lista); 
var
	emp: empleado; 
begin 
	leerEmpleado(emp); 
	reset (arch); 
	if (not estaRegistrado(emp.num, l)) then begin
		write(arch, emp); 
		insertarOrdenado(l, emp.num); 
		writeln(' empleado registrado '); 
	end
	else
		writeln(' el empleado ya se encuentra registrado'); 
	close (arch); 
end; 

procedure modificarEdad(var arch: archivo_empleados; l: lista); 
var 
	num: integer; 
	emp: empleado; 

begin 
	write(' numero de empleado buscado: '); 
	readln(num); 
	reset(arch); 
	if (estaRegistrado(num, l)) then begin
		while (not eof(arch)) do 
			read(arch, emp);  
		
		write('ingrese la edad del empleado ', num, ': '); 
		readln(emp.edad); 
		seek(arch, filePos(arch )-1); 
		write(arch, emp); 
	end
	else
		writeln('el empleado no se encuentra registrado');
	close(arch); 
end; 
procedure exportarAtxt(var arch: archivo_empleados; var txt: Text); 
var 
	emp: empleado; 
begin 
	Assign(txt, 'todos_empleados.txt'); 
	reset (arch); 
	rewrite(txt); 
	
	while (not eof (arch)) do begin 
		read(arch, emp);
		with emp do
			writeln(txt,' | ', num, ' | ', apellido, ' | ', nombre, ' |	', dni, ' |	', edad, '|	'); 
	end;
	writeln(' datos exportados '); 
	close(arch); 
	close(txt);
end; 

procedure exportarEmpleadosSinDNI(var arch: archivo_empleados; var txt2: Text); 
var 
	emp: empleado; 
begin 
	Assign(txt2, 'faltaDNIEmpleado.txt'); 
	reset (arch); 
	rewrite(txt2);
	while (not eof (arch)) do begin 
		read(arch, emp);
		if (emp.dni = 00) then 
			with emp do
				writeln(txt2,'	|', num, '	|', apellido, '|	', nombre, '|	', dni, '|	', edad, '|	'); 
	end;
	writeln(' datos exportados '); 
	close(arch); 
	close(txt2);
end; 
var 
	arch: archivo_empleados; 
	arch_fisico: string; 
	op: integer; 
	l: lista;
	arch_txt, arch_txt2: Text; 
begin 
	
	mostrarMenu(op); 
	l:= nil; 
	while (op <> 0) do begin 
		case op of
			1 : crearArchivoEmpleados(arch, arch_fisico); 
			2 : listarEmpleadosApNom(arch); 
			3 : listarTodosLosEmpleados(arch); 
			4 : listarProximosAJubilarse(arch);
			5 : agregarEmpleado(arch, l); 
			6 : modificarEdad (arch, l); 
			7 : exportarAtxt (arch, arch_txt); 
			8 : exportarEmpleadosSinDNI(arch, arch_txt2); 
		end; 	
		mostrarMenu(op); 
	end; 
end.
	
	
	
