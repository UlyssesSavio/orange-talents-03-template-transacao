package br.com.transacao.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.OneToOne;

import br.com.transacao.model.Cartao;
import br.com.transacao.model.Estabelecimento;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToOne
	private Cartao cartao;
	private LocalDateTime efetivadaEm;

	public TransacaoResponse() {
	}

	public TransacaoResponse(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
