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
		this.getMntmIniciarSesion().addActionListener(this.getCtrlMainGUI());
		this.getTblIntegrantes().addMouseListener(this.getCtrlMainGUI());
		this.getBtnEliminar().addActionListener(this.getCtrlMainGUI());
		this.getBtnAnadir().addActionListener(this.getCtrlMainGUI());
		this.getBtnModificar().addActionListener(this.getCtrlMainGUI());
		this.getBtnBuscar().addActionListener(this.getCtrlMainGUI());
		this.getBtnMostrarTodo().addActionListener(this.getCtrlMainGUI());
		this.getTblPC().addMouseListener(this.getCtrlMainGUI());
		this.getBtnEliminarPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnA�adirPC().addActionListener(this.getCtrlMainGUI());
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