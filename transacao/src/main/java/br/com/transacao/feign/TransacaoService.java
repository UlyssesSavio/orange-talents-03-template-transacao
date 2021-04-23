package br.com.transacao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.transacao.model.TransacaoRequest;

@FeignClient(name = "transacao", url = "http://localhost:7777/")
public interface TransacaoService {

	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes", consumes = "application/json")
	TransacaoRequest criaTransacao(TransacaoRequest transacao);

}
