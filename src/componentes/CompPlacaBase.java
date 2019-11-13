package componentes;

public class CompPlacaBase extends Componente {
	
	public CompPlacaBase(String tipo, String modelo, String estado, Integer cantidad) {
		super(tipo, modelo, estado, cantidad);
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
