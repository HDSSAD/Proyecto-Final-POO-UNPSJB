package modelo;

public class CompPlacaBase extends Componente {
	
	public CompPlacaBase(String tipo, String modelo, String estado) {
		super(tipo, modelo, estado);
	}

	public CompPlacaBase(String[] array) {
		super(array);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String toSqlArray() {
		return super.toSqlArray();
	}
}
