package br.com.transacao.model;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class TransacaoRequest {

	@NotBlank
	@NotNull
	private String id;
	@NotBlank
	@NotNull
	private String email;

	public TransacaoRequest() {
	}

	public TransacaoRequest(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
