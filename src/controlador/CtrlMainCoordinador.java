package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Computadora;
import modelo.ComputadoraDAOImpl;
import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaMainGUICoordinador;

public class CtrlMainCoordinador implements ActionListener, WindowListener, MouseListener {

	private IntegranteDAOImpl integrante;
	private ComputadoraDAOImpl computadora;
	private VistaMainGUICoordinador mainGUI;
	private CtrlLogin ctrlLogin;
	private String dni;

	public CtrlMainCoordinador(CtrlLogin ctrlLogin, String dni) {
		this.setCtrlLogin(ctrlLogin);
		this.setDni(dni);
		this.setIntegrante(new IntegranteDAOImpl());
		this.setComputadora(new ComputadoraDAOImpl());
		this.setMainGUI(new VistaMainGUICoordinador(this));
		this.getMainGUI().setTitle(this.getMainGUI().getTitle() + " - " + this.getIntegrante().getAdminLevel(dni));
		this.getMainGUI().setVisible(true);
	}

	private void openDBLoginWindow() {
		this.getMainGUI().dispose();
		this.getCtrlLogin().getVistaLogin().setVisible(true);
	}

	private void updateTableComputadoras(List<Computadora> computadoras) {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Nro PC", "Estado" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		for (Computadora computadora : computadoras) {
			Object[] row = new Object[2];
			row[0] = computadora.getIdComputadora();
			row[1] = computadora.getEstado();
			modelo.addRow(row);
		}
		this.getMainGUI().getTblPC().setModel(modelo);
		this.getMainGUI().getTblPC().getColumnModel().getColumn(0).setMaxWidth(70);
		this.getMainGUI().getTblPC().getColumnModel().getColumn(0).setMinWidth(70);
		this.getMainGUI().getTblPC().getColumnModel().getColumn(0).setResizable(false);
		this.getMainGUI().getTblPC().getColumnModel().getColumn(1).setResizable(false);

	}

	private void updateTableIntegrantes(List<Integrante> integrantes) {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Apellido y Nombre" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		for (Integrante integrante : integrantes) {
			Object[] row = new Object[2];
			row[0] = integrante.getDni();
			row[1] = integrante.getApellido() + " " + integrante.getNombre();
			modelo.addRow(row);
		}
		this.getMainGUI().getTblIntegrantes().setModel(modelo);
		this.getMainGUI().getTblIntegrantes().getColumnModel().getColumn(0).setMaxWidth(70);
		this.getMainGUI().getTblIntegrantes().getColumnModel().getColumn(0).setMinWidth(70);
		this.getMainGUI().getTblIntegrantes().getColumnModel().getColumn(0).setResizable(false);
		this.getMainGUI().getTblIntegrantes().getColumnModel().getColumn(1).setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getMainGUI().getBtnModificar()) {
			if (this.getMainGUI().getTblIntegrantes().getSelectedRow() != -1) {
				if (this.getMainGUI().getTxtTipoIntegrante().getText().equals("Integrante")
						|| this.getDni().equals(this.getMainGUI().getTxtDNI().getText())) {
					CtrlIntegranteEditar ctrlEditarIntegrante = new CtrlIntegranteEditar();
					for (int i = 0; i < ctrlEditarIntegrante.getVistaIntegrante().getArrayTxtField().size(); i++) {
						ctrlEditarIntegrante.getVistaIntegrante().getArrayTxtField().get(i)
								.setText(this.getMainGUI().getArrayTextField().get(i).getText());
					}
					ctrlEditarIntegrante.getVistaIntegrante().getTxtFechaNacimiento()
							.setValue(this.getMainGUI().getTxtFechaNacimiento().getText());
					ctrlEditarIntegrante.getVistaIntegrante().getCboxTipoIntegrante().setEditable(true);
					ctrlEditarIntegrante.getVistaIntegrante().getCboxTipoIntegrante()
							.setSelectedItem(this.getMainGUI().getTxtTipoIntegrante().getText());
					ctrlEditarIntegrante.getVistaIntegrante().getCboxTipoIntegrante().setEditable(false);
					ctrlEditarIntegrante.getVistaIntegrante().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this.getMainGUI(),
							"Una cuenta de 'Coordinador' solo puede editar usuarios de tipo 'Integrante' o su propia informacion",
							"Sistema", JOptionPane.ERROR_MESSAGE);
				}

			}

		} else if (e.getSource() == this.getMainGUI().getBtnBuscar()) {
			CtrlIntegranteBuscar ctrlBuscarIntegrante = new CtrlIntegranteBuscar();
			ctrlBuscarIntegrante.getVistaBuscarIntegrante().setVisible(true);
			if (!ctrlBuscarIntegrante.getWhere().isBlank()) {
				List<Integrante> integrantes = this.getIntegrante().buscarIntegrante(ctrlBuscarIntegrante.getWhere(),
						ctrlBuscarIntegrante.getParametros());
				this.updateTableIntegrantes(integrantes);
			}

		} else if (e.getSource() == this.getMainGUI().getBtnMostrarTodo()) {
			List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
			if (integrantes != null)
				this.updateTableIntegrantes(integrantes);

		} else if (e.getSource() == this.getMainGUI().getMntmCerrarSesion()) {
			int result = JOptionPane.showConfirmDialog(this.getMainGUI(), "Confirmar cierre de sesion", "Cerrar sesion",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				this.openDBLoginWindow();
			}
		} else if (e.getSource() == this.getMainGUI().getMntmCambiarContraseña()) {
			CtrlContraseña ctrlContraseña = new CtrlContraseña(this.getDni());
			ctrlContraseña.getVistaContraseña().setVisible(true);

		} else if (e.getSource() == this.getMainGUI().getBtnAñadirPC()) {
			CtrlPCAgregar ctrlAgregarPC = new CtrlPCAgregar();
			ctrlAgregarPC.getVistaComputadora().getTxtIdComputadora()
					.setText(String.valueOf(Integer.parseInt(this.getComputadora().obtenerUltimoNroPC()) + 1));
			ctrlAgregarPC.getVistaComputadora().getTxtIdComputadora().setEnabled(false);
			ctrlAgregarPC.getVistaComputadora().setVisible(true);
			this.updateTableComputadoras(this.getComputadora().buscarComputadora());

		} else if (e.getSource() == this.getMainGUI().getBtnBuscarPC()) {
			CtrlPCBuscar ctrlPCBuscar = new CtrlPCBuscar();
			ctrlPCBuscar.getVistaPCBuscar().setVisible(true);
			if (!ctrlPCBuscar.getWhere().isBlank()) {
				List<Computadora> computadoras = this.getComputadora().buscarComputadora(ctrlPCBuscar.getWhere(),
						ctrlPCBuscar.getParametros());
				this.updateTableComputadoras(computadoras);
			}

		} else if (e.getSource() == this.getMainGUI().getBtnEditarPC()) {
			if (this.getMainGUI().getTblPC().getSelectedRow() != -1) {
				CtrlPCEditar ctrlPCEditar = new CtrlPCEditar();
				Computadora computadora = this.getComputadora().buscarComputadora(Integer.valueOf((this.getMainGUI()
						.getTblPC().getValueAt(this.getMainGUI().getTblPC().getSelectedRow(), 0).toString())));
				if (computadora != null) {
					ctrlPCEditar.getVistaComputadora().getTxtIdComputadora().setText(computadora.getIdComputadora());
					ctrlPCEditar.getVistaComputadora().getTxtIdComputadora().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getTxtPlacaBase()
							.setText(computadora.getPlacaBase().getModelo());
					ctrlPCEditar.getVistaComputadora().getTxtpnNotasPC().setText(computadora.getNotas());
					ctrlPCEditar.getVistaComputadora().getTxtProcesador()
							.setText(computadora.getProcesador().getModelo());
					ctrlPCEditar.getVistaComputadora().getTxtProcesadorGhz()
							.setText(computadora.getProcesador().getGhz());
					ctrlPCEditar.getVistaComputadora().getCboxDiscoRigidoEstado().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxDiscoRigidoEstado()
							.setSelectedItem(computadora.getDisco().getEstado());
					ctrlPCEditar.getVistaComputadora().getCboxDiscoRigidoEstado().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxDiscoRigidoTipo().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxDiscoRigidoTipo()
							.setSelectedItem(computadora.getDisco().getModelo());
					ctrlPCEditar.getVistaComputadora().getCboxDiscoRigidoTipo().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxLectoraColor().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxLectoraColor()
							.setSelectedItem(computadora.getLectora().getColor());
					ctrlPCEditar.getVistaComputadora().getCboxLectoraColor().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxLectoraEstado().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxLectoraEstado()
							.setSelectedItem(computadora.getLectora().getEstado());
					ctrlPCEditar.getVistaComputadora().getCboxLectoraEstado().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxLectoraTipo().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxLectoraTipo()
							.setSelectedItem(computadora.getLectora().getModelo());
					ctrlPCEditar.getVistaComputadora().getCboxLectoraTipo().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxPlacaBaseEstado().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxPlacaBaseEstado()
							.setSelectedItem(computadora.getPlacaBase().getEstado());
					ctrlPCEditar.getVistaComputadora().getCboxPlacaBaseEstado().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxProcesadorEstado().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxProcesadorEstado()
							.setSelectedItem(computadora.getProcesador().getEstado());
					ctrlPCEditar.getVistaComputadora().getCboxProcesadorEstado().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxRamEstado().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxRamEstado()
							.setSelectedItem(computadora.getRam().getEstado());
					ctrlPCEditar.getVistaComputadora().getCboxRamEstado().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getCboxRamTipo().setEditable(true);
					ctrlPCEditar.getVistaComputadora().getCboxRamTipo()
							.setSelectedItem(computadora.getRam().getModelo());
					ctrlPCEditar.getVistaComputadora().getCboxRamTipo().setEditable(false);
					ctrlPCEditar.getVistaComputadora().getSpnDiscoRigidoCantidad()
							.setValue(computadora.getDisco().getCantidad());
					ctrlPCEditar.getVistaComputadora().getSpnDiscoRigidoCapacidad()
							.setValue(computadora.getDisco().getCapacidad());
					ctrlPCEditar.getVistaComputadora().getSpnLectoraCantidad()
							.setValue(computadora.getLectora().getCantidad());
					ctrlPCEditar.getVistaComputadora().getSpnProcesadorCantidad()
							.setValue(computadora.getProcesador().getCantidad());
					ctrlPCEditar.getVistaComputadora().getSpnProcesadorNucleos()
							.setValue(computadora.getProcesador().getNucleos());
					ctrlPCEditar.getVistaComputadora().getSpnRamCantidad().setValue(computadora.getRam().getCantidad());
					ctrlPCEditar.getVistaComputadora().getSpnRamCapacidad()
							.setValue(computadora.getRam().getCapacidad());

					String participantes = this.getComputadora().getIntegranteFromIntPC(computadora.getIdComputadora());
					if (!participantes.isBlank()) {
						ctrlPCEditar.getVistaComputadora().getTxtIdsIntegrantes().setText(participantes);
						ctrlPCEditar.getVistaComputadora().getCboxComputadoraEstado()
								.setSelectedItem(computadora.getEstado());
					} else {
						ctrlPCEditar.getVistaComputadora().getCboxComputadoraEstado().setSelectedItem("Pendiente");
					}

					ctrlPCEditar.getVistaComputadora().setVisible(true);
					this.updateTableComputadoras(this.getComputadora().buscarComputadora());
				} else {
					ctrlPCEditar.getVistaComputadora().dispose();
					JOptionPane.showMessageDialog(this.getMainGUI(),
							"Ocurrio un error al recibir datos de la computadora desde la base de datos", "Sistema",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			
		} else if (e.getSource() == this.getMainGUI().getBtnMostrarTodoPC()) {
			List<Computadora> computadora = this.getComputadora().buscarComputadora();
			if (computadora != null)
				this.updateTableComputadoras(computadora);
		}
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public VistaMainGUICoordinador getMainGUI() {
		return mainGUI;
	}

	public void setMainGUI(VistaMainGUICoordinador mainGUI) {
		this.mainGUI = mainGUI;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
		if (integrantes != null)
			this.updateTableIntegrantes(integrantes);
		List<Computadora> computadoras;
		computadoras = this.getComputadora().buscarComputadora();
		if (computadoras != null)
			this.updateTableComputadoras(computadoras);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(this.getMainGUI(), "Quieres salir de la aplicacion?",
				"Confirmar cierre: ", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			getMainGUI().setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.getCtrlLogin().getVistaLogin().setVisible(true);
		} else {
			getMainGUI().setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.getMainGUI().getTblIntegrantes()) {
			JTable table = this.getMainGUI().getTblIntegrantes();
			String dni = table.getValueAt(table.getSelectedRow(), 0).toString();
			Integrante integrante = this.getIntegrante().buscarIntegrante(dni);
			this.getMainGUI().getTxtDNI().setText(integrante.getDni());
			this.getMainGUI().getTxtTipoIntegrante().setText(integrante.getTipo());
			this.getMainGUI().getTxtApellido().setText(integrante.getApellido());
			this.getMainGUI().getTxtNombre().setText(integrante.getNombre());
			this.getMainGUI().getTxtFechaNacimiento().setText(integrante.getFechaNacimiento());
			this.getMainGUI().getTxtDireccion().setText(integrante.getDireccion());
			this.getMainGUI().getTxtTelefono().setText(integrante.getTelefono());
			this.getMainGUI().getTxtTelefono2().setText(integrante.getTelefono2());
			this.getMainGUI().getTxtCorreo().setText(integrante.getCorreo());
		} else if (e.getSource() == this.getMainGUI().getTblPC()) {
			JTable table = this.getMainGUI().getTblPC();
			String idComputadora = table.getValueAt(table.getSelectedRow(), 0).toString();
			// si el anterior retorna un objeto, un cast a Integer podria ser suficiente
			Computadora computadora = this.getComputadora().buscarComputadora(Integer.valueOf(idComputadora));
			if (computadora != null) {
				this.getMainGUI().getTxtpnDatospc().setText(computadora.toString());
			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public CtrlLogin getCtrlLogin() {
		return ctrlLogin;
	}

	public void setCtrlLogin(CtrlLogin ctrlLogin) {
		this.ctrlLogin = ctrlLogin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public ComputadoraDAOImpl getComputadora() {
		return computadora;
	}

	public void setComputadora(ComputadoraDAOImpl computadora) {
		this.computadora = computadora;
	}

}
