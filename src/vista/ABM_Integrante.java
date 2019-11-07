package vista;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorABMIntegrante;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ABM_Integrante extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private ControladorABMIntegrante ctrlABMIntegrante;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtFechaNacimiento;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtTelefono2;
	private JTextField txtCorreo;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public ABM_Integrante(ControladorABMIntegrante ctrlABMIntegrante) {
		this.setCtrlABMIntegrante(ctrlABMIntegrante);
		this.setModal(true);
		setBounds(100, 100, 318, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 282, 214);
		contentPane.add(panel);
		
		JLabel lblDNI = new JLabel("DNI (*)");
		lblDNI.setBounds(12, 11, 122, 14);
		panel.add(lblDNI);
		
		JLabel lblApellido = new JLabel("Apellido (*)");
		lblApellido.setBounds(10, 37, 122, 14);
		panel.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre (*)");
		lblNombre.setBounds(10, 61, 122, 14);
		panel.add(lblNombre);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento (*)");
		lblFechaNacimiento.setBounds(10, 85, 122, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblDireccion = new JLabel("Direccion (*)");
		lblDireccion.setBounds(10, 111, 122, 14);
		panel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono (*)");
		lblTelefono.setBounds(10, 136, 122, 14);
		panel.add(lblTelefono);
		
		JLabel lblTelefono2 = new JLabel("Telefono 2");
		lblTelefono2.setBounds(10, 161, 122, 14);
		panel.add(lblTelefono2);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 186, 122, 14);
		panel.add(lblCorreo);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(141, 8, 130, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(141, 34, 130, 20);
		panel.add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(141, 58, 130, 20);
		panel.add(txtNombre);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(141, 82, 130, 20);
		panel.add(txtFechaNacimiento);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(141, 108, 130, 20);
		panel.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(141, 133, 130, 20);
		panel.add(txtTelefono);
		
		txtTelefono2 = new JTextField();
		txtTelefono2.setColumns(10);
		txtTelefono2.setBounds(141, 158, 130, 20);
		panel.add(txtTelefono2);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(141, 183, 130, 20);
		panel.add(txtCorreo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this.getCtrlABMIntegrante());
		btnCancelar.setBounds(203, 236, 89, 23);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this.getCtrlABMIntegrante());
		btnAceptar.setBounds(104, 236, 89, 23);
		contentPane.add(btnAceptar);
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

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
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

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public ControladorABMIntegrante getCtrlABMIntegrante() {
		return ctrlABMIntegrante;
	}

	public void setCtrlABMIntegrante(ControladorABMIntegrante ctrlABMIntegrante) {
		this.ctrlABMIntegrante = ctrlABMIntegrante;
	}

}
