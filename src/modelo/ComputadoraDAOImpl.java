package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadoraDAOImpl implements ComputadoraDAO {

	private ArrayList<String> pcDataToArray (Computadora computadora) {
		ArrayList<String> parametros = new ArrayList<String>();
		String tempString = "";
		parametros.add(computadora.getIdComputadora());
		parametros.add(computadora.getEstado());
		for (CompPlacaBase comp : computadora.getPlacaBase()) {
			if (tempString.isBlank()) {
				tempString += comp.toSqlArray();
			} else {
				tempString += ";" + comp.toSqlArray();
			}
		}
		parametros.add(tempString);
		tempString="";
		for (CompProcesador comp : computadora.getProcesador()) {
			if (tempString.isBlank()) {
				tempString += comp.toSqlArray();
			} else {
				tempString += ";" + comp.toSqlArray();
			}
		}
		parametros.add(tempString);
		tempString="";
		for (CompDiscoRigido comp : computadora.getDisco()) {
			if (tempString.isBlank()) {
				tempString += comp.toSqlArray();
			} else {
				tempString += ";" + comp.toSqlArray();
			}
		}
		parametros.add(tempString);
		tempString="";
		for (CompMemoriaRam comp : computadora.getRam()) {
			if (tempString.isBlank()) {
				tempString += comp.toSqlArray();
			} else {
				tempString += ";" + comp.toSqlArray();
			}
		}
		parametros.add(tempString);
		tempString="";
		for (CompLectora comp : computadora.getLectora()) {
			if (tempString.isBlank()) {
				tempString += comp.toSqlArray();
			} else {
				tempString += ";" + comp.toSqlArray();
			}
		}
		parametros.add(tempString);
		return parametros;
	}
	
	private List<Computadora> dataBaseToPcList (ResultSet rs) {
		List<Computadora> ret = new ArrayList<Computadora>();
		try {
			while (rs.next()) {
				String id = rs.getString("id");
				String estado = rs.getString("estado");
				ArrayList<CompPlacaBase> compPlacaBase = new ArrayList<CompPlacaBase>();
				for (String string : rs.getString("placaBase").split(";")) {
					compPlacaBase.add(new CompPlacaBase(string.split(",")));
				}
				ArrayList<CompProcesador> compProcesador = new ArrayList<CompProcesador>();
				for (String string : rs.getString("procesador").split(";")) {
					compProcesador.add(new CompProcesador(string.split(",")));
				}
				ArrayList<CompDiscoRigido> compDiscoRigido = new ArrayList<CompDiscoRigido>();
				for (String string : rs.getString("disco").split(";")) {
					compDiscoRigido.add(new CompDiscoRigido(string.split(",")));
				}
				ArrayList<CompMemoriaRam> compMemoriaRam = new ArrayList<CompMemoriaRam>();
				for (String string : rs.getString("ram").split(";")) {
					compMemoriaRam.add(new CompMemoriaRam(string.split(",")));
				}
				ArrayList<CompLectora> compLectora = new ArrayList<CompLectora>();
				for (String string : rs.getString("lectora").split(";")) {
					compLectora.add(new CompLectora(string.split(",")));
				}
				ret.add(new Computadora(id,estado,compPlacaBase,compProcesador,compDiscoRigido,compMemoriaRam,compLectora));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public Boolean agregarComputadora(Computadora computadora) {	
		// no esta muy bonito pero funciona y es facil de manejar para nuevos componentes
		// solo se debe añadir la misma porcion de codigo y añadir el metodo toSqlArray al componente
		// este metodo solo concatenera los strings de cada atributo de la clase con una "," itermedia
		ArrayList<String> parametros = this.pcDataToArray(computadora);
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
			String id = rs.getString("id");
			String estado = rs.getString("estado");
			ArrayList<CompPlacaBase> compPlacaBase = new ArrayList<CompPlacaBase>();
			for (String string : rs.getString("placaBase").split(";")) {
				compPlacaBase.add(new CompPlacaBase(string.split(",")));
			}
			ArrayList<CompProcesador> compProcesador = new ArrayList<CompProcesador>();
			for (String string : rs.getString("procesador").split(";")) {
				compProcesador.add(new CompProcesador(string.split(",")));
			}
			ArrayList<CompDiscoRigido> compDiscoRigido = new ArrayList<CompDiscoRigido>();
			for (String string : rs.getString("disco").split(";")) {
				compDiscoRigido.add(new CompDiscoRigido(string.split(",")));
			}
			ArrayList<CompMemoriaRam> compMemoriaRam = new ArrayList<CompMemoriaRam>();
			for (String string : rs.getString("ram").split(";")) {
				compMemoriaRam.add(new CompMemoriaRam(string.split(",")));
			}
			ArrayList<CompLectora> compLectora = new ArrayList<CompLectora>();
			for (String string : rs.getString("lectora").split(";")) {
				compLectora.add(new CompLectora(string.split(",")));
			}
			computadora = new Computadora(id,estado,compPlacaBase,compProcesador,compDiscoRigido,compMemoriaRam,compLectora);
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
		ArrayList<String> parametros = this.pcDataToArray(computadora);
		String consulta = "update computadoras "
				+ "set id = ?, set estado = ?, placaBase = ?, procesador = ?, disco = ?, ram = ?, lectora = ? "
				+ "where id = ? ";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

}
