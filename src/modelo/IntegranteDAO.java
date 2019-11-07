package modelo;

import java.util.ArrayList;
import java.util.List;

public interface IntegranteDAO {

	public Boolean agregarIntegrante(Integrante integrante);
	public List<Integrante> buscarIntegrante(ArrayList<String> parametros);
	public List<Integrante> buscarIntegrante();
	public Boolean borrarIntegrante(String dni);
	public Boolean modificarIntegrante(Integrante integrante);
}
