package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Livro;

@Repository
public class LivroDAO {
	
	public Boolean adiciona(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}finally{
			manager.close();
		}
	}

	public Boolean edita(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			manager.merge(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}finally{
			manager.close();
		}
	}
	
	public Boolean remove(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
	        manager.getTransaction().begin();
	        Livro livroFind = manager.find(Livro.class, livro.getIsbn());
	        manager.remove(livroFind);
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
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraTodosLivros", Livro.class);
		ArrayList<Livro> livros = (ArrayList<Livro>) typedQuery.getResultList();
		return livros;
	}
	
	public ArrayList<Livro> procuraPeloISBN(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraPeloISBN",Livro.class);
		typedQuery.setParameter("isbn", livro.getIsbn());// Setando parametro da Query
		ArrayList<Livro> livrosArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livrosArrayList;
	}
	
	public ArrayList<Livro> procuraPeloTitulo(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraPeloTitulo",Livro.class);
		typedQuery.setParameter("titulo", "%"+livro.getTitulo()+"%");// Setando parametro da Query
		ArrayList<Livro> livrosArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livrosArrayList;
	}
	

}
