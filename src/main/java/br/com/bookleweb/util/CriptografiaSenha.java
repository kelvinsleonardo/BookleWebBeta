package br.com.bookleweb.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** Classe responsável por conter métodos de criptografia.
 * 
 * @author Kelvin Santiago
 *
 */
public class CriptografiaSenha {
	
	/** Método responsável por converter uma String em tipo de criptografia
	 * MD5.
	 * 
	 * @param senha
	 * @return String - Retornado string em MD5
	 */
	public static String md5(String senha) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);
		if(sen.length() % 2 != 0){
			sen = "0" + sen;
		}
		return sen;
	}
}