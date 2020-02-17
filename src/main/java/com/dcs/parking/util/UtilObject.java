/**
 * 
 */
package com.dcs.parking.util;

/**
 * Classe responsável por fazer validações de objetos nulos ou não e parametros
 * vazios ou não
 * 
 * @author Djeison 12 de fev de 2020
 */
public class UtilObject {

	/**
	 * Método responsável por validar se o o objeto está nulo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param object
	 * @return boolean
	 */
	public static boolean isNull(Object object) {
		try {
			return object == null;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Método responsável por validar se o o objeto não está nulo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param object
	 * @return boolean
	 */
	public static boolean isNotNull(Object object) {
		try {
			return !isNull(object);
		} catch (NullPointerException e) {
			return false;
		}

	}

	/**
	 * Método responsável por validar se o o parametro está vazio
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param valor
	 * @return boolean
	 */
	public static boolean isEmpty(String valor) {
		return (isNull(valor) || valor.trim().isEmpty());
	}

	/**
	 * Método responsável por validar se o o parametro não está vazio
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param valor
	 * @return boolean
	 */
	public static boolean isNotEmpty(String valor) {
		return !(isNull(valor) || valor.trim().isEmpty());
	}
}
