package bases.modelo.data;

import java.sql.Connection;
//import java.sql.ResultSet;
//import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import bases.modelo.Data;
import bases.modelo.Pregunta;
//import bases.modelo.error.ConexionException;

public class PreguntaDAO implements Data {

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
	
	public PreguntaDAO(Connection conn) {
	super();
	this.conn = conn;
}
	public PreguntaDAO() {
}

	public Pregunta inserta(Pregunta pregunta) {
		java.sql.Statement st;
		ResultSet rs;
		Pregunta preguntaN = null;
		
		try {
			st = this.conn.createStatement();
			
			st.executeQuery("INSERT INTO PREGUNTA "
						  + "VALUES(-1, '"+pregunta.getPlanteamiento() +"')");
			
			st.executeQuery("COMMIT");
			
			rs = st.executeQuery("SELECT ID "
					           + "FROM PREGUNTA "
				               + "WHERE ENUNCIADO = '"+pregunta.getPlanteamiento()+"'");
			
			while (rs.next()) {
				preguntaN = new Pregunta(rs.getInt("ID"), pregunta.getPlanteamiento());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return preguntaN;
	}
	
	public int rMax(String curso) {
		java.sql.Statement st;
		ResultSet rs;
		int r = 0;
		
		try {
			st = this.conn.createStatement();
			
			rs = st.executeQuery("SELECT COUNT(*) "
					+ "FROM B_D_P_P_C B "
					+ "WHERE B.CURSO_ID = (SELECT ID FROM TRAINING.CURSO WHERE NOMBRE = '"+curso+"')");
			
			while (rs.next()) {
				r = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return r;
	}
	
	public Pregunta recupera(int P_id) {
		return null;
		}
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}

}//FIN CLASE
