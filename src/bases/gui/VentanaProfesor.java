package bases.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bases.control.Comandos;
import bases.modelo.Curso;
import bases.modelo.Data;
import bases.modelo.Pregunta;
import bases.modelo.Respuesta;


@SuppressWarnings("serial")
public class VentanaProfesor extends VentanaAGeneral {

/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	JPanel c, g, aux, aux2;
	JPanel pDerecha, pCab;
	JPanel pIzquierda, pPR, pPR2;
	JComboBox<String> listaC;
	JLabel etCur, etCP, etCB, etP, etR, etCor, etB, vac;
	JTextArea tP;
	JTextField tR, tR1 , tR2, tR3, tR4;
	JButton crearE, consultarB, regresar;
	JCheckBox cb, cb1, cb2, cb3, cb4;
			
/**********************************************************************************************************************************************
 * 
 * 																Mï¿½TODOS
 * 
 *********************************************************************************************************************************************/

	public VentanaProfesor(String [] cursos) {
		super("¿Que acción le gustaría realizar?");
		
		
		//CREAR PANELES
		pCab= new JPanel(new GridLayout(3,2));
		pCab.setBorder(new EmptyBorder(5,5,50,5));
		
		pIzquierda = new JPanel(new GridLayout(5,1));
		pIzquierda.setBorder(new EmptyBorder(5,5,5,5));

		pDerecha = new JPanel(new GridLayout(2,1));
		pDerecha.setBorder(new EmptyBorder(5,5,5,5));
		
			//SUBPNEL
			pPR = new JPanel(new GridLayout(3,2));
			pPR2 = new JPanel(new GridLayout (3,1));
			
		//AUX
		aux = new JPanel(new GridLayout (1,1));
		aux.setBorder(new EmptyBorder(30,100,30,100));
		
		aux2 = new JPanel(new GridLayout (1,1));
		aux2.setBorder(new EmptyBorder(15,10,15,250));
		
		//CREAR ETIQUETAS
		etCur = new JLabel("SELECIONA EL CURSO: ");
		etCP = new JLabel("CREAR UNA NUEVA PREGUNTA PARA EL CURSO");
		etCB = new JLabel("CONSULTA LAS PREGUNTAS PARA EL CURSO");
		
		etP = new JLabel("<html><center>Pregunta:<html>");
		
		etB = new JLabel("");
		
		vac = new JLabel("");
		
		
			//ETIQUETAS DEL SUBPANEL
			etR= new JLabel("Respuestas");
			etCor= new JLabel("¿Correcta?");
		
			
		//CREAR COMBOBOX y CB
		listaC = new JComboBox<>(cursos);
		cb = new JCheckBox();
		cb1 = new JCheckBox();
		cb2 = new JCheckBox();
		cb3 = new JCheckBox();
		cb4 = new JCheckBox();
			
		//CREAR CAMPOS
		tP = new JTextArea();
		tP.setLineWrap(true);
		tP.setWrapStyleWord(true);
		
		tR = new JTextField();
		tR1 = new JTextField();
		tR2= new JTextField();
		tR3 = new JTextField();
		tR4 = new JTextField();
		
		
		//BOTONES Y SUS ACCIONES
		consultarB = new JButton("Consultar");
		consultarB.setActionCommand(Comandos.CONSULTARB);
		consultarB.setBounds(0,0,90,20);
		consultarB.addActionListener(this);
		
		crearE = new JButton("Crear una pregunta");
		crearE.setActionCommand(Comandos.CREARE);
		crearE.addActionListener(this);
		
		regresar= new JButton("<-  REGRESAR");
		regresar.setActionCommand(Comandos.REGRESARP);
		regresar.addActionListener(this);

		//AGREGAR OBJETOS A LOS PANELES
			//SUBPANEL CREAR PREGUNTA
			pPR.add(etR);
			pPR.add(etCor);
			pPR.add(tR);
			pPR.add(cb);
			pPR.add(tR1);
			pPR.add(cb1);
			pPR2.add(tR2);
			pPR2.add(cb2);
			pPR2.add(tR3);
			pPR2.add(cb3);
			pPR2.add(tR4);
			pPR2.add(cb4);
			
		//PANEL CABECERA
			//AUX
			aux2.add(regresar);
		pCab.add(aux2);
		pCab.add(vac);
		pCab.add(etCur);
		pCab.add(listaC);
		pCab.add(etCP);
		pCab.add(etCB);
		
		//PANEL IZQUIERDA
		pIzquierda.add(etP);
		pIzquierda.add(tP);
		pIzquierda.add(pPR);
		pIzquierda.add(pPR2);
		pIzquierda.add(crearE);
		
		pIzquierda.setBackground(Color.gray);
		
			//PANEL DERECHA
		aux.add(consultarB, BorderLayout.CENTER);
		pDerecha.add(aux);
		pDerecha.add(etB);
		
		
		//PANELES AUX
		c = new JPanel(new GridLayout(1,2));
		c.setBorder(new EmptyBorder(5,5,5,5));
		
		c.add(pIzquierda);
		c.add(pDerecha);
		
		g = new JPanel(new GridLayout(2,1));
		g.setBorder(new EmptyBorder(5,5,5,5));
		
		g.add(pCab);
		g.add(c);
		
		//AGREGAR EL PANEL A LA VENTANA
		this.add(g);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Curso curso;
		String nombre;
		ArrayList<Data> respuestas;
		
		switch(e.getActionCommand()) {
		case Comandos.CREARE:
			Pregunta pregunta = null;
			
			nombre = (String)listaC.getSelectedItem();
			curso = new Curso (nombre);
			respuestas = new ArrayList<Data>();
			
			//SI LA PREGUNTA Y LAS RESPUESTAS NO SON NULAS
			if(tR.getText().compareTo("") != 0 &&
			   tR1.getText().compareTo("") != 0 &&
			   tR2.getText().compareTo("") != 0 &&
			   tR3.getText().compareTo("") != 0 &&
			   tR4.getText().compareTo("") != 0 &&
			   tP.getText().compareTo("") != 0) {
				
				pregunta = new Pregunta(-1, this.tP.getText());
				
				respuestas.add(new Respuesta(tR.getText(), cb.isSelected()));
				respuestas.add(new Respuesta(tR1.getText(), cb1.isSelected()));
				respuestas.add(new Respuesta(tR2.getText(), cb2.isSelected()));
				respuestas.add(new Respuesta(tR3.getText(), cb3.isSelected()));
				respuestas.add(new Respuesta(tR4.getText(), cb4.isSelected()));
				
				control.ejecutaComando(Comandos.CREARE, pregunta, curso, respuestas);
				
			}
			
			
		break;
		
		case Comandos.CONSULTARB:
			nombre = (String)listaC.getSelectedItem();
			
			curso = new Curso (nombre);
			
			control.ejecutaComando(Comandos.CONSULTARB, curso, null, null);
		break;
		
		case Comandos.REGRESARP:
			this.control.ejecutaComando(Comandos.REGRESARP, null, null, null);
		break;
		
		}

	}
	

	public void setPreguntasT(String preguntas) {
		this.etB.setText(preguntas);
	}

	public void vaciar() {
		this.tP.setText("");
		this.tR.setText("");
		this.tR1.setText("");
		this.tR2.setText("");
		this.tR3.setText("");
		this.tR4.setText("");
		
		this.etB.setText("");
		
		this.cb.setSelected(false);
		this.cb1.setSelected(false);
		this.cb2.setSelected(false);
		this.cb3.setSelected(false);
		this.cb4.setSelected(false);

	}


	
	
	

}
