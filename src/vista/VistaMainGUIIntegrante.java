package vista;

import controlador.CtrlMainIntegrante;

public class VistaMainGUIIntegrante extends VistaMainGUI {

	private static final long serialVersionUID = 1L;
	private CtrlMainIntegrante ctrlMainGUI;

	public VistaMainGUIIntegrante(CtrlMainIntegrante ctrlMainGUI) {
		super();
		this.setCtrlMainGUI(ctrlMainGUI);
		this.addWindowListener(this.getCtrlMainGUI());
		this.getMntmCerrarSesion().addActionListener(this.getCtrlMainGUI());
		this.getMntmCambiarContraseña().addActionListener(getCtrlMainGUI());
		this.getTblIntegrantes().addMouseListener(this.getCtrlMainGUI());
		this.getBtnEliminar().setEnabled(false);
		this.getBtnAnadir().setEnabled(false);
		this.getBtnModificar().addActionListener(this.getCtrlMainGUI());
		this.getBtnBuscar().addActionListener(this.getCtrlMainGUI());
		this.getBtnMostrarTodo().addActionListener(this.getCtrlMainGUI());
		this.getTblPC().addMouseListener(this.getCtrlMainGUI());
		this.getBtnEliminarPC().setEnabled(false);
		this.getBtnAñadirPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnEditarPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnBuscarPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnMostrarTodoPC().addActionListener(this.getCtrlMainGUI());

	}

	public CtrlMainIntegrante getCtrlMainGUI() {
		return ctrlMainGUI;
	}

	public void setCtrlMainGUI(CtrlMainIntegrante ctrlMainGUI) {
		this.ctrlMainGUI = ctrlMainGUI;
	}

}
