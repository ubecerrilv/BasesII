package bases.modelo.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import bases.modelo.Curso;
import bases.modelo.error.ConexionException;


public class CursoDAO{

	private Connection conn;
	
	

	public CursoDAO() {
		super();
	}
	public CursoDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public ArrayList<Curso> recuperaC (){
		java.sql.Statement st;
		ResultSet rs;
		String nombre = "";
		ArrayList <Curso> cursos = null;
		
		try {
			st = this.conn.createStatement();
			cursos = new ArrayList<Curso>();
			
			rs = st.executeQuery("SELECT NOMBRE "
							   + "FROM TRAINING.CURSO "
							   + "ORDER BY NOMBRE");
		//RECUPERAR DATOS Y PONERLOS EN UN ARREGLO DE CURSOS
			
			while(rs.next()) {
				nombre = rs.getString("NOMBRE");
				
				cursos.add(new Curso (nombre));
			}//FIN WHILE
			
			
		} catch (Exception e) {
			throw new ConexionException(e.getMessage());
		}
		
		return cursos;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public Curso cursosconid(String nombre) {
		java.sql.Statement st;
		ResultSet rs;
		int id;
		Curso curso = null;
		
		try {
			st = this.conn.createStatement();
			
			rs = st.executeQuery("SELECT ID "
							   + "FROM TRAINING.CURSO "
							   + "WHERE NOMBRE = '"+ nombre
							   + "' ORDER BY NOMBRE");
		//RECUPERAR DATOS 
			while(rs.next()) {
				id = rs.getInt("ID");
				curso = new Curso(nombre, id);
			}
			
		} catch (Exception e) {
			throw new ConexionException(e.getMessage());
		}
		
		return curso;
	}
	
	
	
}
