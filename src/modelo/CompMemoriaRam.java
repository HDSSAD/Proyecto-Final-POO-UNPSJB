package modelo;

public class CompMemoriaRam extends Componente {

	private Integer mhz, capacidad;

	public CompMemoriaRam(String tipo, String modelo, String estado, Integer mhz, Integer capacidad) {
		super(tipo, modelo, estado);
		this.setMhz(mhz);
		this.setCapacidad(capacidad);
	}

	public CompMemoriaRam(String[] array) {
		super(array);
		this.setMhz(Integer.parseInt(array[3]));
		this.setCapacidad(Integer.parseInt(array[4]));
	}

	@Override
	public String toString() {
		return super.toString() + "Capacidad: " + this.getCapacidad() + " MB \nVelocidad: " + this.getMhz() + " MHz";
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + this.getMhz() + "," + this.getCapacidad();
	}

	public Integer getMhz() {
		return mhz;
	}

	public void setMhz(Integer mhz) {
		this.mhz = mhz;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

}
