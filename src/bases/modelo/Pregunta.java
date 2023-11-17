package bases.modelo;

public class Pregunta implements Data{

/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/
	
	private int id;
	private String planteamiento;
	
						
/**********************************************************************************************************************************************
 * 
 * 																MÉTODOS
 * 
 *********************************************************************************************************************************************/
	//CONSTRUCTORES
	public Pregunta() {}
	public Pregunta(int id, String planteamiento) {
	super();
	this.id = id;
	this.planteamiento = planteamiento;
}
	
	
	@Override
	public String toString() {
		return this.planteamiento;
	}
	//SETTERS Y GETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlanteamiento() {
		return planteamiento;
	}
	public void setPlanteamiento(String planteamiento) {
		this.planteamiento = planteamiento;
	}

}//FIN CLASE
