package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ComputadoraDAOImpl;
import modelo.IntegranteDAOImpl;
import vista.VistaPCBuscar;

public class CtrlPCBuscar implements ItemListener, ActionListener {

	private VistaPCBuscar vistaPCBuscar;
	private ComputadoraDAOImpl computadora;
	private IntegranteDAOImpl integrante;
	private String where;
	private ArrayList<String> parametros;

	public CtrlPCBuscar() {
		this.setVistaPCBuscar(new VistaPCBuscar(this));
		this.setComputadora(new ComputadoraDAOImpl());
		this.setIntegrante(new IntegranteDAOImpl());
		this.setParametros(new ArrayList<String>());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaPCBuscar().getBtnAceptar()) {
			String estado = this.getVistaPCBuscar().getCboxEstado().getSelectedItem().toString();
			String idIntegrante = this.getVistaPCBuscar().getTxtIntegrante().getText();
			String idComputadora = this.getVistaPCBuscar().getTxtNroComputadora().getText();

			if (estado.equals("Pendiente")) {
				this.getParametros().add(estado);
				this.setWhere("where estado like ?");

			} else if (estado.equals("Revisada") || estado.equals("Completada") || estado.equals("Descarte")
					|| estado.equals("Donada")) {
				if (idIntegrante.isBlank()) {
					this.getParametros().add(estado);
					this.setWhere("where estado like ?");
				} else {
					this.getParametros().add(estado);
					this.getParametros().add(idIntegrante);
					this.setWhere("where estado like ? and idintegrante like ?");
				}

			} else if (estado.equals("Sin seleccion")) {
				if (idIntegrante.isBlank() && idComputadora.isBlank()) {
					JOptionPane.showMessageDialog(this.getVistaPCBuscar(),
							"Se debe realizar una seleccion de criterios de busqueda", "Sistema",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (idIntegrante.isBlank()) {
						this.getParametros().add(idComputadora);
						this.setWhere("where idcomputadora like ?");
					} else if (idComputadora.isBlank()) {
						this.getParametros().add(idIntegrante);
						this.setWhere("where idintegrante like ?");
					} else {
						this.getParametros().add(idIntegrante);
						this.getParametros().add(idComputadora);
						this.setWhere("where idintegrante like ? and idcomputadora like ?");
					}
				}
			}

		} else if (e.getSource() == this.getVistaPCBuscar().getBtnCancelar()) {
			this.getVistaPCBuscar().dispose();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == this.getVistaPCBuscar().getCboxEstado()) {
			String estado = this.getVistaPCBuscar().getCboxEstado().getSelectedItem().toString();
			if (estado.equals("Pendiente")) {
				this.getVistaPCBuscar().getTxtIntegrante().setText("");
				this.getVistaPCBuscar().getTxtNroComputadora().setText("");
				this.getVistaPCBuscar().getTxtIntegrante().setEnabled(false);
				this.getVistaPCBuscar().getTxtNroComputadora().setEnabled(false);
			} else if (estado.equals("Revisada") || estado.equals("Completada") || estado.equals("Descarte")
					|| estado.equals("Donada")) {
				this.getVistaPCBuscar().getTxtIntegrante().setEnabled(true);
				this.getVistaPCBuscar().getTxtNroComputadora().setText("");
				this.getVistaPCBuscar().getTxtNroComputadora().setEnabled(false);
			} else if (estado.equals("Sin seleccion")) {
				this.getVistaPCBuscar().getTxtIntegrante().setEnabled(true);
				this.getVistaPCBuscar().getTxtNroComputadora().setEnabled(true);
			}
		}
	}

	public VistaPCBuscar getVistaPCBuscar() {
		return vistaPCBuscar;
	}

	public void setVistaPCBuscar(VistaPCBuscar vistaPCBuscar) {
		this.vistaPCBuscar = vistaPCBuscar;
	}

	public ComputadoraDAOImpl getComputadora() {
		return computadora;
	}

	public void setComputadora(ComputadoraDAOImpl computadora) {
		this.computadora = computadora;
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public ArrayList<String> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<String> parametros) {
		this.parametros = parametros;
	}

}
