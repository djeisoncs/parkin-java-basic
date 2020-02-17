/**
 * 
 */
package com.dcs.parking.excessao;

/**
 * Classe responsável por encapsular as exções da camada de negócio
 * 
 * @author Djeison 12 de fev de 2020
 */
public class NegocioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4704001022231770985L;
	private String codigoException;

	/**
	 * Construtor responsável por
	 * 
	 * @author Djeison 12 de fev de 2020
	 */
	public NegocioException(String codigoException, String message) {
		super(message);
		this.codigoException = codigoException;
	}

	/**
	 * @return the codigoException
	 */
	public String getCodigoException() {
		return codigoException;
	}

	/**
	 * @param codigoException the codigoException to set
	 */
	public void setCodigoException(String codigoException) {
		this.codigoException = codigoException;
	}

}
