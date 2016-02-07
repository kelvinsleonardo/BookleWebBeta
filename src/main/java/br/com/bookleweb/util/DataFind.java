package br.com.bookleweb.util;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import br.com.bookleweb.modelo.Disciplina;

/** Classe responsável por implementar métodos de procura em Coleções.
 * 
 * @author Kelvin Santiago
 *
 */
public class DataFind {

	/** Método responsável por procurar um inteiro (Codigo Disciplina) dentro de uma lista de disciplinas,
	 * caso encontre é retornado verdadeiro senão é retornado falso;
	 * 
	 * @param cod_disciplina - Inteiro a procurar
	 * @param array - Lista de Disciplinas
	 * @return Boolean
	 */
	public Boolean procuraDisciplinaNoArray(int cod_disciplina, List<Disciplina> array){		
		Iterator<Disciplina> iterator = array.iterator();

		while (iterator.hasNext()) {
			if(iterator.next().getCod_disciplina() == cod_disciplina){
				return true;
			}
		}			
		return false;
	}
	
	public static Long gerarId(){
		StringBuilder codigo = new StringBuilder();
        Random random = new Random();

        for(int contador = 0; contador < 11; contador++){
            codigo.append(random.nextInt(9));
        }
        
        return Long.parseLong(codigo.toString());
	}
	
}
