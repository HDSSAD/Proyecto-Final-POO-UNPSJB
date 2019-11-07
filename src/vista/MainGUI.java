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

import controlador.ControladorMain;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorMain ctrlIntegrante;
	private JPanel contentPane;
	private JTable tblIntegrantes;
	private JButton btnModificar;
	private JButton btnAnadir;
	private JButton btnEliminar;

	public MainGUI(ControladorMain ctrlIntegrante) {
		this.setCtrlIntegrante(ctrlIntegrante);
		this.setTitle("Gestor Puente");
		this.addWindowListener(this.getCtrlIntegrante());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
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
		tblIntegrantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblIntegrantes.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Apellido y Nombre"}));
		tblIntegrantes.getColumnModel().getColumn(0).setResizable(false);
		scrlpIntegrantes.setViewportView(tblIntegrantes);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(610, 355, 89, 23);
		panelIntegrantes.add(btnEliminar);

		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(this.getCtrlIntegrante());
		btnAnadir.setBounds(511, 355, 89, 23);
		panelIntegrantes.add(btnAnadir);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(412, 355, 89, 23);
		panelIntegrantes.add(btnModificar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 355, 89, 23);
		panelIntegrantes.add(btnBuscar);

		JPanel panelIntegrantesDatos = new JPanel();
		panelIntegrantesDatos.setBounds(278, 11, 421, 335);
		panelIntegrantes.add(panelIntegrantesDatos);
		panelIntegrantesDatos.setLayout(null);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 11, 155, 14);
		panelIntegrantesDatos.add(lblDNI);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 36, 155, 14);
		panelIntegrantesDatos.add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 61, 155, 14);
		panelIntegrantesDatos.add(lblNombre);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(10, 86, 155, 14);
		panelIntegrantesDatos.add(lblFechaNacimiento);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 111, 155, 14);
		panelIntegrantesDatos.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 136, 155, 14);
		panelIntegrantesDatos.add(lblTelefono);

		JLabel lblTelefono_1 = new JLabel("Telefono 2");
		lblTelefono_1.setBounds(10, 161, 155, 14);
		panelIntegrantesDatos.add(lblTelefono_1);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 186, 155, 14);
		panelIntegrantesDatos.add(lblCorreo);

		JLabel lblComputadorasTrabajadas = new JLabel("Computadoras Trabajadas");
		lblComputadorasTrabajadas.setBounds(10, 211, 155, 14);
		panelIntegrantesDatos.add(lblComputadorasTrabajadas);

		JTextField txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setBounds(175, 8, 96, 20);
		panelIntegrantesDatos.add(txtDNI);
		txtDNI.setColumns(10);

		JTextField txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(175, 33, 96, 20);
		panelIntegrantesDatos.add(txtApellido);
		txtApellido.setColumns(10);

		JTextField txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(175, 58, 96, 20);
		panelIntegrantesDatos.add(txtNombre);
		txtNombre.setColumns(10);

		JTextField txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setEditable(false);
		txtFechaNacimiento.setBounds(175, 83, 96, 20);
		panelIntegrantesDatos.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);

		JTextField txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(175, 108, 96, 20);
		panelIntegrantesDatos.add(txtDireccion);
		txtDireccion.setColumns(10);

		JTextField txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(175, 133, 96, 20);
		panelIntegrantesDatos.add(txtTelefono);
		txtTelefono.setColumns(10);

		JTextField txtTelefono2 = new JTextField();
		txtTelefono2.setEditable(false);
		txtTelefono2.setBounds(175, 158, 96, 20);
		panelIntegrantesDatos.add(txtTelefono2);
		txtTelefono2.setColumns(10);

		JTextField txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(175, 183, 96, 20);
		panelIntegrantesDatos.add(txtCorreo);
		txtCorreo.setColumns(10);

		JTextField txtComputadorasTrabajadas = new JTextField();
		txtComputadorasTrabajadas.setEditable(false);
		txtComputadorasTrabajadas.setBounds(175, 208, 96, 20);
		panelIntegrantesDatos.add(txtComputadorasTrabajadas);
		txtComputadorasTrabajadas.setColumns(10);
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

	public ControladorMain getCtrlIntegrante() {
		return ctrlIntegrante;
	}

	public void setCtrlIntegrante(ControladorMain ctrlIntegrante) {
		this.ctrlIntegrante = ctrlIntegrante;
	}

	public JTable getTblIntegrantes() {
		return tblIntegrantes;
	}

	public void setTblIntegrantes(JTable tblIntegrantes) {
		this.tblIntegrantes = tblIntegrantes;
	}
}
