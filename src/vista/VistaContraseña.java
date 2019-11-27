package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CtrlContrase�a;

import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class VistaContrase�a extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passFContrase�aActual;
	private JPasswordField passFContrase�aNueva;
	private JPasswordField passFContrase�aConfirmar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private CtrlContrase�a ctrlContrase�a;

	public VistaContrase�a(CtrlContrase�a ctrlContrase�a) {
		this.setCtrlContrase�a(ctrlContrase�a);
		this.setModal(true);
		setBounds(100, 100, 360, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		passFContrase�aActual = new JPasswordField();
		passFContrase�aActual.setBounds(153, 11, 180, 20);
		contentPanel.add(passFContrase�aActual);

		passFContrase�aNueva = new JPasswordField();
		passFContrase�aNueva.setBounds(153, 42, 180, 20);
		contentPanel.add(passFContrase�aNueva);

		passFContrase�aConfirmar = new JPasswordField();
		passFContrase�aConfirmar.setBounds(153, 73, 180, 20);
		contentPanel.add(passFContrase�aConfirmar);

		JLabel lblContrase�aActual = new JLabel("Contrase\u00F1a actual");
		lblContrase�aActual.setBounds(10, 14, 126, 14);
		contentPanel.add(lblContrase�aActual);

		JLabel lblConfirmarContrase�a = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrase�a.setBounds(10, 75, 126, 16);
		contentPanel.add(lblConfirmarContrase�a);

		JLabel lblNuevaContrase�a = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrase�a.setBounds(10, 44, 126, 16);
		contentPanel.add(lblNuevaContrase�a);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnAceptar = new JButton("Aceptar");
		buttonPane.add(btnAceptar);
		btnAceptar.addActionListener(this.getCtrlContrase�a());

		btnCancelar = new JButton("Cancelar");
		buttonPane.add(btnCancelar);
		btnCancelar.addActionListener(this.getCtrlContrase�a());

	}

	public JPasswordField getPassFContrase�aActual() {
		return passFContrase�aActual;
	}

	public void setPassFContrase�aActual(JPasswordField passFContrase�aActual) {
		this.passFContrase�aActual = passFContrase�aActual;
	}

	public JPasswordField getPassFContrase�aNueva() {
		return passFContrase�aNueva;
	}

	public void setPassFContrase�aNueva(JPasswordField passFContrase�aNueva) {
		this.passFContrase�aNueva = passFContrase�aNueva;
	}

	public JPasswordField getPassFContrase�aConfirmar() {
		return passFContrase�aConfirmar;
	}

	public void setPassFContrase�aConfirmar(JPasswordField passFContrase�aConfirmar) {
		this.passFContrase�aConfirmar = passFContrase�aConfirmar;
	}

	public CtrlContrase�a getCtrlContrase�a() {
		return ctrlContrase�a;
	}

	public void setCtrlContrase�a(CtrlContrase�a ctrlContrase�a) {
		this.ctrlContrase�a = ctrlContrase�a;
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
