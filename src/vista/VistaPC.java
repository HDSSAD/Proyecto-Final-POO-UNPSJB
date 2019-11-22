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
import javax.swing.JCheckBox;

public class VistaPC extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtIdComputadora;
	private JTextField txtProcesador;
	private JSpinner txtProcesadorGhz;
	private JTextField txtPlacaBase;
	private JTextField txtIdsIntegrantes;
	private JComboBox<Componente> cboxPlacaBaseEstado;
	private JComboBox<Componente> cboxProcesadorEstado;
	private JComboBox<Componente> cboxDiscoRigidoEstado;
	private JComboBox<Componente> cboxRamEstado;
	private JComboBox<Componente> cboxLectoraEstado;
	private JComboBox<EstadosPC> cboxComputadoraEstado;
	private JTextPane txtpnNotasPC;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JSpinner spnProcesadorNucleos;
	private JSpinner spnProcesadorCantidad;
	private JComboBox<Discos> cboxDiscoRigidoTipo;
	private JSpinner spnDiscoRigidoCapacidad;
	private JSpinner spnDiscoRigidoCantidad;
	private JComboBox<MemoriaRam> cboxRamTipo;
	private JSpinner spnRamCapacidad;
	private JSpinner spnRamCantidad;
	private JComboBox<Lectora> cboxLectoraTipo;
	private JComboBox<ColorLectora> cboxLectoraColor;
	private JSpinner spnLectoraCantidad;
	private JTextField txtFechaAgregada;
	private JComboBox<String> cboxSeleccionarIntegrante;

	public VistaPC() {
		this.setModal(true);
		setBounds(100, 100, 570, 636);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 129, 532, 418);
		contentPanel.add(tabbedPane);
		
		JPanel panelHardware = new JPanel();
		tabbedPane.addTab("Hardware", null, panelHardware, null);
		panelHardware.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel.setBounds(12, 313, 503, 64);
		panelHardware.add(panel);
		
		JLabel lblLectoraTipo = new JLabel("Lectora Tipo");
		lblLectoraTipo.setBounds(12, 12, 95, 14);
		panel.add(lblLectoraTipo);
		
		JLabel label_1 = new JLabel("Estado");
		label_1.setBounds(296, 11, 55, 16);
		panel.add(label_1);
		
		cboxLectoraEstado = new JComboBox<Componente>();
		cboxLectoraEstado.setModel(new DefaultComboBoxModel<Componente>(Componente.values()));
		cboxLectoraEstado.setBounds(387, 9, 104, 20);
		panel.add(cboxLectoraEstado);
		
		JLabel lblLectoraColor = new JLabel("Color");
		lblLectoraColor.setBounds(22, 38, 85, 16);
		panel.add(lblLectoraColor);
		
		cboxLectoraTipo = new JComboBox<Lectora>();
		cboxLectoraTipo.setModel(new DefaultComboBoxModel<Lectora>(Lectora.values()));
		cboxLectoraTipo.setBounds(125, 9, 115, 20);
		panel.add(cboxLectoraTipo);
		
		JLabel lblLectoraCantidad = new JLabel("Cantidad");
		lblLectoraCantidad.setBounds(296, 38, 73, 16);
		panel.add(lblLectoraCantidad);
		
		spnLectoraCantidad = new JSpinner();
		spnLectoraCantidad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnLectoraCantidad.setBounds(387, 36, 104, 20);
		panel.add(spnLectoraCantidad);
		
		cboxLectoraColor = new JComboBox<ColorLectora>();
		cboxLectoraColor.setModel(new DefaultComboBoxModel<ColorLectora>(ColorLectora.values()));
		cboxLectoraColor.setBounds(125, 36, 115, 20);
		panel.add(cboxLectoraColor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel_1.setBounds(12, 237, 503, 64);
		panelHardware.add(panel_1);
		
		JLabel lblRamTipo = new JLabel("RAM Tipo");
		lblRamTipo.setBounds(12, 12, 95, 14);
		panel_1.add(lblRamTipo);
		
		JLabel label_5 = new JLabel("Estado");
		label_5.setBounds(296, 11, 55, 16);
		panel_1.add(label_5);
		
		cboxRamEstado = new JComboBox<Componente>();
		cboxRamEstado.setModel(new DefaultComboBoxModel<Componente>(Componente.values()));
		cboxRamEstado.setBounds(387, 9, 104, 20);
		panel_1.add(cboxRamEstado);
		
		JLabel lblRamPlacas = new JLabel("Cantidad");
		lblRamPlacas.setBounds(296, 38, 68, 16);
		panel_1.add(lblRamPlacas);
		
		JLabel lblCapacidadTotal = new JLabel("Capacidad MB");
		lblCapacidadTotal.setBounds(22, 38, 85, 16);
		panel_1.add(lblCapacidadTotal);
		
		cboxRamTipo = new JComboBox<MemoriaRam>();
		cboxRamTipo.setModel(new DefaultComboBoxModel<MemoriaRam>(MemoriaRam.values()));
		cboxRamTipo.setBounds(125, 9, 115, 20);
		panel_1.add(cboxRamTipo);
		
		spnRamCantidad = new JSpinner();
		spnRamCantidad.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		spnRamCantidad.setBounds(387, 36, 104, 20);
		panel_1.add(spnRamCantidad);
		
		spnRamCapacidad = new JSpinner();
		spnRamCapacidad.setModel(new SpinnerNumberModel(0, 0, 8192, 256));
		spnRamCapacidad.setBounds(125, 36, 115, 20);
		panel_1.add(spnRamCapacidad);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel_2.setBounds(12, 161, 503, 64);
		panelHardware.add(panel_2);
		
		JLabel lblDiscoTipo = new JLabel("Disco Tipo");
		lblDiscoTipo.setBounds(12, 12, 95, 14);
		panel_2.add(lblDiscoTipo);
		
		JLabel label_9 = new JLabel("Estado");
		label_9.setBounds(296, 11, 55, 16);
		panel_2.add(label_9);
		
		cboxDiscoRigidoEstado = new JComboBox<Componente>();
		cboxDiscoRigidoEstado.setModel(new DefaultComboBoxModel<Componente>(Componente.values()));
		cboxDiscoRigidoEstado.setBounds(387, 9, 104, 20);
		panel_2.add(cboxDiscoRigidoEstado);
		
		JLabel lblDiscoRigidoCapacidad = new JLabel("Capacidad");
		lblDiscoRigidoCapacidad.setBounds(22, 38, 85, 16);
		panel_2.add(lblDiscoRigidoCapacidad);
		
		cboxDiscoRigidoTipo = new JComboBox<Discos>();
		cboxDiscoRigidoTipo.setModel(new DefaultComboBoxModel<Discos>(Discos.values()));
		cboxDiscoRigidoTipo.setBounds(125, 9, 115, 20);
		panel_2.add(cboxDiscoRigidoTipo);
		
		JLabel lblDiscoRigidoCantidad = new JLabel("Cantidad");
		lblDiscoRigidoCantidad.setBounds(296, 38, 73, 16);
		panel_2.add(lblDiscoRigidoCantidad);
		
		spnDiscoRigidoCantidad = new JSpinner();
		spnDiscoRigidoCantidad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnDiscoRigidoCantidad.setBounds(387, 36, 104, 20);
		panel_2.add(spnDiscoRigidoCantidad);
		
		spnDiscoRigidoCapacidad = new JSpinner();
		spnDiscoRigidoCapacidad.setBounds(125, 36, 115, 20);
		panel_2.add(spnDiscoRigidoCapacidad);
		spnDiscoRigidoCapacidad.setModel(new SpinnerNumberModel(0, 0, 1000, 10));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(180, 180, 180), 1, true));
		panel_3.setBounds(12, 59, 503, 90);
		panelHardware.add(panel_3);
		
		JLabel lblProcesador = new JLabel("Procesador");
		lblProcesador.setBounds(12, 12, 95, 14);
		panel_3.add(lblProcesador);
		
		txtProcesador = new JTextField();
		txtProcesador.setColumns(10);
		txtProcesador.setBounds(125, 9, 153, 20);
		panel_3.add(txtProcesador);
		
		JLabel label_12 = new JLabel("Estado");
		label_12.setBounds(296, 11, 55, 16);
		panel_3.add(label_12);
		
		cboxProcesadorEstado = new JComboBox<Componente>();
		cboxProcesadorEstado.setModel(new DefaultComboBoxModel<Componente>(Componente.values()));
		cboxProcesadorEstado.setBounds(387, 9, 104, 20);
		panel_3.add(cboxProcesadorEstado);
		
		JLabel lblProcesadorNucleos = new JLabel("Nucleos");
		lblProcesadorNucleos.setBounds(22, 38, 85, 16);
		panel_3.add(lblProcesadorNucleos);
		
		JLabel label_14 = new JLabel("GHz");
		label_14.setBounds(22, 66, 85, 16);
		panel_3.add(label_14);
		
		SpinnerNumberModel model = new SpinnerNumberModel(0.0, 0.0, 10.0, 0.1);
	    txtProcesadorGhz = new JSpinner(model);
	    JSpinner.NumberEditor ne_txtProcesadorGhz_1 = new JSpinner.NumberEditor(txtProcesadorGhz) ;
	    txtProcesadorGhz.setEditor(ne_txtProcesadorGhz_1);
	    txtProcesadorGhz.setBounds(125, 64, 115, 20);
		panel_3.add(txtProcesadorGhz);
		
		
