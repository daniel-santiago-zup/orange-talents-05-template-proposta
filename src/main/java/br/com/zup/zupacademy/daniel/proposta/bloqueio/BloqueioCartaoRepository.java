package br.com.zup.zupacademy.daniel.proposta.bloqueio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface BloqueioCartaoRepository extends CrudRepository<BloqueioCartao, Long> {

    @Query("SELECT bc FROM BloqueioCartao bc WHERE bc.idCartao = :pIdCartao AND (bc.statusBloqueio = 'BLOQUEIO_PENDENTE' OR bc.statusBloqueio = 'BLOQUEADO')")
    Set<BloqueioCartao> cartoesBloquados(@Param("pIdCartao") String idCartao);
}
