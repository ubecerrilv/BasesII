package bases.modelo;

import java.time.LocalDate;

public class Examen implements Data{

	private int id, nP;
	private LocalDate fecha;
	private int alumno_id;
	private int curso_id;

	
	public Examen() {
		super();
	}
	public Examen(int nP) {
		super();
		this.nP = nP;
	}
	public Examen(int id, LocalDate fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
	}
	public Examen(int id, LocalDate fecha, int alumno_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.alumno_id = alumno_id;
	}
	public Examen(int id, LocalDate fecha, int alumno_id, int curso_id) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.alumno_id = alumno_id;
		this.curso_id = curso_id;
	}
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getAlumno_id() {
		return alumno_id;
	}
	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}
	public int getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	public int getnP() {
		return nP;
	}
	public void setnP(int nP) {
		this.nP = nP;
	}
	
	
	
	
}
