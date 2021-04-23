package br.com.transacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transacao.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	List<Transacao> findFirst10ById(String id);

	List<Transacao> findFirst10ByCartaoId(String id);

}
