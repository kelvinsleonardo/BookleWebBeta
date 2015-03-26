package br.com.bookleweb.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQueries({
	@NamedQuery(name="Curso.pesquisaPelaMatricula", 
				query="select c from Curso c where c.cod_curso = :cod_curso"),
	@NamedQuery(name="Curso.pesquisaPeloNome", 
					query="select c from Curso c where c.nome_curso LIKE :nome_curso")
	
})
@Entity
@Table(name = "tb_curso")
public class Curso {
	@Id
	private Integer cod_curso;
	
	private String nome_curso;
	
	private String descricao_curso;
	
	@ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL)
	private List<Disciplina> disciplinas;
	
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
		return disciplinas;
	}
	public void setDisciplina(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getDescricao_curso() {
		return descricao_curso;
	}
	public void setDescricao_curso(String descricao_curso) {
		this.descricao_curso = descricao_curso;
	}
		
	
}