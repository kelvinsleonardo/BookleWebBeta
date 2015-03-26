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
	@NamedQuery(name="Disciplina.pesquisaPeloCodigo", 
				query="SELECT disc FROM Disciplina disc JOIN disc.cursos cur WHERE disc.cod_disciplina = :cod_disciplina"),
	@NamedQuery(name="Disciplina.pesquisaPeloNome", 
				query="SELECT disc FROM Disciplina disc JOIN disc.cursos cur WHERE disc.nome_disciplina LIKE :nome_disciplina"),
	@NamedQuery(name="Disciplina.pesquisaTodasDisciplinas", 
				query="SELECT disc FROM Disciplina disc JOIN disc.cursos cur")
})

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {
	@Id
	private Integer cod_disciplina;
	
	private String nome_disciplina;
	
	private String desc_disciplina;
	
	@ManyToMany
	@JoinTable(name="tb_curso_disciplina", 
				joinColumns= @JoinColumn(name="cod_disciplina"),
				inverseJoinColumns = @JoinColumn(name="cod_curso"))
	private List<Curso> cursos;

	@ManyToMany(mappedBy = "disciplinas")
	private List<Livro> livros;

	public Integer getCod_disciplina() {
		return cod_disciplina;
	}

	public void setCod_disciplina(Integer cod_disciplina) {
		this.cod_disciplina = cod_disciplina;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getDesc_disciplina() {
		return desc_disciplina;
	}

	public void setDesc_disciplina(String desc_disciplina) {
		this.desc_disciplina = desc_disciplina;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
}
	