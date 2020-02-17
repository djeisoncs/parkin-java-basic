/**
 * 
 */
package com.dcs.parking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.dcs.parking.entidades.Lancamentos;
import com.dcs.parking.enumerador.NegocioExceptionEnum;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.services.ILancamentoService;
import com.dcs.parking.repository.LancamentoReporitory;

/**
 * Classe responsável por validar regras de negocio referentes aos lançamentos
 * 
 * @author Djeison 12 de fev de 2020
 */
@Service
public class LancamentosService extends ServiceEntityFull<Lancamentos> implements ILancamentoService {

	@Autowired
	private LancamentoReporitory reporitory;
	@Autowired
	private VeiculoService veiculoService;

	/**
	 * Método responsável por retornar a instancia de repositorio da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return reporitory
	 */
	@Override
	public JpaRepository<Lancamentos, Long> getRepository() {
		return reporitory;
	}

	/**
	 * Método responsável por retornar o nome da entidade
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @return nome
	 */
	@Override
	public String getNomeEntidade() {
		return "Lancamento";
	}

	/**
	 * Método responsável por listar lançamentos por patio
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorPatio(Long idPatio) {
		return reporitory.findByPatioIdOrderByDataCadastroAsc(idPatio);
	}

	/**
	 * Método responsável por listar lançamentos por patio e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @param status
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorPatio(Long idPatio, String status) {
		return reporitory.findByPatioIdAndStatusLikeOrderByDataCadastroAsc(idPatio, status);
	}

	/**
	 * Método responsável por listar lançamentos por veiculo
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idVeiculo
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorVeiculo(Long idVeiculo) {
		return reporitory.findByVeiculoIdOrderByDataCadastroAsc(idVeiculo);
	}

	/**
	 * Método responsável por listar lançamentos por veiculo e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idVeiculo
	 * @param status
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorVeiculo(Long idVeiculo, String status) {
		return reporitory.findByVeiculoIdAndStatusLikeOrderByDataCadastroAsc(idVeiculo, status);
	}

	/**
	 * Método responsável por listar lançamentos por cliente
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idCliente
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorCliente(Long idCliente) {
		return reporitory.findByVeiculoClienteIdOrderByDataCadastroAsc(idCliente);
	}

	/**
	 * Método responsável por listar lançamentos por cliente e status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idCliente
	 * @param status
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorCliente(Long idCliente, String status) {
		return reporitory.findByVeiculoClienteIdAndStatusLikeOrderByDataCadastroAsc(idCliente, status);
	}

	/**
	 * Método responsável por listar lançamentos por status
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param status
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> listarLancamentosPorStatus(String status) {
		return reporitory.findByStatusLikeOrderByDataCadastroAsc(status);
	}

	/**
	 * Método responsável por retornar os lançamentos que estão em aberto
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param idPatio
	 * @return lancamentos
	 */
	@Override
	public List<Lancamentos> getLancamentosPendentesEmAberto(Long idPatio) {
		return listarLancamentosPorPatio(idPatio, "A");
	}

	/**
	 * Método responsável por pesquisar lançamento por placa
	 * 
	 * @author Djeison 12 de fev de 2020
	 * @param placa
	 * @return lancamentos
	 * @throws NegocioException
	 */
	@Override
	public Lancamentos getLancamentosPendentePorPlaca(String placa) throws NegocioException {
		List<Lancamentos> lancamentos = new ArrayList<>();
		lancamentos = listarLancamentosPorVeiculo(veiculoService.getVeiculoPorPlaca(placa).getId(), "A");
		if (lancamentos.size() > 1)
			throw new NegocioException(NegocioExceptionEnum.MULTIPLOS_REGISTOS.getCodigo(),
					NegocioExceptionEnum.MULTIPLOS_REGISTOS.getMensagem(placa));
		else if (lancamentos.size() < 0)
			throw new NegocioException(NegocioExceptionEnum.DADOS_INEXISTENTE.getCodigo(),
					NegocioExceptionEnum.DADOS_INEXISTENTE.getMensagem("Para a placa " + placa));
		return lancamentos.get(0);
	}

	/**
	 * Método responsável por contar o numero de vagas usadas por patio
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idPatio
	 * @return numVagas
	 * @throws NegocioException
	 */
	@Override
	public int countVagasUsadasPorPario(Long idPatio) throws NegocioException {
		return reporitory.countByPatioIdAndStatus(idPatio, "A");
	}
}
