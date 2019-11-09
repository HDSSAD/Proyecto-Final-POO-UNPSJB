package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.EditarIntegrante;

public class CtrlEditarIntegrante implements ActionListener {

	private IntegranteDAOImpl integrante;
	private EditarIntegrante vistaIntegrante;

	public CtrlEditarIntegrante() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaIntegrante(new EditarIntegrante(this));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaIntegrante().getBtnAceptar()) {
			String legajo = this.getVistaIntegrante().getTxtLegajo().getText();
			String dni = this.getVistaIntegrante().getTxtDNI().getText();
			String apellido = this.getVistaIntegrante().getTxtApellido().getText();
			String nombre = this.getVistaIntegrante().getTxtNombre().getText();
			String fechaNacimiento = this.getVistaIntegrante().getTxtFechaNacimiento().getText();
			String direccion = this.getVistaIntegrante().getTxtDireccion().getText();
			String telefono = this.getVistaIntegrante().getTxtTelefono().getText();
			String telefono2 = this.getVistaIntegrante().getTxtTelefono2().getText();
			String correo = this.getVistaIntegrante().getTxtCorreo().getText();
			Boolean isValid = !(dni.isBlank() || apellido.isBlank() || nombre.isBlank() || fechaNacimiento.isBlank()
					|| direccion.isBlank() || telefono.isBlank());
			if (isValid) {
				Integrante integrante = new Integrante(legajo, dni, apellido, nombre, fechaNacimiento, direccion,
						telefono, telefono2, correo);
				if (this.getIntegrante().modificarIntegrante(integrante)) {
					JOptionPane.showMessageDialog(this.getVistaIntegrante(), "Integrante añadido correctamente",
							"Sistema", JOptionPane.INFORMATION_MESSAGE);
					this.getVistaIntegrante().dispose();
				} else {
					JOptionPane.showMessageDialog(this.getVistaIntegrante(), "No se pudo añadir el Integrante",
							"Sistema", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this.getVistaIntegrante(),
						"Se deben completar los campos marcados con (*)", "Sistema", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == this.getVistaIntegrante().getBtnCancelar()) {
			this.getVistaIntegrante().dispose();
		}

	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public EditarIntegrante getVistaIntegrante() {
		return vistaIntegrante;
	}

	public void setVistaIntegrante(EditarIntegrante vistaIntegrante) {
		this.vistaIntegrante = vistaIntegrante;
	}
}
