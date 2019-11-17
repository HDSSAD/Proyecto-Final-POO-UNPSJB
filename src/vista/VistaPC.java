package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;

import enumTypes.EstadosPC;

import java.awt.Color;
import java.awt.SystemColor;
import java.text.NumberFormat;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import enumTypes.Lectora;
import enumTypes.MemoriaRam;
import enumTypes.Discos;
import enumTypes.Componente;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import enumTypes.ColorLectora;

public class VistaPC extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtIdComputadora;
	private JTextField txtProcesador;
	private JTextField txtProcesadorGhz;
	private JTextField txtPlacaBase;
	private JTextField txtIdsIntegrantes;
	private JComboBox cboxPlacaBaseEstado;
	private JComboBox cboxProcesadorEstado;
	private JComboBox cboxDiscoRigidoEstado;
	private JComboBox cboxRamEstado;
	private JComboBox cboxLectoraEstado;
	private JComboBox cboxComputadoraEstado;
	private JTextPane txtpnNotasPC;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JSpinner spnProcesadorNucleos;
	private JSpinner spnProcesadorCantidad;
	private JComboBox cboxDiscoRigidoTipo;
	private JSpinner spnDiscoRigidoCapacidad;
	private JSpinner spnDiscoRigidoCantidad;
	private JComboBox cboxRamTipo;
	private JSpinner spnRamCapacidad;
	private JSpinner spnRamCantidad;
	private JComboBox cboxLectoraTipo;
	private JComboBox cboxLectoraColor;
	private JSpinner spnLectoraCantidad;

	public VistaPC() {
		this.setModal(true);
		setBounds(100, 100, 526, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel lblIdComputadora = new JLabel("ID Computadora");
		lblIdComputadora.setBounds(10, 11, 105, 14);
		contentPanel.add(lblIdComputadora);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 36, 105, 14);
		contentPanel.add(lblEstado);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
	    
		txtIdComputadora = new JFormattedTextField(formatter);
		txtIdComputadora.setBounds(125, 8, 104, 20);
		contentPanel.add(txtIdComputadora);
		txtIdComputadora.setColumns(10);
		
		cboxComputadoraEstado = new JComboBox();
		cboxComputadoraEstado.setModel(new DefaultComboBoxModel(EstadosPC.values()));
		cboxComputadoraEstado.setBounds(125, 33, 104, 20);
		contentPanel.add(cboxComputadoraEstado);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 62, 488, 418);
		contentPanel.add(tabbedPane);
		
		JPanel panelHardware = new JPanel();
		tabbedPane.addTab("Hardware", null, panelHardware, null);
		panelHardware.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel.setBounds(12, 313, 459, 64);
		panelHardware.add(panel);
		
		JLabel lblLectoraTipo = new JLabel("Lectora Tipo");
		lblLectoraTipo.setBounds(12, 12, 105, 14);
		panel.add(lblLectoraTipo);
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setBounds(257, 11, 55, 16);
		panel.add(label_1);
		
		cboxLectoraEstado = new JComboBox();
		cboxLectoraEstado.setModel(new DefaultComboBoxModel(Componente.values()));
		cboxLectoraEstado.setBounds(343, 9, 104, 20);
		panel.add(cboxLectoraEstado);
		
		JLabel lblLectoraColor = new JLabel("Color");
		lblLectoraColor.setBounds(22, 38, 95, 16);
		panel.add(lblLectoraColor);
		
		cboxLectoraTipo = new JComboBox();
		cboxLectoraTipo.setModel(new DefaultComboBoxModel(Lectora.values()));
		cboxLectoraTipo.setBounds(135, 7, 104, 20);
		panel.add(cboxLectoraTipo);
		
		JLabel lblLectoraCantidad = new JLabel("Cantidad");
		lblLectoraCantidad.setBounds(257, 38, 73, 16);
		panel.add(lblLectoraCantidad);
		
		spnLectoraCantidad = new JSpinner();
		spnLectoraCantidad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnLectoraCantidad.setBounds(343, 36, 104, 20);
		panel.add(spnLectoraCantidad);
		
		cboxLectoraColor = new JComboBox();
		cboxLectoraColor.setModel(new DefaultComboBoxModel(ColorLectora.values()));
		cboxLectoraColor.setBounds(135, 36, 104, 20);
		panel.add(cboxLectoraColor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel_1.setBounds(12, 237, 459, 64);
		panelHardware.add(panel_1);
		
		JLabel lblRamTipo = new JLabel("RAM Tipo");
		lblRamTipo.setBounds(12, 12, 105, 14);
		panel_1.add(lblRamTipo);
		
		JLabel label_5 = new JLabel("Estado");
		label_5.setBounds(257, 11, 55, 16);
		panel_1.add(label_5);
		
		cboxRamEstado = new JComboBox();
		cboxRamEstado.setModel(new DefaultComboBoxModel(Componente.values()));
		cboxRamEstado.setBounds(343, 9, 104, 20);
		panel_1.add(cboxRamEstado);
		
		JLabel lblRamPlacas = new JLabel("Cantidad");
		lblRamPlacas.setBounds(257, 38, 68, 16);
		panel_1.add(lblRamPlacas);
		
		JLabel lblCapacidadTotal = new JLabel("Capacidad MB");
		lblCapacidadTotal.setBounds(22, 38, 95, 16);
		panel_1.add(lblCapacidadTotal);
		
		cboxRamTipo = new JComboBox();
		cboxRamTipo.setModel(new DefaultComboBoxModel(MemoriaRam.values()));
		cboxRamTipo.setBounds(135, 7, 104, 20);
		panel_1.add(cboxRamTipo);
		
		spnRamCantidad = new JSpinner();
		spnRamCantidad.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		spnRamCantidad.setBounds(343, 36, 104, 20);
		panel_1.add(spnRamCantidad);
		
		spnRamCapacidad = new JSpinner();
		spnRamCapacidad.setModel(new SpinnerNumberModel(0, 0, 8192, 256));
		spnRamCapacidad.setBounds(135, 36, 104, 20);
		panel_1.add(spnRamCapacidad);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel_2.setBounds(12, 161, 459, 64);
		panelHardware.add(panel_2);
		
		JLabel lblDiscoTipo = new JLabel("Disco Tipo");
		lblDiscoTipo.setBounds(12, 12, 105, 14);
		panel_2.add(lblDiscoTipo);
		
		JLabel label_9 = new JLabel("Estado");
		label_9.setBounds(257, 11, 55, 16);
		panel_2.add(label_9);
		
		cboxDiscoRigidoEstado = new JComboBox();
		cboxDiscoRigidoEstado.setModel(new DefaultComboBoxModel(Componente.values()));
		cboxDiscoRigidoEstado.setBounds(343, 9, 104, 20);
		panel_2.add(cboxDiscoRigidoEstado);
		
		JLabel lblDiscoRigidoCapacidad = new JLabel("Capacidad");
		lblDiscoRigidoCapacidad.setBounds(22, 38, 95, 16);
		panel_2.add(lblDiscoRigidoCapacidad);
		
		cboxDiscoRigidoTipo = new JComboBox();
		cboxDiscoRigidoTipo.setModel(new DefaultComboBoxModel(Discos.values()));
		cboxDiscoRigidoTipo.setBounds(135, 7, 104, 20);
		panel_2.add(cboxDiscoRigidoTipo);
		
		JLabel lblDiscoRigidoCantidad = new JLabel("Cantidad");
		lblDiscoRigidoCantidad.setBounds(257, 38, 73, 16);
		panel_2.add(lblDiscoRigidoCantidad);
		
		spnDiscoRigidoCantidad = new JSpinner();
		spnDiscoRigidoCantidad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnDiscoRigidoCantidad.setBounds(343, 36, 104, 20);
		panel_2.add(spnDiscoRigidoCantidad);
		
		spnDiscoRigidoCapacidad = new JSpinner();
		spnDiscoRigidoCapacidad.setBounds(135, 36, 104, 20);
		panel_2.add(spnDiscoRigidoCapacidad);
		spnDiscoRigidoCapacidad.setModel(new SpinnerNumberModel(0, 0, 1000, 10));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(180, 180, 180), 1, true));
		panel_3.setBounds(12, 59, 459, 90);
		panelHardware.add(panel_3);
		
		JLabel lblProcesador = new JLabel("Procesador");
		lblProcesador.setBounds(12, 12, 105, 14);
		panel_3.add(lblProcesador);
		
		txtProcesador = new JTextField();
		txtProcesador.setColumns(10);
		txtProcesador.setBounds(135, 9, 104, 20);
		panel_3.add(txtProcesador);
		
		JLabel label_12 = new JLabel("Estado");
		label_12.setBounds(257, 11, 55, 16);
		panel_3.add(label_12);
		
		cboxProcesadorEstado = new JComboBox();
		cboxProcesadorEstado.setModel(new DefaultComboBoxModel(Componente.values()));
		cboxProcesadorEstado.setBounds(343, 9, 104, 20);
		panel_3.add(cboxProcesadorEstado);
		
		JLabel lblProcesadorNucleos = new JLabel("Nucleos");
		lblProcesadorNucleos.setBounds(22, 38, 95, 16);
		panel_3.add(lblProcesadorNucleos);
		
		JLabel label_14 = new JLabel("GHz");
		label_14.setBounds(22, 66, 95, 16);
		panel_3.add(label_14);
		
		txtProcesadorGhz = new JTextField();
		txtProcesadorGhz.setColumns(10);
		txtProcesadorGhz.setBounds(135, 64, 104, 20);
		panel_3.add(txtProcesadorGhz);
		
		JLabel lblProcesadorCantidad = new JLabel("Cantidad");
		lblProcesadorCantidad.setBounds(257, 38, 73, 16);
		panel_3.add(lblProcesadorCantidad);
		
		spnProcesadorCantidad = new JSpinner();
		spnProcesadorCantidad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnProcesadorCantidad.setBounds(343, 36, 104, 20);
		panel_3.add(spnProcesadorCantidad);
		
		spnProcesadorNucleos = new JSpinner();
		spnProcesadorNucleos.setModel(new SpinnerNumberModel(0, 0, 64, 1));
		spnProcesadorNucleos.setBounds(135, 36, 104, 20);
		panel_3.add(spnProcesadorNucleos);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel_4.setBounds(12, 12, 459, 35);
		panelHardware.add(panel_4);
		
		JLabel label_15 = new JLabel("Placa Base");
		label_15.setBounds(12, 12, 105, 14);
		panel_4.add(label_15);
		
		txtPlacaBase = new JTextField();
		txtPlacaBase.setColumns(10);
		txtPlacaBase.setBounds(135, 9, 104, 20);
		panel_4.add(txtPlacaBase);
		
		JLabel label_16 = new JLabel("Estado");
		label_16.setBounds(257, 11, 55, 16);
		panel_4.add(label_16);
		
		cboxPlacaBaseEstado = new JComboBox();
		cboxPlacaBaseEstado.setModel(new DefaultComboBoxModel(Componente.values()));
		cboxPlacaBaseEstado.setBounds(343, 9, 104, 20);
		panel_4.add(cboxPlacaBaseEstado);
		
		JPanel panelSoftware = new JPanel();
		tabbedPane.addTab("Software", null, panelSoftware, null);
		panelSoftware.setLayout(null);
		
		JPanel panelNotas = new JPanel();
		tabbedPane.addTab("Notas", null, panelNotas, null);
		panelNotas.setLayout(null);
		
		txtpnNotasPC = new JTextPane();
		txtpnNotasPC.setBounds(12, 12, 459, 366);
		panelNotas.add(txtpnNotasPC);
		
		txtIdsIntegrantes = new JTextField();
		txtIdsIntegrantes.setBounds(370, 8, 128, 20);
		contentPanel.add(txtIdsIntegrantes);
		txtIdsIntegrantes.setColumns(10);
		
		JLabel lblIdsIntegrantes = new JLabel("IDs Integrantes");
		lblIdsIntegrantes.setBounds(247, 10, 105, 16);
		contentPanel.add(lblIdsIntegrantes);
		
		JLabel lblIdsSeparadosPor = new JLabel("IDs separados por una coma \",\"");
		lblIdsSeparadosPor.setForeground(SystemColor.controlDkShadow);
		lblIdsSeparadosPor.setBounds(257, 35, 241, 16);
		contentPanel.add(lblIdsSeparadosPor);
		{	// Botones
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(320, 492, 80, 26);
			contentPanel.add(btnAceptar);
			btnAceptar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(412, 492, 86, 26);
			contentPanel.add(btnCancelar);
			btnCancelar.setActionCommand("Cancel");
		}
	}

	public JFormattedTextField getTxtIdComputadora() {
		return txtIdComputadora;
	}

	public void setTxtIdComputadora(JFormattedTextField txtIdComputadora) {
		this.txtIdComputadora = txtIdComputadora;
	}

	public JTextField getTxtProcesador() {
		return txtProcesador;
	}

	public void setTxtProcesador(JTextField txtProcesador) {
		this.txtProcesador = txtProcesador;
	}

	public JTextField getTxtProcesadorGhz() {
		return txtProcesadorGhz;
	}

	public void setTxtProcesadorGhz(JTextField txtProcesadorGhz) {
		this.txtProcesadorGhz = txtProcesadorGhz;
	}

	public JTextField getTxtPlacaBase() {
		return txtPlacaBase;
	}

	public void setTxtPlacaBase(JTextField txtPlacaBase) {
		this.txtPlacaBase = txtPlacaBase;
	}

	public JTextField getTxtIdsIntegrantes() {
		return txtIdsIntegrantes;
	}

	public void setTxtIdsIntegrantes(JTextField txtIdsIntegrantes) {
		this.txtIdsIntegrantes = txtIdsIntegrantes;
	}

	public JComboBox getCboxPlacaBaseEstado() {
		return cboxPlacaBaseEstado;
	}

	public void setCboxPlacaBaseEstado(JComboBox cboxPlacaBaseEstado) {
		this.cboxPlacaBaseEstado = cboxPlacaBaseEstado;
	}

	public JComboBox getCboxProcesadorEstado() {
		return cboxProcesadorEstado;
	}

	public void setCboxProcesadorEstado(JComboBox cboxProcesadorEstado) {
		this.cboxProcesadorEstado = cboxProcesadorEstado;
	}

	public JComboBox getCboxDiscoRigidoEstado() {
		return cboxDiscoRigidoEstado;
	}

	public void setCboxDiscoRigidoEstado(JComboBox cboxDiscoRigidoEstado) {
		this.cboxDiscoRigidoEstado = cboxDiscoRigidoEstado;
	}

	public JComboBox getCboxRamEstado() {
		return cboxRamEstado;
	}

	public void setCboxRamEstado(JComboBox cboxRamEstado) {
		this.cboxRamEstado = cboxRamEstado;
	}

	public JComboBox getCboxLectoraEstado() {
		return cboxLectoraEstado;
	}

	public void setCboxLectoraEstado(JComboBox cboxLectoraEstado) {
		this.cboxLectoraEstado = cboxLectoraEstado;
	}

	public JTextPane getTxtpnNotasPC() {
		return txtpnNotasPC;
	}

	public void setTxtpnNotasPC(JTextPane txtpnNotasPC) {
		this.txtpnNotasPC = txtpnNotasPC;
	}

	public JComboBox getCboxComputadoraEstado() {
		return cboxComputadoraEstado;
	}

	public void setCboxComputadoraEstado(JComboBox cboxComputadoraEstado) {
		this.cboxComputadoraEstado = cboxComputadoraEstado;
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

	public JSpinner getSpnProcesadorNucleos() {
		return spnProcesadorNucleos;
	}

	public void setSpnProcesadorNucleos(JSpinner spnProcesadorNucleos) {
		this.spnProcesadorNucleos = spnProcesadorNucleos;
	}

	public JSpinner getSpnProcesadorCantidad() {
		return spnProcesadorCantidad;
	}

	public void setSpnProcesadorCantidad(JSpinner spnProcesadorCantidad) {
		this.spnProcesadorCantidad = spnProcesadorCantidad;
	}

	public JComboBox getCboxDiscoRigidoTipo() {
		return cboxDiscoRigidoTipo;
	}

	public void setCboxDiscoRigidoTipo(JComboBox cboxDiscoRigidoTipo) {
		this.cboxDiscoRigidoTipo = cboxDiscoRigidoTipo;
	}

	public JSpinner getSpnDiscoRigidoCapacidad() {
		return spnDiscoRigidoCapacidad;
	}

	public void setSpnDiscoRigidoCapacidad(JSpinner spnDiscoRigidoCapacidad) {
		this.spnDiscoRigidoCapacidad = spnDiscoRigidoCapacidad;
	}

	public JSpinner getSpnDiscoRigidoCantidad() {
		return spnDiscoRigidoCantidad;
	}

	public void setSpnDiscoRigidoCantidad(JSpinner spnDiscoRigidoCantidad) {
		this.spnDiscoRigidoCantidad = spnDiscoRigidoCantidad;
	}

	public JComboBox getCboxRamTipo() {
		return cboxRamTipo;
	}

	public void setCboxRamTipo(JComboBox cboxRamTipo) {
		this.cboxRamTipo = cboxRamTipo;
	}

	public JSpinner getSpnRamCapacidad() {
		return spnRamCapacidad;
	}

	public void setSpnRamCapacidad(JSpinner spnRamCapacidad) {
		this.spnRamCapacidad = spnRamCapacidad;
	}

	public JSpinner getSpnRamCantidad() {
		return spnRamCantidad;
	}

	public void setSpnRamCantidad(JSpinner spnRamCantidad) {
		this.spnRamCantidad = spnRamCantidad;
	}

	public JComboBox getCboxLectoraTipo() {
		return cboxLectoraTipo;
	}

	public void setCboxLectoraTipo(JComboBox cboxLectoraTipo) {
		this.cboxLectoraTipo = cboxLectoraTipo;
	}

	public JComboBox getCboxLectoraColor() {
		return cboxLectoraColor;
	}

	public void setCboxLectoraColor(JComboBox cboxLectoraColor) {
		this.cboxLectoraColor = cboxLectoraColor;
	}

	public JSpinner getSpnLectoraCantidad() {
		return spnLectoraCantidad;
	}

	public void setSpnLectoraCantidad(JSpinner spnLectoraCantidad) {
		this.spnLectoraCantidad = spnLectoraCantidad;
	}
}
