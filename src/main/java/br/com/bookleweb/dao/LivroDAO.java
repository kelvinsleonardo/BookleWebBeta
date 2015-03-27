package br.com.bookleweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;

@Repository
public class LivroDAO {
	
	public Boolean adiciona(Livro livro, Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();			
			List<Disciplina> listadisciplina = new ArrayList<Disciplina>();
			listadisciplina.add(disciplina);
			livro.setDisciplinas(listadisciplina);;
			manager.persist(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	public Boolean edita(Livro livro, Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			List<Disciplina> listadisciplina = new ArrayList<Disciplina>();
			listadisciplina.add(disciplina);
			livro.setDisciplinas(listadisciplina);
			manager.merge(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean remove(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Disciplina livrobuscado = manager.find(Disciplina.class, livro.getIsbn());
			manager.remove(livrobuscado);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	public ArrayList<Livro> getlistaTodosLivros(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.pesquisaTodosLivros", Livro.class);
		ArrayList<Livro> livros = (ArrayList<Livro>) typedQuery.getResultList();
		return livros;
	}
	
	public ArrayList<Livro> pesquisaPeloISBN(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.pesquisaPeloISBN",Livro.class);
		typedQuery.setParameter("isbn", livro.getIsbn());// Setando parametro da Query
		ArrayList<Livro> livrosArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livrosArrayList;
	}
	
	public ArrayList<Livro> pesquisaPeloTitulo(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.pesquisaPeloTitulo",Livro.class);
		typedQuery.setParameter("titulo", "%"+livro.getTitulo()+"%");// Setando parametro da Query
		ArrayList<Livro> livrosArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livrosArrayList;
	}
}
