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
	
	@ManyToMany(mappedBy = "disciplina")
	private List<Curso> curso;

	@ManyToMany
	@JoinTable(name="tb_disciplina_livro", 
				joinColumns= @JoinColumn(name="cod_disciplina"),
				inverseJoinColumns = @JoinColumn(name="isbn"))
	private List<Livro> livro;

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
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}
	
	
}
	