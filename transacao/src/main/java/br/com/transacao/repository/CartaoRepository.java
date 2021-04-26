package br.com.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transacao.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

}
