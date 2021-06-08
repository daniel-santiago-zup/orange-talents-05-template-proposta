package br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "analise-solicitacao", url = "${analise_solicitacao_url}")
public interface AnaliseFinanceiraClient {

    @PostMapping
        AnaliseFinanceiraResponse obtemResultadoSolicitacao(AnaliseFinanceiraRequest analiseFinanceiraRequest);
}
