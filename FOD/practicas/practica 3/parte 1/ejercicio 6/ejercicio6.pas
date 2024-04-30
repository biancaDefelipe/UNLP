program ejercicio6;
const 
	valor_alto=9999;
	
type
	prenda= record
		cod_prenda: integer; 
		descripcion: string; 
		colores: string; 
		tipo_prenda: string;
		stock: integer; 
		precio_unitario: real; 
	end;
	
	archivo_maestro= file of prenda;
	archivo_detalle= file of integer; 
	

procedure leerPrenda (var p: prenda); 
begin
	write('ingrese codigo de prenda: '); 
	readln(p.cod_prenda); 
	if (p.cod_prenda <>-1) then begin 
		write('ingrese descripcion de la prenda: '); 
		readln(p.descripcion); 
		write('ingrese colores de la prenda: '); 
		readln(p.colores);
		write('ingrese el tipo de la prenda: '); 
		readln(p.tipo_prenda);
		write('ingrese stock de la prenda: '); 
		readln(p.stock);
		write('ingrese precio unitario de la prenda: '); 
		readln(p.precio_unitario);
		
		writeln('___________________________________________________________');
	end; 
end; 
procedure leerPrendaDesdeMaestro (var arch: archivo_maestro; var p: prenda); 
begin
	if (not eof(arch)) then 
		read(arch, p)
	else
		p.cod_prenda:= valor_alto; 
end; 

procedure leerPrendaDesdeDetalle(var arch: archivo_detalle; var cod: integer); 
begin
	if (not eof(arch)) then 
		read(arch, cod)
	else
		cod:= valor_alto; 
end; 
	

procedure generarArchivoMaestro (var arch: archivo_maestro); 
var
	nom: string; 
	p:prenda; 
begin 
	write('ingrese nombre del archivo de prendas: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	
	Assign(arch, nom); 
	rewrite(arch); 
	
	leerPrenda(p); 
	while (p.cod_prenda <> -1) do begin 
		
		write(arch, p); 
		leerPrenda(p); 
	end; 
	close(arch); 
end; 

procedure generarArchivoDetalle(var arch: archivo_detalle); 
var 
	cod: integer; 
	nom:string;
begin
	write('ingrese nombre del archivo detalle: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	
	Assign(arch, nom); 
	rewrite(arch); 
	
	write('ingrese un codigo de prenda: '); 
	readln(cod); 
	while (cod <> -1)do begin
		write(arch, cod); 
		write('ingrese un codigo de prenda: '); 
		readln(cod); 
	end; 
	
	close (arch); 
end; 




//////////////////////// actualizacion de maestro
procedure actualizarMaestro(var mae:archivo_maestro; var det: archivo_detalle);
var 
	nom: string; 
	p: prenda; 
	cod: integer; 
begin 
	write('ingrese nombre del archivo detalle: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	Assign(det, nom); 
	reset(det); 
	
	write('ingrese nombre del archivo de prendas: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	Assign(mae, nom); 
	reset (mae); 
	
	leerPrendaDesdeMaestro(mae, p); 
	leerPrendaDesdeDetalle(det, cod);
	//verifico que el archivo no este vacio
	while (cod <> valor_alto) do begin

		while (p.cod_prenda <> valor_alto) and (p.cod_prenda <> cod) do 
			read(mae, p);
			//encontre el codigo que tengo que actualizar
		writeln('encontre la prenda que tengo que actualizar: '); 
		writeln('cod= ', cod, ' cod_prenda= ', p.cod_prenda); 
		if (p.cod_prenda = cod) then begin
			p.stock:= p.stock*-1; 
			seek(mae, filePos(mae)-1); 
			write(mae, p); 
			writeln('ya escribi en el maestro'); 
			leerPrendaDesdeMaestro(mae, p); 
			leerPrendaDesdeDetalle(det, cod);
		end; 
	end;

	
	close(mae); 
	close(det); 
end; 

procedure efectivizarBajas(var archOri, archNue: archivo_maestro); 
var
	nom:string; 
	p: prenda; 
begin
	write('ingrese nombre del archivo de prendas: ');
	readln(nom); 
	nom:= concat(nom, '.dat'); 
	Assign(archOri, nom); 
	reset (archOri); 
	
	Assign(archNue, 'nuevoArchivoBinario.dat'); 
	rewrite(archNue);
	
	leerPrendaDesdeMaestro(archOri, p); 
	while (p.cod_prenda <> valor_alto) do begin 
		writeln(' en el while'); 
		writeln(' cod_prenda= ', p.cod_prenda, ' stock: ', p.stock); 
		if (p.stock >=0) then begin
			write(archNue, p); 
			writeln('ya escribi en el maestro'); 
		end; 
		leerPrendaDesdeMaestro(archOri, p); 
	end; 
	
	close(archOri); 
	writeln('cerrado archivo original'); 
	close(archNue); 
	writeln('cerrado nuevo archivo'); 
	Erase(archOri); 
	writeln('ya borre el arch ori'); 
	Rename(archNue, nom); 
	writeln('archivo renombrado exitosamente'); 
	
	writeln('termine de efectivizar'); 
	
end; 

procedure exportarMaestro(var arch: archivo_maestro); 
var
	txt: text; 
	p:prenda; 
	nomFisico, nom:string;  
begin 
	write(' ingrese nombre del archivo binario: '); 
	readln(nomFisico); 
	nom:= concat(nomFisico, '.dat'); 
	Assign (arch, nom); 
	reset(arch); 
	Assign (txt, 'prendas de temporada.txt'); 
	rewrite(txt); 
	
	leerPrendaDesdeMaestro(arch, p);
	while (p.cod_prenda <> valor_alto) do begin 
		with p do begin
		
			writeln('---------------------------------------------------------------------------');
			writeln(txt, 'codigo: ', cod_prenda, ' stock: ', stock, ' precio unitario: ', precio_unitario:2:2); 

			writeln(txt, 'descripcion: ', descripcion,' tipo: ', tipo_prenda, ' colores: ', colores); 

			writeln('---------------------------------------------------------------------------'); 
		end; 
		leerPrendaDesdeMaestro(arch, p); 

		
	
	end; 
	close(txt);
	close (arch); 
end; 
{programa principal}
var 
	archOri,archNue:archivo_maestro; 
	archDet:archivo_detalle; 

begin 
	
//	generarArchivoMaestro(archOri); 
//	generarArchivoDetalle(archDet); 
	
//	writeln('archivos creados exitosamente'); 
//	actualizarMaestro(archOri, archDet); 
	
	efectivizarBajas(archOri, archNue); 
	exportarMaestro(archNue); 
end.
END.
