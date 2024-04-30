{
Se dispone de un archivo con información de los alumnos de la Facultad de Informática. Por
cada alumno se dispone de su código de alumno, apellido, nombre, cantidad de materias
(cursadas) aprobadas sin final y cantidad de materias con final aprobado. Además, se tiene
un archivo detalle con el código de alumno e información correspondiente a una materia
(esta información indica si aprobó la cursada o aprobó el final).
Todos los archivos están ordenados por código de alumno y en el archivo detalle puede
haber 0, 1 ó más registros por cada alumno del archivo maestro. Se pide realizar un
programa con opciones para

a. Actualizar el archivo maestro de la siguiente manera:
i.Si aprobó el final se incrementa en uno la cantidad de materias con final aprobado,
y se decrementa en uno la cantidad de materias sin final aprobado.
ii.Si aprobó la cursada se incrementa en uno la cantidad de materias aprobadas sin
final.
b. Listar en un archivo de texto aquellos alumnos que tengan más materias con finales
aprobados que materias sin finales aprobados. Teniendo en cuenta que este listado
es un reporte de salida (no se usa con fines de carga), debe informar todos los
campos de cada alumno en una sola línea del archivo de texto.
NOTA: Para la actualización del inciso a) los archivos deben ser recorridos sólo una vez.
* 
}
program ejercicio2.pas; 

const 
	valor_alto= 9999; 

type 
	alumno = record
		codigo: integer; 
		apellido: string; 
		nombre: string;
		cursadas_aprobadas: integer; 
		finales_aprobados :integer; 
	end; 
	det_materia= record
		codigo: integer;
		finalA: integer; 
		cursadaA: integer; 
	end;
	
	archivo_alumnos= file of alumno; 
	detalle_materias= file of det_materia; 
	
procedure leerAlumno(var a: alumno); 
begin 
	write('codigo: '); 
	readln(a.codigo); 
	if (a.codigo <> -1) then begin
		write('nombre: '); 
		readln (a.nombre); 
		write('apellido: '); 
		readln(a.apellido); 
		write('finales aprobados: '); 
		readln(a.finales_aprobados); 
		write('cursadas_aprobadas'); 
		readln(a.cursadas_aprobadas); 
	end ; 
end;
procedure leerMateria(var mat: det_materia); 
begin 
	write('codigo de alumno: '); 
	readln(mat.codigo); 
	if (mat.codigo <> -1) then begin  
		write('final aprobado (1= aprobado 0= desaprobado/no-rindio) :'); 
		readln(mat.finalA); 
		write('cursada aprobada (1= aprobado 0= desaprobado): '); 
		readln(mat.cursadaA); 
	end; 
end; 

procedure imprimirAlumno(alu : alumno); 
begin 
	writeln('cod ', alu.codigo, ' nombre y apellido: ', alu.nombre,' ', alu.apellido,' finales: ', alu.finales_aprobados, ' cursadas: ', alu.cursadas_aprobadas); 
	writeln('__________________________________________________________________________________________________________________________________________________');
end; 

procedure imprimirMateria(mat: det_materia); 
begin 
	writeln('codigo: ', mat.codigo, ' final: ', mat.finalA, ' cursada: ', mat.cursadaA); 
	writeln('_______________________________________________________________________');
end; 

procedure imprimirArchivoMaestro(var mae: archivo_alumnos); 
var 
	alu: alumno; 
begin 
	reset (mae); 
	while (not eof(mae)) do begin
		read(mae, alu); 
		imprimirAlumno(alu); 
	end; 
	close(mae); 
end; 
procedure imprimirArchivoDetalle(var det: detalle_materias); 
var 
	mat: det_materia; 
begin	
	reset(det); 
	while (not eof(det)) do begin
		read(det, mat); 
		imprimirMateria(mat); 
	end; 
	close(det); 
end; 
procedure crearArchivoAlumnos(var mae: archivo_alumnos); 
var
	alu: alumno; 
begin 
	Assign (mae, 'archivo_alumnos'); 
	rewrite(mae); 
	leerAlumno(alu);
	while (alu.codigo <> -1) do begin 
		write(mae, alu); 
		leerAlumno(alu); 
	end; 
	close(mae); 
