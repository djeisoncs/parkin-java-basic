/**
 * 
 */
package com.dcs.parking.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.Auditoria;
import com.dcs.parking.enumerador.NegocioExceptionEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.IServiceEntity;
import com.dcs.parking.util.UtilObject;
import com.dcs.parking.util.ValidacoesUtil;

/**
 * Classe responsável por
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public abstract class ServiceEntity<T extends Auditoria> extends Services<T> implements IServiceEntity<T> {

	/**
	 * Método responsável por salvar e validar as regras de gravação da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public T salvar(T entidade) throws NegocioException {
		entidade = montarDados(entidade);
		if (naoExisteCadastro(entidade))
			return getRepository().save(entidade);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO.getMensagem(""));
	}

	/**
	 * Método responsável por salvar e validar as regras de gravação da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	@Override
	public List<T> salvar(List<T> entidades) throws NegocioException {
		entidades = montarDados(entidades);
		if (naoExisteCadastro(entidades))
			return getRepository().saveAll(entidades);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO.getMensagem(""));
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param id
	 * @throws NegocioException
	 */
	@Override
	public void excluir(Long id) throws NegocioException {
		getRepository().deleteById(id);

	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @throws NegocioException
	 */
	@Override
	public void excluir(T entidade) throws NegocioException {
		getRepository().delete(entidade);
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @throws NegocioException
	 */
	@Override
	public void excluir(List<T> entidades) throws NegocioException {
		getRepository().deleteAll(entidades);
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @throws NegocioException
	 */
	@Override
	public void excluir() throws NegocioException {
		getRepository().deleteAll();
	}

	/**
	 * Método responsável por listar todos os registros da entidade de manipulação
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return entidades
	 */
	@Override
	public List<T> listarTodos() {
		return getRepository().findAll();
	}

	/**
	 * Método responsável por consultar a entidade por id
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param id
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public Optional<T> consultarPorId(Long id) throws NegocioException {
		return getRepository().findById(id);
	}

	/**
	 * Método responsável por validar se os dados obrigatorios para salvar a
	 * entidade estão preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean dadosObrigatoriosPreenchidos(T entidade) throws NegocioException {
		String campos = "";
		if (UtilObject.isNull(entidade.getDataCadastro()))
			campos = ValidacoesUtil.concatenaStringParaMensagens(campos, "data de cadastro");
		if (UtilObject.isNotEmpty(campos))
			throw new NegocioException(NegocioExceptionEnum.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getCodigo(),
					NegocioExceptionEnum.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getMensagem(campos));
		return true;
	}

	/**
	 * Método responsável por validar se os dados obrigatorios para salvar a
	 * entidade estão preenchidos
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean dadosObrigatoriosPreenchidos(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			dadosObrigatoriosPreenchidos(entidade);
		return true;
	}

	/**
	 * Método responsável por montar os dados para salvar a entidade passada por
	 * parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public T montarDados(T entidade) throws NegocioException {
		entidade.setDataCadastro(new Date(System.currentTimeMillis()).getTime());
		return entidade;
	}

	/**
	 * Método responsável por montar os dados para salvar a entidade passada por
	 * parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	@Override
	public List<T> montarDados(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			entidade = montarDados(entidade);
		return entidades;
	}

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteCadastro(T entidade) throws NegocioException {
		return true;
	}

	/**
	 * Método responsável por validar se as entidades que estão prestes a serem
	 * salvas já não estão cadastradas
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteCadastro(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			naoExisteCadastro(entidade);
		return true;
	}
}
