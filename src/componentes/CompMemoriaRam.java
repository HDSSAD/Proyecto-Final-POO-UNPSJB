package componentes;

public class CompMemoriaRam extends Componente {

	private Integer capacidad;

	public CompMemoriaRam(String tipo, String modelo, String estado, Integer cantidad, Integer capacidad) {
		super(tipo, modelo, estado, cantidad);
		this.setCapacidad(capacidad);
	}

	public CompMemoriaRam(String[] array) {
		super(array);
		this.setCapacidad(Integer.parseInt(array[4]));
	}

	@Override
	public String toString() {
		String ret;
		if (this.getCantidad() < 1) {
			ret = "\n Faltante \n";
		} else {
			ret = super.toString() + "   Capacidad: " + this.getCapacidad() + " MB\n";
		}
		return ret;
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + "," + this.getCapacidad();
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

}
