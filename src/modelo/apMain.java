package modelo;

import java.awt.EventQueue;

import controlador.ControladorMain;

public class apMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
