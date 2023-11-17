package bases.modelo;

import java.util.ArrayList;

public class PR implements Data {
	
	private Pregunta pregunta;
	private ArrayList<Respuesta> respuestas;
	
	
	
	public PR(Pregunta pregunta, ArrayList<Respuesta> respuestas) {
		super();
		this.pregunta = pregunta;
		this.respuestas = respuestas;
	}
	public PR() {
		super();
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	

}
