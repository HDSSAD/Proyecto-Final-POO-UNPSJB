package vista;

import controlador.CtrlIntegranteEditar;

public class VistaIntegranteEditar extends VistaIntegrante {

	private static final long serialVersionUID = 1L;
	
	private CtrlIntegranteEditar ctrlEditarIntegrante;

	public VistaIntegranteEditar(CtrlIntegranteEditar ctrlEditarIntegrante) {
		super();
		this.getTxtDNI().setEnabled(false);
		this.getPassfContraseña().setEnabled(false);
		this.getPassfContraseñaConfirmar().setEnabled(false);
		this.setCtrlEditarIntegrante(ctrlEditarIntegrante);
		this.getBtnAceptar().addActionListener(this.getCtrlEditarIntegrante());
		this.getBtnCancelar().addActionListener(this.getCtrlEditarIntegrante());
		
	}

	public CtrlIntegranteEditar getCtrlEditarIntegrante() {
		return ctrlEditarIntegrante;
	}

	public void setCtrlEditarIntegrante(CtrlIntegranteEditar ctrlEditarIntegrante) {
		this.ctrlEditarIntegrante = ctrlEditarIntegrante;
	}

}
