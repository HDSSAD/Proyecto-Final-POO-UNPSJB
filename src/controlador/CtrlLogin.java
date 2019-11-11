package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import modelo.BD;
import vista.Login;

public class CtrlLogin implements ActionListener, WindowListener{
	
	private Login vistaLogin;
	

	public CtrlLogin() {
		super();
		this.setVistaLogin(new Login(this));
		this.getVistaLogin().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.getVistaLogin().getBtnIngresar()) {
			if (!this.getVistaLogin().getTxtUser().getText().isBlank() && !this.getVistaLogin().getTxtPass().getText().isBlank()) {
				BD.createInstance(this.getVistaLogin().getTxtUser().getText(), this.getVistaLogin().getTxtPass().getText());
				this.getVistaLogin().dispose();
			} else {
				JOptionPane.showMessageDialog(this.getVistaLogin(), "Se debe indicar Usuario y Contraseña",
						"Sistema", JOptionPane.ERROR_MESSAGE);
			}
		}
	}


	public Login getVistaLogin() {
		return vistaLogin;
	}


	public void setVistaLogin(Login vistaLogin) {
		this.vistaLogin = vistaLogin;
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

}
