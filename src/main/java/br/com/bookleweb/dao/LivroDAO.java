package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Livro;

/**
 * Classe responsável pelo DAO (Data Access Object) do Livro, ou seja é uma
 * classe que contém métodos para acesso ao banco de dados com JPA.
 * 
 * @author Kélvin Santiago
 *
 */

@Repository
public class LivroDAO {
	
	/**
	 * Método responsável por adicionar um livro no banco de dados
	 * 
	 * @param livro
	 * @return Boolean - True ou False
	 */
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

	/**
	 * Método responsável por editar um livro no banco de dados
	 * 
	 * @param livro
	 * @return Boolean - True ou False
	 */
	public Boolean edita(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			manager.getTransaction().begin();
			Livro livroFind = manager.find(Livro.class, livro.getIsbn());
			livro.setDisciplinas(livroFind.getDisciplinas());
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
	
	/**
	 * Método responsável por remover um livro no banco de dados
	 * 
	 * @param livro
	 * @return Boolean - True ou False
	 */
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
	
	/**
	 * Método responsável por buscar todos livros no banco de dados
	 * 
	 * @return ArrayList<Livros> - Lista de livros
	 */
	public ArrayList<Livro> getlistaTodosLivros(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraTodosLivros", Livro.class);
		ArrayList<Livro> livros = (ArrayList<Livro>) typedQuery.getResultList();
		return livros;
	}
	
	/** Método responsável por buscar os dados do livro no banco de dados
	 * de acordo com o isbn do livro informado.
	 * 
	 * @param livro
	 * @return ArrayList<Livro> - Lista de livro
	 */
	public ArrayList<Livro> procuraPeloISBN(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraPeloISBN",Livro.class);
		typedQuery.setParameter("isbn", livro.getIsbn());// Setando parametro da Query
		ArrayList<Livro> livrosArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livrosArrayList;
	}
	
	/** Método responsável por buscar os dados do livro no banco de dados
	 * de acordo com o titulo do livro informado.
	 * 
	 * @param livro
	 * @return ArrayList<Livro> - Lista de livro
	 */
	public ArrayList<Livro> procuraPeloTitulo(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraPeloTitulo",Livro.class);
		typedQuery.setParameter("titulo", "%"+livro.getTitulo()+"%");// Setando parametro da Query
		ArrayList<Livro> livrosArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livrosArrayList;
	}
	

}
