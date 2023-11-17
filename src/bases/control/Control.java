package bases.control;

import java.util.ArrayList;

import bases.modelo.Data;

public interface Control {

	public Data ejecutaComando(String c, Data d, Data d2, ArrayList<Data> respuestas);
	void setCP(Control c);
}
