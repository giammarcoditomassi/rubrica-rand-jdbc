package it.corso.rubjdbc.service;
import java.util.List;
import it.corso.rubjdbc.model.Contatto;

public interface RubricaService {
	
	public List<Contatto> salva(Contatto c);
	public List<Contatto> rimuovi (Contatto c);
	public List <Contatto> tornaTutti ();

}
