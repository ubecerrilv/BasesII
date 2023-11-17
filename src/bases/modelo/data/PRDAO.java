package bases.modelo.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import bases.modelo.Pregunta;
import bases.modelo.Respuesta;

public class PRDAO {


/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/
		
	private Connection conn;

							
/**********************************************************************************************************************************************
 * 
 * 																MÉTODOS
 * 
 *********************************************************************************************************************************************/	
	
	
	
	public void insertaPR(Pregunta p, ArrayList<Respuesta> respuestas) {
		java.sql.Statement st;
		
		try {
			st = this.conn.createStatement();
			
			for(int i =0; i<respuestas.size();i++) {
				st.executeQuery("INSERT INTO P_R "
					          + "VALUES("+p.getId()+", "+respuestas.get(i).getId()+")");
				
				
				st.executeQuery("COMMIT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public PRDAO() {
	super();
}


	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	

}
