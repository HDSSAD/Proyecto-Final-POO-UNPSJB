package modelo;

import java.util.ArrayList;
import java.util.List;

public interface ComputadoraDAO {

	public Boolean agregarComputadora(Computadora computadora);
	public List<Computadora> buscarComputadora(String where, ArrayList<String> parametros);
	public List<Computadora> buscarComputadora();
	public Computadora buscarComputadora(Integer idComputadora);
	public Boolean borrarComputadora(Integer idComputadora);
	public Boolean borrarComputadoraIntegrante(String idIntegrante, String idComputadora);
	public Boolean modificarComputadora(Computadora computadora);
	public Boolean agregarIntegranteComputadora(String idIntegrante, String idComputadora);
	public String obtenerUltimoNroPC();
	public String obtenerComputadorasTrabajadas(String dni);
	public String getComputadoraFromIntPC(String idIntegrante);
}
