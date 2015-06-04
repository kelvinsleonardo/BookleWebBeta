package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;
import br.com.bookleweb.util.DataFind;

/**
 * Classe responsável pelo DAO (Data Access Object) do relacionamento Livro com Disciplina, ou seja é uma
 * classe que contém métodos para acesso ao banco de dados com JPA.
 * 
 * @author Kélvin Santiago
 *
 */

@Repository
public class RelacionamentoDisciplinaLivroDAO {

	/**
	 * Método responsável por adicionar um livro a disciplina no banco de dados
	 * 
	 * @param livro
	 * @param disciplina
	 * @return Boolean - True ou False
	 */
	public Boolean adiciona(Livro livro, Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		DataFind datafind = new DataFind();
		try{
	        manager.getTransaction().begin();
	        Disciplina disciplinaFind = manager.find(Disciplina.class, disciplina.getCod_disciplina());
			Livro livroFind = manager.find(Livro.class, livro.getIsbn());
			
			// Verifica se livro já está cadastrado na disciplina
			Boolean encontrouDisciplina = datafind.procuraDisciplinaNoArray(disciplina.getCod_disciplina(), livroFind.getDisciplinas());
			
			// Se não estiver cadastrado, então cadastra
			if(!encontrouDisciplina){
				livroFind.getDisciplinas().add(disciplinaFind);
				manager.persist(livroFind);
				manager.getTransaction().commit();
				return true;
			}
			else{
				return false;
			}

		}catch(Exception e){
			System.out.println(e);
			return false;
		}finally{
			manager.close();
		}   
	}
	
	/**
	 * Método responsável por remover um livro da disciplina no banco de dados
	 * 
	 * @param livro
	 * @param disciplina
	 * @return Boolean - True ou False
	 */
	public Boolean remove(Livro livro, Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		try{
			
	        manager.getTransaction().begin();
	        Disciplina disciplinaFind = manager.find(Disciplina.class, disciplina.getCod_disciplina());
			Livro livroFind = manager.find(Livro.class, livro.getIsbn());
			livroFind.getDisciplinas().remove(disciplinaFind);
			manager.merge(livroFind);
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
	 * Método responsável por buscar todos os livros relacionados a disciplina no banco de dados
	 * 
	 * @return ArrayList<Livro> - Lista de livros
	 */
	public ArrayList<Livro> getlistaTodosLivrosDaRelacao(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraTodosLivrosDaRelacao", Livro.class);
		ArrayList<Livro> livros = (ArrayList<Livro>) typedQuery.getResultList();
		return livros;
	}
	
	/** Método responsável por buscar os dados do livro com relaçao a disciplina no banco de dados
	 * de acordo com o ISBN do livro informado.
	 * 
	 * @param livro
	 * @return ArrayList<Livro> - Lista de livros
	 */
	public ArrayList<Livro> procuraNaRelacaoPeloISBN(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraNaRelacaoPeloCodigoISBN",Livro.class);
		typedQuery.setParameter("isbn",livro.getIsbn());
		ArrayList<Livro> livroArrayList = (ArrayList<Livro>) typedQuery.getResultList(); 
		return livroArrayList;
	}

}
