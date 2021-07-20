package it.corso.rubjdbc.dao;

import java.util.List;

import it.corso.rubjdbc.model.Contatto;

public class RubricaDAO {
	
	private static RubricaDAO rubDao;
	
	private RubricaDAO () {	
	}
	
	public static RubricaDAO getDao () {
		if (rubDao == null) {
			rubDao = new RubricaDAO();
		} return rubDao;
	}
	
	public Contatto salva (Contatto c) {
		return c;	
	}
	
	public void rimuovi (Contatto c) {
	}
	
	public List<Contatto> trovaTutti(){
		
		
		
		return null;
		
	}
	
	
	
	

}
