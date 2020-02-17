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

import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.entidades.Veiculo;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.IVeiculoController;
import com.dcs.parking.services.ServiceEntityFull;
import com.dcs.parking.services.VeiculoService;

/**
 * Classe responsável por realizar todas as operações de comunicação da entidade
 * veiculo
 * 
 * @author Djeison 13 de fev de 2020
 */
@Controller
@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController extends ControllerEntityFull<Veiculo> implements IVeiculoController {

	@Autowired
	private VeiculoService service;

	/**
	 * Método responsável por retornar a instancia service da entidade manipulada
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return service
	 */
	@Override
	public ServiceEntityFull<Veiculo> getService() {
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
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody Veiculo entidade) {
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
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody List<Veiculo> entidades) {
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
	public ResponseEntity<RespostaControle> editar(@RequestBody Veiculo entidade) {
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
	public ResponseEntity<RespostaControle> editar(@RequestBody List<Veiculo> entidades) {
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
	 * Método responsável por pesquisar veiculo por placa
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param placa
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/placa/{placa}")
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarVeiculosPorPlaca(@PathVariable String placa) {
		try {
			return service.getRespostaControle(service.pesquisarVeiculosPorPlaca(placa));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por retornar veiculo correspondente a placa passada por
	 * paramentro
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param placa
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/get-placa/{placa}")
	@Override
	public ResponseEntity<Map<String, Object>> getVeiculoPorPlaca(@PathVariable String placa) {
		try {
			return service.getRespostaControle(service.getVeiculoPorPlaca(placa));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por pesquisar veiculos por modelo
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param modelo
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/modelo/{modelo}")
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarVeiculosPorModelo(@PathVariable String modelo) {
		try {
			return service.getRespostaControle(service.pesquisarVeiculosPorModelo(modelo));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por pesquisar veiculos por cor
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param cor
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/cor/{cor}")
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarVeiculosPorCor(@PathVariable String cor) {
		try {
			return service.getRespostaControle(service.pesquisarVeiculosPorCor(cor));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar veiculos por cliente
	 * 
	 * @author Djeison 16 de fev de 2020
	 * @param idCliente
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/cliente/{idCliente}")
	@Override
	public ResponseEntity<Map<String, Object>> listarVeiculosPorCliente(@PathVariable Long idCliente) {
		try {
			return service.getRespostaControle(service.listarVeiculosPorCliente(idCliente));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
