package modelo;

public class Componente {

	private String tipo, modelo, estado;

	public Componente(String tipo, String modelo, String estado) {
		super();
		this.setTipo(tipo);
		this.setModelo(modelo);
		this.setEstado(estado);
	}

	public Componente (String[] array) {
		super();
		this.setTipo(array[0]);
		this.setModelo(array[1]);
		this.setEstado(array[2]);
	}
	
	public String toString() {
		return "Componente\nTipo: " + this.getTipo() + "\nModelo: " + this.getModelo() + "\nEstado: "
				+ this.getEstado();
	}

	public String toSqlArray() {
		return this.getTipo() + "," + this.getModelo() + "," + this.getEstado() + ",";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}