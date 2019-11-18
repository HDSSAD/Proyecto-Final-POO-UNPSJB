package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegranteDAOImpl implements IntegranteDAO {

	private List<String> listaParametros = Arrays.asList("dni", "contraseña", "apellido", "nombre",
			"fechaNacimiento", "direccion", "telefono", "telefono2", "correo", "tipo");

	public List<String> getListaParametros() {
		return listaParametros;
	}

	@Override
	public Boolean agregarIntegrante(Integrante integrante) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(integrante.getDni());
		parametros.add(integrante.getApellido());
		parametros.add(integrante.getNombre());
		parametros.add(integrante.getFechaNacimiento());
		parametros.add(integrante.getDireccion());
		parametros.add(integrante.getTelefono());
		parametros.add(integrante.getTelefono2());
		parametros.add(integrante.getCorreo());
		parametros.add(integrante.getContraseña());
		parametros.add(integrante.getTipo());
		String consulta = "insert into integrantes(dni,apellido,nombre,fechanacimiento,direccion,telefono,telefono2,correo,contraseña,tipo)  values(?,?,?,?::date,?,?,?,?,?,?)";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public List<Integrante> buscarIntegrante(String where, ArrayList<String> parametros) {
		List<Integrante> ret = new ArrayList<Integrante>();
		String consulta = "select * from integrantes " + where; // para hacerlo mas generico y poder usarla de otras
																// formas
		ResultSet rs = BD.getInstance().listarEntidadesParametrizada(consulta, parametros);
		try {
			while (rs.next()) {
				Integrante integrante = new Integrante(rs.getString("dni"),
						rs.getString("contraseña"), rs.getString("apellido"), rs.getString("nombre"),
						rs.getString("fechanacimiento"), rs.getString("direccion"), rs.getString("telefono"),
						rs.getString("telefono2"), rs.getString("correo"), rs.getString("tipo"));
				ret.add(integrante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Integrante loginIntegrante(ArrayList<String> parametros) {
		Integrante ret = null;
		String consulta = "select * from integrantes where dni = ? and contraseña = ? ";
		ResultSet rs = BD.getInstance().listarEntidadesParametrizada(consulta, parametros);
		try {
			while (rs.next()) {
				ret = new Integrante(rs.getString("dni"), "", rs.getString("apellido"), 
						// blank pass field (third field = "")
						rs.getString("nombre"), rs.getString("fechanacimiento"), rs.getString("direccion"),
						rs.getString("telefono"), rs.getString("telefono2"), rs.getString("correo"), rs.getString("tipo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Integrante> buscarIntegrante() {
		String consulta = "select * from integrantes";
		List<Integrante> ret = new ArrayList<Integrante>();
		ResultSet rs = BD.getInstance().listarEntidades(consulta);
		try {
			while (rs.next()) {
				Integrante integrante;
				integrante = new Integrante(rs.getString("dni"), rs.getString("contraseña"),
						rs.getString("apellido"), rs.getString("nombre"), rs.getString("fechanacimiento"),
						rs.getString("direccion"), rs.getString("telefono"), rs.getString("telefono2"),
						rs.getString("correo"), rs.getString("tipo"));
				ret.add(integrante);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Boolean borrarIntegrante(String dni) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(dni);
		String consulta = "delete from integrantes where dni = ? ";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public Boolean modificarIntegrante(Integrante integrante) {
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(integrante.getApellido());
		parametros.add(integrante.getNombre());
		parametros.add(integrante.getFechaNacimiento());
		parametros.add(integrante.getDireccion());
		parametros.add(integrante.getTelefono());
		parametros.add(integrante.getTelefono2());
		parametros.add(integrante.getCorreo());
		parametros.add(integrante.getContraseña());
		parametros.add(integrante.getTipo());
		parametros.add(integrante.getDni());
		String consulta = "update integrantes "
				+ "set apellido = ?, nombre = ?, fechanacimiento = ?::date, direccion = ?, telefono = ?, telefono2 = ?, correo = ?, contraseña = ?, tipo = ? "
				+ "where dni = ?";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public Integrante buscarIntegrante(String dni) {
		String consulta = "select * from integrantes where dni ilike '" + dni + "'";
		ResultSet rs = BD.getInstance().listarEntidades(consulta);
		Integrante integrante = null;
		try {
			rs.next();
			integrante = new Integrante(rs.getString("dni"), rs.getString("contraseña"),
					rs.getString("apellido"), rs.getString("nombre"), rs.getString("fechanacimiento"),
					rs.getString("direccion"), rs.getString("telefono"), rs.getString("telefono2"),
					rs.getString("correo"), rs.getString("tipo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return integrante;
	}

	@Override
	public String getAdminLevel(String dni) {
		 Integrante integrante = this.buscarIntegrante(dni);
		 return integrante.getTipo();
	}

}
