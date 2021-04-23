package br.com.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transacao.model.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

}
