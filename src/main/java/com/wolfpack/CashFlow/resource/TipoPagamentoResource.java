package com.wolfpack.CashFlow.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolfpack.CashFlow.domain.TipoPagamento;
import com.wolfpack.CashFlow.repository.TipoPagamentoRepository;

@RestController
@RequestMapping(value = "/tipo-pagamentos")
public class TipoPagamentoResource {

	@Autowired
	private TipoPagamentoRepository pagamentoRepository;

	@GetMapping
	public List<TipoPagamento> findAll() {
		return pagamentoRepository.findAll();
	}

	@GetMapping("/{id}")
	public TipoPagamento findById(@PathVariable Long id) {
		return pagamentoRepository.findById(id).orElse(null);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		pagamentoRepository.deleteById(id);
	}

	@PostMapping
	public TipoPagamento cadastrar(@RequestBody TipoPagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}
}

