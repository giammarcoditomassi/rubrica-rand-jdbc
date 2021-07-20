package it.corso.rubjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.corso.rubjdbc.model.Contatto;

public class RubricaDAO {

	private static RubricaDAO rubDao;

	private RubricaDAO() {
	}

	public static RubricaDAO getDao() {
		if (rubDao == null) {
			rubDao = new RubricaDAO();
		}
		return rubDao;
	}

	public Contatto salva(Contatto c) {
		return c;
	}

	public void rimuovi(Contatto c) {

		// Connection con = null;
		// PreparedStatement stat = null;
		String sql = "delete from contatto where id = ? ";
		// stat = con.createStatement();

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubricarand", "root", "");
				PreparedStatement stat = con.prepareStatement(sql)) {

			stat.setLong(1, c.getId());

			int num = stat.executeUpdate();

		} catch (Exception ex) {

			ex.printStackTrace();
			// return new ArrayList<>();

		}
	}

	public List<Contatto> trovaTutti() {
		Connection con = null;
		Statement stmt = null;
		List<Contatto> lista = new ArrayList<>();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubricarand", "root", "");

			Statement stat = con.createStatement();
			String sql = "select * from contatto";

			ResultSet res = stmt.executeQuery(sql);

			while (res.next()) {
				long id = res.getLong("id");
				String fn = res.getString("nome");
				String ln = res.getString("cognome");
				String ph = res.getString("telefono");

				Contatto cx = new Contatto(id, fn, ln, ph);
				cx.setId(id);
				lista.add(cx);
				System.out.println("id = " + id + "; Nome = " + fn + "; Cognome= " + ln + "; Telefono = " + ph);

			}

			return lista;
		} catch (Exception ex) {

			ex.printStackTrace();
			return new ArrayList<>();

		} finally {

			if (stmt != null) {

				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
