package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Curso;

@Repository
public class CursoDAO {
	
	public Boolean adiciona(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.persist(curso);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean edita(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.merge(curso);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean remove(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Curso cursoBuscado = manager.find(Curso.class, curso.getCod_curso());
			manager.remove(cursoBuscado);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public ArrayList<Curso> getTodosCursos(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Curso> typedQuery = manager.createQuery("FROM Curso", Curso.class);
		ArrayList<Curso> cursos = (ArrayList<Curso>) typedQuery.getResultList();
		return cursos;
	}
	
	public ArrayList<Curso> procuraCursoPeloCodigo(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Curso> typedQuery = manager.createNamedQuery("Curso.procuraPeloCodigo",Curso.class);
		typedQuery.setParameter("cod_curso", curso.getCod_curso());// Setando parametro da Query
		ArrayList<Curso> cursoArrayList = (ArrayList<Curso>) typedQuery.getResultList();  // Pega resultado
		return cursoArrayList;
	}
	
	public ArrayList<Curso> procuraCursoPeloNome(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Curso> typedQuery = manager.createNamedQuery("Curso.procuraPeloNome",Curso.class);
		typedQuery.setParameter("nome_curso", "%"+curso.getNome_curso()+"%");// Setando parametro da Query
		ArrayList<Curso> cursoArrayList = (ArrayList<Curso>) typedQuery.getResultList();  // Pega resultado
		return cursoArrayList;
	}

}
