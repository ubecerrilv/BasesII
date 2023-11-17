package bases.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import bases.control.Comandos;
import bases.control.ControlPrincipal;
import bases.control.ControlVBA;
import bases.control.ControlVEstudiante;
import bases.control.ControlVPrincipal;
import bases.control.ControlVProfesor;
import bases.gui.VentanaBA;
import bases.gui.VentanaEstudiante;
import bases.gui.VentanaPrincipal;
import bases.gui.VentanaProfesor;
import bases.modelo.Curso;
import bases.modelo.data.AlumnoCursoDAO;
import bases.modelo.data.BDPPCDAO;
import bases.modelo.data.CursoDAO;
import bases.modelo.data.ExamenDAO;
import bases.modelo.data.PRDAO;
import bases.modelo.data.PreguntaDAO;
import bases.modelo.data.RespuestaDAO;

public class Principal {
	
 /*@author ULISES BECERRIL VALD�S*/
	
	
/**********************************************************************************************************************************************
 * 
 * 																M�TODOS
 * 
 *********************************************************************************************************************************************/
	public static void main(String[] args) {
		
		// CREAR LAS VARIABLES NECESARIAS
		
		ControlPrincipal cPrincipal;
		
		VentanaPrincipal ventP;
		ControlVPrincipal cVentP;
		
		VentanaProfesor ventProf;
		ControlVProfesor cVentProf;
		
		VentanaEstudiante ventEst;
		ControlVEstudiante cVentEst;
		
		VentanaBA ventBA;
		ControlVBA cBA;
		
		//VARIABLES DAOS
		BDPPCDAO bdao;
		CursoDAO curDao;
		PreguntaDAO pdao;
		RespuestaDAO rdao; 
		PRDAO prdao;
		AlumnoCursoDAO aldao;
		ExamenDAO edao;
		
		
		//CONEXI�N A LA BASE DE DATOS
		Connection conn = getDBConnection();
		
		if(conn != null){
		//INSTANCIAR VARIABLES
			//VENTANAS
			ventP = new VentanaPrincipal();
			ventProf =  new VentanaProfesor(new Curso().sCursos(conn));
			ventEst = new VentanaEstudiante(new Curso().sCursos(conn), conn);
			ventBA = new VentanaBA();
			
			//CONTROLES DE VENTANAS
			cVentP = new ControlVPrincipal();
			cVentProf = new ControlVProfesor();
			cVentEst = new ControlVEstudiante();
			cBA = new ControlVBA();
			
			//DAOS
			bdao = new BDPPCDAO();
			curDao = new CursoDAO();
			pdao = new PreguntaDAO();
			rdao = new RespuestaDAO();
			prdao = new PRDAO();
			aldao = new AlumnoCursoDAO();
			edao = new ExamenDAO();
			
			
			//CONTROL PRINCIPAL
			cPrincipal =  new ControlPrincipal();
			
			
			
		//INYECCI�N DE DEPENDENCIAS
			//SETEAR VENTANAS
			cPrincipal.setvP(ventP);
			cPrincipal.setvProf(ventProf);
			cPrincipal.setvE(ventEst);
			cPrincipal.setvBA(ventBA);
			
			//CONEXIONES A LOS DAOS
			bdao.setConn(conn);
			curDao.setConn(conn);
			pdao.setConn(conn);
			rdao.setConn(conn);
			prdao.setConn(conn);
			aldao.setConn(conn);
			edao.setConn(conn);
			
			//DAOS A LOS CONTROLES
			cVentProf.setDao(bdao);
			cVentProf.setDaoCursos(curDao);
			cVentProf.setPdao(pdao);
			cVentProf.setRdao(rdao);
			cVentProf.setPrdao(prdao);
			
			cVentEst.setDao(bdao);
			cVentEst.setDaoCursos(curDao);
			cVentEst.setRdao(rdao);
			cVentEst.setEdao(edao);
			
			cBA.setAld(aldao);
			
			
			//CONTROL PRINCIPAL EN CONTROLES DE VENTANAS
			cVentP.setCP(cPrincipal);
			cVentProf.setCP(cPrincipal);
			cVentEst.setCP(cPrincipal);
			cBA.setCP(cPrincipal);
			
			//CONTROLES DE VENTANAS
			ventP.setControl(cVentP);
			ventProf.setControl(cVentProf);
			ventEst.setControl(cVentEst);
			ventBA.setControl(cBA);
		
		//INICIAR LA EJECUCI�N
			cPrincipal.ejecutaComando(Comandos.INICIA, null,null, null);
			
		}//FIN IF
		
	
	}//FIN MAIN
	
	
    public static Connection getDBConnection() 
    {
        String url          = "jdbc:oracle:thin:@//187.188.66.250:1521/orcl";
        //String url = "jdbc:oracle:thin:@//192.168.1.117:1521/orcl";
        String username     = "EXAMEN";
        String password     = "oracle1" ;
        try
        {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado ... "+ conn);
            return conn;
        }
        catch (SQLException e)
        {
              JOptionPane.showMessageDialog(null, "Falló la conexión " + e);  
              return null;
        }       
    }//FIN GETCONN
    

}//FIN CLASE