end; 

procedure crearArchivoMaterias(var det: detalle_materias); 
var 
	m: det_materia; 
begin 
	Assign(det, 'archivo_materias'); 
	rewrite(det); 
	leerMateria(m);
	while (m.codigo <> -1) do begin 
		write(det, m); 
		leerMateria(m); 
	end; 
end; 

/// MOSTRAR MENU 
procedure mostrarMenu(var op : integer); 
begin 
	writeln(' SELECCIONE UNA OPCION : '); 
	writeln('                        1: ACTUALIZAR ARCHIVO DE ALUMNOS '); 
	writeln('                        2: EXPORTAR A ARCHIVO DE TEXTO ALUMNOS CON MAYOR CANTIDAD DE FINALES APROBADOS QUE DE CURSADAS');
	writeln('                        0: SALIR                                                                                      '); 
	
	writeln('_______________________________________________________________________________________________________________________'); 
	readln(op); 
end; 		


// ACTUALIZACION DEL MAESTRO
procedure leer( var det: detalle_materias; var m: det_materia); 
begin 
	if (not eof(det)) then begin
		read(det, m)
	end 
	else
		m.codigo:= valor_alto; 
end; 

procedure actualizarMaestro(var mae: archivo_alumnos; var det: detalle_materias);
var
	alu:alumno; 
	act:integer; 
	mat: det_materia; 
begin
	reset(mae); 
	reset(det);
	leer(det, mat); 
	while (mat.codigo<> valor_alto) do begin 
		act:= mat.codigo; 
		read(mae, alu); 
		while (mat.codigo <> act) do 
			read(mae, alu); 
		while (alu.codigo= mat.codigo) do begin
			writeln('actualizandoo...');
			if (mat.finalA= 1) then begin 
				alu.finales_aprobados:= alu.finales_aprobados+1; 
				alu.cursadas_aprobadas:= alu.cursadas_aprobadas -1; 
			end
			else
				if (mat.cursadaA = 1) then
					alu.cursadas_aprobadas:= alu.cursadas_aprobadas+ 1; 
					
			leer(det, mat); 
		end; 
		seek(mae, filepos(mae)-1);
		write(mae, alu); 
	end;
	close (mae);
	close(det); 
end; 
//    EXPORTAR A TXT 
function cumpleCondicion(alu: alumno): boolean; 
begin 
	cumpleCondicion:= (alu.finales_aprobados> alu.cursadas_aprobadas);
end;
procedure exportarAtxt(var mae: archivo_alumnos; var txt: Text); 
var
	alu: alumno; 
begin
	Assign (txt, 'alumnosConMasFinales.txt');
	rewrite(txt); 
	reset(mae); 
	while (not eof(mae) ) do begin 
		read(mae, alu); 
		if (cumpleCondicion(alu))then 
			with alu do 
				 writeln(txt, 'CODIGO: ',codigo,' | APELLIDO: ',apellido,' | NOMBRE: ',nombre,' | FINALES: ',finales_aprobados,' | CURSADAS: ', cursadas_aprobadas);
	end; 
	close(txt);
	close(mae); 
end; 

{programa principal}
var
	mae: archivo_alumnos; 
	det: detalle_materias; 
	txt: Text;
	op: integer; 
begin 
	//crearArchivoAlumnos(mae); 
	//crearArchivoMaterias(det); 
	Assign (mae, 'archivo_alumnos'); 
	Assign (det, 'archivo_materias'); 
	
	writeln('               ARCHIVO MAESTRO                            '); 
	imprimirArchivoMaestro(mae); 
	writeln('               ARCHIVO DETALLE                          '); 
	imprimirArchivoDetalle (det); 
	mostrarMenu(op); 
	while (op <> 0) do begin
		case op of 
			1 : begin
				actualizarMaestro(mae, det);
				writeln('maestro actualizado'); 
				imprimirArchivoMaestro(mae); 
				end; 
			2 : begin
				exportarAtxt(mae, txt); 
				writeln('datos exportados'); 
				end; 
		end; 
		mostrarMenu(op); 
	end;
end.
	
