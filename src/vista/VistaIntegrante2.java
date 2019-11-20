package vista;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enumTypes.TipoIntegranteAdmin;
import javax.swing.JFormattedTextField;

public class VistaIntegrante2 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private ArrayList<JTextField> arrayTxtField = new ArrayList<JTextField>();
	private JTextField txtDNI;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtTelefono2;
	private JTextField txtCorreo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox cboxTipoIntegrante;
	private JFormattedTextField txtFechaNacimiento;

	public VistaIntegrante2() {
		this.setModal(true);
		setBounds(100, 100, 318, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 282, 243);
		contentPane.add(panel);

		JLabel lblTipo = new JLabel("Tipo Integrante");
		lblTipo.setBounds(12, 11, 122, 14);
		panel.add(lblTipo);

		JLabel lblDNI = new JLabel("DNI (*)");
		lblDNI.setBounds(12, 37, 122, 14);
		panel.add(lblDNI);

		JLabel lblApellido = new JLabel("Apellido (*)");
		lblApellido.setBounds(12, 62, 122, 14);
		panel.add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre (*)");
		lblNombre.setBounds(12, 88, 122, 14);
		panel.add(lblNombre);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento (*)");
		lblFechaNacimiento.setBounds(12, 114, 122, 14);
		panel.add(lblFechaNacimiento);

		JLabel lblDireccion = new JLabel("Direccion (*)");
		lblDireccion.setBounds(12, 140, 122, 14);
		panel.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono (*)");
		lblTelefono.setBounds(12, 166, 122, 14);
		panel.add(lblTelefono);

		JLabel lblTelefono2 = new JLabel("Telefono 2");
		lblTelefono2.setBounds(12, 192, 122, 14);
		panel.add(lblTelefono2);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(12, 218, 122, 14);
		panel.add(lblCorreo);

		cboxTipoIntegrante = new JComboBox();
		cboxTipoIntegrante.setModel(new DefaultComboBoxModel(TipoIntegranteAdmin.values()));
		cboxTipoIntegrante.setBounds(141, 8, 130, 20);
		panel.add(cboxTipoIntegrante);

		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(141, 34, 130, 20);
		panel.add(txtDNI);
		arrayTxtField.add(txtDNI);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(141, 59, 130, 20);
		panel.add(txtApellido);
		arrayTxtField.add(txtApellido);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(141, 85, 130, 20);
		panel.add(txtNombre);
		arrayTxtField.add(txtNombre);

		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("####-##-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtFechaNacimiento = new JFormattedTextField(mask);
		txtFechaNacimiento.setBounds(141, 111, 130, 20);
		panel.add(txtFechaNacimiento);
		arrayTxtField.add(txtFechaNacimiento);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(141, 137, 130, 20);
		panel.add(txtDireccion);
		arrayTxtField.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(141, 163, 130, 20);
		panel.add(txtTelefono);
		arrayTxtField.add(txtTelefono);

		txtTelefono2 = new JTextField();
		txtTelefono2.setColumns(10);
		txtTelefono2.setBounds(141, 189, 130, 20);
		panel.add(txtTelefono2);
		arrayTxtField.add(txtTelefono2);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(141, 215, 130, 20);
		panel.add(txtCorreo);
		arrayTxtField.add(txtCorreo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(203, 265, 89, 23);
		contentPane.add(btnCancelar);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(104, 265, 89, 23);
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

	public ArrayList<JTextField> getArrayTxtField() {
		return arrayTxtField;
	}

	public void setArrayTxtField(ArrayList<JTextField> arrayTxtField) {
		this.arrayTxtField = arrayTxtField;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JComboBox getCboxTipoIntegrante() {
		return cboxTipoIntegrante;
	}

	public void setCboxTipoIntegrante(JComboBox cboxTipoIntegrante) {
		this.cboxTipoIntegrante = cboxTipoIntegrante;
	}

	public JFormattedTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JFormattedTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}
}
