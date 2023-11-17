package bases.modelo;


public class Respuesta implements Data {
	
/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	private int id;
	private String descrpcion;
	private boolean correc;
	private int cor;
	
/**********************************************************************************************************************************************
 * 
 * 																MÉTODOS
 * 
 *********************************************************************************************************************************************/

	
	
	public Respuesta(int id, String descrpcion) {
		this.id = id;
		this.descrpcion = descrpcion;
	}

	public Respuesta() {}
	
	

	public Respuesta(String descrpción, boolean correc) {
		this.descrpcion = descrpción;
		this.correc = correc;
		
		if(correc) {
			this.cor=1;
		}else {
			this.cor=0;
		}
	}
	public Respuesta(int id, String descrpción, boolean correc) {
		this.id=id;
		this.descrpcion = descrpción;
		this.correc = correc;
		
		if(correc) {
			this.cor=1;
		}else {
			this.cor=0;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrpcion() {
		return descrpcion;
	}

	public void setDescrpcion(String descrpción) {
		this.descrpcion = descrpción;
	}

	public boolean isCorrec() {
		return correc;
	}

	public void setCorrec(boolean correc) {
		this.correc = correc;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}
	
	
	
	
}//FIN
