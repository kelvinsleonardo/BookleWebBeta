package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Curso;

/**
 * Classe responsável pelo DAO (Data Access Object) do Curso, ou seja é uma
 * classe que contém métodos para acesso ao banco de dados com JPA.
 * 
 * @author Kélvin Santiago
 *
 */

@Repository
public class CursoDAO {

	/**
	 * Método responsável por adicionar um curso no banco de dados
	 * 
	 * @param curso
	 * @return Boolean - True ou False
	 */
	public Boolean adiciona(Curso curso) {
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory()
				.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(curso);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			manager.close();
		}
	}

	/**
	 * Método responsável por editar um curso no banco de dados
	 * 
	 * @param curso
	 * @return Boolean - True ou False.
	 */
	public Boolean edita(Curso curso) {
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory()
				.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(curso);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			manager.close();
		}
	}

	/**
	 * Método responsável por remover um curso no banco de dados
	 * 
	 * @param curso
	 * @return Boolean - True ou False.
	 */
	public Boolean remove(Curso curso) {
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory()
				.createEntityManager();
		try {
			manager.getTransaction().begin();
			Curso cursoBuscado = manager
					.find(Curso.class, curso.getCod_curso());
			manager.remove(cursoBuscado);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			manager.close();
		}
	}

	/** Método responsável por buscar todos os cursos no banco de dados
	 * 
	 * @return ArrayList<Curso> - Lista de cursos
	 */
	public ArrayList<Curso> getTodosCursos() {
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory()
				.createEntityManager();
		TypedQuery<Curso> typedQuery = manager.createQuery("FROM Curso",
				Curso.class);
		ArrayList<Curso> cursos = (ArrayList<Curso>) typedQuery.getResultList();
		return cursos;
	}

	/** Método responsável por buscar os dados do curso no banco de dados
	 * de acordo com o código do curso informado.
	 * 
	 * @param curso
	 * @return ArrayList<Curso> - Lista de cursos
	 */
	public ArrayList<Curso> procuraCursoPeloCodigo(Curso curso) {
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Curso> typedQuery = manager.createNamedQuery("Curso.procuraPeloCodigo", Curso.class);
		typedQuery.setParameter("cod_curso", curso.getCod_curso());
																	
		ArrayList<Curso> cursoArrayList = (ArrayList<Curso>) typedQuery.getResultList(); 
		return cursoArrayList;
	}


	/** Método responsável por buscar os dados do curso no banco de dados
	 * de acordo com o nome do curso informado.
	 * 
	 * @param curso
	 * @return ArrayList<Curso> - Lista de cursos
	 */
	public ArrayList<Curso> procuraCursoPeloNome(Curso curso) {
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Curso> typedQuery = manager.createNamedQuery("Curso.procuraPeloNome", Curso.class);
		typedQuery.setParameter("nome_curso", "%" + curso.getNome_curso() + "%");													
		ArrayList<Curso> cursoArrayList = (ArrayList<Curso>) typedQuery.getResultList(); 
		return cursoArrayList;
	}

}
