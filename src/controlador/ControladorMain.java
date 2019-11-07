package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.MainGUI;

public class ControladorMain implements ActionListener, WindowListener {

	private IntegranteDAOImpl integrante;
	private MainGUI mainGUI;

	public ControladorMain() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setMainGUI(new MainGUI(this));
		this.getMainGUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getMainGUI().getBtnAnadir()) {
			ControladorABMIntegrante ctrlABMintegrante = new ControladorABMIntegrante();
			ctrlABMintegrante.getVistaIntegrante().setLocationRelativeTo(null);
			ctrlABMintegrante.getVistaIntegrante().setVisible(true);
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
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Apellido y Nombre"}) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		List<Integrante> integrantes = this.getIntegrante().buscarIntegrante();
		for (Integrante integrante : integrantes) {
			Object[] row = new Object[1];
			row[0] = integrante.getApellido() + " " + integrante.getNombre();
			modelo.addRow(row);
		}
		this.getMainGUI().getTblIntegrantes().setModel(modelo);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
