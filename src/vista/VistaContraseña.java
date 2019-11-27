package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CtrlContraseña;

import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class VistaContraseña extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passFContraseñaActual;
	private JPasswordField passFContraseñaNueva;
	private JPasswordField passFContraseñaConfirmar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private CtrlContraseña ctrlContraseña;

	public VistaContraseña(CtrlContraseña ctrlContraseña) {
		this.setCtrlContraseña(ctrlContraseña);
		this.setModal(true);
		setBounds(100, 100, 360, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		passFContraseñaActual = new JPasswordField();
		passFContraseñaActual.setBounds(153, 11, 180, 20);
		contentPanel.add(passFContraseñaActual);

		passFContraseñaNueva = new JPasswordField();
		passFContraseñaNueva.setBounds(153, 42, 180, 20);
		contentPanel.add(passFContraseñaNueva);

		passFContraseñaConfirmar = new JPasswordField();
		passFContraseñaConfirmar.setBounds(153, 73, 180, 20);
		contentPanel.add(passFContraseñaConfirmar);

		JLabel lblContraseñaActual = new JLabel("Contrase\u00F1a actual");
		lblContraseñaActual.setBounds(10, 14, 126, 14);
		contentPanel.add(lblContraseñaActual);

		JLabel lblConfirmarContraseña = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContraseña.setBounds(10, 75, 126, 16);
		contentPanel.add(lblConfirmarContraseña);

		JLabel lblNuevaContraseña = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContraseña.setBounds(10, 44, 126, 16);
		contentPanel.add(lblNuevaContraseña);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnAceptar = new JButton("Aceptar");
		buttonPane.add(btnAceptar);
		btnAceptar.addActionListener(this.getCtrlContraseña());

		btnCancelar = new JButton("Cancelar");
		buttonPane.add(btnCancelar);
		btnCancelar.addActionListener(this.getCtrlContraseña());

	}

	public JPasswordField getPassFContraseñaActual() {
		return passFContraseñaActual;
	}

	public void setPassFContraseñaActual(JPasswordField passFContraseñaActual) {
		this.passFContraseñaActual = passFContraseñaActual;
	}

	public JPasswordField getPassFContraseñaNueva() {
		return passFContraseñaNueva;
	}

	public void setPassFContraseñaNueva(JPasswordField passFContraseñaNueva) {
		this.passFContraseñaNueva = passFContraseñaNueva;
	}

	public JPasswordField getPassFContraseñaConfirmar() {
		return passFContraseñaConfirmar;
	}

	public void setPassFContraseñaConfirmar(JPasswordField passFContraseñaConfirmar) {
		this.passFContraseñaConfirmar = passFContraseñaConfirmar;
	}

	public CtrlContraseña getCtrlContraseña() {
		return ctrlContraseña;
	}

	public void setCtrlContraseña(CtrlContraseña ctrlContraseña) {
		this.ctrlContraseña = ctrlContraseña;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
}
