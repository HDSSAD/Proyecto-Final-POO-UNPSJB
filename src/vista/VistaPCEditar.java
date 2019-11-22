package vista;

import controlador.CtrlPCEditar;

public class VistaPCEditar extends VistaPC {

	private static final long serialVersionUID = 1L;

	private CtrlPCEditar ctrlPCEditar;
	
	public VistaPCEditar(CtrlPCEditar ctrlPCEditar) {
		super();
		this.setCtrlPCEditar(ctrlPCEditar);
		this.getBtnAceptar().addActionListener(ctrlPCEditar);
		this.getBtnCancelar().addActionListener(ctrlPCEditar);
		this.getCboxSeleccionarIntegrante().addItemListener(ctrlPCEditar);
	}

	public CtrlPCEditar getCtrlPCEditar() {
		return ctrlPCEditar;
	}

	public void setCtrlPCEditar(CtrlPCEditar ctrlPCEditar) {
		this.ctrlPCEditar = ctrlPCEditar;
	}

}
