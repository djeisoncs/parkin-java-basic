/**
 * 
 */
package com.dcs.parking.enumerador;

/**
 * Classe responsável por conter codigos e descrições das exceções de negocio
 * 
 * @author Djeison 12 de fev de 2020
 */
public enum NegocioExceptionEnum {

	ARQUIVO_BD_INACESSIVEL(1), DADOS_CONEXAO_INEXISTENTE(2), ERRO_LER_ARQUIVO(3), DADOS_OBRIGATORIOS_NAO_PREENCHIDOS(4),
	EXISTE_CADASTRO(5), EXISTE_CADASTRO_EDICAO(6), DADOS_INEXISTENTE(7), MULTIPLOS_REGISTOS(8);

	private final int valor;

	/**
	 * Construtor responsável por receber o valor do enum que está sendo tratado
	 * 
	 * @author DEV 28 de mai de 2019
	 */
	NegocioExceptionEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	/**
	 * Método responsável por retornar a mensagem descritiva da excessão
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param msg
	 * @return mensagem
	 */
	public String getMensagem(String msg) {
		if (valor == ARQUIVO_BD_INACESSIVEL.getValor())
			return "Arquivo de configuração de banco de dados inacessível";
		else if (valor == DADOS_CONEXAO_INEXISTENTE.getValor())
			return "Dados de conexão inexistente";
		else if (valor == ERRO_LER_ARQUIVO.getValor())
			return "Erro ao ler arquivo " + msg;
		else if (valor == DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getValor())
			return "Por favor, preencha todos os campos obrigatórios os valores a seguir devem ser preenchidos " + msg;
		else if (valor == EXISTE_CADASTRO.getValor())
			return "Cadastro já realizado anteriormente";
		else if (valor == EXISTE_CADASTRO_EDICAO.getValor())
			return "Atenção: Operação não concluida. " + EXISTE_CADASTRO.getMensagem("");
		else if (valor == DADOS_INEXISTENTE.getValor())
			return msg + " inexistente";
		else if (valor == EXISTE_CADASTRO_EDICAO.getValor())
			return "Multiplos lançamentos encontrados para a placa " + msg
					+ " utilize a tela de pesquisa para selecionar o lançamento desejado";
		return "Falha na execução";
	}

	/**
	 * Método responsável por retornar o codigo da excessão
	 * 
	 * @author DEV 28 de mai de 2019
	 * @return codigo
	 */
	public String getCodigo() {
		if (valor == ARQUIVO_BD_INACESSIVEL.getValor())
			return "NG001";
		else if (valor == DADOS_CONEXAO_INEXISTENTE.getValor())
			return "NG002";
		else if (valor == ERRO_LER_ARQUIVO.getValor())
			return "NG003";
		else if (valor == DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getValor())
			return "NG004";
		else if (valor == EXISTE_CADASTRO.getValor())
			return "NG005";
		else if (valor == EXISTE_CADASTRO_EDICAO.getValor())
			return "NG006";
		else if (valor == DADOS_INEXISTENTE.getValor())
			return "NG007";
		else if (valor == MULTIPLOS_REGISTOS.getValor())
			return "NG008";
		return "NG0000";
	}
}
