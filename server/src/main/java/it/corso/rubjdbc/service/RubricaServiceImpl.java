package it.corso.rubjdbc.service;

import java.util.List;

import it.corso.rubjdbc.dao.RubricaDAO;
import it.corso.rubjdbc.model.Contatto;

public class RubricaServiceImpl implements RubricaService {

	RubricaDAO dao = RubricaDAO.getDao();
	
	@Override
	public List<Contatto> salva(Contatto c) {
		dao.salva(c);
		return tornaTutti();
	}

	@Override
	public List<Contatto> rimuovi(Contatto c) {
		dao.rimuovi(c);
		return tornaTutti();
	}

	@Override
	public List<Contatto> tornaTutti() {
		return dao.trovaTutti();
		
	}

}
