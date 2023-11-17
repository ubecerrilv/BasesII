package bases.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bases.control.Comandos;
import bases.modelo.PR;
import bases.modelo.Pregunta;
import bases.modelo.Respuesta;

@SuppressWarnings("serial")
public class VentanaExamen extends VentanaAGeneral {
	
	JPanel cab, cent, baj;
	JButton sig, calf;
	JLabel e1,e2,e3,e4,e5, r;
	JCheckBox c1,c2,c3,c4,c5;
	ArrayList<PR> pr, pra;
	int i = 1;
	int buenas =0;
	
	public VentanaExamen() {
		super("Examen");
		
		//CREAR PANELES
		cab = new JPanel(new GridLayout(1,1));//PREGUNTA
		cab.setBorder(new EmptyBorder(5,5,5,5));
		
		cent = new JPanel(new GridLayout(5,2));//RESPUESTAS
		cent.setBorder(new EmptyBorder(5,5,5,5));
		
		baj = new JPanel(new GridLayout(1,2));
		baj.setBorder(new EmptyBorder(5,5,5,5));
		
		//CREAR ETIQUETAS
		r = new JLabel("");
		e1 = new JLabel("");
		e2 = new JLabel("");
		e3 = new JLabel("");
		e4 = new JLabel("");
		e5 = new JLabel("");
		
		//CREAR CHECKBOX
		c1 = new JCheckBox();
		c2 = new JCheckBox();
		c3 = new JCheckBox();
		c4 = new JCheckBox();
		c5 = new JCheckBox();
		
		//CREAR BOTONES
	    
	    sig = new JButton("Siguiente pregunta ->");
	    sig.setActionCommand(Comandos.SIGUIENTE);
	    sig.addActionListener(this);
	    
	    calf = new JButton("Calificar examen");
	    calf.setActionCommand(Comandos.CALIFICAR);
	    calf.addActionListener(this);
	    calf.setBackground(Color.magenta);
	    		
	    cab.add(r);
	    
	    cent.add(e1);
	    cent.add(c1);
	    cent.add(e2);
	    cent.add(c2);
	    cent.add(e3);
	    cent.add(c3);
	    cent.add(e4);
	    cent.add(c4);
	    cent.add(e5);
	    cent.add(c5);

	    baj.add(sig);
	    baj.add(calf);
	    
	    this.add(cab, BorderLayout.NORTH);
	    this.add(cent, BorderLayout.WEST);
	    this.add(baj, BorderLayout.SOUTH);
	    
	    pra = new ArrayList<PR>();
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()) {
		
		case Comandos.SIGUIENTE:
			
			if(pr.size()>=i) {
				ArrayList<Respuesta> res = new ArrayList<Respuesta>();
				
				res.add(new Respuesta(e1.getText(), c1.isSelected()));
				res.add(new Respuesta(e2.getText(), c2.isSelected()));
				res.add(new Respuesta(e3.getText(), c3.isSelected()));
				res.add(new Respuesta(e4.getText(), c4.isSelected()));
				res.add(new Respuesta(e5.getText(), c5.isSelected()));
				
				pra.add(new PR(new Pregunta(0, r.getText()),res));
			
			
				if(pr.size()>i) {
			
						setPregunta(this.pr, this.i);
							setCH();
								this.i++;
				}
			}
		break;
		
		case Comandos.CALIFICAR:
		
			String correcta = "";
			String  res = "";
			
			
			
			for(int p =0; this.pr.size()>p; p++) {
				for(int j=0; pr.get(p).getRespuestas().size()>j; j++) {

					if(pr.get(p).getRespuestas().get(j).getCor() == 1) {
						
						correcta = pr.get(p).getRespuestas().get(j).getDescrpcion();

					}
				}
				
				for(int y=0; pra.get(p).getRespuestas().size()>y; y++) {

					if(pra.get(p).getRespuestas().get(y).getCor() == 1) {
						
						res = pra.get(p).getRespuestas().get(y).getDescrpcion();
					}
				}
				
				if(correcta.compareTo(res)==0) {
					buenas++;
				}
				
			}
			
		
			
			
			int cali = (this.buenas*10)/pr.size();
			
			JOptionPane.showMessageDialog(this, "Tu calificación es de "+cali);
			
			this.control.ejecutaComando(Comandos.CALIFICAR, null, null,null);
			this.setVisible(false);
			
		break;
		
		}
	}

	public JPanel getCab() {
		return cab;
	}

	public void setCab(JPanel cab) {
		this.cab = cab;
	}

	public JPanel getCent() {
		return cent;
	}

	public void setCent(JPanel cent) {
		this.cent = cent;
	}
	
	
	public void setPr(ArrayList<PR> pr) {
		this.pr = pr;
	}

	public void setPregunta(ArrayList<PR> pr, int i) {
		this.r.setText(pr.get(i).getPregunta().getPlanteamiento());
		this.e1.setText(pr.get(i).getRespuestas().get(0).getDescrpcion());
		this.e2.setText(pr.get(i).getRespuestas().get(1).getDescrpcion());
		this.e3.setText(pr.get(i).getRespuestas().get(2).getDescrpcion());
		this.e4.setText(pr.get(i).getRespuestas().get(3).getDescrpcion());
		this.e5.setText(pr.get(i).getRespuestas().get(4).getDescrpcion());
	}

	public void setCH() {
		c1.setSelected(false);
		c5.setSelected(false);
		c2.setSelected(false);
		c3.setSelected(false);
		c4.setSelected(false);
	}
	
	
	
}
