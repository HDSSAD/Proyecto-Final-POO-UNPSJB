package componentes;

public class Componente {

	private String tipo, modelo, estado;
	private Integer cantidad;

	public Componente(String tipo, String modelo, String estado, Integer cantidad) {
		super();
		this.setTipo(tipo);
		this.setModelo(modelo);
		this.setEstado(estado);
		this.setCantidad(cantidad);
	}

	public Componente (String[] array) {
		super();
		this.setTipo(array[0]);
		this.setModelo(array[1]);
		this.setEstado(array[2]);
		this.setCantidad(Integer.parseInt(array[3]));
	}
	
	public String toString() {
		return "Componente\nTipo: " + this.getTipo() + "\nModelo: " + this.getModelo() + "\nEstado: "
				+ this.getEstado() + "\nCantidad: " + this.getCantidad() + "\n";
	}

	public String toSqlArray() {
		return this.getTipo() + "," + this.getModelo() + "," + this.getEstado() + "," + this.getCantidad() + ",";
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
