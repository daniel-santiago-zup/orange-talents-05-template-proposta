package br.com.zup.zupacademy.daniel.proposta.procedimentosAgendados;

import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoResponse;
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
    CartaoLegadoClient cartaoLegadoClient;

    @Scheduled(fixedDelay = 5000)
    private void associaCartao() {
        List<Proposta> propostasElegiveis = propostaRepository.encontraPropostasElegiveisSemCartao();
        propostasElegiveis.forEach(proposta -> {
            CartaoLegadoResponse cartaoLegadoResponse = cartaoLegadoClient.obtemCartaoGerado(proposta.getId());
            proposta.setCartao(cartaoLegadoResponse.converte());
            propostaRepository.save(proposta);
        });
    }
}
