package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Integrante;
import modelo.IntegranteDAOImpl;
import vista.VistaLogin;

public class CtrlLogin implements ActionListener, WindowListener{
	
	private VistaLogin vistaLogin;
	private IntegranteDAOImpl integrante;

	public CtrlLogin() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaLogin(new VistaLogin(this));
		this.getVistaLogin().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaLogin().getBtnIngresar()) {
			ArrayList<String> parametros = new ArrayList<String>();
			parametros.add(this.getVistaLogin().getTxtUser().getText());
			parametros.add(String.valueOf(this.getVistaLogin().getPassfContraseña().getPassword()));
			
			System.out.println(this.getVistaLogin().getPassfContraseña().getPassword());
			// Esto esta aqui para revisar la conexion con la base de datos
			// Solo durante el proceso de programacion
			// Retirar al terminar
			
			this.getVistaLogin().getPassfContraseña().setText("");
			Integrante integrante = this.getIntegrante().loginIntegrante(parametros);
			parametros = null;
			System.out.println(integrante);
			if (integrante != null) {
				this.getVistaLogin().setVisible(false);
				if (integrante.getTipo().equals("Administrador")) {
					new CtrlMainAdmin(this, integrante.getDni());
				} else if (integrante.getTipo().equals("Coordinador")) {
					new CtrlMainCoordinador(this, integrante.getDni());
				} else if (integrante.getTipo().equals("Integrante")){
					new CtrlMainIntegrante(this, integrante.getDni());
				}
			} else {
				JOptionPane.showMessageDialog(this.getVistaLogin(), "No se encontro el integrante en la base de datos", "Sistema", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == this.getVistaLogin().getBtnCancelar()) {
			this.getVistaLogin().dispose();
		}
	}


	public VistaLogin getVistaLogin() {
		return vistaLogin;
	}


	public void setVistaLogin(VistaLogin vistaLogin2) {
		this.vistaLogin = vistaLogin2;
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}


	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}
}
