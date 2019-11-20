package modelo;

import java.util.ArrayList;
import java.util.List;

public interface IntegranteDAO {

	public Boolean agregarIntegrante(Integrante integrante);
	public List<Integrante> buscarIntegrante(String where, ArrayList<String> parametros);
	public Integrante loginIntegrante(ArrayList<String> parametros);
	public List<Integrante> buscarIntegrante();
	public Integrante buscarIntegrante(String dni);
	public Boolean borrarIntegrante(String dni);
	public Boolean modificarIntegrante(Integrante integrante);
	public String getAdminLevel(String dni);
	public Boolean modificarIntegranteNoPass(Integrante integrante);
}
