package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaIntegranteAgregar;

public class CtrlIntegranteAgregar implements ActionListener {

	private IntegranteDAOImpl integrante;
	private VistaIntegranteAgregar vistaIntegrante;

	public CtrlIntegranteAgregar() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaIntegrante(new VistaIntegranteAgregar(this));
	}

	private Boolean validarFecha(String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		formatoFecha.setLenient(false);
		try {
			formatoFecha.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaIntegrante().getBtnAceptar()) {
			String dni = this.getVistaIntegrante().getTxtDNI().getText().replaceAll("\\s", "");
			String contraseña = String.valueOf(this.getVistaIntegrante().getPassfContraseña().getPassword());
			String apellido = this.getVistaIntegrante().getTxtApellido().getText().strip();
			String nombre = this.getVistaIntegrante().getTxtNombre().getText().strip();
			String fechaNacimiento = this.getVistaIntegrante().getTxtFechaNacimiento().getText();
			String direccion = this.getVistaIntegrante().getTxtDireccion().getText().strip();
			String telefono = this.getVistaIntegrante().getTxtTelefono().getText().replaceAll("\\s", "");
			String telefono2 = this.getVistaIntegrante().getTxtTelefono2().getText().replaceAll("\\s", "");
			String correo = this.getVistaIntegrante().getTxtCorreo().getText().strip();
			String tipo = this.getVistaIntegrante().getCboxTipoIntegrante().getSelectedItem().toString();

			Boolean isValid = !(dni.isBlank() || contraseña.isBlank() || apellido.isBlank() || nombre.isBlank()
					|| !this.validarFecha(fechaNacimiento) || direccion.isBlank() || telefono.isBlank());

			if (isValid) {
				if (this.getIntegrante().buscarIntegrante(dni) == null) {
					if (contraseña.equals(
							String.valueOf(this.getVistaIntegrante().getPassfContraseñaConfirmar().getPassword()))) {
						Integrante integrante = new Integrante(dni, contraseña, apellido, nombre, fechaNacimiento,
								direccion, telefono, telefono2, correo, tipo);
						if (this.getIntegrante().agregarIntegrante(integrante)) {
							JOptionPane.showMessageDialog(this.getVistaIntegrante(), "Integrante añadido correctamente",
									"Sistema", JOptionPane.INFORMATION_MESSAGE);
							this.getVistaIntegrante().dispose();
						} else {
							JOptionPane.showMessageDialog(this.getVistaIntegrante(), "No se pudo añadir el Integrante",
									"Sistema", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this.getVistaIntegrante(), "Las contraseñas no coinciden",
								"Sistema", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this.getVistaIntegrante(),
							"El integrante con DNI = " + dni + " ya se encuentra en la base de datos", "Sistema",
							JOptionPane.ERROR_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(this.getVistaIntegrante(),
						"Uno de los campos requeridos (*) no se llenado correctamente", "Sistema", JOptionPane.ERROR_MESSAGE);
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
