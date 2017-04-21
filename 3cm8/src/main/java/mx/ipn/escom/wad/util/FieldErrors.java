package mx.ipn.escom.wad.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldErrors {
	private Map<String, List<String>> errores;

	public FieldErrors() {
		this.errores = new HashMap<String, List<String>>();
	}

	public void add(String name, String error) {
		if (this.errores.containsKey(name)) {
			List<String> listErrores = this.errores.get(name);
			listErrores.add(error);
			this.errores.put(name, listErrores);
		} else {
			List<String> listErrores = new ArrayList<String>();
			listErrores.add(error);
			this.errores.put(name, listErrores);
		}
	}

	public List<String> remove(String name) {
		List<String> listErrores = this.errores.remove(name);
		return listErrores == null ? new ArrayList<String>() : listErrores;
	}

	public List<String> get(String name) {
		List<String> listErrores = this.errores.get(name);
		return listErrores == null ? new ArrayList<String>() : listErrores;
	}

	public Boolean contains(String name) {
		return this.errores.containsKey(name);
	}
	
	public Boolean hasFieldErrors(){
		return !this.errores.isEmpty();
	}
}
