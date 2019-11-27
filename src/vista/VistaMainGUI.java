package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class VistaMainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblIntegrantes;
	private JButton btnModificar;
	private JButton btnAnadir;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnMostrarTodo;
	private ArrayList<JTextField> arrayTextField = new ArrayList<JTextField>();
	private JTextField txtDNI;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtFechaNacimiento;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtTelefono2;
	private JTextField txtCorreo;
	private JTextField txtComputadorasTrabajadas;
	private JMenuItem mntmCerrarSesion;
	private JTextField txtTipoIntegrante;
	private JTable tblPC;
	private JTextPane txtpnDatospc;
	private JButton btnBuscarPC;
	private JButton btnMostrarTodoPC;
	private JButton btnEditarPC;
	private JButton btnAñadirPC;
	private JButton btnEliminarPC;
	private JMenuItem mntmCambiarContraseña;
	private JPanel panel;
	private JButton btnReportePersonalTodos;
	private JButton btnReportePersonalAdmin;
	private JButton btnReportePersonalCoord;
	private JButton btnReportePersonalIntegr;
	private JButton btnReportePersonalCumpleaños;
	private JButton btnReportePCDonadas;
	private JButton btnReportePCDescartada;
	private JButton btnReportePCCompletada;
	private JButton btnReportePCRevisada;
	private JButton btnReportePCPendiente;
	
	public VistaMainGUI() {
		this.setTitle("Gestor Puente");
//		this.setModal(true);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 734, 22);
		contentPane.add(menuBar);

		JMenu mnSesion = new JMenu("Sesion");
		menuBar.add(mnSesion);

		mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mnSesion.add(mntmCerrarSesion);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		mntmCambiarContraseña = new JMenuItem("Cambiar Contrase\u00F1a");
		mnUsuario.add(mntmCambiarContraseña);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 33, 664, 417);
		contentPane.add(tabbedPane);

		JPanel panelIntegrantes = new JPanel();
		tabbedPane.addTab("Integrantes", null, panelIntegrantes, null);
		panelIntegrantes.setLayout(null);

		JScrollPane scrlpIntegrantes = new JScrollPane();
		scrlpIntegrantes.setBounds(10, 11, 250, 335);
		panelIntegrantes.add(scrlpIntegrantes);

		tblIntegrantes = new JTable();
		tblIntegrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIntegrantes.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"DNI", "Apellido y Nombre"}));
		tblIntegrantes.getColumnModel().getColumn(0).setMaxWidth(70);
		tblIntegrantes.getColumnModel().getColumn(0).setMinWidth(70);
		tblIntegrantes.getColumnModel().getColumn(0).setResizable(false);
		tblIntegrantes.getColumnModel().getColumn(1).setResizable(false);
		
		scrlpIntegrantes.setViewportView(tblIntegrantes);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(560, 355, 89, 23);
		panelIntegrantes.add(btnEliminar);

		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setBounds(461, 355, 89, 23);
		panelIntegrantes.add(btnAnadir);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(362, 355, 89, 23);
		panelIntegrantes.add(btnModificar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 355, 89, 23);
		panelIntegrantes.add(btnBuscar);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.setBounds(111, 355, 110, 23);
		panelIntegrantes.add(btnMostrarTodo);

		JPanel panelIntegrantesDatos = new JPanel();
		panelIntegrantesDatos.setBounds(270, 11, 379, 335);
		panelIntegrantes.add(panelIntegrantesDatos);
		panelIntegrantesDatos.setLayout(null);
		
		JLabel lblTipoIntegrante = new JLabel("Tipo Integrante");
		lblTipoIntegrante.setBounds(12, 12, 155, 16);
		panelIntegrantesDatos.add(lblTipoIntegrante);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(12, 40, 155, 14);
		panelIntegrantesDatos.add(lblDNI);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 66, 155, 14);
		panelIntegrantesDatos.add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 92, 155, 14);
		panelIntegrantesDatos.add(lblNombre);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(12, 118, 155, 14);
		panelIntegrantesDatos.add(lblFechaNacimiento);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 144, 155, 14);
		panelIntegrantesDatos.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 170, 155, 14);
		panelIntegrantesDatos.add(lblTelefono);

		JLabel lblTelefono_1 = new JLabel("Telefono 2");
		lblTelefono_1.setBounds(12, 196, 155, 14);
		panelIntegrantesDatos.add(lblTelefono_1);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(12, 222, 155, 14);
		panelIntegrantesDatos.add(lblCorreo);

		JLabel lblComputadorasTrabajadas = new JLabel("Computadoras Trabajadas");
		lblComputadorasTrabajadas.setBounds(12, 248, 155, 14);
		panelIntegrantesDatos.add(lblComputadorasTrabajadas);
		
		txtTipoIntegrante = new JTextField();
		txtTipoIntegrante.setEditable(false);
		txtTipoIntegrante.setBounds(177, 12, 192, 20);
		panelIntegrantesDatos.add(txtTipoIntegrante);
		txtTipoIntegrante.setColumns(10);
