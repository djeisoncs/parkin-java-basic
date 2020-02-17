/**
 * 
 */
package com.dcs.parking.interfaces.services;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import com.dcs.parking.entidades.Conexao;
import com.dcs.parking.entidades.ConexaoBanco;
import com.dcs.parking.excessao.NegocioException;
import com.google.gson.JsonSyntaxException;

/**
 * Classe responsável por fazer as manipulações necessárias para realizar a
 * conexão com o banco de dados
 * 
 * @author Djeison 12 de fev de 2020
 */
public interface IConexaoBancoService extends Serializable {

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param dataBase
	 * @return
	 */
	public abstract String montarUrl(String url, String servidor, String dataBase);

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param porta
	 * @param dataBase
	 * @return
	 */
	public abstract String montarUrl(String url, String servidor, int porta, String dataBase);

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param dataBase
	 * @param urlFinal
	 * @return
	 */
	public abstract String montarUrl(String url, String servidor, String dataBase, String urlFinal);

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param porta
	 * @param dataBase
	 * @param urlFinal
	 * @return
	 */
	public abstract String montarUrl(String url, String servidor, int porta, String dataBase, String urlFinal);

	/**
	 * Método responsável por montar os dados do objeto de de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @param tipo
	 * @return conexao
	 * @throws JsonSyntaxException
	 * @throws FileNotFoundException
	 */
	public abstract ConexaoBanco montarObjeto(String caminho, String nome, String tipo)
			throws JsonSyntaxException, FileNotFoundException;

	/**
	 * Método responsável por salvar conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean salvar(Conexao conexao) throws NegocioException;

	/**
	 * Método responsável por salvar conexões no arquivo de configuração
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexoes
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean salvar(List<ConexaoBanco> conexoes) throws NegocioException;

	/**
	 * Método responsável por editar a conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean editar(ConexaoBanco conexao) throws NegocioException;

	/**
	 * Método responsável por editar a conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean editar(Conexao conexao) throws NegocioException;

	/**
	 * Método responsável por retornar as conexões existentes no arquivo de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @return conexoes
	 * @throws NegocioException
	 */
	public abstract List<ConexaoBanco> getConexoes(String caminho, String nome) throws NegocioException;

	/**
	 * Método responsável por retornar a conexão do banco de acordo com id da
	 * conexão passado por parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @param idConexao
	 * @return conexao
	 * @throws NegocioException
	 */
	public abstract ConexaoBanco getConexao(String caminho, String nome, String idConexao) throws NegocioException;

	/**
	 * Método responsável por retornar a conexão do banco de acordo com id da
	 * conexão passado por parametro
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @param tipo
	 * @param idConexao
	 * @return conexao
	 */
	public abstract ConexaoBanco getConexao(Conexao conexao, String tipo, String idConexao);

	/**
	 * Método responsável por retornar o objeto concentrador de conexões
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @return conexao
	 * @throws NegocioException
	 */
	public abstract Conexao getConexao(String caminho, String nome) throws NegocioException;
}
