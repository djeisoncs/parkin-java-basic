/**
 * 
 */
package com.dcs.parking.entidades;

import java.io.Serializable;

/**
 * Classe responsável por
 * 
 * @author Djeison 16 de fev de 2020
 */
public class DashBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3137046415949622574L;
	private int vagasTotal;
	private int vagasUsadas;
	private int vagasLivres;

	/**
	 * @return the vagasTotal
	 */
	public int getVagasTotal() {
		return vagasTotal;
	}

	/**
	 * @param vagasTotal the vagasTotal to set
	 */
	public void setVagasTotal(int vagasTotal) {
		this.vagasTotal = vagasTotal;
	}

	/**
	 * @return the vagasUsadas
	 */
	public int getVagasUsadas() {
		return vagasUsadas;
	}

	/**
	 * @param vagasUsadas the vagasUsadas to set
	 */
	public void setVagasUsadas(int vagasUsadas) {
		this.vagasUsadas = vagasUsadas;
	}

	/**
	 * @return the vagasLivres
	 */
	public int getVagasLivres() {
		return vagasLivres;
	}

	/**
	 * @param vagasLivres the vagasLivres to set
	 */
	public void setVagasLivres(int vagasLivres) {
		this.vagasLivres = vagasLivres;
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vagasLivres;
		result = prime * result + vagasTotal;
		result = prime * result + vagasUsadas;
		return result;
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DashBoard other = (DashBoard) obj;
		if (vagasLivres != other.vagasLivres)
			return false;
		if (vagasTotal != other.vagasTotal)
			return false;
		if (vagasUsadas != other.vagasUsadas)
			return false;
		return true;
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @return
	 */
	@Override
	public String toString() {
		return "DashBoard [vagasTotal=" + vagasTotal + ", vagasUsadas=" + vagasUsadas + ", vagasLivres=" + vagasLivres
				+ "]";
	}

}
