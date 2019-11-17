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
		String ret;
		if (this.getCantidad() < 1) {
			ret = "\n Faltante \n";
		} else {
			ret = super.toString();
		}
		return ret;
	}

	public String toSqlArray() {
		return super.toSqlArray();
	}
}
