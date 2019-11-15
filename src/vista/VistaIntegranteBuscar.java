package vista;

import controlador.CtrlBuscarIntegrante;

public class VistaIntegranteBuscar extends VistaIntegrante {
	
	private static final long serialVersionUID = 1L;
	
	private CtrlBuscarIntegrante ctrlBusarIntegrante;

	public VistaIntegranteBuscar(CtrlBuscarIntegrante ctrlBuscarIntegrante) {
		super();
		this.setCtrlBusarIntegrante(ctrlBuscarIntegrante);
		this.getBtnAceptar().addActionListener(this.getCtrlBusarIntegrante());
		this.getBtnCancelar().addActionListener(this.getCtrlBusarIntegrante());
	}

	public CtrlBuscarIntegrante getCtrlBusarIntegrante() {
		return ctrlBusarIntegrante;
	}

	public void setCtrlBusarIntegrante(CtrlBuscarIntegrante ctrlBusarIntegrante) {
		this.ctrlBusarIntegrante = ctrlBusarIntegrante;
	}

}
