package modelo;

public class Integrante {
	
	private String legajo, dni, apellido, nombre, fechaNacimiento, direccion, telefono, telefono2, correo;
	
	
	public Integrante(String legajo, String dni, String apellido, String nombre, String fechaNacimiento, String direccion,
			String telefono, String telefono2, String correo) {
		super();
		this.setLegajo(legajo);
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setFechaNacimiento(fechaNacimiento);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setTelefono2(telefono2);
		this.setCorreo(correo);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

}
