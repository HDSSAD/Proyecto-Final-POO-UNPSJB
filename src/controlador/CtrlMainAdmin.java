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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Computadora;
import modelo.ComputadoraDAOImpl;
import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaMainGUIAdmin;

public class CtrlMainAdmin implements ActionListener, WindowListener, MouseListener {

	private IntegranteDAOImpl integrante;
	private ComputadoraDAOImpl computadora;
	private VistaMainGUIAdmin mainGUI;
	private CtrlLogin ctrlLogin;
	private String dni;

	public CtrlMainAdmin(CtrlLogin ctrlLogin, String dni) {
		this.setCtrlLogin(ctrlLogin);
		this.setDni(dni);
		this.setIntegrante(this.getCtrlLogin().getIntegrante());
		this.setMainGUI(new VistaMainGUIAdmin(this));
		this.getMainGUI().setTitle(this.getMainGUI().getTitle() + " - " + this.getIntegrante().getAdminLevel(dni));
		this.getMainGUI().setVisible(true);
	}

	private void openDBLoginWindow() {
		this.getMainGUI().dispose();
		this.getCtrlLogin().getVistaLogin().setVisible(true);
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
		if (e.getSource() == this.getMainGUI().getBtnAnadir()) {
			CtrlIntegranteAgregar ctrlAgregarintegrante = new CtrlIntegranteAgregar();
			ctrlAgregarintegrante.getVistaIntegrante().setVisible(true);
			this.updateTableIntegrantes(this.getIntegrante().buscarIntegrante());

		} else if (e.getSource() == this.getMainGUI().getBtnEliminar()) {
			String dni = this.getMainGUI().getTxtDNI().getText();
			if (!dni.isBlank()) {
				this.getIntegrante().borrarIntegrante(dni);
				List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
				this.updateTableIntegrantes(integrantes);
				for (JTextField jtf : this.getMainGUI().getArrayTextField()) {
					jtf.setText("");
				}
			}

		} else if (e.getSource() == this.getMainGUI().getBtnModificar()) {
			if (this.getMainGUI().getTblIntegrantes().getSelectedRow() != -1) {
				CtrlIntegranteEditar ctrlEditarIntegrante = new CtrlIntegranteEditar();
				for (int i = 0; i < ctrlEditarIntegrante.getVistaIntegrante().getArrayTxtField().size(); i++) {
					ctrlEditarIntegrante.getVistaIntegrante().getArrayTxtField().get(i)
							.setText(this.getMainGUI().getArrayTextField().get(i).getText());
				}
				ctrlEditarIntegrante.getVistaIntegrante().getCboxTipoIntegrante().setEditable(true);
				ctrlEditarIntegrante.getVistaIntegrante().getCboxTipoIntegrante()
						.setSelectedItem(this.getMainGUI().getTxtTipoIntegrante().getText());
				ctrlEditarIntegrante.getVistaIntegrante().getCboxTipoIntegrante().setEditable(false);
				ctrlEditarIntegrante.getVistaIntegrante().setVisible(true);
			}

		} else if (e.getSource() == this.getMainGUI().getBtnBuscar()) {
			CtrlBuscarIntegrante ctrlBuscarIntegrante = new CtrlBuscarIntegrante();
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
		} else if (e.getSource() == this.getMainGUI().getBtnAñadirPC()) {
			CtrlPCAgregar ctrlAgregarPC = new CtrlPCAgregar();
			ctrlAgregarPC.getVistaComputadora().setVisible(true);

		} else if (e.getSource() == this.getMainGUI().getBtnBuscarPC()) {

		} else if (e.getSource() == this.getMainGUI().getBtnEditarPC()) {
			CtrlPCEditar ctrlPCEditar = new CtrlPCEditar();
			ctrlPCEditar.getVistaComputadora().setVisible(true);
			
		} else if (e.getSource() == this.getMainGUI().getBtnEliminarPC()) {

		} else if (e.getSource() == this.getMainGUI().getBtnMostrarTodoPC()) {

		}
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public VistaMainGUIAdmin getMainGUI() {
		return mainGUI;
	}

	public void setMainGUI(VistaMainGUIAdmin mainGUI) {
		this.mainGUI = mainGUI;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
		if (integrantes != null)
			this.updateTableIntegrantes(integrantes);
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
			Integer idComputadora = Integer.parseInt((table.getValueAt(table.getSelectedRow(), 0).toString()));
			// si el anterior retorna un objeto, un cast a Integer podria ser suficiente
			Computadora computadora = this.getComputadora().buscarComputadora(idComputadora);
			this.getMainGUI().getTxtpnDatospc().setText(computadora.toString());
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
