package bases.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bases.control.Comandos;


@SuppressWarnings("serial")
public class VentanaPrincipal extends VentanaAGeneral {

/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

	JPanel panelB;
	JButton btnEstu, btnProf;
	JLabel t;
	
			
/**********************************************************************************************************************************************
 * 
 * 																Mï¿½TODOS
 * 
 *********************************************************************************************************************************************/

	//CONSTRUCTOR PARA LA VENTANA
	public VentanaPrincipal() {
		super("¿Como le gustarÍa entrar?");
		
		//CREAR PANEL
		panelB = new JPanel(new GridLayout(1,1));
		panelB.setBorder(new EmptyBorder(5,5,5,5));
		
		//CREAR ETIQUETAS
		t = new JLabel("<html><center>Estás conectado a la base de datos de exámenes<html>");
		
		//CREAR BOTONES Y SUS ACCIONES
		btnEstu = new JButton("Soy estudiante");
		btnEstu.setActionCommand(Comandos.ESTUDIANTE);
		btnEstu.addActionListener(this);
		
		btnProf = new JButton("Soy profesor");
		btnProf.setActionCommand(Comandos.PROFESOR);
		btnProf.addActionListener(this);
		
		//AGREGAR BOTONES AL PANEL
		panelB.add(btnEstu);
		panelB.add(btnProf);
		
		//AGREGAR EL PANEL A LA VENTANA
		this.add(t, BorderLayout.NORTH);
		this.add(panelB, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()) {
		
		case Comandos.ESTUDIANTE:
			this.control.ejecutaComando(Comandos.ESTUDIANTE, null,null, null);
			break;
			
		case Comandos.PROFESOR:
			this.control.ejecutaComando(Comandos.PROFESOR, null,null,null);
			break;
		}

	}

}
