/**
 * 
 */
package com.dcs.parking.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.parking.entidades.Auditoria;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.enumerador.InformativoEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.IControllerEtity;

/**
 * Classe responsável por conter metodos comuns a todas as classes da camada de
 * controle
 * 
 * @author Djeison 13 de fev de 2020
 */
@Controller
@RestController
@CrossOrigin(origins = "*")
public abstract class ControllerEntity<T extends Auditoria> implements IControllerEtity<T> {

	/**
	 * Método responsável por salvar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> salvar(T entidade) {
		try {
			return getService().getRespostaControle(getService().salvar(entidade));
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por salvar as entidades passadas por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> salvar(List<T> entidades) {
		try {
			return getService().getRespostaControle(getService().salvar(entidades));
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(Long id) {
		try {
			getService().excluir(id);
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(T entidade) {
		try {
			getService().excluir(entidade);
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir as entidades passadas por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(List<T> entidades) {
		try {
			getService().excluir(entidades);
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir todas as entidades cadastradas
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir() {
		try {
			getService().excluir();
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar todas as entidades
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> listarTodos() {
		try {
			return getService().getRespostaControle(getService().listarTodos());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por realizar a consulta da entidade por id
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> consultarPorId(Long id) {
		try {
			return getService().getRespostaControle(getService().consultarPorId(id));
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
