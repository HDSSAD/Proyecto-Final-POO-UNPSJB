package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.IntegranteDAOImpl;
import vista.VistaIntegranteBuscar;

public class CtrlBuscarIntegrante implements ActionListener {

	private IntegranteDAOImpl integrante;
	private VistaIntegranteBuscar vistaBuscarIntegrante;
	private String where;
	private ArrayList<String> parametros;

	public CtrlBuscarIntegrante() {
		this.setIntegrante(new IntegranteDAOImpl());
		this.setVistaBuscarIntegrante(new VistaIntegranteBuscar(this));
		this.setWhere("");
		this.setParametros(new ArrayList<String>());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getVistaBuscarIntegrante().getBtnAceptar()) {
			for (int i = 0; i < this.getVistaBuscarIntegrante().getArrayTxtField().size(); i++) {
				if (!this.getVistaBuscarIntegrante().getArrayTxtField().get(i).getText().isBlank()) {
					if (this.getParametros().isEmpty()) {
						this.setWhere("where " + this.getIntegrante().getListaParametros().get(i) + " ilike ? ");
					} else {
						this.setWhere(this.getWhere() + "and " + this.getIntegrante().getListaParametros().get(i) + " ilike ? ");
					}
					this.getParametros().add(this.getVistaBuscarIntegrante().getArrayTxtField().get(i).getText());
				}
			}
			this.getVistaBuscarIntegrante().dispose();
		} else if (e.getSource() == this.getVistaBuscarIntegrante().getBtnCancelar()) {
			this.getVistaBuscarIntegrante().dispose();
		}
	}

	public IntegranteDAOImpl getIntegrante() {
		return integrante;
	}

	public void setIntegrante(IntegranteDAOImpl integrante) {
		this.integrante = integrante;
	}

	public VistaIntegranteBuscar getVistaBuscarIntegrante() {
		return vistaBuscarIntegrante;
	}

	public void setVistaBuscarIntegrante(VistaIntegranteBuscar vistaBuscarIntegrante) {
		this.vistaBuscarIntegrante = vistaBuscarIntegrante;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public ArrayList<String> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<String> parametros) {
		this.parametros = parametros;
	}

}
