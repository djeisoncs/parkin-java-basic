/**
 * 
 */
package com.dcs.parking.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.parking.entidades.Lancamentos;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.ILancamentoController;
import com.dcs.parking.services.LancamentosService;
import com.dcs.parking.services.ServiceEntityFull;

/**
 * Classe responsável por realizar todas as operações de comunicação da entidade
 * lancamentos
 * 
 * @author Djeison 13 de fev de 2020
 */
@Controller
@RestController
@RequestMapping("/api/lancamentos")
@CrossOrigin(origins = "*")
public class LancamentoController extends ControllerEntityFull<Lancamentos> implements ILancamentoController {

	@Autowired
	private LancamentosService service;

	/**
	 * Método responsável por retornar a instancia service da entidade manipulada
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return service
	 */
	@Override
	public ServiceEntityFull<Lancamentos> getService() {
		return service;
	}

	/**
	 * Método responsável por salvar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@PostMapping
	@Override
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody Lancamentos entidade) {
		return super.salvar(entidade);
	}

	/**
	 * Método responsável por salvar as entidades passadas por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@PostMapping(value = "/list")
	@Override
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody List<Lancamentos> entidades) {
		return salvar(entidades);
	}

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidade
	 * @return ResponseEntity<RespostaControle>
	 */
	@PutMapping
	@Override
	public ResponseEntity<RespostaControle> editar(@RequestBody Lancamentos entidade) {
		return super.editar(entidade);
	}

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param entidades
	 * @return
	 */
	@PutMapping(value = "/list")
	@Override
	public ResponseEntity<RespostaControle> editar(@RequestBody List<Lancamentos> entidades) {
		return super.editar(entidades);
	}

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<RespostaControle>
	 */
	@DeleteMapping(value = "/{id}")
	@Override
	public ResponseEntity<RespostaControle> excluir(@PathVariable Long id) {
		return super.excluir(id);
	}

	/**
	 * Método responsável por excluir todas as entidades cadastradas
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<RespostaControle>
	 */
	@DeleteMapping
	@Override
	public ResponseEntity<RespostaControle> excluir() {
		return super.excluir();
	}

	/**
	 * Método responsável por listar todas as entidades
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping
	@Override
	public ResponseEntity<Map<String, Object>> listarTodos() {
		return super.listarTodos();
	}

	/**
	 * Método responsável por realizar a consulta da entidade por id
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/id/{id}")
	@Override
	public ResponseEntity<Map<String, Object>> consultarPorId(@PathVariable Long id) {
		return super.consultarPorId(id);
	}

	/**
	 * Método responsável por listar lançamentos por patio
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/patio/{idPatio}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorPatio(@PathVariable Long idPatio) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorPatio(idPatio));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar lançamentos por patio e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/patio/{idPatio}/{status}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorPatio(@PathVariable Long idPatio,
			@PathVariable String status) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorPatio(idPatio, status));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar lançamentos por veiculo
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idVeiculo
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/veiculo/{idVeiculo}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorVeiculo(@PathVariable Long idVeiculo) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorVeiculo(idVeiculo));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar lançamentos por veiculo e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idVeiculo
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/veiculo/{idVeiculo}/{status}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorVeiculo(@PathVariable Long idVeiculo,
			@PathVariable String status) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorVeiculo(idVeiculo, status));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar lançamentos por cliente
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idCliente
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/cliente/{idCliente}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorCliente(@PathVariable Long idCliente) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorCliente(idCliente));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar lançamentos por cliente e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idCliente
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/cliente/{idCliente}/{status}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorCliente(@PathVariable Long idCliente,
			@PathVariable String status) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorCliente(idCliente, status));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar lançamentos por cliente e status
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/status/{status}")
	@Override
	public ResponseEntity<Map<String, Object>> listarLancamentosPorStatus(@PathVariable String status) {
		try {
			return service.getRespostaControle(service.listarLancamentosPorStatus(status));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por retornar os lançamentos que estão em aberto por patio
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param idPatio
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/pendentes-patio/{idPatio}")
	@Override
	public ResponseEntity<Map<String, Object>> getLancamentosPendentesEmAberto(@PathVariable Long idPatio) {
		try {
			return service.getRespostaControle(service.getLancamentosPendentesEmAberto(idPatio));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por retornar os lançamentos que estão em aberto por placa
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param placa
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/pendentes-placa/{placa}")
	@Override
	public ResponseEntity<Map<String, Object>> getLancamentosPendentePorPlaca(@PathVariable String placa) {
		try {
			return service.getRespostaControle(service.getLancamentosPendentePorPlaca(placa));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
