package componentes;

public class CompProcesador extends Componente {

	private Integer nucleos;
	private String ghz;

	public CompProcesador(String tipo, String modelo, String estado, Integer cantidad, String ghz, Integer nucleos) {
		super(tipo, modelo, estado, cantidad);
		this.setGhz(ghz);
		this.setNucleos(nucleos);
	}

	public Integer getNucleos() {
		return nucleos;
	}

	public void setNucleos(Integer nucleos) {
		this.nucleos = nucleos;
	}

	public CompProcesador(String[] array) {
		super(array);
		this.setGhz(array[3]);
	}

	@Override
	public String toString() {
		return super.toString() + "Nucleos: " + this.getNucleos() + "\nVelocidad: " + this.getGhz() + " Ghz";
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + this.getNucleos() + "," + this.getGhz();
	}

	public String getGhz() {
		return ghz;
	}

	public void setGhz(String ghz) {
		this.ghz = ghz;
	}

}
