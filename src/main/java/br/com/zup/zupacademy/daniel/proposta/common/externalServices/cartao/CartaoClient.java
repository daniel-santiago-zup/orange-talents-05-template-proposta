package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cartao", url = "${cartao_url}")
public interface CartaoClient {

    @GetMapping
    CartaoResponse obtemCartaoGerado(@RequestParam Long idProposta);

    @GetMapping("/{idCartao}")
    CartaoResponse obtemCartaoPorId(@PathVariable String idCartao);

    @PostMapping(value = "/{idCartao}/bloqueios")
    BloqueioCartaoLegadoReponse registraNovoBloqueio(BloqueioCartaoLegadoRequest bloqueioCartaoLegadoRequest, @PathVariable String idCartao);
}
