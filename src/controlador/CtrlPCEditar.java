package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import componentes.CompDiscoRigido;
import componentes.CompLectora;
import componentes.CompMemoriaRam;
import componentes.CompPlacaBase;
import componentes.CompProcesador;
import modelo.Computadora;
import modelo.ComputadoraDAOImpl;
import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaPCEditar;

public class CtrlPCEditar implements ActionListener, ItemListener {
	private ComputadoraDAOImpl computadora;
	private VistaPCEditar vistaComputadora;
	private IntegranteDAOImpl integrante;
	private Computadora pcActual;

	public CtrlPCEditar(Computadora pcActual) {
		this.setPcActual(pcActual);
		this.setComputadora(new ComputadoraDAOImpl());
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaComputadora(new VistaPCEditar(this));
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>(new String[] {});
		modelo.addElement("Seleccionar integrante");
		for (Integrante integrante : this.getIntegrante().buscarIntegrante()) {
			modelo.addElement(integrante.getApellido() + ", " + integrante.getNombre());
		}
		this.getVistaComputadora().getCboxSeleccionarIntegrante().setModel(modelo);
		if (pcActual != null) {
			this.getInfoFromPCtoView(pcActual);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaComputadora().getBtnAceptar()) {
			String id = this.getVistaComputadora().getTxtIdComputadora().getText().replaceAll("\\s", "");
			if (this.getComputadora().buscarComputadora(Integer.valueOf(id)) != null) {
				String idsIntegrantes;
				idsIntegrantes = this.getVistaComputadora().getTxtIdsIntegrantes().getText().replaceAll("\\s", "");

				String estado = this.getVistaComputadora().getCboxComputadoraEstado().getSelectedItem().toString();

				String placaBase = this.getVistaComputadora().getTxtPlacaBase().getText().strip();
				String placaBaseEstado = this.getVistaComputadora().getCboxPlacaBaseEstado().getSelectedItem()
						.toString();
				Integer placaBaseCantidad;
				if (!this.getVistaComputadora().getTxtPlacaBase().getText().isBlank()) {
					placaBaseCantidad = 1;
				} else {
					placaBaseCantidad = 0;
				}

				String procesador = this.getVistaComputadora().getTxtProcesador().getText().strip();
				String procesadorEstado = this.getVistaComputadora().getCboxProcesadorEstado().getSelectedItem()
						.toString();
				Integer procesadorCantidad = (Integer) this.getVistaComputadora().getSpnProcesadorCantidad().getValue();
				Integer procesadorNucleos = (Integer) this.getVistaComputadora().getSpnProcesadorNucleos().getValue();
				Double procesadorGhz = (Double) this.getVistaComputadora().getTxtProcesadorGhz().getValue();

				String disco = this.getVistaComputadora().getCboxDiscoRigidoTipo().getSelectedItem().toString().strip();
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
								|| procesadorCantidad < 1 || procesadorNucleos < 1 || procesador.isBlank()
								|| lectora.isBlank() || lectoraCantidad < 1) {
							isValid = false;
							JOptionPane.showMessageDialog(this.getVistaComputadora(),
									"Una computadora marcada como 'Completada' debe cumplir lo siguientes requisitos minimos: \n"
											+ "- Almenos una placa de RAM instalada, con un total minimo de 2GB (2048MB) \n"
											+ "- Almenos un Disco Rigido con capacidad minima de 80GB \n"
											+ "- Almenos un Procesador, indicando el modelo, los nucleos y su velocidad en GHz \n"
											+ "- Almenos una lectora de DVD/CD ",
									"Sistema", JOptionPane.ERROR_MESSAGE);
						} else if (!placaBaseEstado.equals("Correcto") || !procesadorEstado.equals("Correcto")
								|| !discoEstado.equals("Correcto") || !ramEstado.equals("Correcto")
								|| !lectoraEstado.equals("Correcto")) {
							isValid = false;
							JOptionPane.showMessageDialog(this.getVistaComputadora(),
									"Los componentes de una computadora marcada como 'Completada' deben estar marcados como 'Correctos'",
									"Sistema", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else { // el estado si es pendiente
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
									String.valueOf(procesadorGhz), procesadorNucleos),
							new CompDiscoRigido("Disco Rigido", disco, discoEstado, discoCantidad, discoCapacidad),
							new CompMemoriaRam("Memoria Ram", ram, ramEstado, ramCantidad, ramCapacidad),
							new CompLectora("Lectora", lectora, lectoraEstado, lectoraCantidad, lectoraColor), notasPC);
					if (this.getComputadora().modificarComputadora(computadora)) {
						JOptionPane.showMessageDialog(this.getVistaComputadora(),
								"Informacion de Computadora modificada correctamente", "Sistema",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(this.getVistaComputadora(),
								"No se pudo editar la informacion de la Computadora", "Sistema",
								JOptionPane.ERROR_MESSAGE);
					}
					if (!idsIntegrantes.isBlank()) {
						String asignacionFaltante = "";
						for (String integrante : idsIntegrantes.split(",")) {
							if (!this.getComputadora().agregarIntegranteComputadora(integrante, id)) {
								asignacionFaltante += "  " + integrante + "\n";
							}
						}
						if (!asignacionFaltante.isBlank()) {
							JOptionPane.showMessageDialog(this.getVistaComputadora(),
									"Ha ocurrido un error en la base de datos al intentar asignar la computadora a los siguientes integrantes: \n"
											+ asignacionFaltante
											+ "\nSe recomienda iniciar sesion nuevamente y modificar los integrantes en la computadora agregada",
									"Sistema", JOptionPane.ERROR_MESSAGE);
						}
					}
					this.getVistaComputadora().dispose();
				} else {
					JOptionPane.showMessageDialog(this.getVistaComputadora(),
							"Se ha indtroducido una combinacion de datos no validos", "Sistema",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this.getVistaComputadora(),
						"El numero de computadora que se quiere editar no se encuentra en la base de datos", "Sistema",
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

	public Computadora getPcActual() {
		return pcActual;
	}

	public void setPcActual(Computadora pcActual) {
		this.pcActual = pcActual;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == this.getVistaComputadora().getCboxSeleccionarIntegrante()) {
				String integranteSeleccionado = this.getVistaComputadora().getCboxSeleccionarIntegrante()
						.getSelectedItem().toString();
				if (integranteSeleccionado != "Seleccionar integrante") {
					String integrantesActuales = this.getVistaComputadora().getTxtIdsIntegrantes().getText();
					String idIntegrante = this.getIntegrante()._getIdFromName(integranteSeleccionado);
					if (idIntegrante != null) {
						if (integrantesActuales.isBlank()) {
							this.getVistaComputadora().getTxtIdsIntegrantes().setText(idIntegrante);
						} else {
							Boolean add = true;
							for (String string : integrantesActuales.split(",")) {
								if (string.strip().equals(idIntegrante)) {
									add = false;
								}
							}
							if (add) {
								this.getVistaComputadora().getTxtIdsIntegrantes()
										.setText(integrantesActuales + ", " + idIntegrante);
							}
						}
					}
				}
			}
		}
		this.getVistaComputadora().getCboxSeleccionarIntegrante().removeItemListener(this);
		this.getVistaComputadora().getCboxSeleccionarIntegrante().setSelectedIndex(0);
		this.getVistaComputadora().getCboxSeleccionarIntegrante().addItemListener(this);
	}

	private void getInfoFromPCtoView(Computadora pcActual) {
		this.getVistaComputadora().getTxtIdComputadora().setText(pcActual.getIdComputadora());
		this.getVistaComputadora().getTxtIdComputadora().setEditable(false);
		this.getVistaComputadora().getTxtPlacaBase().setText(pcActual.getPlacaBase().getModelo());
		this.getVistaComputadora().getTxtpnNotasPC().setText(pcActual.getNotas());
		this.getVistaComputadora().getTxtProcesador().setText(pcActual.getProcesador().getModelo());
		this.getVistaComputadora().getTxtProcesadorGhz().setValue(Double.valueOf(pcActual.getProcesador().getGhz()));
		this.getVistaComputadora().getCboxDiscoRigidoEstado().setEditable(true);
		this.getVistaComputadora().getCboxDiscoRigidoEstado().setSelectedItem(pcActual.getDisco().getEstado());
		this.getVistaComputadora().getCboxDiscoRigidoEstado().setEditable(false);
		this.getVistaComputadora().getCboxDiscoRigidoTipo().setEditable(true);
		this.getVistaComputadora().getCboxDiscoRigidoTipo().setSelectedItem(pcActual.getDisco().getModelo());
		this.getVistaComputadora().getCboxDiscoRigidoTipo().setEditable(false);
		this.getVistaComputadora().getCboxLectoraColor().setEditable(true);
		this.getVistaComputadora().getCboxLectoraColor().setSelectedItem(pcActual.getLectora().getColor());
		this.getVistaComputadora().getCboxLectoraColor().setEditable(false);
		this.getVistaComputadora().getCboxLectoraEstado().setEditable(true);
		this.getVistaComputadora().getCboxLectoraEstado().setSelectedItem(pcActual.getLectora().getEstado());
		this.getVistaComputadora().getCboxLectoraEstado().setEditable(false);
		this.getVistaComputadora().getCboxLectoraTipo().setEditable(true);
		this.getVistaComputadora().getCboxLectoraTipo().setSelectedItem(pcActual.getLectora().getModelo());
		this.getVistaComputadora().getCboxLectoraTipo().setEditable(false);
		this.getVistaComputadora().getCboxPlacaBaseEstado().setEditable(true);
		this.getVistaComputadora().getCboxPlacaBaseEstado().setSelectedItem(pcActual.getPlacaBase().getEstado());
		this.getVistaComputadora().getCboxPlacaBaseEstado().setEditable(false);
		this.getVistaComputadora().getCboxProcesadorEstado().setEditable(true);
		this.getVistaComputadora().getCboxProcesadorEstado().setSelectedItem(pcActual.getProcesador().getEstado());
		this.getVistaComputadora().getCboxProcesadorEstado().setEditable(false);
		this.getVistaComputadora().getCboxRamEstado().setEditable(true);
		this.getVistaComputadora().getCboxRamEstado().setSelectedItem(pcActual.getRam().getEstado());
		this.getVistaComputadora().getCboxRamEstado().setEditable(false);
		this.getVistaComputadora().getCboxRamTipo().setEditable(true);
		this.getVistaComputadora().getCboxRamTipo().setSelectedItem(pcActual.getRam().getModelo());
		this.getVistaComputadora().getCboxRamTipo().setEditable(false);
		this.getVistaComputadora().getSpnDiscoRigidoCantidad().setValue(pcActual.getDisco().getCantidad());
		this.getVistaComputadora().getSpnDiscoRigidoCapacidad().setValue(pcActual.getDisco().getCapacidad());
		this.getVistaComputadora().getSpnLectoraCantidad().setValue(pcActual.getLectora().getCantidad());
		this.getVistaComputadora().getSpnProcesadorCantidad().setValue(pcActual.getProcesador().getCantidad());
		this.getVistaComputadora().getSpnProcesadorNucleos().setValue(pcActual.getProcesador().getNucleos());
		this.getVistaComputadora().getSpnRamCantidad().setValue(pcActual.getRam().getCantidad());
		this.getVistaComputadora().getSpnRamCapacidad().setValue(pcActual.getRam().getCapacidad());
	}
}
