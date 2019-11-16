package vista;

import controlador.CtrlIntegranteAgregar;

public class VistaIntegranteAgregar extends VistaIntegrante {

	private static final long serialVersionUID = 1L;

	private CtrlIntegranteAgregar ctrlAgregarIntegrante;
	
	public VistaIntegranteAgregar(CtrlIntegranteAgregar ctrlAgregarIntegrante) {
		super();
		this.setCtrlAgregarIntegrante(ctrlAgregarIntegrante);
		this.getBtnAceptar().addActionListener(this.getCtrlAgregarIntegrante());
		this.getBtnCancelar().addActionListener(this.getCtrlAgregarIntegrante());
		
	}

	public CtrlIntegranteAgregar getCtrlAgregarIntegrante() {
		return ctrlAgregarIntegrante;
	}

	public void setCtrlAgregarIntegrante(CtrlIntegranteAgregar ctrlAgregarIntegrante) {
		this.ctrlAgregarIntegrante = ctrlAgregarIntegrante;
	}
	
}
