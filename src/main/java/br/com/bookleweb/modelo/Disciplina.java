package br.com.bookleweb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {
	@Id
	private Integer coddisciplina;
	private String nome;
	
	public Integer getCoddisciplina() {
		return coddisciplina;
	}
	public void setCoddisciplina(Integer coddisciplina) {
		this.coddisciplina = coddisciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
	