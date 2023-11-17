package bases.control;



import java.util.ArrayList;

import bases.modelo.BDPPC;
import bases.modelo.Curso;
import bases.modelo.Data;
import bases.modelo.Pregunta;
import bases.modelo.Respuesta;
import bases.modelo.data.BDPPCDAO;
import bases.modelo.data.CursoDAO;
import bases.modelo.data.PRDAO;
import bases.modelo.data.PreguntaDAO;
import bases.modelo.data.RespuestaDAO;


public class ControlVProfesor extends ControlAbs {
	
	private BDPPCDAO dao;
	private CursoDAO daoCursos;
	private PreguntaDAO pdao;
	private RespuestaDAO rdao;
	private PRDAO prdao;
	
	@Override
	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas) {
		
		
		Pregunta p; //PREGUNTA "VACIA"
		Pregunta np; //PREGUNTA "LLENA"
		Curso cur; //CURSO "VACIO"
		Curso ncurso; //CURSO "LLENO"
		ArrayList<Respuesta> nrespuestas;

		switch (c) {
		case Comandos.CREARE:
			
			p = (Pregunta)d;
		    cur = (Curso) d2;
		    
		    //INSERTAR PREGUNTA Y RECUPERAR ID
		    
		    np = pdao.inserta(p);
		    
		    //INSERTAR LA RELACION DE LA PREGUNTA Y EL CURSO
		    
		    ncurso = daoCursos.cursosconid(cur.nombre);
		    dao.insertaR(np, ncurso);
		    
		    //INSERTAR RESPUESTAS
		    
		    nrespuestas = rdao.insertaRes(respuestas);
		    
		    //INSERTAR LA RELACION DE LAS REPUESTAS CON LA PREGUNTA
		    
		    prdao.insertaPR(np, nrespuestas);
			
			this.padre.ejecutaComando(Comandos.CREARE, null,null, null);
		break;

		case Comandos.CONSULTARB:
			
			cur = (Curso) d;
			
			//OBTENER EL CURSO CON ID
			ncurso = daoCursos.cursosconid(cur.nombre);
			
			//OBTENER EL BANCO DE PREGUNTAS DE ESE CURSO
			BDPPC bL = new BDPPC(dao.recuperaP(ncurso));
			
			this.padre.ejecutaComando(Comandos.CONSULTARB, bL,null, null);
			
		break;
		
		case Comandos.REGRESARP:
			this.padre.ejecutaComando(Comandos.INICIA, null, null, null);
		break;
		}
		return null;
	}

	public void setDao(BDPPCDAO dao) {
		this.dao = dao;
	}

	public void setDaoCursos(CursoDAO daoCursos) {
		this.daoCursos = daoCursos;
	}

	public void setPdao(PreguntaDAO pdao) {
		this.pdao = pdao;
	}

	public void setCurso(int curso_id) {
		
	}

	public void setRdao(RespuestaDAO rdao) {
		this.rdao = rdao;
	}

	public void setPrdao(PRDAO prdao) {
		this.prdao = prdao;
	}
	
	
	
	
}
