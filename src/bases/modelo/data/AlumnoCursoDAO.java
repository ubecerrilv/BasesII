package bases.modelo.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bases.modelo.AlumnoCurso;
import bases.modelo.error.ConexionException;

public class AlumnoCursoDAO {
	
	private Connection conn;

	public AlumnoCursoDAO() {
		super();
	}
	
	
	public AlumnoCurso recuperaAC(AlumnoCurso alumno) {
		java.sql.Statement st;
		ResultSet rs, rs2;
		AlumnoCurso alumnoN = new AlumnoCurso(null, null, null, null, null, 0);
		
		try {
			st = this.conn.createStatement();
			
			rs = st.executeQuery("SELECT P.APELLIDO_PATERNO, P.APELLIDO_MATERNO, P.NOMBRE, P.ID "
							   		+ "FROM RUIC.PERSONA P, TRAINING.ALUMNO_CURSO AC "
							   			+ "WHERE AC.ID_DE_CURSO_PROGRAMADO = (SELECT ID FROM TRAINING.CURSO WHERE NOMBRE = '"+alumno.getCurso().toUpperCase()+"') "
							   			+ "AND P.NOMBRE = '" +alumno.getNombre().toUpperCase()+ "' "
							   			+ "AND P.APELLIDO_PATERNO = '"+alumno.getApellido1().toUpperCase()+"' "
							   			+ "AND P.APELLIDO_MATERNO = '"+alumno.getApellido2().toUpperCase()+"' "
							   			+ "ORDER BY P.APELLIDO_PATERNO");
			
			while(rs.next()) {
				alumnoN = new AlumnoCurso(rs.getString("NOMBRE"), rs.getString("APELLIDO_PATERNO"),rs.getString("APELLIDO_MATERNO"), 
						null, alumno.getCurso(),
						rs.getInt("ID"));
			}
			
			
			rs2 = st.executeQuery("SELECT P.APELLIDO_PATERNO, P.APELLIDO_MATERNO, P.NOMBRE "
					+ "FROM RUIC.PERSONA P\r\n"
					+ "WHERE P.ID = (SELECT ID_DE_INSTRUCTOR FROM TRAINING.CURSO_PROGRAMADO WHERE ID_DE_CURSO = "
					+ "(SELECT ID FROM TRAINING.CURSO WHERE NOMBRE = '"+alumno.getCurso()+"'))");
			
			while(rs2.next()) {
				alumnoN.setInstructor(rs2.getString("NOMBRE") +" "+ rs2.getString("APELLIDO_PATERNO") +" "+ rs2.getString("APELLIDO_MATERNO"));
			}
			
		} catch (SQLException e) {
			throw new ConexionException(e.getMessage());
		}
		
		return alumnoN;
		
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	

}
