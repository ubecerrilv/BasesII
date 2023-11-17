package bases.modelo.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bases.modelo.Curso;
import bases.modelo.Pregunta;
import bases.modelo.error.ConexionException;

public class BDPPCDAO{
/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	private Connection conn;

					
/**********************************************************************************************************************************************
 * 
 * 																M�TODOS
 * 
 *********************************************************************************************************************************************/
	public BDPPCDAO() {}
	public BDPPCDAO(Connection conn) {
	super();
	this.conn = conn;
}


	public ArrayList<Pregunta> recuperaP (Curso curson){
		java.sql.Statement st;
		ResultSet rs;
		int id = -1;
		String enunciado ="";
		ArrayList<Pregunta> preguntas = null;
		
		try {
			st = this.conn.createStatement();
			preguntas = new ArrayList<Pregunta>();
			
			rs = st.executeQuery("SELECT P.ID, P.ENUNCIADO "
					           + "FROM PREGUNTA P, B_D_P_P_C B"
					           + " WHERE B.CURSO_ID = "+ curson.getId()
					           + " AND P.ID = B.PREGUNTA_ID"
					           + " ORDER BY 1");
		//RECUPERAR DATOS Y PONERLOS EN UN ARREGLO DE PREGUNTAS
			
			while(rs.next()) {
				id= rs.getInt("ID"); 	
				enunciado = rs.getString("ENUNCIADO");
				
				preguntas.add(new Pregunta(id,enunciado));
			}//FIN WHILE
			
			
		} catch (Exception e) {
			throw new ConexionException(e.getMessage());
		}
		
		return preguntas;
	}
	
	public ArrayList<Pregunta> recuperaP (Curso curson, int n){
		java.sql.Statement st;
		ResultSet rs;
		int id = -1;
		String enunciado ="";
		ArrayList<Pregunta> preguntas = null;
		
		try {
			st = this.conn.createStatement();
			preguntas = new ArrayList<Pregunta>();
			
			rs = st.executeQuery("SELECT P.ID, P.ENUNCIADO "
					           + "FROM PREGUNTA P, B_D_P_P_C B"
					           + " WHERE B.CURSO_ID = "+ curson.getId()
					           + " AND P.ID = B.PREGUNTA_ID");
		//RECUPERAR DATOS Y PONERLOS EN UN ARREGLO DE PREGUNTAS
			
			while(rs.next() && n!=0) {
				
					id= rs.getInt("ID"); 	
					enunciado = rs.getString("ENUNCIADO");
					
					preguntas.add(new Pregunta(id,enunciado));
					
					n--;
				
			}//FIN WHILE
			
			
		} catch (Exception e) {
			throw new ConexionException(e.getMessage());
		}
		
		return preguntas;
	}
	
	public void insertaR(Pregunta pregunta, Curso curso) {
		java.sql.Statement st;
		
		try {
			st = this.conn.createStatement();
			
			st.executeQuery("INSERT INTO B_D_P_P_C "
					      + "VALUES("+curso.getId()+", "+pregunta.getId()+")");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	
	
}//FIN CLASE
