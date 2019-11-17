package componentes;

public class CompLectora extends Componente {

	private String color;

	public CompLectora(String tipo, String modelo, String estado, Integer cantidad, String color) {
		super(tipo, modelo, estado, cantidad);
		this.setColor(color);
	}

	public CompLectora(String[] array) {
		super(array);
		this.setColor(array[3]);
	}

	@Override
	public String toString() {
		String ret;
		if (this.getCantidad() < 1) {
			ret = "\n Faltante \n";
		} else {
			ret = super.toString() + "   Color: " + this.getColor() + "\n";
		}
		return ret;
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + "," + this.getColor();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
