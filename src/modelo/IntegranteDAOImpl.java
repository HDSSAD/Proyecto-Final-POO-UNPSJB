package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntegranteDAOImpl implements IntegranteDAO {

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
		String consulta = "insert into integrantes(dni,apellido,nombre,fechanacimiento,direccion,telefono,telefono2,correo)  values(?,?,?,?::date,?,?,?,?)";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public List<Integrante> buscarIntegrante(ArrayList<String> parametros) {
		List<Integrante> ret = new ArrayList<Integrante>();
		String consulta = "select * from integrantes where apellido ilike ? and nombre ilike ? ";
		ResultSet rs = BD.getInstance().listarEntidadesParametrizada(consulta, parametros);
		try {
			while (rs.next()) {
				Integrante integrante = new Integrante(rs.getString("dni"), rs.getString("apellido"),
						rs.getString("nombre"), rs.getString("fechanacimiento"), rs.getString("direccion"),
						rs.getString("telefono"), rs.getString("telefono2"), rs.getString("correo"));
				ret.add(integrante);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				integrante = new Integrante(rs.getString("dni"), rs.getString("apellido"), rs.getString("nombre"),
						rs.getString("fechanacimiento"), rs.getString("direccion"), rs.getString("telefono"),
						rs.getString("telefono2"), rs.getString("correo"));
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
		String consulta = "delete from integrantes where dni = ?";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

	@Override
	public Boolean modificarIntegrante(Integrante integrante) {
		// TODO Auto-generated method stub
		ArrayList<String> parametros = new ArrayList<String>();
		parametros.add(integrante.getApellido());
		parametros.add(integrante.getNombre());
		parametros.add(integrante.getFechaNacimiento());
		parametros.add(integrante.getDireccion());
		parametros.add(integrante.getTelefono());
		parametros.add(integrante.getTelefono2());
		parametros.add(integrante.getCorreo());
		parametros.add(integrante.getDni());
		String consulta = "update integrantes "
				+ "set apellido = ?, nombre = ?, fechanacimiento = ?, direccion = ?, telefono = ?, telefono2 = ?, correo = ? "
				+ "where dni = ?";
		return BD.getInstance().manipularEntidades(consulta, parametros);
	}

}