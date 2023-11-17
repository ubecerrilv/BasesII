package bases.control;

import java.util.ArrayList;

import bases.modelo.AlumnoCurso;
import bases.modelo.Data;
import bases.modelo.data.AlumnoCursoDAO;

public class ControlVBA extends ControlAbs {
	
	AlumnoCursoDAO ald;

	@Override
	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas) {
		
		switch (c) {
		case Comandos.BUSCARV:
			AlumnoCurso alumnoO = (AlumnoCurso) d;
			AlumnoCurso alumnoC;
			
			//BUSCAR ALUMNOS EN EL CURSO
			alumnoC = ald.recuperaAC(alumnoO);
			
			//COLOCAR LOS ALUMNOS EN EL COMBO
			this.padre.ejecutaComando(Comandos.BUSCOAL, alumnoC, null, null);
			
		break;
		
		case Comandos.ACEPTARV:
			AlumnoCurso alumnoOA = (AlumnoCurso) d;
			AlumnoCurso alumnoCA;
			
			alumnoCA = ald.recuperaAC(alumnoOA);
			
			this.padre.ejecutaComando(Comandos.ACEPTARV, alumnoCA, null, null);
		break;
		}
		
		return null;
	}

	public AlumnoCursoDAO getAld() {
		return ald;
	}

	public void setAld(AlumnoCursoDAO ald) {
		this.ald = ald;
	}
	


}
