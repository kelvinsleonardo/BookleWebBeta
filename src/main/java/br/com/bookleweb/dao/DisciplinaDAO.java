package br.com.bookleweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Curso;
import br.com.bookleweb.modelo.Disciplina;

@Repository
public class DisciplinaDAO {
	
	public Boolean adiciona(Disciplina disciplina, Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();			
			List<Curso> listacursos = new ArrayList<Curso>();
			listacursos.add(curso);
			disciplina.setCurso(listacursos);
			manager.persist(disciplina);
			manager.getTransaction().commit();
			return true;
			
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	public Boolean edita(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.merge(disciplina);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
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

	public ArrayList<Disciplina> getlistaTodasDisciplinas(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createQuery("FROM Disciplina", Disciplina.class);
		ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) typedQuery.getResultList();
		return disciplinas;
	}
	
	public ArrayList<Disciplina> pesquisaPorMatricula(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.pesquisaPelaMatricula",Disciplina.class);
		typedQuery.setParameter("cod_disciplina", disciplina.getCod_disciplina());// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
	
	public ArrayList<Disciplina> pesquisaPorNome(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.pesquisaPeloNome",Disciplina.class);
		typedQuery.setParameter("nome_disciplina", "%"+disciplina.getNome_disciplina()+"%");// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
}
