package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import componentes.CompDiscoRigido;
import componentes.CompLectora;
import componentes.CompMemoriaRam;
import componentes.CompPlacaBase;
import componentes.CompProcesador;

public class ComputadoraDAOImpl implements ComputadoraDAO {

//	private static String separator = ";";
	/*
	 * private ArrayList<String> pcDataToArray (Computadora computadora) {
	 * ArrayList<String> parametros = new ArrayList<String>(); String tempString =
	 * ""; parametros.add(computadora.getIdComputadora());
	 * parametros.add(computadora.getEstado()); for (CompPlacaBase comp :
	 * computadora.getPlacaBase()) { if (tempString.isBlank()) { tempString +=
	 * comp.toSqlArray(); } else { tempString += ";" + comp.toSqlArray(); } }
	 * parametros.add(tempString); tempString=""; for (CompProcesador comp :
	 * computadora.getProcesador()) { if (tempString.isBlank()) { tempString +=
	 * comp.toSqlArray(); } else { tempString += ";" + comp.toSqlArray(); } }
	 * parametros.add(tempString); tempString=""; for (CompDiscoRigido comp :
	 * computadora.getDisco()) { if (tempString.isBlank()) { tempString +=
	 * comp.toSqlArray(); } else { tempString += ";" + comp.toSqlArray(); } }
	 * parametros.add(tempString); tempString=""; for (CompMemoriaRam comp :
	 * computadora.getRam()) { if (tempString.isBlank()) { tempString +=
	 * comp.toSqlArray(); } else { tempString += ";" + comp.toSqlArray(); } }
	 * parametros.add(tempString); tempString=""; for (CompLectora comp :
	 * computadora.getLectora()) { if (tempString.isBlank()) { tempString +=
	 * comp.toSqlArray(); } else { tempString += ";" + comp.toSqlArray(); } }
	 * parametros.add(tempString); return parametros; }
	 */

	private ArrayList<String> getParamFromPC(Computadora computadora) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(computadora.getIdComputadora());
		parametros.add(computadora.getEstado());
		parametros.add(computadora.getPlacaBase().toSqlArray());
		parametros.add(computadora.getProcesador().toSqlArray());
		parametros.add(computadora.getDisco().toSqlArray());
		parametros.add(computadora.getRam().toSqlArray());
		parametros.add(computadora.getLectora().toSqlArray());
		return parametros;
	}

	private List<Computadora> dataBaseToPcList(ResultSet rs) {
		List<Computadora> ret = new ArrayList<Computadora>();
		try {
			while (rs.next()) {
				ret.add(new Computadora(rs.getString("id"), rs.getString("estado"),
						new CompPlacaBase(rs.getString("placaBase").split(",")),
						new CompProcesador(rs.getString("procesador").split(",")),
						new CompDiscoRigido(rs.getString("disco").split(",")),
						new CompMemoriaRam(rs.getString("ram").split(",")),
						new CompLectora(rs.getString("lectora").split(","))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Boolean agregarComputadora(Computadora computadora) {
		ArrayList<String> parametros = this.getParamFromPC(computadora);
		String consulta = "insert into computadoras (id,estado,placaBase,procesador,disco,ram,lectora) values (?,?,?,?,?,?,?)";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public List<Computadora> buscarComputadora(String where, ArrayList<String> parametros) {
		String consulta = "select * from computadoras " + where;
		ResultSet rs = BD.getInstance().listarEntidadesParametrizada(consulta, parametros);
		List<Computadora> ret = this.dataBaseToPcList(rs);
		return ret;
	}

	@Override
	public List<Computadora> buscarComputadora() {
		String consulta = "select * from computadoras";
		ResultSet rs = BD.getInstance().listarEntidades(consulta);
		List<Computadora> ret = this.dataBaseToPcList(rs);
		return ret;
	}

	@Override
	public Computadora buscarComputadora(Integer idComputadora) {
		String consulta = "select * from computadoras where id = " + idComputadora.toString();
		ResultSet rs = BD.getInstance().listarEntidades(consulta);
		Computadora computadora = null;
		try {
			rs.next();
			computadora = new Computadora(rs.getString("id"), rs.getString("estado"),
					new CompPlacaBase(rs.getString("placaBase").split(",")),
					new CompProcesador(rs.getString("procesador").split(",")),
					new CompDiscoRigido(rs.getString("disco").split(",")),
					new CompMemoriaRam(rs.getString("ram").split(",")),
					new CompLectora(rs.getString("lectora").split(",")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computadora;
	}

	@Override
	public Boolean borrarComputadora(Integer idComputadora) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(idComputadora.toString());
		String consulta = "delete from computadoras where id = ? ";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public Boolean modificarComputadora(Computadora computadora) {
		ArrayList<String> parametros = this.getParamFromPC(computadora);
		String consulta = "update computadoras "
				+ "set id = ?, set estado = ?, placaBase = ?, procesador = ?, disco = ?, ram = ?, lectora = ? "
				+ "where id = ? ";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

}
