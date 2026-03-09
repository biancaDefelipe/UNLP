program ejercicio17; 
const 
	valor_alto= 'zzz'; 
	
type
	reg= record
		cod_loc: integer; 
		nom_loc: string; 
		cod_municipio: integer; 
		nom_municipio: string; 
		cod_hospi: integer; 
		nom_hospi: string; 
		cant_casos: integer; 
		fecha: integer; 
	end; 

	archivo=file of reg; 
	


procedure informar(var arch: archivo); 
var 

	act: reg; 
	
begin 
	assign(arch, 'archivo.dat');
	reset(arch); 
	leer(arch, r); 
	totalProv:=0; 
	while (r.nom_loc <> valor_alto ) do begin 
		act.nom_loc:= r.nom_loc; totalLoc:=0; 
		
		while (r.nom_loc = act.nom_loc) do begin 
			
			act.nom_municipio:= r.nom_municipio; totalMunicipio:=0; 
			
			while (r.nom_loc = act.nom_loc) and (r.nom_municipio=act.nom_municipio) do begin 
				act.nom_hospi:= r.nom_hospi; totalHospi:=0;
				
				while (r.nom_loc = act.nom_loc) and (r.nom_municipio=act.nom_municipio)and (r.nom_hospi= act.nom_hospi) do begin 
					totalHospi:=totalHospi+r.cant_casos; 
					leer(arch, r); 
				end; 
				totalMunicipio:= totalMuunicipio+ totalHospi; 
			end; 
			if (totalMunicipio > 1500) then 
				//escribirEnTxt(
			totalLoc:= totalLoc+totalMunicipio;
		end; 
		totalProvicia:= totalProvincia + totalLoc; 
	end; 
				
	close(arch); close(txt); 
				
				
				
				
		
