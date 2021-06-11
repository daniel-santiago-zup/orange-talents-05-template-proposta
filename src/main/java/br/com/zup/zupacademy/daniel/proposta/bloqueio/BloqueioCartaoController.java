package br.com.zup.zupacademy.daniel.proposta.bloqueio;

import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.BloqueioCartaoLegadoReponse;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.BloqueioCartaoLegadoRequest;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.CartaoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.CartaoResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/bloqueio-cartao")
public class BloqueioCartaoController {

    @Autowired
    BloqueioCartaoRepository bloqueiCartaoRepository;
    @Autowired
    CartaoClient cartaoClient;


    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> cadastraBloqueioCartao(    @PathVariable String idCartao,
                                                         @RequestHeader(value = "User-Agent") String userAgent,
                                                         HttpServletRequest request,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        try {
            CartaoResponse cartaoResponse = cartaoClient.obtemCartaoPorId(idCartao);
        } catch (FeignException.NotFound e) {
            return ResponseEntity.notFound().build();
        }
        if (!bloqueiCartaoRepository.cartoesBloquados(idCartao).isEmpty()) {
            return ResponseEntity.unprocessableEntity().body("Cartão já está bloqueado!");
        }
        BloqueioCartao bloqueioCartao = new BloqueioCartao(idCartao,request.getRemoteAddr(),userAgent);

        try {
            BloqueioCartaoLegadoReponse bloqueioCartaoLegadoReponse = cartaoClient.registraNovoBloqueio(new BloqueioCartaoLegadoRequest("propostas"),idCartao);
            bloqueioCartao.setStatusBloqueio(bloqueioCartaoLegadoReponse.retornaStatusBloqueio());
        } catch (FeignException.UnprocessableEntity e) {
            if (e.responseBody().isPresent() && e.responseBody().get().toString().contains("FALHA")) {
                return ResponseEntity.unprocessableEntity().body("Cartão já está bloqueado");
            }
            return ResponseEntity.unprocessableEntity().build();
        } catch (FeignException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        bloqueiCartaoRepository.save(bloqueioCartao);
        URI uri = uriComponentsBuilder.path("/bloqueio-cartao/{idBloqueio}").buildAndExpand(bloqueioCartao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
