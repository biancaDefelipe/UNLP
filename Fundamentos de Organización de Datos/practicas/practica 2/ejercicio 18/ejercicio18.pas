program ejercicio18; 
const
	dimF=50;
	valor_alto=9999;
type
	reg_ direccion= record
		calle: integer; 
		numero: integer; 
		piso: integer; 
		depto: integer; 
		ciudad: string; 
	end; 
	
	reg_nacimiento= record
		partida: integer; 
		nombre: string; 
		apellido: string; 
		direccion: reg_direccion;
		matricula_medico: integer; 
		apYnom_madre: string; 
		dni_madre: integer;
		apYnom_padre: string; 
		dni_padre: integer;
	end;
	reg_fallecimiento= record
		partida:integer; 
		dni: integer; 
		apYnom: string; 
		matricula_medico: integer; 
		fechaYhora:string; 
		lugar: string; 
	end; 
	
	reg_maestro= record
		partida: integer;
		nombre: string; 
		apellido:string;
		direccion: reg_direccion; 
		matricula_medico: integer;
		apYnom_madre: string; 
		dni_madre: integer; 
		apYnom_padre: string; 
		dni_padre:integer; 
		fallecido:boolean;
		matricula_medico_desceso: integer; 
		fechaYhora: integer; 
		lugar: string; 
	end; 
	detalle_nacimientos= file of reg_nacimiento; 
	detalle_fallecimientos= file of reg_fallecimiento; 
	
	vecNacimientos= array [1..dimF] of detalle_nacimientos;
	vecFallecimientos= array [1..dimF] of detalle_fallecimientos; 
	
	vecRegNacimientos= array[1..dimF] of reg_nacimiento; 
	vecRegFallecimiento=array[1..dimF] of reg_fallecimiento; 
	
	maestro= file of reg_maestro;  		 

procedure leerNacimiento(var det: detalle_nacimientos; var n: reg_nacimiento); 
begin
	if (not eof(det) then 
		read(det, n); 
	else
		n.partida:= valor_alto; 
end; 

procedure leerFallecimiento(var det: detalle_fallecimientos; var f: reg_fallecimiento); 
begin
	if (not eof(det) then 
		read(det, n); 
	else
		f.partida:= valor_alto; 
end; 


procedure minimoFallecimiento(var vecDet: vecfallecimientos; var vecReg: vecRegFallecimiento; var min: reg_fallecimiento);
var	
	i, minPos:integer; 
begin	
	min.partida:= valor_alto;
	for (i:= to dimF) do begin
		if (vecReg[i].partida < min.partida) then begin
			min:= vecReg[i]; 
			minPos:=1;
		end; 
	end; 
	if (min.partida <> valor_alto) then 
		leerFallecimiento(vecDet[minPos], vecReg[minPos]);
end; 
		
end; 
procedure minimoNacimiento (var vecDet:vecNacimientos; var vecReg: vecRegNacimientos var min: reg_nacimiento); 
var
	i, minPos: integer; 
begin
	min.partida:= valor_alto;
	for (i:= 1 ro dimF) do begin 
		if (vecReg[i].partida < min.partida) then begin 
			min:= vecReg[i]; 
			minPos:= i;
		end;
	end; 
	if (min.partida<> valor_alto) then 
		leerNacimiento(vecDet[minPos], vecReg[minPos]); 
end; 
//////////////////////////////////////
procedure armarDato(n: reg_nacimiento; f:reg_fallecido; var m:reg_maestro); 
begin 
		m.partida: n.partida;
		m.nombre: n.nombre; 
		m.apellido:n.apellido;
		m.direccion: n.reg_direccion; 
		m.matricula_medico: n.matricula_medico;
		m.apYnom_madre: n.apYnom_madre; 
		m.dni_madre: n.dni_madre; 
		m.apYnom_padre: n.apYnom_padre; 
		m.dni_padre:n.dni_padre;
		//
		if (n.partida= f.partida) then begin
			m.fallecido:true;
			m.matricula_medico_desceso: f.matricula_medico; 
			m.fechaYhora: f.fechaYhora; 
			m.lugar: f.lugar; 
		end
		else
			m.fallecido= false; 
end; 
procedure merge(var mae:maestro; var vecN: vecNacimientos; var vecF: vecFallecimientos); 
var 
	vecRegN: vecRegNacimientos; 
	vecRegF: vecRegFallecimiento; 
	aux_n:reg_nacimiento; 
	aux_f: reg_fallecimiento; 
	aux_m: reg_maestrO; 
	i: integer; 
begin
	reset(mae); 
	Assign(mae, 'archivo_maestro');
	rewrite(mae), 
	
	for i:= 1 to dimF do begin 
		reset(vecN[i]);    
		reset (vecF[i]);
		leerNacimiento(vecN[i], vecRegN[i]);     
		leerFallecimiento(vecF[i], vecRegF[i]); 
	end; 
	minimoFallecimiento(vecF, vecRegF, aux_f); 
	minimoNacimiento(vecN, vecRegN, aux_n); 
	
	
	while (aux_f.partida <> valorAlto) do begin
		aux_m.partida: aux_n.partida;
		aux_m.nombre: aux_n.nombre; 
		aux_m.apellido:aux_n.apellido;
		aux_m.direccion: aux_n.reg_direccion; 
		aux_m.matricula_medico: aux_n.matricula_medico;
		aux_m.apYnom_madre: aux_n.apYnom_madre; 
		aux_m.dni_madre: aux_n.dni_madre; 
		aux_m.apYnom_padre: aux_n.apYnom_padre; 
		aux_m.dni_padre:aux_n.dni_padre;
		//
		if (aux_n.partida= aux_f.partida) then begin
			aux_m.fallecido:true;
			aux_m.matricula_medico_desceso: aux_f.matricula_medico; 
			aux_m.fechaYhora: aux_f.fechaYhora; 
			aux_m.lugar: aux_f.lugar; 
		end
		else
			aux_m.fallecido= false;
		write(mae, aux_m);
		minimoNacimiento(vecN, vecRegN, aux_n);
		//
		if(aux_m.fallecido) then 
			minimoFallecimiento(vecN, vecRegN, aux_n);
		
		
