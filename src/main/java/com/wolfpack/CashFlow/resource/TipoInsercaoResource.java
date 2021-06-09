package com.wolfpack.CashFlow.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolfpack.CashFlow.domain.TipoInsercao;
import com.wolfpack.CashFlow.repository.TipoInsercaoRepository;

@RestController
@RequestMapping(value = "/tipo-insercoes")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoInsercaoResource {

	@Autowired
	private TipoInsercaoRepository insercaoRepository;

	@GetMapping
	public List<TipoInsercao> findAll() {
		return insercaoRepository.findAll();
	}

	@GetMapping("/{id}")
	public TipoInsercao findById(@PathVariable Long id) {
		return insercaoRepository.findById(id).orElse(null);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		insercaoRepository.deleteById(id);
	}

	@PostMapping
	public TipoInsercao cadastrar(@RequestBody TipoInsercao insercao) {
		return insercaoRepository.save(insercao);
	}
}

