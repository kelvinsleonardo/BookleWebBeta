package br.com.bookleweb.util;

import java.util.Iterator;
import java.util.List;

import br.com.bookleweb.modelo.Disciplina;

public class DataFind {

	public Boolean procuraDisciplinaNoArray(int cod_disciplina, List<Disciplina> array){		
		
		Iterator<Disciplina> iterator = array.iterator();

		while (iterator.hasNext()) {
			if(iterator.next().getCod_disciplina() == cod_disciplina){
				return true;
			}
		}			
		return false;

	}
	
}
