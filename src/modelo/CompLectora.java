package modelo;

public class CompLectora extends Componente {

	private String color, velocidad;

	public CompLectora(String tipo, String modelo, String estado, String color, String velocidad) {
		super(tipo, modelo, estado);
		this.setColor(color);
		this.setVelocidad(velocidad);
	}

	public CompLectora(String[] array) {
		super(array);
		this.setColor(array[3]);
		this.setVelocidad(array[4]);
	}

	@Override
	public String toString() {
		return super.toString() + "Color: " + this.getColor() + "\nVelocidad: " + this.getVelocidad() + "X";
	}

	@Override
	public String toSqlArray() {
		return super.toSqlArray() + this.getColor() + "," + this.getVelocidad();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

}
