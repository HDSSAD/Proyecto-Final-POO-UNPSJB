package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CtrlLogin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VistaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private CtrlLogin ctrlLogin;
	private JPasswordField passfContraseña;

	public VistaLogin(CtrlLogin ctrlLogin2) {
		this.setCtrlLogin(ctrlLogin2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 135);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 11, 75, 14);
		contentPanel.add(lblUsuario);

		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(10, 36, 75, 14);
		contentPanel.add(lblPass);

		txtUser = new JTextField();
		txtUser.setBounds(95, 8, 129, 20);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);

		passfContraseña = new JPasswordField();
		passfContraseña.setBounds(95, 33, 129, 20);
		contentPanel.add(passfContraseña);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(40, 64, 86, 23);
		contentPanel.add(btnIngresar);
		btnIngresar.addActionListener(this.getCtrlLogin());
		this.getRootPane().setDefaultButton(btnIngresar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(138, 64, 86, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(this.getCtrlLogin());
	}

	public CtrlLogin getCtrlLogin() {
		return ctrlLogin;
	}

	public void setCtrlLogin(CtrlLogin ctrlLogin2) {
		this.ctrlLogin = ctrlLogin2;
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JPasswordField getPassfContraseña() {
		return passfContraseña;
	}

	public void setTxtUser(JTextField txtUser) {
		this.txtUser = txtUser;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public void setPassfContraseña(JPasswordField passfContraseña) {
		this.passfContraseña = passfContraseña;
	}
}
