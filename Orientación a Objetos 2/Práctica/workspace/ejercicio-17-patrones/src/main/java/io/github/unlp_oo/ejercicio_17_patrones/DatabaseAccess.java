package io.github.unlp_oo.ejercicio_17_patrones;

import java.util.Collection;
import java.util.List;

public interface DatabaseAccess {
    Collection<String> getSearchResults(String queryString);

    int insertNewRow(List<String> rowData);
	}


