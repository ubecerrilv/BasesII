package bases.control;

import java.util.ArrayList;

import bases.modelo.Data;

public class ControlVPrincipal extends ControlAbs{

	@Override
	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas) {
		switch(c) {
		case Comandos.ESTUDIANTE:
			this.padre.ejecutaComando(Comandos.ESTUDIANTE, null,null, null);
		break;
		
		case Comandos.PROFESOR:
			this.padre.ejecutaComando(Comandos.PROFESOR, null,null, null);
		break;
		}
		return null;
	}

}
