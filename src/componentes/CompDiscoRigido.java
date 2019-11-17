package componentes;

public class CompDiscoRigido extends Componente {
	
	private Integer capacidad;

	public CompDiscoRigido(String tipo, String modelo, String estado, Integer cantidad, Integer capacidad) {
		super(tipo, modelo, estado, cantidad);
		this.setCapacidad(capacidad);
	}

	public CompDiscoRigido(String[] array) {
		super(array);
		this.setCapacidad(Integer.parseInt(array[4]));
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		String ret;
		if (this.getCantidad() < 1) {
			ret = "\n Faltante \n";
		} else {
			ret = super.toString() + "   Capacidad: " + this.getCapacidad() + " GB\n";
		}
		return ret;
	}

	public String toSqlArray() {
		return super.toSqlArray() + "," + this.getCapacidad();
	}
}
