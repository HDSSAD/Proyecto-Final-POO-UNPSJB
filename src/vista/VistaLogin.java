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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 140);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(44, 65, 82, 26);
		btnIngresar.addActionListener(this.getCtrlLogin());
		contentPanel.add(btnIngresar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(138, 65, 86, 26);
		btnCancelar.addActionListener(this.getCtrlLogin());
		contentPanel.add(btnCancelar);

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
		
		this.getRootPane().setDefaultButton(btnIngresar);
		
		passfContraseña = new JPasswordField();
		passfContraseña.setBounds(95, 33, 129, 20);
		contentPanel.add(passfContraseña);
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
}
