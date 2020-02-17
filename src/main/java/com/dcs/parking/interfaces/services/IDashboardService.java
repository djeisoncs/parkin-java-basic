/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.io.Serializable;

import com.dcs.parking.entidades.DashBoard;
import com.dcs.parking.excessao.NegocioException;

/**
 * Classe responsável por 
 * @author Djeison
 * 16 de fev de 2020
 */
public interface IDashboardService  extends Serializable {

	public abstract DashBoard getDashboardByPatio(Long idPatio) throws NegocioException;
}
