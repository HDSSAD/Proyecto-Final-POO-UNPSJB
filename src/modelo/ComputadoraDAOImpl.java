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

	private ArrayList<String> getParamFromPC(Computadora computadora) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(computadora.getIdComputadora());
		parametros.add(computadora.getEstado());
		parametros.add(computadora.getPlacaBase().toSqlArray());
		parametros.add(computadora.getProcesador().toSqlArray());
		parametros.add(computadora.getDisco().toSqlArray());
		parametros.add(computadora.getRam().toSqlArray());
		parametros.add(computadora.getLectora().toSqlArray());
		parametros.add(computadora.getNotas());
		return parametros;
	}

	private ArrayList<String> getParamFromPC_Update(Computadora computadora) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(computadora.getEstado());
		parametros.add(computadora.getPlacaBase().toSqlArray());
		parametros.add(computadora.getProcesador().toSqlArray());
		parametros.add(computadora.getDisco().toSqlArray());
		parametros.add(computadora.getRam().toSqlArray());
		parametros.add(computadora.getLectora().toSqlArray());
		parametros.add(computadora.getNotas());
		parametros.add(computadora.getIdComputadora());
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
						new CompLectora(rs.getString("lectora").split(",")), rs.getString("notas")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Boolean agregarIntegranteComputadora(String idIntegrante, String idComputadora) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(idComputadora);
		parametros.add(idIntegrante);
		if (this.existeIntegranteComputadora(idIntegrante, idComputadora)) {
			return true;
		}
		String consulta = "insert into integrantes_computadoras (idComputadora, idIntegrante) values (?,?)";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public Boolean agregarComputadora(Computadora computadora) {
		ArrayList<String> parametros = this.getParamFromPC(computadora);
		String consulta = "insert into computadoras (id,estado,placaBase,procesador,disco,ram,lectora,notas) values (?,?,?,?,?,?,?,?)";
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
					new CompLectora(rs.getString("lectora").split(",")), rs.getString("notas"));
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
		ArrayList<String> parametros = this.getParamFromPC_Update(computadora);
		String consulta = "update computadoras "
				+ "set estado = ?, placaBase = ?, procesador = ?, disco = ?, ram = ?, lectora = ?, notas = ?"
				+ "where id = ? ";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	private Boolean existeIntegranteComputadora(String idIntegrante, String idComputadora) {
		Boolean ret = false;
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(idIntegrante);
		parametros.add(idComputadora);
		String consulta = "select * " + "from integrantes_computadoras "
				+ "where idIntegrante ilike ? and idComputadora ilike ?";
		if (BD.getInstance().listarEntidadesParametrizada(consulta, parametros) != null)
			ret = true;
		return ret;
	}

}
