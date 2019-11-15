package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import componentes.CompDiscoRigido;
import componentes.CompLectora;
import componentes.CompMemoriaRam;
import componentes.CompPlacaBase;
import componentes.CompProcesador;
import modelo.Computadora;
import modelo.ComputadoraDAOImpl;
import vista.VistaAgregarPC;

public class CtrlAgregarPC implements ActionListener {

	private ComputadoraDAOImpl computadora;
	private VistaAgregarPC vistaComputadora;
	

	public CtrlAgregarPC() {
		this.setComputadora(new ComputadoraDAOImpl());
		this.setVistaComputadora(new VistaAgregarPC(this));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaComputadora().getBtnAceptar()) {
			String idsIntegrantes = this.getVistaComputadora().getTxtIdsIntegrantes().getText();

			String id = this.getVistaComputadora().getTxtIdComputadora().getText();
			String estado = this.getVistaComputadora().getCboxComputadoraEstado().getSelectedItem().toString();

			String placaBase = this.getVistaComputadora().getTxtPlacaBase().getText();
			String placaBaseEstado = this.getVistaComputadora().getCboxPlacaBaseEstado().getSelectedItem().toString();
			Integer placaBaseCantidad = 0;
			if (!this.getVistaComputadora().getTxtPlacaBase().getText().isBlank()) {
				placaBaseCantidad = 1;
			}

			String procesador = this.getVistaComputadora().getTxtProcesador().getText();
			String procesadorEstado = this.getVistaComputadora().getCboxProcesadorEstado().getSelectedItem().toString();
			Integer procesadorCantidad = (Integer) this.getVistaComputadora().getSpnProcesadorCantidad().getValue();
			Integer procesadorNucleos = (Integer) this.getVistaComputadora().getSpnProcesadorNucleos().getValue();
			String procesadorGhz = this.getVistaComputadora().getTxtProcesadorGhz().getText();

			String disco = this.getVistaComputadora().getCboxDiscoRigidoEstado().getSelectedItem().toString();
			String discoEstado = this.getVistaComputadora().getCboxDiscoRigidoEstado().getSelectedItem().toString();
			Integer discoCantidad = (Integer) this.getVistaComputadora().getSpnDiscoRigidoCantidad().getValue();
			Integer discoCapacidad = (Integer) this.getVistaComputadora().getSpnDiscoRigidoCapacidad().getValue();

			String ram = this.getVistaComputadora().getCboxRamTipo().getSelectedItem().toString();
			String ramEstado = this.getVistaComputadora().getCboxRamEstado().getSelectedItem().toString();
			Integer ramCantidad = (Integer) this.getVistaComputadora().getSpnRamCantidad().getValue();
			Integer ramCapacidad = (Integer) this.getVistaComputadora().getSpnRamCapacidad().getValue();

			String lectora = this.getVistaComputadora().getCboxLectoraTipo().getSelectedItem().toString();
			String lectoraEstado = this.getVistaComputadora().getCboxLectoraEstado().getSelectedItem().toString();
			Integer lectoraCantidad = (Integer) this.getVistaComputadora().getSpnLectoraCantidad().getValue();
			String lectoraColor = this.getVistaComputadora().getCboxLectoraColor().getSelectedItem().toString();

			Boolean isValid = true;
			if (procesadorCantidad > 0) {
				if (procesadorGhz.isBlank())
					isValid = false;
				if (procesadorNucleos < 1)
					isValid = false;
				if (procesador.isBlank())
					isValid = false;
			}
			if (discoCantidad > 0) {
				if (discoCapacidad < 80)
					isValid = false;
				// corregir con string split ya que las capacidades de varios discos se añaden
				// con ","
			}
			if (ramCantidad > 0) {
				if (ramCapacidad < 2048)
					isValid = false;
			}
			if (!estado.equals("Pendiente")) {
				if (idsIntegrantes.isBlank()) 
					isValid = false;
				// si el estado no es pendiente, alguien debio revisarla
			}
			if (isValid) {
				Computadora computadora = new Computadora(id, estado,
						new CompPlacaBase("Placa Base", placaBase, placaBaseEstado, placaBaseCantidad),
						new CompProcesador("Procesador", procesador, procesadorEstado, procesadorCantidad, procesadorGhz, procesadorNucleos),
						new CompDiscoRigido("Disco Rigido", disco, discoEstado, discoCantidad, discoCapacidad),
						new CompMemoriaRam("Memoria Ram", ram, ramEstado, ramCantidad, ramCapacidad),
						new CompLectora("Lectora", lectora, lectoraEstado, lectoraCantidad, lectoraColor));
				if (this.getComputadora().agregarComputadora(computadora)) {
					JOptionPane.showMessageDialog(this.getVistaComputadora(), "Computadora añadida correctamente",
							"Sistema", JOptionPane.INFORMATION_MESSAGE);
					this.getVistaComputadora().dispose();
				} else {
					JOptionPane.showMessageDialog(this.getVistaComputadora(), "No se pudo añadir la Computadora",
							"Sistema", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this.getVistaComputadora(),
						"Los datos introducidos de 'cantidad' no corresponden al resto de la informacion", "Sistema", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == this.getVistaComputadora().getBtnCancelar()) {
			this.getVistaComputadora().dispose();
		}

	}

	public ComputadoraDAOImpl getComputadora() {
		return computadora;
	}

	public void setComputadora(ComputadoraDAOImpl computadora) {
		this.computadora = computadora;
	}

	public VistaAgregarPC getVistaComputadora() {
		return vistaComputadora;
	}

	public void setVistaComputadora(VistaAgregarPC vistaComputadora) {
		this.vistaComputadora = vistaComputadora;
	}

}
