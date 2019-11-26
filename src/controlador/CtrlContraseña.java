package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaContraseña;

public class CtrlContraseña implements ActionListener {

	private VistaContraseña vistaContraseña;
	private IntegranteDAOImpl integrantes;
	private String dni;

	public CtrlContraseña(String dni) {
		this.setIntegrantes(new IntegranteDAOImpl());
		this.setDni(dni);
		this.setVistaContraseña(new VistaContraseña(this));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaContraseña().getBtnAceptar()) {
			Integrante integrante = this.getIntegrantes().buscarIntegrante(this.getDni());
			if (integrante != null) {
				if (String.valueOf(this.getVistaContraseña().getPassFContraseñaNueva().getPassword())
						.equals(String.valueOf(this.getVistaContraseña().getPassFContraseñaConfirmar().getPassword()))) {
					if (integrante.getContraseña().equals(
							String.valueOf(this.getVistaContraseña().getPassFContraseñaActual().getPassword()))) {
						integrante.setContraseña(
								String.valueOf(this.getVistaContraseña().getPassFContraseñaNueva().getPassword()));
						if (this.getIntegrantes().modificarIntegrante(integrante)) {
							JOptionPane.showMessageDialog(this.getVistaContraseña(),
									"Contraseña modificada correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
							integrante = null;
							this.getVistaContraseña().dispose();
						} else {
							JOptionPane.showMessageDialog(this.getVistaContraseña(),
									"Ocurrio un error al conectar a la base de datos", "Sistema",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this.getVistaContraseña(),
								"La contraseña actual ingresada no es la correcta", "Sistema",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println(this.getVistaContraseña().getPassFContraseñaNueva().getPassword());
					System.out.println(this.getVistaContraseña().getPassFContraseñaConfirmar().getPassword());
					JOptionPane.showMessageDialog(this.getVistaContraseña(),
							"La nueva contraseña y su confirmacion no son identicas", "Sistema",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			integrante = null;
		} else if (e.getSource() == this.getVistaContraseña().getBtnCancelar()) {
			this.getVistaContraseña().dispose();
		}

	}

	public VistaContraseña getVistaContraseña() {
		return vistaContraseña;
	}

	public void setVistaContraseña(VistaContraseña vistaContraseña) {
		this.vistaContraseña = vistaContraseña;
	}

	public IntegranteDAOImpl getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(IntegranteDAOImpl integrantes) {
		this.integrantes = integrantes;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
