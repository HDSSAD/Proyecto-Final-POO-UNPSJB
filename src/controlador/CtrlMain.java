package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.MainGUI;

public class CtrlMain implements ActionListener, WindowListener, MouseListener {

	private IntegranteDAOImpl integrante;
	private MainGUI mainGUI;

	public CtrlMain() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setMainGUI(new MainGUI(this));
		this.getMainGUI().setVisible(true);
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
		this.getMainGUI().getTblIntegrantes().getColumnModel().getColumn(0).setResizable(false);
		this.getMainGUI().getTblIntegrantes().getColumnModel().getColumn(1).setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getMainGUI().getBtnAnadir()) {
			CtrlAgregarIntegrante ctrlAgregarintegrante = new CtrlAgregarIntegrante();
			ctrlAgregarintegrante.getVistaIntegrante().setVisible(true);
			return;
		} else if (e.getSource() == this.getMainGUI().getBtnEliminar()) {
			String dni = this.getMainGUI().getTxtDNI().getText();
			this.getIntegrante().borrarIntegrante(dni);
			List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
			this.updateTableIntegrantes(integrantes);
			for (JTextField jtf : this.getMainGUI().getArrayTextField()) {
				jtf.setText("");
			}
			return;
		} else if (e.getSource() == this.getMainGUI().getBtnModificar()) {
			CtrlEditarIntegrante ctrlEditarIntegrante = new CtrlEditarIntegrante();
			for (int i = 0; i < ctrlEditarIntegrante.getVistaIntegrante().getArrayTxtField().size(); i++) {
				ctrlEditarIntegrante.getVistaIntegrante().getArrayTxtField().get(i)
						.setText(this.getMainGUI().getArrayTextField().get(i).getText());
			}
			ctrlEditarIntegrante.getVistaIntegrante().setVisible(true);
			return;
		} else if (e.getSource() == this.getMainGUI().getBtnBuscar()) {
			CtrlBuscarIntegrante ctrlBuscarIntegrante = new CtrlBuscarIntegrante();
			ctrlBuscarIntegrante.getVistaBuscarIntegrante().setVisible(true);
			if (!ctrlBuscarIntegrante.getWhere().isBlank()) {
				List<Integrante> integrantes = this.getIntegrante().buscarIntegrante(
						ctrlBuscarIntegrante.getWhere(),
						ctrlBuscarIntegrante.getParametros());
				this.updateTableIntegrantes(integrantes);
			}
			return;
		} else if (e.getSource() == this.getMainGUI().getBtnMostrarTodo()) {
			List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
			this.updateTableIntegrantes(integrantes);
		}
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public MainGUI getMainGUI() {
		return mainGUI;
	}

	public void setMainGUI(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
		this.updateTableIntegrantes(integrantes);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

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
			this.getMainGUI().getTxtApellido().setText(integrante.getApellido());
			this.getMainGUI().getTxtNombre().setText(integrante.getNombre());
			this.getMainGUI().getTxtFechaNacimiento().setText(integrante.getFechaNacimiento());
			this.getMainGUI().getTxtDireccion().setText(integrante.getDireccion());
			this.getMainGUI().getTxtTelefono().setText(integrante.getTelefono());
			this.getMainGUI().getTxtTelefono2().setText(integrante.getTelefono2());
			this.getMainGUI().getTxtCorreo().setText(integrante.getCorreo());
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
}
