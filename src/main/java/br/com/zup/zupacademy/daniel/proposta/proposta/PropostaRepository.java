package br.com.zup.zupacademy.daniel.proposta.proposta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropostaRepository extends CrudRepository<Proposta, Long> {
    @Query("select p from Proposta p where p.statusAnalise = 'ELEGIVEL' and p.idCartao = null")
    List<Proposta> encontraPropostasElegiveisSemCartao();
}
