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
		this.setNucleos(Integer.valueOf(array[4]));
	}

	@Override
	public String toString() {
		String ret;
		if (this.getCantidad() < 1) {
			ret = "\n Faltante \n";
		} else {
			ret = super.toString() + "   Nucleos: " + this.getNucleos() + ", Velocidad: " + this.getGhz() + " Ghz\n";
		}
		return ret;
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + "," + this.getNucleos() + "," + this.getGhz();
	}

	public String getGhz() {
		return ghz;
	}

	public void setGhz(String ghz) {
		this.ghz = ghz;
	}

}
