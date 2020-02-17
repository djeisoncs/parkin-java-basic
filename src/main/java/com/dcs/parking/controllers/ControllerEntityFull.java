/**
 * 
 */
package com.dcs.parking.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.parking.entidades.AuditoriaEdicao;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.enumerador.InformativoEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.IControllerEtityFull;

/**
 * Classe responsável por conter metodos comuns a todas as classes da camada de
 * controle
 * 
 * @author Djeison 13 de fev de 2020
 */
@Controller
@RestController
@CrossOrigin(origins = "*")
public abstract class ControllerEntityFull<T extends AuditoriaEdicao> extends ControllerEntity<T> implements IControllerEtityFull<T> {

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> editar(T entidade) {
		try {
			getService().editar(entidade);
			return getService().getRespostaControle(true, InformativoEnum.EDITADO_SUCESSO.getCodigo(),
					InformativoEnum.EDITADO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return
	 */
	@Override
	public ResponseEntity<RespostaControle> editar(List<T> entidades) {
		try {
			getService().editar(entidades);
			return getService().getRespostaControle(true, InformativoEnum.EDITADO_SUCESSO.getCodigo(),
					InformativoEnum.EDITADO_SUCESSO.getMensagem(""));
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}
}
