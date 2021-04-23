package br.com.transacao.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transacao.feign.TransacaoService;
import br.com.transacao.model.TransacaoRequest;
import br.com.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	private TransacaoService transacaoService;
	private TransacaoRepository transacaoRepository;

	public TransacaoController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
		this.transacaoService = transacaoService;
		this.transacaoRepository = transacaoRepository;
	}

	@PostMapping
	public ResponseEntity<?> cadastra(@RequestBody @Valid TransacaoRequest transacaoRequest) {

		transacaoService.criaTransacao(transacaoRequest);
		System.out.println("Cadastrando" + transacaoRequest.getId());
		return ResponseEntity.ok(transacaoRequest);
	}

}
