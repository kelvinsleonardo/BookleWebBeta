package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

/**
 * Classe responsável pelo DAO (Data Access Object) da Disciplina, ou seja é uma
 * classe que contém métodos para acesso ao banco de dados com JPA.
 * 
 * @author Kélvin Santiago
 *
 */

@Repository
public class DisciplinaDAO {
	
	/**
	 * Método responsável por adicionar uma disciplina no banco de dados
	 * 
	 * @param disciplina
	 * @param curso
	 * @return Boolean - True ou False
	 */
	public Boolean adiciona(Disciplina disciplina, Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();			
			disciplina.setCurso(curso);
			manager.persist(disciplina);
			manager.getTransaction().commit();
			return true;
			
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	/**
	 * Método responsável por editar uma disciplina no banco de dados
	 * 
	 * @param disciplina
	 * @param curso
	 * @return Boolean - True ou False
	 */
	public Boolean edita(Disciplina disciplina, Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			disciplina.setCurso(curso);
			manager.merge(disciplina);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	/**
	 * Método responsável por remover uma disciplina no banco de dados
	 * 
	 * @param disciplina
	 * @param curso
	 * @return Boolean - True ou False
	 */
	public Boolean remove(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Disciplina disciplinabuscado = manager.find(Disciplina.class, disciplina.getCod_disciplina());
			manager.remove(disciplinabuscado);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	/**
	 * Método responsável por buscar todos cursos no banco de dados
	 * 
	 * @return ArrayList<Disciplina> - Lista de disciplina
	 */
	public ArrayList<Disciplina> getTodasDisciplinas(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraTodasAsDisciplinas", Disciplina.class);
		ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) typedQuery.getResultList();
		return disciplinas;
	}
	
	/** Método responsável por buscar os dados da disciplina no banco de dados
	 * de acordo com o código da disciplina informado.
	 * 
	 * @param disciplina
	 * @return ArrayList<Disciplina> - Lista de disciplina
	 */
	public ArrayList<Disciplina> procuraPeloCodigoDaDisciplina(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraPeloCodigo",Disciplina.class);
		typedQuery.setParameter("cod_disciplina", disciplina.getCod_disciplina());// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
	
	/** Método responsável por buscar os dados da disciplina no banco de dados
	 * de acordo com o nome da disciplina informado.
	 * 
	 * @param disciplina
	 * @return ArrayList<Disciplina> - Lista de disciplina
	 */
	public ArrayList<Disciplina> procuraPeloNomeDaDisciplina(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraPeloNome",Disciplina.class);
		typedQuery.setParameter("nome_disciplina", "%"+disciplina.getNome_disciplina()+"%");// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
	
	/** Método responsável por buscar os dados da disciplina no banco de dados
	 * de acordo com o código do curso informado.
	 * 
	 * @param curso
	 * @return ArrayList<Disciplina> - Lista de disciplina
	 */
	public ArrayList<Disciplina> procuraDisciplinaPeloCodigoDoCurso(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraPeloCodigoCurso",Disciplina.class);
		typedQuery.setParameter("cod_curso",curso.getCod_curso());// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
}
