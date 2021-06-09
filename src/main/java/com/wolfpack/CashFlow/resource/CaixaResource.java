package com.wolfpack.CashFlow.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.wolfpack.CashFlow.domain.Caixa;
import com.wolfpack.CashFlow.repository.CaixaRepository;


@RestController
@RequestMapping(value = "/caixa")
@CrossOrigin(origins = "http://localhost:3000")
public class CaixaResource {

	@Autowired
	private CaixaRepository caixaRepository;

	@GetMapping
	public List<Caixa> findAll() {
		return caixaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Caixa findById(@PathVariable Long id) {
		return caixaRepository.findById(id).orElse(null);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		caixaRepository.deleteById(id);
	}

	@PostMapping
	public Caixa cadastrar(@RequestBody Caixa caixa) {
		return caixaRepository.save(caixa);
	}
	
}
