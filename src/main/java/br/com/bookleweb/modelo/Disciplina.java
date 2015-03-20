package br.com.bookleweb.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {
	@Id
	private Integer cod_disciplina;
	
	private String nome_disciplina;
	
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

	public List<Curso> getCurso() {
		return cursos;
	}

	public void setCurso(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Livro> getLivro() {
		return livros;
	}

	public void setLivro(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
	