package bases.gui;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import bases.control.Control;

@SuppressWarnings("serial")
public abstract class VentanaAGeneral extends JFrame implements ActionListener {

/**********************************************************************************************************************************************
 * 
 * 																ATRIBUTOS
 * 
 *********************************************************************************************************************************************/

			Control control;
		
/**********************************************************************************************************************************************
 * 
 * 																MÉTODOS
 * 
 *********************************************************************************************************************************************/

		public VentanaAGeneral(String titulo) {
			super(titulo);
		}
			
		
		public VentanaAGeneral() {
			super();
		}
			
		
		public void setControl(Control control) {
			this.control = control;
		}
}//FIN CLASE
