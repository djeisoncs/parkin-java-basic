/**
 * 
 */
package com.dcs.parking.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.AuditoriaEdicao;
import com.dcs.parking.enumerador.NegocioExceptionEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.IServiceEntityFull;
import com.dcs.parking.util.UtilObject;
import com.dcs.parking.util.ValidacoesUtil;

/**
 * Classe responsável por
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public abstract class ServiceEntityFull<T extends AuditoriaEdicao> extends ServiceEntity<T>
		implements IServiceEntityFull<T> {

	/**
	 * Método responsável por editar e validar as regras de edição da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public T editar(T entidade) throws NegocioException {
		entidade = montarDadosEdicao(entidade);
		if (dadosObrigatoriosEdicaoPreenchidos(entidade))
			if (naoExisteDuplicidadeCadastro(entidade))
				return getRepository().save(entidade);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getMensagem(""));
	}

	/**
	 * Método responsável por editar e validar as regras de edição da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	@Override
	public List<T> editar(List<T> entidades) throws NegocioException {
		entidades = montarDadosEdicao(entidades);
		if (dadosObrigatoriosEdicaoPreenchidos(entidades))
			if (naoExisteDuplicidadeCadastro(entidades))
				return getRepository().saveAll(entidades);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getMensagem(""));

	}

	/**
	 * Método responsável por validar se os dados obrigatorios de auditoria estão
	 * preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean dadosObrigatoriosEdicaoPreenchidos(T entidade) throws NegocioException {
		String campos = "";
		if (UtilObject.isNull(entidade.getId()))
			super.dadosObrigatoriosPreenchidos(entidade);
		else
			if (UtilObject.isNull(entidade.getDataEdicao()))
				campos = ValidacoesUtil.concatenaStringParaMensagens(campos, "data de edição");
		if (UtilObject.isNotEmpty(campos))
			throw new NegocioException(NegocioExceptionEnum.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getCodigo(),
					NegocioExceptionEnum.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getMensagem(campos));
		return true;
	}

	/**
	 * Método responsável por validar se os dados obrigatorios de auditoria estão
	 * preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean dadosObrigatoriosEdicaoPreenchidos(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			dadosObrigatoriosEdicaoPreenchidos(entidade);
		return true;
	}

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteDuplicidadeCadastro(T entidade) throws NegocioException {
		return true;
	}

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteDuplicidadeCadastro(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			naoExisteDuplicidadeCadastro(entidade);
		return true;
	}

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidadeBanco
	 * @param entidade
	 * @param nomeEntidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteDuplicidadeCadastro(T entidadeBanco, T entidade, String nomeEntidade)
			throws NegocioException {
		if (UtilObject.isNull(entidadeBanco))
			return true;
		if (entidadeBanco.getId().equals(entidade.getId()))
			return true;
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getMensagem("entidade"));
	}

	/**
	 * Método responsável por montar os dados da entidade passada por parametro que
	 * será editada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public T montarDadosEdicao(T entidade) throws NegocioException {
		entidade.setDataEdicao(new Date(System.currentTimeMillis()).getTime());
		return entidade;
	}

	/**
	 * Método responsável por montar os dados da entidade passada por parametro que
	 * será editada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	@Override
	public List<T> montarDadosEdicao(List<T> entidades) throws NegocioException {		
		for (T entidade : entidades) {
			if (UtilObject.isNotNull(entidade.getId()))
				montarDadosEdicao(entidade);
			else 
				montarDados(entidade);
		}
		return entidades;
	}
}
