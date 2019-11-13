package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.CtrlMain;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private CtrlMain ctrlMainGUI;
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
	private JMenuItem mntmIniciarSesion;
	private JTextField txtLegajo;
	private JTable tblPC;
	private JTextPane txtpnDatospc;
	private JButton btnBuscarPC;
	private JButton btnMostrarTodoPC;
	private JButton btnEditarPC;
	private JButton btnAñadirPC;
	private JButton btnEliminarPC;
	
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

	public MainGUI(CtrlMain ctrlMainGUI) {
		this.setctrlMainGUI(ctrlMainGUI);
		this.setTitle("Gestor Puente");
		this.addWindowListener(this.getctrlMainGUI());
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 734, 22);
		contentPane.add(menuBar);

		JMenu mnSesion = new JMenu("Sesion");
		menuBar.add(mnSesion);

		mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mntmCerrarSesion.addActionListener(this.getctrlMainGUI());
		
		mntmIniciarSesion = new JMenuItem("Iniciar Sesion");
		mntmIniciarSesion.addActionListener(this.getctrlMainGUI());
		
		mnSesion.add(mntmIniciarSesion);
		mnSesion.add(mntmCerrarSesion);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 33, 714, 417);
		contentPane.add(tabbedPane);

		JPanel panelIntegrantes = new JPanel();
		tabbedPane.addTab("Integrantes", null, panelIntegrantes, null);
		panelIntegrantes.setLayout(null);

		JScrollPane scrlpIntegrantes = new JScrollPane();
		scrlpIntegrantes.setBounds(10, 11, 256, 335);
		panelIntegrantes.add(scrlpIntegrantes);

		tblIntegrantes = new JTable();
		tblIntegrantes.addMouseListener(this.getctrlMainGUI());
		tblIntegrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIntegrantes.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"DNI", "Apellido y Nombre"}));
		tblIntegrantes.getColumnModel().getColumn(0).setResizable(false);
		tblIntegrantes.getColumnModel().getColumn(1).setResizable(false);
		
		scrlpIntegrantes.setViewportView(tblIntegrantes);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this.getctrlMainGUI());
		btnEliminar.setBounds(610, 355, 89, 23);
		panelIntegrantes.add(btnEliminar);

		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(this.getctrlMainGUI());
		btnAnadir.setBounds(511, 355, 89, 23);
		panelIntegrantes.add(btnAnadir);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this.getctrlMainGUI());
		btnModificar.setBounds(412, 355, 89, 23);
		panelIntegrantes.add(btnModificar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this.getctrlMainGUI());
		btnBuscar.setBounds(10, 355, 89, 23);
		panelIntegrantes.add(btnBuscar);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.addActionListener(this.getctrlMainGUI());
		btnMostrarTodo.setBounds(111, 355, 110, 23);
		panelIntegrantes.add(btnMostrarTodo);

		JPanel panelIntegrantesDatos = new JPanel();
		panelIntegrantesDatos.setBounds(278, 11, 421, 335);
		panelIntegrantes.add(panelIntegrantesDatos);
		panelIntegrantesDatos.setLayout(null);
		
		JLabel lblLegajo = new JLabel("Legajo");
		lblLegajo.setBounds(12, 12, 155, 16);
		panelIntegrantesDatos.add(lblLegajo);

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

		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(177, 37, 96, 20);
		panelIntegrantesDatos.add(txtDNI);
		txtDNI.setColumns(10);
		arrayTextField.add(txtDNI);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(177, 63, 96, 20);
		panelIntegrantesDatos.add(txtApellido);
		txtApellido.setColumns(10);
		arrayTextField.add(txtApellido);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(177, 89, 96, 20);
		panelIntegrantesDatos.add(txtNombre);
		txtNombre.setColumns(10);
		arrayTextField.add(txtNombre);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setEditable(false);
		txtFechaNacimiento.setBounds(177, 115, 96, 20);
		panelIntegrantesDatos.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		arrayTextField.add(txtFechaNacimiento);

		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(177, 141, 96, 20);
		panelIntegrantesDatos.add(txtDireccion);
		txtDireccion.setColumns(10);
		arrayTextField.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(177, 167, 96, 20);
		panelIntegrantesDatos.add(txtTelefono);
		txtTelefono.setColumns(10);
		arrayTextField.add(txtTelefono);

		txtTelefono2 = new JTextField();
		txtTelefono2.setEditable(false);
		txtTelefono2.setBounds(177, 193, 96, 20);
		panelIntegrantesDatos.add(txtTelefono2);
		txtTelefono2.setColumns(10);
		arrayTextField.add(txtTelefono2);

		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(177, 219, 96, 20);
		panelIntegrantesDatos.add(txtCorreo);
		txtCorreo.setColumns(10);
		arrayTextField.add(txtCorreo);

		txtComputadorasTrabajadas = new JTextField();
		txtComputadorasTrabajadas.setEditable(false);
		txtComputadorasTrabajadas.setBounds(177, 245, 96, 20);
		panelIntegrantesDatos.add(txtComputadorasTrabajadas);
		txtComputadorasTrabajadas.setColumns(10);
		
		txtLegajo = new JTextField();
		txtLegajo.setEditable(false);
		txtLegajo.setBounds(177, 10, 96, 20);
		panelIntegrantesDatos.add(txtLegajo);
		txtLegajo.setColumns(10);
		
		JPanel panelComputadoras = new JPanel();
		panelComputadoras.setForeground(SystemColor.info);
		panelComputadoras.setLayout(null);
		tabbedPane.addTab("Computadoras", null, panelComputadoras, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 256, 335);
		panelComputadoras.add(scrollPane);
		
		tblPC = new JTable();
		tblPC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPC.addMouseListener(this.getctrlMainGUI());
		tblPC.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Estado"}));
		tblPC.getColumnModel().getColumn(0).setResizable(false);
		tblPC.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tblPC);
		
		btnEliminarPC = new JButton("Eliminar");
		btnEliminarPC.setBounds(610, 355, 89, 23);
		btnEliminarPC.addActionListener(this.getctrlMainGUI());
		panelComputadoras.add(btnEliminarPC);
		
		btnAñadirPC = new JButton("A\u00F1adir");
		btnAñadirPC.setBounds(511, 355, 89, 23);
		btnAñadirPC.addActionListener(this.getctrlMainGUI());
		panelComputadoras.add(btnAñadirPC);
		
		btnEditarPC = new JButton("Modificar");
		btnEditarPC.setBounds(412, 355, 89, 23);
		btnEditarPC.addActionListener(this.getctrlMainGUI());
		panelComputadoras.add(btnEditarPC);
		
		btnBuscarPC = new JButton("Buscar");
		btnBuscarPC.setBounds(10, 355, 89, 23);
		btnBuscarPC.addActionListener(this.getctrlMainGUI());
		panelComputadoras.add(btnBuscarPC);
		
		btnMostrarTodoPC = new JButton("Mostrar Todo");
		btnMostrarTodoPC.setBounds(111, 355, 110, 23);
		btnMostrarTodoPC.addActionListener(this.getctrlMainGUI());
		panelComputadoras.add(btnMostrarTodoPC);
		
		txtpnDatospc = new JTextPane();
		txtpnDatospc.setBackground(SystemColor.text);
		txtpnDatospc.setEditable(false);
		txtpnDatospc.setText("DatosPC");
		txtpnDatospc.setBounds(278, 11, 419, 335);
		panelComputadoras.add(txtpnDatospc);
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

	public CtrlMain getctrlMainGUI() {
		return ctrlMainGUI;
	}

	public void setctrlMainGUI(CtrlMain ctrlMainGUI) {
		this.ctrlMainGUI = ctrlMainGUI;
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

	public JMenuItem getMntmIniciarSesion() {
		return mntmIniciarSesion;
	}

	public JTextField getTxtLegajo() {
		return txtLegajo;
	}
}
