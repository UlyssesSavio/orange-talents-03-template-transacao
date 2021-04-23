package br.com.transacao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.transacao.feign.TransacaoService;
import br.com.transacao.model.Transacao;
import br.com.transacao.model.TransacaoRequest;
import br.com.transacao.repository.TransacaoRepository;
import br.com.transacao.validacao.ApiErroException;

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
		return ResponseEntity.ok(transacaoRequest);
	}

	@GetMapping
	public ResponseEntity<List<Transacao>> buscaUltimas10Transacao(@RequestParam String id) {
		List<Transacao> transacao = new ArrayList<>();
		transacao = transacaoRepository.findFirst10ByCartaoId(id);
		if (transacao.isEmpty() || transacao == null)
			throw new ApiErroException(HttpStatus.NOT_FOUND, "Nenhuma transacao encontrada");
		return ResponseEntity.ok(transacao);
	}

}
