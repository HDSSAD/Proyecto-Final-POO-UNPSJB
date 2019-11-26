package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.BD;
import modelo.Computadora;
import modelo.ComputadoraDAOImpl;
import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
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
				List<Computadora> computadoras = new ArrayList<Computadora>();
				if (!ctrlPCBuscar.getVistaPCBuscar().getTxtIntegrante().getText().isBlank()) {
					for (String nroPC : this.getComputadora()
							.getComputadoraFromIntPC(ctrlPCBuscar.getVistaPCBuscar().getTxtIntegrante().getText())
							.split(",")) {
						computadoras.add(this.getComputadora().buscarComputadora(Integer.valueOf(nroPC.strip())));
					}
				} else if (!ctrlPCBuscar.getVistaPCBuscar().getTxtNroComputadora().getText().isBlank()) {
					computadoras = this.getComputadora().buscarComputadora(ctrlPCBuscar.getWhere(),
							ctrlPCBuscar.getParametros());
				} else {
					computadoras = this.getComputadora().buscarComputadora(ctrlPCBuscar.getWhere(),
							ctrlPCBuscar.getParametros());
				}
				this.updateTableComputadoras(computadoras);
			}
		} else if (e.getSource() == this.getMainGUI().getBtnEditarPC()) {
			if (this.getMainGUI().getTblPC().getSelectedRow() != -1) {
				Computadora computadora = this.getComputadora().buscarComputadora(Integer.valueOf((this.getMainGUI()
						.getTblPC().getValueAt(this.getMainGUI().getTblPC().getSelectedRow(), 0).toString())));
				CtrlPCEditar ctrlPCEditar = new CtrlPCEditar(computadora);

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

			}

		} else if (e.getSource() == this.getMainGUI().getBtnMostrarTodoPC()) {
			List<Computadora> computadora = this.getComputadora().buscarComputadora();
			if (computadora != null)
				this.updateTableComputadoras(computadora);
		} else if (e.getSource() == this.getMainGUI().getBtnReportePersonalTodos()) {
			String sourceFileName = "C:\\Users\\Sebastian\\Desktop\\Proyecto Final POO\\integrantesTodos.jasper";
			this._callJasperReportNew(sourceFileName, null);
			System.out.println("siome");

		} else if (e.getSource() == this.getMainGUI().getBtnReportePersonalCumpleaños()) {
			String sourceFileName = "C:\\Users\\Sebastian\\Desktop\\Proyecto Final POO\\cumpleaños.jasper";
			Calendar cal = Calendar.getInstance();
			Integer month = cal.get(Calendar.MONTH) + 1;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ParamMes", month);
			this._callJasperReportNew(sourceFileName, map);

		} else if (e.getSource() == this.getMainGUI().getBtnReportePersonalAdmin()
				|| e.getSource() == this.getMainGUI().getBtnReportePersonalCoord()
				|| e.getSource() == this.getMainGUI().getBtnReportePersonalIntegr()) {
			String sourceFileName = "C:\\Users\\Sebastian\\Desktop\\Proyecto Final POO\\integrantesTipo.jasper";
			Map<String, Object> map = new HashMap<String, Object>();
			if (e.getSource() == this.getMainGUI().getBtnReportePersonalAdmin()) {
				map.put("ParamIntegranteTipo", "Administrador");
			} else if (e.getSource() == this.getMainGUI().getBtnReportePersonalCoord()) {
				map.put("ParamIntegranteTipo", "Coordinador");
			} else if (e.getSource() == this.getMainGUI().getBtnReportePersonalIntegr()) {
				map.put("ParamIntegranteTipo", "Integrante");
			}
			if (map.size() > 0) {
				this._callJasperReportNew(sourceFileName, map);
			} else {
				JOptionPane.showMessageDialog(this.getMainGUI(), "Parametros para la llamada al Reporte no validos",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == this.getMainGUI().getBtnReportePCCompletada()
				|| e.getSource() == this.getMainGUI().getBtnReportePCDescartada()
				|| e.getSource() == this.getMainGUI().getBtnReportePCDonadas()
				|| e.getSource() == this.getMainGUI().getBtnReportePCPendiente()
				|| e.getSource() == this.getMainGUI().getBtnReportePCRevisada()) {
			String sourceFileName = "C:\\Users\\Sebastian\\Desktop\\Proyecto Final POO\\computadorasEstado.jasper";
			Map<String, Object> map = new HashMap<String, Object>();
			if (e.getSource() == this.getMainGUI().getBtnReportePCCompletada()) {
				map.put("ParamEstado", "Completada");
			} else if (e.getSource() == this.getMainGUI().getBtnReportePCDescartada()) {
				map.put("ParamEstado", "Descarte");
			} else if (e.getSource() == this.getMainGUI().getBtnReportePCDonadas()) {
				map.put("ParamEstado", "Donada");
			} else if (e.getSource() == this.getMainGUI().getBtnReportePCPendiente()) {
				map.put("ParamEstado", "Pendiente");
			} else if (e.getSource() == this.getMainGUI().getBtnReportePCRevisada()) {
				map.put("ParamEstado", "Revisada");
			}
			if (map.size() > 0) {
				this._callJasperReportNew(sourceFileName, map);
			} else {
				JOptionPane.showMessageDialog(this.getMainGUI(), "Parametros para la llamada al Reporte no validos",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void _callJasperReportNew(String sourceFileName, Map<String, Object> map) {
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(sourceFileName);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, BD.getInstance().getConexion());
			if (!jasperPrint.getPages().isEmpty()) {
				JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
				jasperViewer.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this.getMainGUI(),
						"No existen resultados para esta busqueda en la base de datos", "Sin datos",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (JRException e1) {
			this._callJasperFileError(e1);
		}
	}

	private void _callJasperFileError(JRException e1) {
		JOptionPane.showMessageDialog(this.getMainGUI(),
				"Ocurrio un problema al obtener el archivo para generar el informe", "Error",
				JOptionPane.ERROR_MESSAGE);
		e1.printStackTrace();
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
//			this.getMainGUI().getTxtDNI().setText(integrante.getDni());
			this.getMainGUI().getTxtTipoIntegrante().setText(integrante.getTipo());
			this.getMainGUI().getTxtApellido().setText(integrante.getApellido());
			this.getMainGUI().getTxtNombre().setText(integrante.getNombre());
			this.getMainGUI().getTxtFechaNacimiento().setText(integrante.getFechaNacimiento());
//			this.getMainGUI().getTxtDireccion().setText(integrante.getDireccion());
			this.getMainGUI().getTxtTelefono().setText(integrante.getTelefono());
			this.getMainGUI().getTxtTelefono2().setText(integrante.getTelefono2());
			this.getMainGUI().getTxtCorreo().setText(integrante.getCorreo());
			this.getMainGUI().getTxtComputadorasTrabajadas()
					.setText(this.getComputadora().obtenerComputadorasTrabajadas(integrante.getDni()));
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
