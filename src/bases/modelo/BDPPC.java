package bases.modelo;

import java.util.ArrayList;


public class BDPPC implements Data{

/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	private ArrayList<Pregunta> preguntas;
	private String nombreCurso;
	private int id_Pregunta;
				
/**********************************************************************************************************************************************
 * 
 * 																M�TODOS
 * 
 *********************************************************************************************************************************************/
public BDPPC () {}




public BDPPC(ArrayList<Pregunta> preguntas, String nombreCurso, int id_Pregunta) {
	super();
	this.preguntas = preguntas;
	this.nombreCurso = nombreCurso;
	this.id_Pregunta = id_Pregunta;
}




public BDPPC( ArrayList<Pregunta> preguntas) {
	super();
	this.preguntas = preguntas;
}


public ArrayList<Pregunta> getPreguntas() {
	return preguntas;
}

public void setPreguntas(ArrayList<Pregunta> preguntas) {
	this.preguntas = preguntas;
}




public String getNombreCurso() {
	return nombreCurso;
}


public void setNombreCurso(String nombreCurso) {
	this.nombreCurso = nombreCurso;
}




public int getId_Pregunta() {
	return id_Pregunta;
}



public void setId_Pregunta(int id_Pregunta) {
	this.id_Pregunta = id_Pregunta;
}


@Override
public String toString() {
	String r = "<html>";
	
	for(int i =0; i<this.preguntas.size();i++) {
		r = r + (i+1) + ".- " + this.preguntas.get(i).getPlanteamiento() + "<br>";
	}
	r = r + "<html>";
	return r;
}
	
	
	
}//FIN CLASE
