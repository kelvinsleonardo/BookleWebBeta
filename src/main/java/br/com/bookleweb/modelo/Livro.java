package br.com.bookleweb.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Livro.pesquisaPeloISBN", 
				query="SELECT DISTINCT liv FROM Livro liv JOIN liv.disciplinas disc WHERE liv.isbn = :isbn"),
	@NamedQuery(name="Livro.pesquisaPeloTitulo", 
				query="SELECT DISTINCT liv FROM Livro liv JOIN liv.disciplinas disc WHERE liv.titulo LIKE :titulo"),
	@NamedQuery(name="Livro.pesquisaTodosLivros", 
				query="SELECT liv FROM Livro liv")
})

@Entity
@Table(name = "tb_livro")
public class Livro {
	@Id
	private Integer isbn;
	private String titulo;
	private String autor;
	private String desc_livro;
	private String local;
	private String status;
	private Integer exemplares;
	
	@ManyToMany
	@JoinTable(name="tb_disciplina_livro", 
	joinColumns= @JoinColumn(name="isbn"),
	inverseJoinColumns = @JoinColumn(name="cod_disciplina"))
	private List<Disciplina> disciplinas;
	
	public Integer getIsbn() {
		return isbn;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getDesc_livro() {
		return desc_livro;
	}
	public void setDesc_livro(String desc_livro) {
		this.desc_livro = desc_livro;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getExemplares() {
		return exemplares;
	}
	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}
}