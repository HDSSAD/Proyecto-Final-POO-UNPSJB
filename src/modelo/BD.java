package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BD {

	private Connection conexion = null;
	private static BD bd = null;
	private static String pass = "Mepache", user = "postgres";

	private BD(String user, String pass) {
		this.cerrarConexion();
		String url = "jdbc:postgresql://localhost:5432/GestorPuente";
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			conexion = null;
			System.out.println("Error al registrar el driver de PostgreSQL: " + e);
		} catch (SQLException e) {
			conexion = null;
			System.out.println("Error al asignar conexion DriverManager: " + e);
		}
	}

	private BD() {
		establecerConexion();
	}

	private void establecerConexion() {
		if (conexion != null)
			return;
		String url = "jdbc:postgresql://localhost:5432/GestorPuente";
//		String user = "postgres";
//		String pass = "Sebastian";
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println(url + " " + user + " " + pass);
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al registrar el driver de PostgreSQL: " + e);
		} catch (SQLException e) {
			conexion = null;
			System.out.println("Error al asignar conexion DriverManager: " + e);
		}
	}

	public static BD getInstance() {
		if (bd == null)
			bd = new BD();
//			return null;
		return bd;
	}

	public ResultSet listarEntidades(String consulta) {
		ResultSet rs = null;
		try {
			Statement s = conexion.createStatement();
			rs = s.executeQuery(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet listarEntidadesParametrizada(String consulta, ArrayList<String> parametros) {
		ResultSet rs = null;
		try {
			PreparedStatement s = conexion.prepareStatement(consulta);
			int i = 0;
			while (i < parametros.size()) {
				s.setString(i + 1, parametros.get(i));
				i++;
			}
			rs = s.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Boolean manipularEntidades(String consulta, ArrayList<String> parametros) {
		Boolean ret = false;
		try {
			PreparedStatement s = conexion.prepareStatement(consulta);
			int i = 0;
			while (i < parametros.size()) {
				s.setString(i + 1, parametros.get(i));
				i++;
			}
			s.executeUpdate();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				bd = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
