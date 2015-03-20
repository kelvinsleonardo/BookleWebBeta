package br.com.bookleweb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {
	@Id
	private Integer codcurso;
	private String nome;
	
	public Integer getCodcurso() {
		return codcurso;
	}
	public void setCodcurso(Integer codcurso) {
		this.codcurso = codcurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}