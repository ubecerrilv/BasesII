package bases.modelo.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bases.modelo.AlumnoCurso;
import bases.modelo.PR;
import bases.modelo.error.ConexionException;

public class ExamenDAO {
	
	private Connection conn;

	public ExamenDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public ExamenDAO() {
		super();
	}


	public int inserta(AlumnoCurso ac) {
		java.sql.Statement st;
		ResultSet rs;
		int r =0;
		String fecha = "";
		try {
			
			fecha = LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear();
			
			st = this.conn.createStatement();
			
			st.executeQuery("INSERT INTO EXAMEN VALUES(-1, '"+fecha+"', "+ac.getId()+", (SELECT ID FROM TRAINING.CURSO WHERE NOMBRE = '"+ac.getCurso()+"'))");
			st.executeQuery("COMMIT");
			
			
			rs = st.executeQuery("SELECT ID "
					+ "FROM EXAMEN "
					+ "WHERE ALUMNO_ID = "+ac.getId()+" AND "
					+ "CURSO_ID = (SELECT ID FROM TRAINING.CURSO WHERE NOMBRE = '"+ac.getCurso()+"')");
			while(rs.next()) {
				r = rs.getInt("ID");
			}
			
			
		} catch (SQLException e) {
			throw new ConexionException(e.getMessage());
		}
		
		return r;
	}
	
	public void insertaepr(int ide, ArrayList<PR> preguntasr) {
		java.sql.Statement st;

		try {
			st = this.conn.createStatement();
			
			for(int i=0; preguntasr.size()>i; i++) {
				for(int j =0; preguntasr.get(i).getRespuestas().size()>j; j++) {
					st.executeQuery("INSERT INTO E_P_R VALUES("+ide+", "+preguntasr.get(i).getPregunta().getId()+", "+preguntasr.get(i).getRespuestas().get(j).getId()+")");
					
					System.out.println("INSERT INTO E_P_R VALUES("+ide+", "+preguntasr.get(i).getPregunta().getId()+", "+preguntasr.get(i).getRespuestas().get(j).getId()+")");
					st.executeQuery("COMMIT");
				}	
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	

}