//		txtProcesadorGhz = new JTextField();
//		txtProcesadorGhz.setColumns(10);
//		txtProcesadorGhz.setBounds(125, 64, 115, 20);
//		panel_3.add(txtProcesadorGhz);
		
		JLabel lblProcesadorCantidad = new JLabel("Cantidad");
		lblProcesadorCantidad.setBounds(296, 38, 73, 16);
		panel_3.add(lblProcesadorCantidad);
		
		spnProcesadorCantidad = new JSpinner();
		spnProcesadorCantidad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnProcesadorCantidad.setBounds(387, 36, 104, 20);
		panel_3.add(spnProcesadorCantidad);
		
		spnProcesadorNucleos = new JSpinner();
		spnProcesadorNucleos.setModel(new SpinnerNumberModel(0, 0, 64, 1));
		spnProcesadorNucleos.setBounds(125, 36, 115, 20);
		panel_3.add(spnProcesadorNucleos);

		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panel_4.setBounds(12, 12, 503, 35);
		panelHardware.add(panel_4);
		
		JLabel label_15 = new JLabel("Placa Base");
		label_15.setBounds(12, 12, 95, 14);
		panel_4.add(label_15);
		
		txtPlacaBase = new JTextField();
		txtPlacaBase.setColumns(10);
		txtPlacaBase.setBounds(125, 9, 153, 20);
		panel_4.add(txtPlacaBase);
		
		JLabel label_16 = new JLabel("Estado");
		label_16.setBounds(296, 11, 55, 16);
		panel_4.add(label_16);
		
		cboxPlacaBaseEstado = new JComboBox<Componente>();
		cboxPlacaBaseEstado.setModel(new DefaultComboBoxModel<Componente>(Componente.values()));
		cboxPlacaBaseEstado.setBounds(387, 9, 104, 20);
		panel_4.add(cboxPlacaBaseEstado);
		
		JPanel panelSoftware = new JPanel();
		tabbedPane.addTab("Software", null, panelSoftware, null);
		panelSoftware.setLayout(null);
		
		JCheckBox chckbxPrograma = new JCheckBox("Programa 1");
		chckbxPrograma.setBounds(8, 8, 112, 24);
		panelSoftware.add(chckbxPrograma);
		
		JPanel panelNotas = new JPanel();
		tabbedPane.addTab("Notas", null, panelNotas, null);
		panelNotas.setLayout(null);
		
		txtpnNotasPC = new JTextPane();
		txtpnNotasPC.setBounds(12, 12, 503, 366);
		panelNotas.add(txtpnNotasPC);
		{	// Botones
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(364, 559, 80, 26);
			contentPanel.add(btnAceptar);
			btnAceptar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(456, 559, 86, 26);
			contentPanel.add(btnCancelar);
			btnCancelar.setActionCommand("Cancel");
		}
		
		JPanel panelIntegrantes = new JPanel();
		panelIntegrantes.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panelIntegrantes.setBounds(269, 12, 273, 105);
		contentPanel.add(panelIntegrantes);
		panelIntegrantes.setLayout(null);
		
		JLabel lblIdsIntegrantes = new JLabel("IDs Integrantes");
		lblIdsIntegrantes.setBounds(12, 15, 105, 16);
		panelIntegrantes.add(lblIdsIntegrantes);
		
		cboxSeleccionarIntegrante = new JComboBox<String>();
		cboxSeleccionarIntegrante.setBounds(12, 43, 249, 20);
		panelIntegrantes.add(cboxSeleccionarIntegrante);
		
		txtIdsIntegrantes = new JTextField();
		txtIdsIntegrantes.setBounds(12, 75, 249, 20);
		panelIntegrantes.add(txtIdsIntegrantes);
		txtIdsIntegrantes.setColumns(10);
		
		JPanel panelComputadoraDetalle = new JPanel();
		panelComputadoraDetalle.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, true));
		panelComputadoraDetalle.setBounds(10, 12, 247, 105);
		contentPanel.add(panelComputadoraDetalle);
		panelComputadoraDetalle.setLayout(null);
		
		JLabel lblIdComputadora = new JLabel("ID Computadora");
		lblIdComputadora.setBounds(12, 15, 98, 14);
		panelComputadoraDetalle.add(lblIdComputadora);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(12, 46, 105, 14);
		panelComputadoraDetalle.add(lblEstado);
		
		txtIdComputadora = new JFormattedTextField(formatter);
		txtIdComputadora.setBounds(127, 12, 104, 20);
		panelComputadoraDetalle.add(txtIdComputadora);
		txtIdComputadora.setColumns(10);
		
		cboxComputadoraEstado = new JComboBox<EstadosPC>();
		cboxComputadoraEstado.setBounds(127, 43, 104, 20);
		panelComputadoraDetalle.add(cboxComputadoraEstado);
		cboxComputadoraEstado.setModel(new DefaultComboBoxModel<EstadosPC>(EstadosPC.values()));
		
		txtFechaAgregada = new JTextField();
		txtFechaAgregada.setBounds(127, 75, 104, 20);
		panelComputadoraDetalle.add(txtFechaAgregada);
		txtFechaAgregada.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha Agregada");
		lblNewLabel.setBounds(12, 77, 98, 16);
		panelComputadoraDetalle.add(lblNewLabel);
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

	public JSpinner getTxtProcesadorGhz() {
		return txtProcesadorGhz;
	}

	public void setTxtProcesadorGhz(JSpinner txtProcesadorGhz) {
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

	public JComboBox<Componente> getCboxPlacaBaseEstado() {
		return cboxPlacaBaseEstado;
	}

	public void setCboxPlacaBaseEstado(JComboBox<Componente> cboxPlacaBaseEstado) {
		this.cboxPlacaBaseEstado = cboxPlacaBaseEstado;
	}

	public JComboBox<Componente> getCboxProcesadorEstado() {
		return cboxProcesadorEstado;
	}

	public void setCboxProcesadorEstado(JComboBox<Componente> cboxProcesadorEstado) {
		this.cboxProcesadorEstado = cboxProcesadorEstado;
	}

	public JComboBox<Componente> getCboxDiscoRigidoEstado() {
		return cboxDiscoRigidoEstado;
	}

	public void setCboxDiscoRigidoEstado(JComboBox<Componente> cboxDiscoRigidoEstado) {
		this.cboxDiscoRigidoEstado = cboxDiscoRigidoEstado;
	}

	public JComboBox<Componente> getCboxRamEstado() {
		return cboxRamEstado;
	}

	public void setCboxRamEstado(JComboBox<Componente> cboxRamEstado) {
		this.cboxRamEstado = cboxRamEstado;
	}

	public JComboBox<Componente> getCboxLectoraEstado() {
		return cboxLectoraEstado;
	}

	public void setCboxLectoraEstado(JComboBox<Componente> cboxLectoraEstado) {
		this.cboxLectoraEstado = cboxLectoraEstado;
	}

	public JTextPane getTxtpnNotasPC() {
		return txtpnNotasPC;
	}

	public void setTxtpnNotasPC(JTextPane txtpnNotasPC) {
		this.txtpnNotasPC = txtpnNotasPC;
	}

	public JComboBox<EstadosPC> getCboxComputadoraEstado() {
		return cboxComputadoraEstado;
	}

	public void setCboxComputadoraEstado(JComboBox<EstadosPC> cboxComputadoraEstado) {
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

	public JComboBox<Discos> getCboxDiscoRigidoTipo() {
		return cboxDiscoRigidoTipo;
	}

	public void setCboxDiscoRigidoTipo(JComboBox<Discos> cboxDiscoRigidoTipo) {
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

	public JComboBox<MemoriaRam> getCboxRamTipo() {
		return cboxRamTipo;
	}

	public void setCboxRamTipo(JComboBox<MemoriaRam> cboxRamTipo) {
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

	public JComboBox<Lectora> getCboxLectoraTipo() {
		return cboxLectoraTipo;
	}

	public void setCboxLectoraTipo(JComboBox<Lectora> cboxLectoraTipo) {
		this.cboxLectoraTipo = cboxLectoraTipo;
	}

	public JComboBox<ColorLectora> getCboxLectoraColor() {
		return cboxLectoraColor;
	}

	public void setCboxLectoraColor(JComboBox<ColorLectora> cboxLectoraColor) {
		this.cboxLectoraColor = cboxLectoraColor;
	}

	public JSpinner getSpnLectoraCantidad() {
		return spnLectoraCantidad;
	}

	public void setSpnLectoraCantidad(JSpinner spnLectoraCantidad) {
		this.spnLectoraCantidad = spnLectoraCantidad;
	}

	public JTextField getTxtFechaAgregada() {
		return txtFechaAgregada;
	}

	public void setTxtFechaAgregada(JTextField txtFechaAgregada) {
		this.txtFechaAgregada = txtFechaAgregada;
	}

	public JComboBox<String> getCboxSeleccionarIntegrante() {
		return cboxSeleccionarIntegrante;
	}

	public void setCboxSeleccionarIntegrante(JComboBox<String> cboxSeleccionarIntegrante) {
		this.cboxSeleccionarIntegrante = cboxSeleccionarIntegrante;
	}
}
