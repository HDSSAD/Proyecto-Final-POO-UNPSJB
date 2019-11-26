package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaContrase�a;

public class CtrlContrase�a implements ActionListener {

	private VistaContrase�a vistaContrase�a;
	private IntegranteDAOImpl integrantes;
	private String dni;

	public CtrlContrase�a(String dni) {
		this.setIntegrantes(new IntegranteDAOImpl());
		this.setDni(dni);
		this.setVistaContrase�a(new VistaContrase�a(this));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaContrase�a().getBtnAceptar()) {
			Integrante integrante = this.getIntegrantes().buscarIntegrante(this.getDni());
			if (integrante != null) {
				if (String.valueOf(this.getVistaContrase�a().getPassFContrase�aNueva().getPassword())
						.equals(String.valueOf(this.getVistaContrase�a().getPassFContrase�aConfirmar().getPassword()))) {
					if (integrante.getContrase�a().equals(
							String.valueOf(this.getVistaContrase�a().getPassFContrase�aActual().getPassword()))) {
						integrante.setContrase�a(
								String.valueOf(this.getVistaContrase�a().getPassFContrase�aNueva().getPassword()));
						if (this.getIntegrantes().modificarIntegrante(integrante)) {
							JOptionPane.showMessageDialog(this.getVistaContrase�a(),
									"Contrase�a modificada correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
							integrante = null;
							this.getVistaContrase�a().dispose();
						} else {
							JOptionPane.showMessageDialog(this.getVistaContrase�a(),
									"Ocurrio un error al conectar a la base de datos", "Sistema",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this.getVistaContrase�a(),
								"La contrase�a actual ingresada no es la correcta", "Sistema",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					System.out.println(this.getVistaContrase�a().getPassFContrase�aNueva().getPassword());
					System.out.println(this.getVistaContrase�a().getPassFContrase�aConfirmar().getPassword());
					JOptionPane.showMessageDialog(this.getVistaContrase�a(),
							"La nueva contrase�a y su confirmacion no son identicas", "Sistema",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			integrante = null;
		} else if (e.getSource() == this.getVistaContrase�a().getBtnCancelar()) {
			this.getVistaContrase�a().dispose();
		}

	}

	public VistaContrase�a getVistaContrase�a() {
		return vistaContrase�a;
	}

	public void setVistaContrase�a(VistaContrase�a vistaContrase�a) {
		this.vistaContrase�a = vistaContrase�a;
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
