/**
 * 
 */
package com.dcs.parking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.DashBoard;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.IDashboardService;

/**
 * Classe responsável por
 * 
 * @author Djeison 16 de fev de 2020
 */
@Service
public class DashboardService extends Services<DashBoard> implements IDashboardService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4948251792455647142L;

	@Autowired
	private PatioService patioService;
	@Autowired
	private LancamentosService lancamentosService;

	/**
	 * Método responsável por retornar o nome da entidade 
	 * @author Djeison
	 * 16 de fev de 2020
	 * @return
	 */
	@Override
	public String getNomeEntidade() {
		return "Dashboard";
	}
	
	/**
	 * Método responsável por retornar o dashBoard de vagas por patio
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idPatio
	 * @return dashBoard
	 * @throws NegocioException
	 */
	@Override
	public DashBoard getDashboardByPatio(Long idPatio) throws NegocioException {
		DashBoard dashBoard = new DashBoard();
		dashBoard.setVagasTotal(patioService.consultarPorId(idPatio).get().getNumVagas());
		dashBoard.setVagasUsadas(lancamentosService.countVagasUsadasPorPario(idPatio));
		dashBoard.setVagasLivres(dashBoard.getVagasTotal() - dashBoard.getVagasUsadas());
		return dashBoard;
	}


}
