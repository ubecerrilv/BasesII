package bases.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bases.control.Comandos;
import bases.modelo.AlumnoCurso;
import bases.modelo.Curso;

@SuppressWarnings("serial")
public class VentanaBA extends VentanaAGeneral {
	
	JPanel cab, iz, der, baj;
	JLabel curso, nombre, apellido1, apellido2;
	JButton buscar, aceptar;
	JTextField tNombre, tApell1, tApell2;
	JLabel alumnos;
	Curso cursoS;
	
	
	public VentanaBA() {
		super("Selecciona el alumno que eres");
		
		//CREAR PANELES
		cab= new JPanel(new GridLayout(1,1));
		cab.setBorder(new EmptyBorder(5,5,5,5));
		
		iz= new JPanel(new GridLayout(3,2));
		iz.setBorder(new EmptyBorder(5,5,5,5));
		
		der= new JPanel(new GridLayout(1,1));
		der.setBorder(new EmptyBorder(5,5,5,5));
		
		baj= new JPanel(new GridLayout(1,2));
		baj.setBorder(new EmptyBorder(5,5,5,5));
		
		//CREAR ETIQUETAS
		curso = new JLabel();//setear nombre del curso
		
		nombre = new JLabel("Nombre:");
		
		apellido1  = new JLabel("Apellido paterno:");
		
		apellido2 = new JLabel("Apellido materno:");
	
		//CREAR BOTONES Y SUS ACCIONES
		buscar = new JButton("Buscar");
		buscar.setActionCommand(Comandos.BUSCARV);
		buscar.addActionListener(this);
		
		aceptar = new JButton("Aceptar");
		aceptar.setActionCommand(Comandos.ACEPTARV);
		aceptar.addActionListener(this);
		
		//CREAR AREAS DE TEXTO
		tNombre = new JTextField();
		tApell1 = new JTextField();
		tApell2 = new JTextField();
		
		//CREAR 
		alumnos = new JLabel();
		
		//ANADIR LOS COMPONENTES A LOS PANELES
		cab.add(curso);
		
		iz.add(nombre);
		iz.add(tNombre);
		iz.add(apellido1);
		iz.add(tApell1);
		iz.add(apellido2);
		iz.add(tApell2);
		
		der.add(alumnos);
		
		baj.add(buscar);
		baj.add(aceptar);
		
		//ANADIR LOS PANELES A LA VENTANA
		this.add(cab, BorderLayout.NORTH);
		this.add(iz, BorderLayout.WEST);
		this.add(der, BorderLayout.CENTER);
		this.add(baj, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nombre, apellido1, apellido2;
		
		switch(e.getActionCommand()) {
		case Comandos.BUSCARV:
			nombre = tNombre.getText();
			apellido1 = tApell1.getText();
			apellido2 = tApell2.getText();
			
			if(nombre.compareTo("") !=0 && apellido1.compareTo("") !=0 && apellido2.compareTo("") !=0) {
				this.control.ejecutaComando(Comandos.BUSCARV,new AlumnoCurso(nombre, apellido1, apellido2, null, this.cursoS.getNombre(), 0) , null, null);
			}
			
			
		break;
		
		case Comandos.ACEPTARV:
			nombre = tNombre.getText();
			apellido1 = tApell1.getText();
			apellido2 = tApell2.getText();
			
			if(nombre.compareTo("") !=0 && apellido1.compareTo("") !=0 && apellido2.compareTo("") !=0) {
				this.control.ejecutaComando(Comandos.ACEPTARV,new AlumnoCurso(nombre, apellido1, apellido2, null, this.cursoS.getNombre(), 0) , null, null);
			}
		break;
		}
		
	}

	public void setAlumnos(String alumno) {
		this.alumnos.setText(alumno);
	}

	public Curso getCursoS() {
		return cursoS;
	}

	public void setCursoS(Curso cursoS) {
		this.cursoS = cursoS;
	}
	
	public void setETC(String cursoE) {
		this.curso.setText(cursoE);
	}
	
	public void borra() {
		this.tNombre.setText("");
		this.tApell1.setText("");
		this.tApell2.setText("");
		this.alumnos.setText("");
	}
	

}
