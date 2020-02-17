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

import com.dcs.parking.entidades.Patio;
import com.dcs.parking.entidades.RespostaControle;
import com.dcs.parking.excessao.NegocioException;
import com.dcs.parking.interfaces.controllers.IPatioController;
import com.dcs.parking.services.PatioService;
import com.dcs.parking.services.ServiceEntityFull;

/**
 * Classe responsável por realizar todas as operações de comunicação da entidade
 * patio
 * 
 * @author Djeison 13 de fev de 2020
 */
@Controller
@RestController
@RequestMapping("/api/patios")
@CrossOrigin(origins = "*")
public class PatioController extends ControllerEntityFull<Patio> implements IPatioController {

	@Autowired
	private PatioService service;

	/**
	 * Método responsável por retornar a instancia service da entidade manipulada
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @return service
	 */
	@Override
	public ServiceEntityFull<Patio> getService() {
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
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody Patio entidade) {
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
	public ResponseEntity<Map<String, Object>> salvar(@RequestBody List<Patio> entidades) {
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
	public ResponseEntity<RespostaControle> editar(@RequestBody Patio entidade) {
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
	public ResponseEntity<RespostaControle> editar(@RequestBody List<Patio> entidades) {
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
	 * Método responsável por pesquisar patios por descricao
	 * 
	 * @author Djeison 13 de fev de 2020
	 * @param descricao
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@GetMapping(value = "/descricao/{descricao}")
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarPorDescricao(@PathVariable String descricao) {
		try {
			return service.getRespostaControle(service.pesquisarPorDescricao(descricao));
		} catch (NegocioException e) {
			return service.getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
