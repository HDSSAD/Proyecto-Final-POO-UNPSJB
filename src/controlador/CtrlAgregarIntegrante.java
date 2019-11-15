package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaIntegranteAgregar;

public class CtrlAgregarIntegrante implements ActionListener {

	private IntegranteDAOImpl integrante;
	private VistaIntegranteAgregar vistaIntegrante;

	public CtrlAgregarIntegrante() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaIntegrante(new VistaIntegranteAgregar(this));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaIntegrante().getBtnAceptar()) {
			String dni = this.getVistaIntegrante().getTxtDNI().getText();
			String contrase�a = String.valueOf(this.getVistaIntegrante().getPassfContrase�a().getPassword());
			String apellido = this.getVistaIntegrante().getTxtApellido().getText();
			String nombre = this.getVistaIntegrante().getTxtNombre().getText();
			String fechaNacimiento = this.getVistaIntegrante().getTxtFechaNacimiento().getText();
			String direccion = this.getVistaIntegrante().getTxtDireccion().getText();
			String telefono = this.getVistaIntegrante().getTxtTelefono().getText();
			String telefono2 = this.getVistaIntegrante().getTxtTelefono2().getText();
			String correo = this.getVistaIntegrante().getTxtCorreo().getText();
			String tipo = this.getVistaIntegrante().getCboxTipoIntegrante().getSelectedItem().toString();

			Boolean isValid = !(dni.isBlank() || contrase�a.isBlank() || apellido.isBlank() || nombre.isBlank()
					|| fechaNacimiento.isBlank() || direccion.isBlank() || telefono.isBlank());
			if (isValid) {
				if (contrase�a.equals(
						String.valueOf(this.getVistaIntegrante().getPassfContrase�aConfirmar().getPassword()))) {
					Integrante integrante = new Integrante(dni, contrase�a, apellido, nombre, fechaNacimiento,
							direccion, telefono, telefono2, correo, tipo);
					if (this.getIntegrante().agregarIntegrante(integrante)) {
						JOptionPane.showMessageDialog(this.getVistaIntegrante(), 
								"Integrante a�adido correctamente",
								"Sistema", JOptionPane.INFORMATION_MESSAGE);
						this.getVistaIntegrante().dispose();
					} else {
						JOptionPane.showMessageDialog(this.getVistaIntegrante(), "No se pudo a�adir el Integrante",
								"Sistema", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this.getVistaIntegrante(), "Las contrase�as no coinciden", "Sistema",
							JOptionPane.ERROR_MESSAGE);
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

	public VistaIntegranteAgregar getVistaIntegrante() {
		return vistaIntegrante;
	}

	public void setVistaIntegrante(VistaIntegranteAgregar vistaIntegrante) {
		this.vistaIntegrante = vistaIntegrante;
	}

}
