package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.IntegranteDAOImpl;
import vista.VistaIntegranteBuscar;

public class CtrlIntegranteBuscar implements ActionListener {

	private VistaIntegranteBuscar vistaBuscarIntegrante;
	private IntegranteDAOImpl integrante;
	private String where;
	private ArrayList<String> parametros;

	public CtrlIntegranteBuscar() {
		this.setVistaBuscarIntegrante(new VistaIntegranteBuscar(this));
		this.setIntegrante(new IntegranteDAOImpl());
		this.setParametros(new ArrayList<String>());
		this.setWhere("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaBuscarIntegrante().getBtnAceptar()) {
			String tipo = this.getVistaBuscarIntegrante().getCboxTipo().getSelectedItem().toString();
			String dni = this.getVistaBuscarIntegrante().getTxtDni().getText().replaceAll("\\s", "");
			String apellido = this.getVistaBuscarIntegrante().getTxtApellido().getText().strip();
			String nombre = this.getVistaBuscarIntegrante().getTxtNombre().getText().strip();
			String telefono = this.getVistaBuscarIntegrante().getTxtTelefono().getText().replaceAll("\\s", "");
			String correo = this.getVistaBuscarIntegrante().getTxtCorreo().getText().strip();
			if (!dni.isBlank() || !apellido.isBlank() || !nombre.isBlank() || !telefono.isBlank()
					|| !dni.isBlank()) {
				if (!tipo.equals("Sin seleccion")) {
					this.setWhere("where tipo like ?");
					this.getParametros().add(tipo);
				}
				if (!dni.isBlank()) {
					if (this.getWhere().isBlank()) {
						this.setWhere("where dni like ?");
					} else
						this.setWhere(" and dni like ?");
					this.getParametros().add(dni);
				}
				if (!apellido.isBlank()) {
					if (this.getWhere().isBlank()) {
						this.setWhere("where apellido ilike ?");
					} else
						this.setWhere(" and apellido ilike ?");
					this.getParametros().add(apellido);
				}
				if (!nombre.isBlank()) {
					if (this.getWhere().isBlank()) {
						this.setWhere("where nombre ilike ?");
					} else
						this.setWhere(" and nombre ilike ?");
					this.getParametros().add(nombre);
				}
				if (!telefono.isBlank()) {
					if (this.getWhere().isBlank()) {
						this.setWhere("where telefono like %?% or telefono2 like %?%");
					} else
						this.setWhere(" and telefono like %?% or telefono2 like %?%");
					this.getParametros().add(telefono);
					this.getParametros().add(telefono);
				}
				if (!correo.isBlank()) {
					if (this.getWhere().isBlank()) {
						this.setWhere("where correo like %?%");
					} else
						this.setWhere(" and correo like %?%");
					this.getParametros().add(correo);
				}
				this.getVistaBuscarIntegrante().dispose();
			} else {
				JOptionPane.showMessageDialog(this.getVistaBuscarIntegrante(),
						"Se debe seleccionar almenos un criterio de busqueda", "Sistema", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == this.getVistaBuscarIntegrante().getBtnCancelar()) {
			this.getVistaBuscarIntegrante().dispose();
		}
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public VistaIntegranteBuscar getVistaBuscarIntegrante() {
		return vistaBuscarIntegrante;
	}

	public void setVistaBuscarIntegrante(VistaIntegranteBuscar vistaBuscarIntegrante) {
		this.vistaBuscarIntegrante = vistaBuscarIntegrante;
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
