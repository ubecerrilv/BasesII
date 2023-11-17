package bases.modelo.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bases.modelo.Data;
import bases.modelo.Pregunta;
import bases.modelo.Respuesta;

public class RespuestaDAO {

	
	private Connection conn;
	
	
	public ArrayList<Respuesta> insertaRes(ArrayList<Data> respuestasv){
		java.sql.Statement st;
		ResultSet rs;
		
		ArrayList<Respuesta> respuestasn = new ArrayList <Respuesta>();
		
		try {
			st = this.conn.createStatement();
			
			for(int i= 0; i<respuestasv.size();i++) {
				st.executeQuery("INSERT INTO RESPUESTA "
						           + "VALUES(-1, '"+((Respuesta) respuestasv.get(i)).getDescrpcion()+"', "
						           +((Respuesta) respuestasv.get(i)).getCor()+")");
			
				st.executeQuery("COMMIT");
			}
			
			for(int i= 0; i<respuestasv.size();i++) {
				rs = st.executeQuery("SELECT ID "
						           + "FROM RESPUESTA "
						           + "WHERE DESCRIPCION = '"+((Respuesta) respuestasv.get(i)).getDescrpcion()+"'");
				
				while(rs.next()) {
					respuestasn.add(new Respuesta(rs.getInt("ID"), ((Respuesta) respuestasv.get(i)).getDescrpcion()));
					
				}
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return respuestasn;
	}
	
	
	public ArrayList<Respuesta> getRespuestas(Pregunta pregunta){
		java.sql.Statement st;
		ResultSet rs;
		
		ArrayList<Respuesta> respuestasn = new ArrayList <Respuesta>();
		
		try {
			st = this.conn.createStatement();
			
			rs = st.executeQuery("SELECT * "
					+ "FROM RESPUESTA R, P_R B "
					+ "WHERE B.PREGUNTA_ID = '"+pregunta.getId()+"' "
					+ "AND R.ID = B.RESPUESTA_ID");
			
			while(rs.next()) {
				boolean r = false;
				
				if(rs.getInt("VALIDA") == 1){
					r = true;
					}
				
				respuestasn.add(new Respuesta(rs.getInt("ID"), rs.getString("DESCRIPCION"), r));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return respuestasn;
	}
	

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	
}


