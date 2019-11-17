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
import modelo.IntegranteDAOImpl;
import vista.VistaPCEditar;

public class CtrlPCEditar implements ActionListener {
	private ComputadoraDAOImpl computadora;
	private VistaPCEditar vistaComputadora;
	private IntegranteDAOImpl integrante;

	public CtrlPCEditar() {
		this.setComputadora(new ComputadoraDAOImpl());
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaComputadora(new VistaPCEditar(this));
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

			String disco = this.getVistaComputadora().getCboxDiscoRigidoTipo().getSelectedItem().toString();
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

			String notasPC = this.getVistaComputadora().getTxtpnNotasPC().getText();

			Boolean isValid = true;

			if (!estado.equals("Pendiente")) {
				// si el estado no es pendiente, alguien debio revisarla
				if (idsIntegrantes.isBlank()) {
					isValid = false;
					JOptionPane.showMessageDialog(this.getVistaComputadora(),
							"La informacion de los integrantes no puede estar vacia en una computadora que ya fue revisada",
							"Sistema", JOptionPane.ERROR_MESSAGE);
				} else {
					String integranteFaltante = "";
					// si alguien la trabajo y y los datos son correctos, se revisa la existencia de
					// los integrantes asginados
					for (String integrante : idsIntegrantes.split(",")) {
						if (this.getIntegrante().buscarIntegrante(integrante) == null) {
							integranteFaltante += "  " + integrante + "\n";
						}
					}
					if (!integranteFaltante.isBlank()) {
						isValid = false;
						JOptionPane.showMessageDialog(this.getVistaComputadora(),
								"No se encontraron los siguientes integrantes en la base de datos: \n"
										+ integranteFaltante,
								"Sistema", JOptionPane.ERROR_MESSAGE);
					}
				}
				if (estado.equals("Completada")) {
					if (ramCantidad < 1 || ramCapacidad < 2048 || discoCantidad < 1 || discoCapacidad < 80
							|| procesadorCantidad < 1 || procesadorGhz.isBlank() || procesadorNucleos < 1
							|| procesador.isBlank() || lectora.isBlank() || lectoraCantidad < 1) {
						isValid = false;
						JOptionPane.showMessageDialog(this.getVistaComputadora(),
								"Una computadora marcada como 'Completada' debe cumplir lo siguientes requisitos minimos: \n"
										+ "- Almenos una placa de RAM instalada, con un total minimo de 2GB (2048MB) \n"
										+ "- Almenos un Disco Rigido con capacidad minima de 80GB \n"
										+ "- Almenos un Procesador, indicando el modelo, los nucleos y su velocidad en GHz \n"
										+ "- Almenos una lectora de DVD/CD ",
								"Sistema", JOptionPane.ERROR_MESSAGE);
					} else if (!(placaBaseEstado.equals("Correcto") || procesadorEstado.equals("Correcto")
							|| discoEstado.equals("Correcto") || ramEstado.equals("Correcto")
							|| lectoraEstado.equals("Correcto"))) {
						JOptionPane.showMessageDialog(this.getVistaComputadora(),
								"Los componentes de una computadora marcada como 'Completada' deben estar marcados como 'Correctos'",
								"Sistema", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {	// el estado si es pendiente
				if (!this.getVistaComputadora().getTxtIdsIntegrantes().getText().isBlank()) {
					String integranteFaltante = "";
					for (String integrante : idsIntegrantes.split(",")) {
						if (this.getIntegrante().buscarIntegrante(integrante) == null) {
							integranteFaltante += "  " + integrante + "\n";
						}
					}
					if (!integranteFaltante.isBlank()) {
						isValid = false;
						JOptionPane.showMessageDialog(this.getVistaComputadora(),
								"No se encontraron los siguientes integrantes en la base de datos: \n"
										+ integranteFaltante,
								"Sistema", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
			if (isValid) {
				Computadora computadora = new Computadora(id, estado,
						new CompPlacaBase("Placa Base", placaBase, placaBaseEstado, placaBaseCantidad),
						new CompProcesador("Procesador", procesador, procesadorEstado, procesadorCantidad,
								procesadorGhz, procesadorNucleos),
						new CompDiscoRigido("Disco Rigido", disco, discoEstado, discoCantidad, discoCapacidad),
						new CompMemoriaRam("Memoria Ram", ram, ramEstado, ramCantidad, ramCapacidad),
						new CompLectora("Lectora", lectora, lectoraEstado, lectoraCantidad, lectoraColor), notasPC);
				if (this.getComputadora().modificarComputadora(computadora)) {
					JOptionPane.showMessageDialog(this.getVistaComputadora(),
							"Informacion de Computadora modificada correctamente", "Sistema",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this.getVistaComputadora(),
							"No se pudo editar la informacion de la Computadora", "Sistema", JOptionPane.ERROR_MESSAGE);
				}
				String asignacionFaltante = "";
				for (String integrante : idsIntegrantes.split(",")) {
					if (!this.getComputadora().agregarIntegranteComputadora(integrante, id)) {
						asignacionFaltante += "  " + integrante + "\n";
					}
				}
				if (!asignacionFaltante.isBlank()) {
					JOptionPane.showMessageDialog(this.getVistaComputadora(),
							"Ha ocurrido un error en la base de datos al intentar asignar la computadora a los siguientes integrantes: \n"
									+ asignacionFaltante + "\nSe recomienda iniciar sesion nuevamente y modificar los integrantes en la computadora agregada",
							"Sistema", JOptionPane.ERROR_MESSAGE);
				}
				this.getVistaComputadora().dispose();
			} else {
				JOptionPane.showMessageDialog(this.getVistaComputadora(),
						"Los datos introducidos de 'cantidad' no corresponden al resto de la informacion", "Sistema",
						JOptionPane.ERROR_MESSAGE);
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

	public VistaPCEditar getVistaComputadora() {
		return vistaComputadora;
	}

	public void setVistaComputadora(VistaPCEditar vistaComputadora) {
		this.vistaComputadora = vistaComputadora;
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

}
