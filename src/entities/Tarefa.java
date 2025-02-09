package entities;

public class Tarefa {
	private int id;
	private String titulo;
	private String prazo;
	private String conteudo;
	
	public Tarefa(String titulo, String prazo, String conteudo) {
		this.id = 0;
		this.titulo = titulo;
		this.prazo = prazo;
		this.conteudo = conteudo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
