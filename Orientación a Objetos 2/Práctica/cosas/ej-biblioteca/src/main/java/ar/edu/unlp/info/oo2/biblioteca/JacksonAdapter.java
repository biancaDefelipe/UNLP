package ar.edu.unlp.info.oo2.biblioteca;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringWriter;
import java.util.List;

public class JacksonAdapter extends VoorheesExporter {

    @Override
    public String exportar(List<Socio> socios) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, socios);  // convierte lista de objetos a JSON
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "[]";  // alternativa simple para manejar errores
        }
    }
}
