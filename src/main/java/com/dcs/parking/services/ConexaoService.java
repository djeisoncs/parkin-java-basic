/**
 * 
 */
package com.dcs.parking.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.Conexao;
import com.dcs.parking.entidades.ConexaoBanco;
import com.dcs.parking.enumerador.NegocioExceptionEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.IConexaoBancoService;
import com.dcs.parking.util.Constantes;
import com.dcs.parking.util.JsonDadosUtil;
import com.dcs.parking.util.UtilObject;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Classe responsável por fazer as manipulações necessárias para realizar a
 * conexão com o banco de dados
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public class ConexaoService implements IConexaoBancoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653642318008225611L;

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param dataBase
	 * @return url
	 */
	@Override
	public String montarUrl(String url, String servidor, String dataBase) {
		if ((UtilObject.isNotEmpty(url)) && (UtilObject.isNotEmpty(servidor)) && (UtilObject.isNotEmpty(dataBase)))
			return url + servidor + dataBase;
		return "";
	}

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param porta
	 * @param dataBase
	 * @return url
	 */
	@Override
	public String montarUrl(String url, String servidor, int porta, String dataBase) {
		if ((UtilObject.isNotEmpty(url)) && (UtilObject.isNotEmpty(servidor)) && (UtilObject.isNotEmpty(dataBase))
				&& (porta > 0))
			return url + servidor + String.valueOf(porta) + dataBase;
		return "";
	}

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param dataBase
	 * @param urlFinal
	 * @return url
	 */
	@Override
	public String montarUrl(String url, String servidor, String dataBase, String urlFinal) {
		if (UtilObject.isNotEmpty(urlFinal))
			return montarUrl(urlFinal, servidor, dataBase) + urlFinal;
		return null;
	}

	/**
	 * Método responsável por montar a url de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param url
	 * @param servidor
	 * @param porta
	 * @param dataBase
	 * @param urlFinal
	 * @return url
	 */
	@Override
	public String montarUrl(String url, String servidor, int porta, String dataBase, String urlFinal) {
		if ((UtilObject.isNotEmpty(urlFinal)) && (porta > 0))
			return montarUrl(urlFinal, servidor, porta, dataBase) + urlFinal;
		return null;
	}

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
	@Override
	public ConexaoBanco montarObjeto(String caminho, String nome, String tipo)
			throws JsonSyntaxException, FileNotFoundException {
		Conexao conexao = new Conexao();
		ConexaoBanco conexaoBanco = new ConexaoBanco();
		Gson gson = new Gson();
		conexao = gson.fromJson(JsonDadosUtil.lerArquivoJson(caminho, nome), Conexao.class);
		if (tipo.equalsIgnoreCase("D"))
			conexaoBanco = getConexao(conexao, tipo, conexao.getBaseParaDados());
		else if (tipo.equalsIgnoreCase("I"))
			conexaoBanco = getConexao(conexao, tipo, conexao.getBaseParaImagem());
		if (conexao.getBaseParaDados().equalsIgnoreCase("sqlServer"))
			conexaoBanco.setUrl(montarUrl(conexaoBanco.getUrl() + "//", conexaoBanco.getServidor() + ";",
					"databaseName=" + conexaoBanco.getDataBase() + ";", conexaoBanco.getUrlFinal()));
		else if ((conexao.getBaseParaDados().equalsIgnoreCase("postgre"))
				|| (conexao.getBaseParaDados().equalsIgnoreCase("mySql")))
			conexaoBanco.setUrl(montarUrl(conexaoBanco.getUrl() + "//", conexaoBanco.getServidor() + ":",
					Integer.parseInt(conexaoBanco.getPorta()), "/" + conexaoBanco.getDataBase()));
		return conexaoBanco;
	}

	/**
	 * Método responsável por salvar conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean salvar(Conexao conexao) throws NegocioException {
		Gson gson = new Gson();
		String json = "";
		json = gson.toJson(conexao);
		try {
			if (JsonDadosUtil.gravarArquivoJson(json, Constantes.CAMINHO_PASTA_RAIZ, Constantes.ARQUIVO_CONF_BANCO))
				return true;
		} catch (IOException e) {
			throw new NegocioException(NegocioExceptionEnum.ARQUIVO_BD_INACESSIVEL.getCodigo(),
					NegocioExceptionEnum.ARQUIVO_BD_INACESSIVEL.getMensagem(""));
		}
		return false;
	}

	/**
	 * Método responsável por salvar conexões
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexoes
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean salvar(List<ConexaoBanco> conexoes) throws NegocioException {
		Conexao conexao = new Conexao();
		conexao = getConexao(Constantes.CAMINHO_PASTA_RAIZ, Constantes.ARQUIVO_CONF_BANCO);
		conexao.setConexoes(conexoes);
		return salvar(conexao);
	}

	/**
	 * Método responsável por editar a conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean editar(ConexaoBanco conexao) throws NegocioException {
		Conexao conexaoPai = new Conexao();
		conexaoPai = getConexao(Constantes.CAMINHO_PASTA_RAIZ, Constantes.ARQUIVO_CONF_BANCO);
		for (ConexaoBanco conexaoBanco : conexaoPai.getConexoes()) {
			if (conexaoBanco.getIdConexao().equalsIgnoreCase(conexao.getIdConexao())) {
				conexaoBanco = conexao;
				break;
			}
		}
		return salvar(conexaoPai);
	}

	/**
	 * Método responsável por editar a conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param conexao
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean editar(Conexao conexao) throws NegocioException {
		return salvar(conexao);
	}

	/**
	 * Método responsável por retornar as conexões existentes no arquivo de conexão
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @return conexoes
	 * @throws NegocioException
	 */
	@Override
	public List<ConexaoBanco> getConexoes(String caminho, String nome) throws NegocioException {
		Conexao conexao = new Conexao();
		conexao = getConexao(caminho, nome);
		return conexao.getConexoes();
	}

	/**
	 * Método responsável por
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @param idConexao
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public ConexaoBanco getConexao(String caminho, String nome, String idConexao) throws NegocioException {
		Conexao conexao = new Conexao();
		conexao = getConexao(caminho, nome);
		for (ConexaoBanco conexaoBanco : conexao.getConexoes())
			if (conexaoBanco.getIdConexao().equalsIgnoreCase(idConexao))
				return conexaoBanco;
		throw new NegocioException(NegocioExceptionEnum.DADOS_CONEXAO_INEXISTENTE.getCodigo(),
				NegocioExceptionEnum.DADOS_CONEXAO_INEXISTENTE.getMensagem(""));
	}

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
	@Override
	public ConexaoBanco getConexao(Conexao conexao, String tipo, String idConexao) {
		for (ConexaoBanco conexaoBanco : conexao.getConexoes())
			if ((conexaoBanco.getIdConexao().indexOf(idConexao) >= 0)
					&& (tipo.equalsIgnoreCase(conexaoBanco.getTipo())))
				return conexaoBanco;
		return null;
	}

	/**
	 * Método responsável por retornar o objeto concentrador de conexões
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param caminho
	 * @param nome
	 * @return conexao
	 * @throws NegocioException
	 */
	@Override
	public Conexao getConexao(String caminho, String nome) throws NegocioException {
		try {
			return new Gson().fromJson(JsonDadosUtil.lerArquivoJson(caminho, nome), Conexao.class);
		} catch (JsonSyntaxException e) {
			throw new NegocioException(NegocioExceptionEnum.ERRO_LER_ARQUIVO.getCodigo(),
					NegocioExceptionEnum.ERRO_LER_ARQUIVO.getMensagem("de configuração"));
		} catch (FileNotFoundException e) {
			throw new NegocioException(NegocioExceptionEnum.ARQUIVO_BD_INACESSIVEL.getCodigo(),
					NegocioExceptionEnum.ARQUIVO_BD_INACESSIVEL.getMensagem(""));
		}
	}
	
	public void gravarArquivoTeste(String caminho, String nome) {
		try {
			ConexaoBanco conexaoBanco = new ConexaoBanco();
			conexaoBanco.setIdConexao("10");
			conexaoBanco.setSenha("Teste");
			JsonDadosUtil.gravarArquivoJson(conexaoBanco.toString(), caminho, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
