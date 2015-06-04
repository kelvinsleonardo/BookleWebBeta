package br.com.bookleweb.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@NamedQueries({
	@NamedQuery(name="Curso.procuraPeloCodigo", 
				query="SELECT cur FROM Curso cur WHERE cur.cod_curso = :cod_curso"),
	@NamedQuery(name="Curso.procuraPeloNome", 
				query="SELEct cur FROM Curso cur WHERE cur.nome_curso LIKE :nome_curso")
})

/** Classe Modelo de Curso
 * 
 * @author Kelvin Santiago
 *
 */

@Entity
@Table(name = "tb_curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_curso;
	
	private String nome_curso;
	
	@OneToMany(mappedBy="curso")
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