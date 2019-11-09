package modelo;

import java.awt.EventQueue;

import controlador.CtrlMain;

public class apMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new CtrlMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
