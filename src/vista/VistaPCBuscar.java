package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CtrlPCBuscar;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class VistaPCBuscar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIntegrante;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox cboxEstado;
	private JTextField txtNroComputadora;
	private CtrlPCBuscar ctrlPCBuscar;

	public VistaPCBuscar(CtrlPCBuscar ctrlPCBuscar) {
		this.setCtrlPCBuscar(ctrlPCBuscar);
		this.setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblEstadoComputadora = new JLabel("Estado Computadora");
		lblEstadoComputadora.setBounds(10, 15, 130, 14);
		contentPanel.add(lblEstadoComputadora);
		
		JLabel lblIntegrante = new JLabel("Integrante");
		lblIntegrante.setBounds(10, 47, 130, 16);
		contentPanel.add(lblIntegrante);
		
		JLabel lblNroComputadora = new JLabel("Nro Computadora");
		lblNroComputadora.setBounds(10, 79, 130, 16);
		contentPanel.add(lblNroComputadora);
		
		cboxEstado = new JComboBox();
		cboxEstado.addItemListener(this.getCtrlPCBuscar());
		cboxEstado.setModel(new DefaultComboBoxModel(new String[] {"Sin seleccion", "Pendiente", "Completada", "Revisada", "Descarte", "Donada"}));
		cboxEstado.setBounds(158, 11, 168, 22);
		contentPanel.add(cboxEstado);
		
		txtIntegrante = new JTextField();
		txtIntegrante.setBounds(158, 45, 168, 20);
		contentPanel.add(txtIntegrante);
		txtIntegrante.setColumns(10);
		
		txtNroComputadora = new JTextField();
		txtNroComputadora.setBounds(158, 77, 168, 20);
		contentPanel.add(txtNroComputadora);
		txtNroComputadora.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnAceptar = new JButton("Aceptar");
			buttonPane.add(btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			buttonPane.add(btnCancelar);
		}
	}

	public CtrlPCBuscar getCtrlPCBuscar() {
		return ctrlPCBuscar;
	}

	public void setCtrlPCBuscar(CtrlPCBuscar ctrlPCBuscar) {
		this.ctrlPCBuscar = ctrlPCBuscar;
	}

	public JTextField getTxtIntegrante() {
		return txtIntegrante;
	}

	public void setTxtIntegrante(JTextField txtIntegrante) {
		this.txtIntegrante = txtIntegrante;
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

	public JComboBox getCboxEstado() {
		return cboxEstado;
	}

	public void setCboxEstado(JComboBox cboxEstado) {
		this.cboxEstado = cboxEstado;
	}

	public JTextField getTxtNroComputadora() {
		return txtNroComputadora;
	}

	public void setTxtNroComputadora(JTextField txtNroComputadora) {
		this.txtNroComputadora = txtNroComputadora;
	}
}
