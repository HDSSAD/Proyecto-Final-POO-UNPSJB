package vista;

import controlador.CtrlEditarIntegrante;

public class VistaIntegranteEditar extends VistaIntegrante {

	private static final long serialVersionUID = 1L;
	
	private CtrlEditarIntegrante ctrlEditarIntegrante;

	public VistaIntegranteEditar(CtrlEditarIntegrante ctrlEditarIntegrante) {
		super();
		this.getTxtDNI().setEnabled(false);
		this.setCtrlEditarIntegrante(ctrlEditarIntegrante);
		this.getBtnAceptar().addActionListener(this.getCtrlEditarIntegrante());
		this.getBtnCancelar().addActionListener(this.getCtrlEditarIntegrante());
		
	}

	public CtrlEditarIntegrante getCtrlEditarIntegrante() {
		return ctrlEditarIntegrante;
	}

	public void setCtrlEditarIntegrante(CtrlEditarIntegrante ctrlEditarIntegrante) {
		this.ctrlEditarIntegrante = ctrlEditarIntegrante;
	}

}
