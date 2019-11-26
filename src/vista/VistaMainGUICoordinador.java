package vista;

import controlador.CtrlMainCoordinador;

public class VistaMainGUICoordinador extends VistaMainGUI {

	private static final long serialVersionUID = 1L;
	private CtrlMainCoordinador ctrlMainGUI;

	public VistaMainGUICoordinador(CtrlMainCoordinador ctrlMainGUI) {
		super();
		this.setCtrlMainGUI(ctrlMainGUI);
		this.addWindowListener(this.getCtrlMainGUI());
		this.getMntmCerrarSesion().addActionListener(this.getCtrlMainGUI());
		this.getMntmCambiarContraseña().addActionListener(getCtrlMainGUI());
		this.getTblIntegrantes().addMouseListener(this.getCtrlMainGUI());
		this.getBtnEliminar().setEnabled(false);
		this.getBtnAnadir().addActionListener(this.getCtrlMainGUI());
		this.getBtnModificar().addActionListener(this.getCtrlMainGUI());
		this.getBtnBuscar().addActionListener(this.getCtrlMainGUI());
		this.getBtnMostrarTodo().addActionListener(this.getCtrlMainGUI());
		this.getTblPC().addMouseListener(this.getCtrlMainGUI());
		this.getBtnEliminarPC().setEnabled(false);
		this.getBtnAñadirPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnEditarPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnBuscarPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnMostrarTodoPC().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePersonalTodos().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePCCompletada().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePCDescartada().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePCDonadas().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePCPendiente().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePCRevisada().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePersonalAdmin().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePersonalCoord().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePersonalCumpleaños().addActionListener(this.getCtrlMainGUI());
		this.getBtnReportePersonalIntegr().addActionListener(this.getCtrlMainGUI());

	}

	public CtrlMainCoordinador getCtrlMainGUI() {
		return ctrlMainGUI;
	}

	public void setCtrlMainGUI(CtrlMainCoordinador ctrlMainGUI) {
		this.ctrlMainGUI = ctrlMainGUI;
	}

}
