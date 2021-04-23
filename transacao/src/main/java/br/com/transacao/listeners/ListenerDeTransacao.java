package br.com.transacao.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.transacao.model.Transacao;
import br.com.transacao.repository.CartaoRepository;
import br.com.transacao.repository.EstabelecimentoRepository;
import br.com.transacao.repository.TransacaoRepository;

@Component
public class ListenerDeTransacao {

	private EstabelecimentoRepository estabelecimentoRepository;
	private CartaoRepository cartaoRepository;
	private TransacaoRepository transacaoRepository;

	public ListenerDeTransacao(EstabelecimentoRepository estabelecimentoRepository, CartaoRepository cartaoRepository,
			TransacaoRepository transacaoRepository) {
		this.estabelecimentoRepository = estabelecimentoRepository;
		this.cartaoRepository = cartaoRepository;
		this.transacaoRepository = transacaoRepository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transacoes}")
	public void ouvir(Transacao transacao) {
		estabelecimentoRepository.save(transacao.getEstabelecimento());
		cartaoRepository.save(transacao.getCartao());
		transacaoRepository.save(transacao);
	}

}
