package br.com.bookleweb.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.bookleweb.factory.FabricaEntityManager;
import br.com.bookleweb.modelo.Disciplina;
import br.com.bookleweb.modelo.Livro;
import br.com.bookleweb.util.DataFind;

@Repository
public class RelationShipDisciplinaLivroDAO {

	public Boolean adiciona(Livro livro, Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		DataFind datafind = new DataFind();
		try{
	        manager.getTransaction().begin();
	        Disciplina disciplinaFind = manager.find(Disciplina.class, disciplina.getCod_disciplina());
			Livro livroFind = manager.find(Livro.class, livro.getIsbn());
			
			Boolean encontrouDisciplina = datafind.procuraDisciplinaNoArray(disciplina.getCod_disciplina(), livroFind.getDisciplinas());
			
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
	
	public Boolean edita(){
		return true;
	}

	public ArrayList<Livro> getlistaTodosLivrosDaRelacao(){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraTodosLivrosDaRelacao", Livro.class);
		ArrayList<Livro> livros = (ArrayList<Livro>) typedQuery.getResultList();
		return livros;
	}
	
	public ArrayList<Livro> procuraNaRelacaoPeloCodigoDaDisciplina(Disciplina disciplina){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		//TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraNaRelacaoPeloCodigoDisciplina",Livro.class);
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraNaRelacaoPeloCodigoDisciplina",Livro.class);
		typedQuery.setParameter("codigodisciplina",disciplina.getCod_disciplina());// Setando parametro da Query
		ArrayList<Livro> livroArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livroArrayList;
	}
	
	public ArrayList<Livro> procuraNaRelacaoPeloISBN(Livro livro){
		EntityManager manager = FabricaEntityManager.getEntityManagerFactory().createEntityManager();
		TypedQuery<Livro> typedQuery = manager.createNamedQuery("Livro.procuraNaRelacaoPeloCodigoISBN",Livro.class);
		typedQuery.setParameter("isbn",livro.getIsbn());// Setando parametro da Query
		ArrayList<Livro> livroArrayList = (ArrayList<Livro>) typedQuery.getResultList();  // Pega resultado
		return livroArrayList;
	}

}
