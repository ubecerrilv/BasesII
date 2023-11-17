package bases.modelo;

public class AlumnoCurso implements Data {

	private String nombre, apellido1, apellido2, instructor, curso;
	private int id;
	public AlumnoCurso(String nombre, String apellido1, String apellido2, String instructor, String curso, int id) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.instructor = instructor;
		this.curso = curso;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		
		return "<html>ID: "+this.getId()+"<br>Alumno: " + this.getNombre() +" "+ this.getApellido1()+" " + this.getApellido2() + "<br>"
		+ "Curso: " + this.getCurso() + "<br>Instructor: " + this.getInstructor() +"<html>";
	}
	
	public String toNombre() {
		return "<html>" + this.getNombre() +" "+ this.getApellido1()+" " + this.getApellido2()+"<html>";
	}
	
}
