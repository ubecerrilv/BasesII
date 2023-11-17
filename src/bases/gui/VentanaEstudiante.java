package bases.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import bases.control.Comandos;
import bases.modelo.AlumnoCurso;
import bases.modelo.Curso;
import bases.modelo.Examen;
import bases.modelo.data.PreguntaDAO;

@SuppressWarnings("serial")
public class VentanaEstudiante extends VentanaAGeneral {
	
/**********************************************************************************************************************************************
* 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

		JPanel cab, baj, aux2, al;
		JLabel etSC, vac, idA;
		JLabel etIDE, alumnot;
		JLabel idat, alumnon;
		JComboBox<String> cursos;
		JButton buscarAl, empE, regresar;
		JTextArea nP;
		String [] aux;
		
		Connection conn;
				
/**********************************************************************************************************************************************
 * 
 * 																MÉTODOS
 * 
 *********************************************************************************************************************************************/

	public VentanaEstudiante(String [] cursosS, Connection conn) {
		super("Contestar examen");
		
		this.conn = conn;
		
		//CREAR PANELES
		cab = new JPanel(new GridLayout(3,2));
		cab.setBorder(new EmptyBorder(5,5,5,5));
		
		baj = new JPanel(new GridLayout(1,1));
	    baj.setBorder(new EmptyBorder(5,300,5,300));
	    
	    aux2 = new JPanel(new GridLayout (1,1));
		aux2.setBorder(new EmptyBorder(5,5,5,350));
		
		al = new JPanel(new GridLayout(2,2));
		al.setBorder(new EmptyBorder(5,5,5,5));
		al.setBackground(Color.GRAY);
	    
	    //CREAR BOTONES
	    buscarAl = new JButton("Buscar alumnos en el curso");
	    buscarAl.setActionCommand(Comandos.BUSCARAL);
	    buscarAl.addActionListener(this);
	    
	    empE = new JButton("Empezar examen");
	    empE.setActionCommand(Comandos.EMPEZARE);
	    empE.addActionListener(this);
	    empE.setBackground(Color.CYAN);
	    
	    regresar = new JButton("<-   REGRESAR");
	    regresar.setActionCommand(Comandos.REGRESARP);
	    regresar.addActionListener(this);
	    
	    
	    //CREAR COMBOBOX
	    cursos = new JComboBox<>(cursosS);
	    
	    //CREAR ETIQUETAS
	    etSC = new JLabel("Selecciona curso:");
	    etIDE = new JLabel("Ingresa el número de preguntas:");
	    
	    vac = new JLabel("");
	    
	    idat = new JLabel("");
	    idA = new JLabel("");
	    alumnot = new JLabel("");
	    alumnon = new JLabel("");
	    
	    //CREAR CAMPO DE TEXTO
	    nP = new JTextArea();
	    
	    //AÑADIR LOS COMPONENTES A LOS PANELES
	    	//AUX
	    	aux2.add(regresar);
	    	aux2.add(vac);
	
	    	al.add(idat);
	    	al.add(idA);
	    	al.add(alumnot);
	    	al.add(alumnon);
	    	
	    cab.add(etSC);
	    cab.add(cursos);
	    cab.add(buscarAl);
	    cab.add(al);
	    cab.add(etIDE);
	    cab.add(nP);
	    
	    cab.setBackground(Color.gray);
	    
	    baj.add(empE);
	    
	    //AÑADIR LOS PANELES A LA VENTANA
	    this.add(aux2, BorderLayout.NORTH);
	    this.add(cab, BorderLayout.CENTER);
	    this.add(baj, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
		
		case Comandos.BUSCARAL:
			
			this.etIDE.setText("Ingresa el número de preguntas:");
			
			String act = this.etIDE.getText();
			String curso1 = (String)this.cursos.getSelectedItem();
			
			this.etIDE.setText("<html>"+act +"<br>Máximo: "+ new PreguntaDAO(this.conn).rMax(curso1)+"<html>");
			
			
			Curso curso = new Curso((String)this.cursos.getSelectedItem());
			
			this.control.ejecutaComando(Comandos.BUSCARAL, curso, null, null);
			
			
		break;
		
		case Comandos.EMPEZARE:
			if(this.nP.getText().compareToIgnoreCase("")!=0) {
				Examen examen = new Examen(Integer.parseInt(this.nP.getText()));
				
				
				
				AlumnoCurso acurso = new AlumnoCurso(null,null,null,null, (String)this.cursos.getSelectedItem(),Integer.parseInt(this.idA.getText()));
				
				this.control.ejecutaComando(Comandos.EMPEZARE, examen, acurso, null);
			}
			
		break;
		
		case Comandos.REGRESARP:
			this.control.ejecutaComando(Comandos.REGRESARP,null, null, null);
		break;
		
		}
		
	}

	public void setVacio(AlumnoCurso alumnocurso) {
		this.idat.setText("ID: ");
		this.idA.setText(""+alumnocurso.getId());
		this.alumnot.setText("Alumno: ");
		this.alumnon.setText(alumnocurso.toNombre());
	}
	
	public void limpia() {
		this.etIDE.setText("Ingresa el número de preguntas:");
		this.idat.setText("");
		this.nP.setText("");
		this.idA.setText("");
		this.alumnot.setText("");
		this.alumnon.setText("");
	}

	public JLabel getVacio() {
		return idat;
	}

	
	public void setidA (String idAl) {
		this.idA.setText(idAl);
	}
	

}
