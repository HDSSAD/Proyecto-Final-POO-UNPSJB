package modelo;

public class CompProcesador extends Componente {

	private Integer ghz;

	public CompProcesador(String tipo, String modelo, String estado, Integer ghz) {
		super(tipo, modelo, estado);
		this.setGhz(ghz);
	}

	public CompProcesador(String[] array) {
		super(array);
		this.setGhz(Integer.parseInt(array[3]));
	}

	@Override
	public String toString() {
		return super.toString() + "Velocidad: " + this.getGhz() + " Ghz";
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + this.getGhz();
	}

	public Integer getGhz() {
		return ghz;
	}

	public void setGhz(Integer ghz) {
		this.ghz = ghz;
	}

}
