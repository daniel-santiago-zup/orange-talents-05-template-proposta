package br.com.zup.zupacademy.daniel.proposta.procedimentosAgendados;

import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.CartaoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.CartaoResponse;
import br.com.zup.zupacademy.daniel.proposta.proposta.Proposta;
import br.com.zup.zupacademy.daniel.proposta.proposta.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssociaCartao {

    @Autowired
    PropostaRepository propostaRepository;
    @Autowired
    CartaoClient cartaoClient;

    @Scheduled(fixedDelay = 5000)
    private void associaCartao() {
        List<Proposta> propostasElegiveis = propostaRepository.encontraPropostasElegiveisSemCartao();
        propostasElegiveis.forEach(proposta -> {
                CartaoResponse cartaoResponse = cartaoClient.obtemCartaoGerado(proposta.getId());
            proposta.setIdCartao(cartaoResponse.getId());
            propostaRepository.save(proposta);
        });
    }
}
