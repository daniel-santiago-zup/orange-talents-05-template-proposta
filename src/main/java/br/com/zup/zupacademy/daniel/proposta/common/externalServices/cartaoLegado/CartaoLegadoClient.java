package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cartao", url = "${cartao_url}")
public interface CartaoLegadoClient {

    @GetMapping
    CartaoLegadoResponse obtemCartaoGerado(@RequestParam Long idProposta);

    @GetMapping("/{idCartao}")
    CartaoLegadoResponse obtemCartaoPorId(@PathVariable String idCartao);

    @PostMapping("/{idCartao}/bloqueios")
    BloqueioCartaoLegadoReponse registraNovoBloqueio(BloqueioCartaoLegadoRequest bloqueioCartaoLegadoRequest, @PathVariable String idCartao);

    @PostMapping("/{idCartao}/avisos")
    NotificacaoViagemLegadoResponse registraNotificacaoViagem(NotificacaoViagemLegadoRequest notificacaoViagemLegadoRequest, @PathVariable String idCartao);
}
