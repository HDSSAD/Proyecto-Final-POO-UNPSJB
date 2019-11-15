package modelo;

import java.awt.EventQueue;

import controlador.CtrlLogin;

public class apMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new CtrlLogin();
//					new CtrlMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
