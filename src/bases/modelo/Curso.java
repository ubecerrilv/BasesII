package bases.modelo;

import java.sql.Connection;
import java.util.ArrayList;

import bases.modelo.data.CursoDAO;

public class Curso  implements Data{
	
	public String nombre;
	public int id;
	
	

	public Curso() {
	}

	public Curso(String nombre) {
		this.nombre = nombre;
	}
	
	public Curso(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
	public String [] sCursos(Connection conn) {
		String [] r ;
		CursoDAO curDao = new CursoDAO(conn);
		ArrayList<Curso> cursos = curDao .recuperaC();
		r = new String[cursos.size()];
		
		for(int i = 0; i<cursos.size(); i++) {
			r[i] = cursos.get(i).toString();
		}
		
		return r;
	}

}
