package br.com.bookleweb.dao;

import java.util.ArrayList;

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

	public ArrayList<Disciplina> getTodasDisciplinas(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraTodasAsDisciplinas", Disciplina.class);
		ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) typedQuery.getResultList();
		return disciplinas;
	}
	
	public ArrayList<Disciplina> procuraPeloCodigoDaDisciplina(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraPeloCodigo",Disciplina.class);
		typedQuery.setParameter("cod_disciplina", disciplina.getCod_disciplina());// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
	
	public ArrayList<Disciplina> procuraPeloNomeDaDisciplina(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraPeloNome",Disciplina.class);
		typedQuery.setParameter("nome_disciplina", "%"+disciplina.getNome_disciplina()+"%");// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
	
	public ArrayList<Disciplina> procuraDisciplinaPeloCodigoDoCurso(Curso curso){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Disciplina> typedQuery = manager.createNamedQuery("Disciplina.procuraPeloCodigoCurso",Disciplina.class);
		typedQuery.setParameter("cod_curso",curso.getCod_curso());// Setando parametro da Query
		ArrayList<Disciplina> disciplinaArrayList = (ArrayList<Disciplina>) typedQuery.getResultList();  // Pega resultado
		return disciplinaArrayList;
	}
}
