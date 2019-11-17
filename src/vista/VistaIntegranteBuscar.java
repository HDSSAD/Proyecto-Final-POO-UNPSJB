package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CtrlIntegranteBuscar;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VistaIntegranteBuscar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private CtrlIntegranteBuscar ctrlIntegranteBuscar;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JComboBox cboxTipo;
	private JButton btnCancelar;
	private JButton btnAceptar;

	public VistaIntegranteBuscar(CtrlIntegranteBuscar ctrlIntegranteBuscar) {
		this.setCtrlIntegranteBuscar(ctrlIntegranteBuscar);
		this.setModal(true);
		setBounds(100, 100, 424, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		cboxTipo = new JComboBox();
		cboxTipo.setModel(new DefaultComboBoxModel(new String[] {"Sin seleccion", "Administrador", "Coordinador", "Integrante"}));
		cboxTipo.setBounds(176, 11, 219, 22);
		contentPanel.add(cboxTipo);
		
		txtDni = new JTextField();
		txtDni.setBounds(176, 44, 219, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(176, 75, 219, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(176, 106, 219, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(176, 137, 219, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(176, 168, 219, 20);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblTipoDeIntegrante = new JLabel("Tipo de Integrante");
		lblTipoDeIntegrante.setBounds(10, 15, 116, 14);
		contentPanel.add(lblTipoDeIntegrante);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 47, 116, 14);
		contentPanel.add(lblDni);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 78, 116, 14);
		contentPanel.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 109, 116, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 140, 116, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 171, 116, 14);
		contentPanel.add(lblCorreo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnAceptar = new JButton("Aceptar");
			buttonPane.add(btnAceptar);
			btnAceptar.addActionListener(this.getCtrlIntegranteBuscar());
			
			btnCancelar = new JButton("Cancelar");
			buttonPane.add(btnCancelar);
			btnCancelar.addActionListener(this.getCtrlIntegranteBuscar());
		}
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
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

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JComboBox getCboxTipo() {
		return cboxTipo;
	}

	public void setCboxTipo(JComboBox cboxTipo) {
		this.cboxTipo = cboxTipo;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public CtrlIntegranteBuscar getCtrlIntegranteBuscar() {
		return ctrlIntegranteBuscar;
	}

	public void setCtrlIntegranteBuscar(CtrlIntegranteBuscar ctrlIntegranteBuscar) {
		this.ctrlIntegranteBuscar = ctrlIntegranteBuscar;
	}
}
