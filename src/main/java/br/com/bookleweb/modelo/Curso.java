package br.com.bookleweb.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {
	@Id
	private Integer cod_curso;
	private String nome_curso;
	@ManyToMany
	@JoinTable(name="tb_curso_disciplina", 
				joinColumns= @JoinColumn(name="cod_curso"),
				inverseJoinColumns = @JoinColumn(name="cod_disciplina"))
	private List<Disciplina> disciplina;
	
	public Integer getCod_curso() {
		return cod_curso;
	}
	public void setCod_curso(Integer cod_curso) {
		this.cod_curso = cod_curso;
	}
	public String getNome_curso() {
		return nome_curso;
	}
	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}
	public List<Disciplina> getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
		
	
}