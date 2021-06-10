package br.com.zup.zupacademy.daniel.proposta.bloqueio;

import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.CartaoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.CartaoResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Cartão já está bloqueado!");
        }
        BloqueioCartao bloqueioCartao = new BloqueioCartao(idCartao,request.getRemoteAddr(),userAgent);
        bloqueiCartaoRepository.save(bloqueioCartao);
        URI uri = uriComponentsBuilder.path("/bloqueio-cartao/{idBloqueio}").buildAndExpand(bloqueioCartao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
