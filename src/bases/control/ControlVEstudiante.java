package bases.control;

import java.util.ArrayList;

import bases.gui.VentanaExamen;
import bases.modelo.AlumnoCurso;
import bases.modelo.BDPPC;
import bases.modelo.Curso;
import bases.modelo.Data;
import bases.modelo.Examen;
import bases.modelo.PR;
import bases.modelo.Pregunta;
import bases.modelo.data.BDPPCDAO;
import bases.modelo.data.CursoDAO;
import bases.modelo.data.ExamenDAO;
import bases.modelo.data.RespuestaDAO;

public class ControlVEstudiante extends ControlAbs {
	
	private VentanaExamen vEx;
	private CursoDAO daoCursos;
	private BDPPCDAO dao;
	private RespuestaDAO rdao;
	private ExamenDAO edao;

	@Override
	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas) {
		vEx = new VentanaExamen();
		
		switch (c) {
		case Comandos.EMPEZARE:
			
			
			this.padre.ejecutaComando(Comandos.EMPEZARE, null, null, null);
			//RECUPERAR LAS PREGUNTAS
			Examen examen = (Examen)d;
			AlumnoCurso acurso = (AlumnoCurso)d2;
			ArrayList<PR> preguntasR = new ArrayList<PR>();
			int idE;
			
			//OBTENER EL CURSO CON ID
			Curso ncurso = daoCursos.cursosconid(acurso.getCurso());
			
			//OBTENER EL BANCO DE PREGUNTAS DE ESE CURSO
			BDPPC bL = new BDPPC(dao.recuperaP(ncurso, examen.getnP()));
			
			
			ArrayList<Pregunta> preguntas = bL.getPreguntas();
			
			//CREAR LA VENTANA Y MOSTRTARLA AL USUARIO
			
			vEx.setBounds(0,0,800,200);
			vEx.setLocationRelativeTo(null);
			
			vEx.setVisible(true);
			
			ControlVExamen cVetnEx = new ControlVExamen();
			
			vEx.setControl(cVetnEx);
			cVetnEx.setCP(this);
			
			//CREAR LAS PREGUNTAS LISTAS PARA INSERTAR E INSERTAR
			for(int i =0; i<preguntas.size();i++) {
				preguntasR.add(new PR(preguntas.get(i), rdao.getRespuestas(preguntas.get(i))));
			}
			
			vEx.setPr(preguntasR);
			vEx.setPregunta(preguntasR, 0);
			
			//INSERTAR EXAMEN EN LA TABLAS
			idE = edao.inserta(acurso);
			
			edao.insertaepr(idE, preguntasR);
			
			
		break;
		
		
		
		case Comandos.CALIFICAR:
			vEx.setVisible(false);
			this.padre.ejecutaComando(Comandos.ESTUDIANTE, null, null, null);
		break;
		
		
		
		case Comandos.BUSCARAL:
			Curso cursoB = (Curso) d;
			
			this.padre.ejecutaComando(Comandos.BUSCARAL, cursoB, null, null);
			
		break;
		
		case Comandos.REGRESARP:
			this.padre.ejecutaComando(Comandos.INICIA, null, null, null);
		break;
		}
		return null;
	}

	public void setvEx(VentanaExamen vEx) {
		this.vEx = vEx;
	}

	public void setDaoCursos(CursoDAO daoCursos) {
		this.daoCursos = daoCursos;
	}

	public void setDao(BDPPCDAO dao) {
		this.dao = dao;
	}

	public void setRdao(RespuestaDAO rdao) {
		this.rdao = rdao;
	}

	public void setEdao(ExamenDAO edao) {
		this.edao = edao;
	}
	
	
	
	

}
