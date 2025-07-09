package ar.edu.unlp.info.oo2.biblioteca;
import java.util.List;

import org.json.simple.*;

public class JSONAdapter extends VoorheesExporter {

    @Override
    public String exportar(List<Socio> socios) {
        if (socios.isEmpty()) return "[]";

        JSONArray arregloJSON = new JSONArray();
        socios.forEach(socio -> arregloJSON.add(this.crearSocio(socio)));

        return arregloJSON.toJSONString();
    }

    private JSONObject crearSocio(Socio socio) {
        JSONObject obj = new JSONObject();
        obj.put("nombre", socio.getNombre());
        obj.put("email", socio.getEmail());
        obj.put("legajo", socio.getLegajo());
        return obj;
    }
}
