package vista;

import controlador.CtrlPCAgregar;

public class VistaPCAgregar extends VistaPC {

	private static final long serialVersionUID = 1L;

	private CtrlPCAgregar ctrlPCAgregar;
	
	public VistaPCAgregar(CtrlPCAgregar ctrlPCAgregar) {
		super();
		this.setCtrlPCAgregar(ctrlPCAgregar);
		this.getBtnAceptar().addActionListener(ctrlPCAgregar);
		this.getBtnCancelar().addActionListener(ctrlPCAgregar);
	}

	public CtrlPCAgregar getCtrlPCAgregar() {
		return ctrlPCAgregar;
	}

	public void setCtrlPCAgregar(CtrlPCAgregar ctrlPCAgregar) {
		this.ctrlPCAgregar = ctrlPCAgregar;
	}

}
