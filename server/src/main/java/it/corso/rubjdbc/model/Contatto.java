package it.corso.rubjdbc.model;

public class Contatto {

	private Long Id;
	private String nome;
	private String cognome;
	private String telefono;

	public Contatto(Long id, String nome, String cognome, String telefono) {
		super();
		Id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public Contatto() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contatto [Id=" + Id + ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + "]";
	}

}
