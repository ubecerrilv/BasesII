package bases.control;



import java.util.ArrayList;

import javax.swing.JOptionPane;

import bases.gui.VentanaBA;
import bases.gui.VentanaEstudiante;
import bases.gui.VentanaPrincipal;
import bases.gui.VentanaProfesor;
import bases.modelo.AlumnoCurso;
import bases.modelo.BDPPC;
import bases.modelo.Curso;
import bases.modelo.Data;

public class ControlPrincipal extends ControlAbs{
	
/*
 * Esta clase es creada como un control de las ventanas, dirige cuando mostrase u ocultarse
 */
	
/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	private VentanaPrincipal vP;	
	private VentanaProfesor vProf;
	private VentanaEstudiante vE;
	private VentanaBA vBA;
	
	
				
/**********************************************************************************************************************************************
 * 
 * 																Mï¿½TODOS
 * 
 *********************************************************************************************************************************************/

	@Override
	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas) {
		switch(c) {
		case Comandos.INICIA:
			
			vProf.vaciar();
			vProf.setVisible(false);
			
			vE.setVisible(false);
			vE.limpia();
			
			vP.setBounds(0, 0, 400, 95);
			vP.setLocationRelativeTo(null);
			vP.setVisible(true);
		break;
		
		case Comandos.ESTUDIANTE:
			vP.setVisible(false);
			
			vE.setBounds(0, 0, 800, 250);
			vE.setLocationRelativeTo(null);
			vE.setVisible(true);
			
			vE.limpia();
			
			break;
		case Comandos.PROFESOR:
			vP.setVisible(false);
			
			vProf.setBounds(0,0,800,550);
			vProf.setLocationRelativeTo(null);
			vProf.setVisible(true);
		break;
		
		case Comandos.CONSULTARB:
			BDPPC bL = (BDPPC) d;
			
			vProf.setPreguntasT(bL.toString());
		break;
		
		case Comandos.CREARE:
			JOptionPane.showMessageDialog(vP, "Pregunta creada!!");
			vProf.vaciar();
		break;
		
		case Comandos.BUSCARAL:
			
			//SETEAR CURSO
			Curso curso = (Curso)d;
			vBA.setCursoS(curso);
			vBA.setETC(curso.getNombre());
			
			vBA.setBounds(0, 0, 500, 170);
			vBA.setLocationRelativeTo(null);
			vBA.setVisible(true);
			
		break;
			
		case Comandos.BUSCOAL:
			AlumnoCurso ac = (AlumnoCurso)d;
			
			if(ac.getNombre()!=null) {
				vBA.setAlumnos(ac.toString());
			}else {
				vBA.setAlumnos("Este alumno no esta registrado en este curso");
			}
			
		break;
		
		case Comandos.ACEPTARV:
			AlumnoCurso acA = (AlumnoCurso)d;
			
			if(acA.getNombre()!=null) {
				
				vE.setVacio(acA);
				
				vBA.borra();
				
				vBA.setVisible(false);
			}
		break;
		
		case Comandos.EMPEZARE:
			
			
			if(vE.getVacio().getText().compareTo("")!=0) {
				vE.setVisible(false);
				JOptionPane.showMessageDialog(vE, "Toma en cuenta que si pasas de pregunta, ya no podrás regresar");
			}
		break;
			
		}
		return null;
	}

public void setvP(VentanaPrincipal vP) {
	this.vP = vP;
}

public void setvProf(VentanaProfesor vProf) {
	this.vProf = vProf;
}

public void setvE(VentanaEstudiante vE) {
	this.vE = vE;
}

public void setvBA(VentanaBA vBA) {
	this.vBA = vBA;
}



	
	

}//FIN CLASE
