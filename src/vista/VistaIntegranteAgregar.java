package vista;

import controlador.CtrlAgregarIntegrante;

public class VistaIntegranteAgregar extends VistaIntegrante {

	private static final long serialVersionUID = 1L;

	private CtrlAgregarIntegrante ctrlAgregarIntegrante;
	
	public VistaIntegranteAgregar(CtrlAgregarIntegrante ctrlAgregarIntegrante) {
		super();
		this.setCtrlAgregarIntegrante(ctrlAgregarIntegrante);
		this.getBtnAceptar().addActionListener(this.getCtrlAgregarIntegrante());
		this.getBtnCancelar().addActionListener(this.getCtrlAgregarIntegrante());
		
	}

	public CtrlAgregarIntegrante getCtrlAgregarIntegrante() {
		return ctrlAgregarIntegrante;
	}

	public void setCtrlAgregarIntegrante(CtrlAgregarIntegrante ctrlAgregarIntegrante) {
		this.ctrlAgregarIntegrante = ctrlAgregarIntegrante;
	}
	
}