//		arrayTextField.add(txtTipoIntegrante);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(177, 39, 192, 20);
		panelIntegrantesDatos.add(txtDNI);
		txtDNI.setColumns(10);
		arrayTextField.add(txtDNI);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(177, 65, 192, 20);
		panelIntegrantesDatos.add(txtApellido);
		txtApellido.setColumns(10);
		arrayTextField.add(txtApellido);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(177, 91, 192, 20);
		panelIntegrantesDatos.add(txtNombre);
		txtNombre.setColumns(10);
		arrayTextField.add(txtNombre);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setEditable(false);
		txtFechaNacimiento.setBounds(177, 117, 192, 20);
		panelIntegrantesDatos.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		arrayTextField.add(txtFechaNacimiento);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(177, 143, 192, 20);
		panelIntegrantesDatos.add(txtDireccion);
		txtDireccion.setColumns(10);
		arrayTextField.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(177, 169, 192, 20);
		panelIntegrantesDatos.add(txtTelefono);
		txtTelefono.setColumns(10);
		arrayTextField.add(txtTelefono);

		txtTelefono2 = new JTextField();
		txtTelefono2.setEditable(false);
		txtTelefono2.setBounds(177, 195, 192, 20);
		panelIntegrantesDatos.add(txtTelefono2);
		txtTelefono2.setColumns(10);
		arrayTextField.add(txtTelefono2);

		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(177, 221, 192, 20);
		panelIntegrantesDatos.add(txtCorreo);
		txtCorreo.setColumns(10);
		arrayTextField.add(txtCorreo);

		txtComputadorasTrabajadas = new JTextField();
		txtComputadorasTrabajadas.setEditable(false);
		txtComputadorasTrabajadas.setBounds(177, 247, 192, 20);
		panelIntegrantesDatos.add(txtComputadorasTrabajadas);
		txtComputadorasTrabajadas.setColumns(10);
		
		JPanel panelComputadoras = new JPanel();
		panelComputadoras.setForeground(SystemColor.info);
		panelComputadoras.setLayout(null);
		tabbedPane.addTab("Computadoras", null, panelComputadoras, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 250, 335);
		panelComputadoras.add(scrollPane);
		
		tblPC = new JTable();
		tblPC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPC.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Estado"}));
		tblPC.getColumnModel().getColumn(0).setResizable(false);
		tblPC.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tblPC);
		
		btnEliminarPC = new JButton("Eliminar");
		btnEliminarPC.setBounds(558, 355, 89, 23);
		panelComputadoras.add(btnEliminarPC);
		
		btnAñadirPC = new JButton("A\u00F1adir");
		btnAñadirPC.setBounds(459, 355, 89, 23);
		panelComputadoras.add(btnAñadirPC);
		
		btnEditarPC = new JButton("Modificar");
		btnEditarPC.setBounds(360, 355, 89, 23);
		panelComputadoras.add(btnEditarPC);
		
		btnBuscarPC = new JButton("Buscar");
		btnBuscarPC.setBounds(10, 355, 89, 23);
		panelComputadoras.add(btnBuscarPC);
		
		btnMostrarTodoPC = new JButton("Mostrar Todo");
		btnMostrarTodoPC.setBounds(111, 355, 110, 23);
		panelComputadoras.add(btnMostrarTodoPC);
		
		txtpnDatospc = new JTextPane();
		txtpnDatospc.setBackground(SystemColor.text);
		txtpnDatospc.setEditable(false);
		txtpnDatospc.setText("DatosPC");
		txtpnDatospc.setBounds(270, 11, 377, 335);
		panelComputadoras.add(txtpnDatospc);
		
		panel = new JPanel();
		tabbedPane.addTab("Reportes", null, panel, null);
		panel.setLayout(null);
		
		JPanel panelReportesIntegrantes = new JPanel();
		panelReportesIntegrantes.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panelReportesIntegrantes.setBounds(10, 11, 310, 367);
		panel.add(panelReportesIntegrantes);
		panelReportesIntegrantes.setLayout(null);
		
		JLabel lblReportesPersonal = new JLabel("Personal");
		lblReportesPersonal.setBounds(10, 11, 57, 14);
		panelReportesIntegrantes.add(lblReportesPersonal);
		
		btnReportePersonalTodos = new JButton("Todos");
		btnReportePersonalTodos.setBounds(10, 36, 165, 23);
		panelReportesIntegrantes.add(btnReportePersonalTodos);
		
		btnReportePersonalAdmin = new JButton("Administradores");
		btnReportePersonalAdmin.setBounds(10, 70, 165, 23);
		panelReportesIntegrantes.add(btnReportePersonalAdmin);
		
		btnReportePersonalCoord = new JButton("Coordinadores");
		btnReportePersonalCoord.setBounds(10, 104, 165, 23);
		panelReportesIntegrantes.add(btnReportePersonalCoord);
		
		btnReportePersonalIntegr = new JButton("Integrantes");
		btnReportePersonalIntegr.setBounds(10, 138, 165, 23);
		panelReportesIntegrantes.add(btnReportePersonalIntegr);
		
		btnReportePersonalCumpleaños = new JButton("Cumplea\u00F1os este mes");
		btnReportePersonalCumpleaños.setBounds(10, 172, 165, 23);
		panelReportesIntegrantes.add(btnReportePersonalCumpleaños);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_1.setLayout(null);
		panel_1.setBounds(339, 11, 310, 367);
		panel.add(panel_1);
		
		JLabel lblComputadoras = new JLabel("Computadoras");
		lblComputadoras.setBounds(10, 11, 85, 14);
		panel_1.add(lblComputadoras);
		
		btnReportePCPendiente = new JButton("Pendientes");
		btnReportePCPendiente.setBounds(10, 36, 165, 23);
		panel_1.add(btnReportePCPendiente);
		
		btnReportePCRevisada = new JButton("Revisadas");
		btnReportePCRevisada.setBounds(10, 70, 165, 23);
		panel_1.add(btnReportePCRevisada);
		
		btnReportePCCompletada = new JButton("Completadas");
		btnReportePCCompletada.setBounds(10, 104, 165, 23);
		panel_1.add(btnReportePCCompletada);
		
		btnReportePCDescartada = new JButton("Descartadas");
		btnReportePCDescartada.setBounds(10, 138, 165, 23);
		panel_1.add(btnReportePCDescartada);
		
		btnReportePCDonadas = new JButton("Donadas");
		btnReportePCDonadas.setBounds(10, 172, 165, 23);
		panel_1.add(btnReportePCDonadas);
		
	}

	public JButton getBtnReportePersonalTodos() {
		return btnReportePersonalTodos;
	}

	public void setBtnReportePersonalTodos(JButton btnReportePersonalTodos) {
		this.btnReportePersonalTodos = btnReportePersonalTodos;
	}

	public JButton getBtnReportePersonalAdmin() {
		return btnReportePersonalAdmin;
	}

	public void setBtnReportePersonalAdmin(JButton btnReportePersonalAdmin) {
		this.btnReportePersonalAdmin = btnReportePersonalAdmin;
	}

	public JButton getBtnReportePersonalCoord() {
		return btnReportePersonalCoord;
	}

	public void setBtnReportePersonalCoord(JButton btnReportePersonalCoord) {
		this.btnReportePersonalCoord = btnReportePersonalCoord;
	}

	public JButton getBtnReportePersonalIntegr() {
		return btnReportePersonalIntegr;
	}

	public void setBtnReportePersonalIntegr(JButton btnReportePersonalIntegr) {
		this.btnReportePersonalIntegr = btnReportePersonalIntegr;
	}

	public JButton getBtnReportePersonalCumpleaños() {
		return btnReportePersonalCumpleaños;
	}

	public void setBtnReportePersonalCumpleaños(JButton btnReportePersonalCumpleaños) {
		this.btnReportePersonalCumpleaños = btnReportePersonalCumpleaños;
	}

	public JButton getBtnReportePCDonadas() {
		return btnReportePCDonadas;
	}

	public void setBtnReportePCDonadas(JButton btnReportePCDonadas) {
		this.btnReportePCDonadas = btnReportePCDonadas;
	}

	public JButton getBtnReportePCDescartada() {
		return btnReportePCDescartada;
	}

	public void setBtnReportePCDescartada(JButton btnReportePCDescartada) {
		this.btnReportePCDescartada = btnReportePCDescartada;
	}

	public JButton getBtnReportePCCompletada() {
		return btnReportePCCompletada;
	}

	public void setBtnReportePCCompletada(JButton btnReportePCCompletada) {
		this.btnReportePCCompletada = btnReportePCCompletada;
	}

	public JButton getBtnReportePCRevisada() {
		return btnReportePCRevisada;
	}

	public void setBtnReportePCRevisada(JButton btnReportePCRevisada) {
		this.btnReportePCRevisada = btnReportePCRevisada;
	}

	public JButton getBtnReportePCPendiente() {
		return btnReportePCPendiente;
	}

	public void setBtnReportePCPendiente(JButton btnReportePCPendiente) {
		this.btnReportePCPendiente = btnReportePCPendiente;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTable getTblIntegrantes() {
		return tblIntegrantes;
	}

	public void setTblIntegrantes(JTable tblIntegrantes) {
		this.tblIntegrantes = tblIntegrantes;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtTelefono2() {
		return txtTelefono2;
	}

	public void setTxtTelefono2(JTextField txtTelefono2) {
		this.txtTelefono2 = txtTelefono2;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtComputadorasTrabajadas() {
		return txtComputadorasTrabajadas;
	}

	public void setTxtComputadorasTrabajadas(JTextField txtComputadorasTrabajadas) {
		this.txtComputadorasTrabajadas = txtComputadorasTrabajadas;
	}

	public ArrayList<JTextField> getArrayTextField() {
		return arrayTextField;
	}

	public void setArrayTextField(ArrayList<JTextField> arrayTextField) {
		this.arrayTextField = arrayTextField;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnMostrarTodo() {
		return btnMostrarTodo;
	}

	public JMenuItem getMntmCerrarSesion() {
		return mntmCerrarSesion;
	}

	public JTextField getTxtTipoIntegrante() {
		return txtTipoIntegrante;
	}

	public void setTxtTipoIntegrante(JTextField txtTipoIntegrante) {
		this.txtTipoIntegrante = txtTipoIntegrante;
	}

	public JTable getTblPC() {
		return tblPC;
	}

	public JTextPane getTxtpnDatospc() {
		return txtpnDatospc;
	}

	public JButton getBtnBuscarPC() {
		return btnBuscarPC;
	}

	public JButton getBtnMostrarTodoPC() {
		return btnMostrarTodoPC;
	}

	public JButton getBtnEditarPC() {
		return btnEditarPC;
	}

	public JButton getBtnAñadirPC() {
		return btnAñadirPC;
	}

	public JButton getBtnEliminarPC() {
		return btnEliminarPC;
	}

	public JMenuItem getMntmCambiarContraseña() {
		return mntmCambiarContraseña;
	}

	public void setMntmCambiarContraseña(JMenuItem mntmCambiarContraseña) {
		this.mntmCambiarContraseña = mntmCambiarContraseña;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public void setBtnMostrarTodo(JButton btnMostrarTodo) {
		this.btnMostrarTodo = btnMostrarTodo;
	}

	public void setMntmCerrarSesion(JMenuItem mntmCerrarSesion) {
		this.mntmCerrarSesion = mntmCerrarSesion;
	}

	public void setTblPC(JTable tblPC) {
		this.tblPC = tblPC;
	}

	public void setTxtpnDatospc(JTextPane txtpnDatospc) {
		this.txtpnDatospc = txtpnDatospc;
	}

	public void setBtnBuscarPC(JButton btnBuscarPC) {
		this.btnBuscarPC = btnBuscarPC;
	}

	public void setBtnMostrarTodoPC(JButton btnMostrarTodoPC) {
		this.btnMostrarTodoPC = btnMostrarTodoPC;
	}

	public void setBtnEditarPC(JButton btnEditarPC) {
		this.btnEditarPC = btnEditarPC;
	}

	public void setBtnAñadirPC(JButton btnAñadirPC) {
		this.btnAñadirPC = btnAñadirPC;
	}

	public void setBtnEliminarPC(JButton btnEliminarPC) {
		this.btnEliminarPC = btnEliminarPC;
	}
}
