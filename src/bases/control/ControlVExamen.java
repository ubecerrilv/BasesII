package bases.control;

import java.util.ArrayList;

import bases.modelo.Data;

public class ControlVExamen extends ControlAbs {

	@Override
	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas) {
		switch (c) {
		case Comandos.CALIFICAR:
			this.padre.ejecutaComando(Comandos.CALIFICAR, null, null, null);
		break;
		}
		return null;
	}

}
