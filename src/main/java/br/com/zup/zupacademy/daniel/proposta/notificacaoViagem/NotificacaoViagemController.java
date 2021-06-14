package br.com.zup.zupacademy.daniel.proposta.notificacaoViagem;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/notificacao-viagem")
public class NotificacaoViagemController {

    @Autowired
    private CartaoLegadoClient cartaoLegadoClient;
    @Autowired
    private NotificacaoViagemRepository notificacaoViagemRepository;

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> cadastraNotificacaoViagem(@PathVariable String idCartao,
                                                    @RequestBody @Valid NotificacaoViagemRequest request,
                                                    HttpServletRequest servletRequest) {
        Cartao cartao;
        try {
            CartaoLegadoResponse cartaoLegadoResponse = cartaoLegadoClient.obtemCartaoPorId(idCartao);
            cartao = cartaoLegadoResponse.converte();
        } catch (FeignException.NotFound e) {
            return ResponseEntity.notFound().build();
        }
        NotificacaoViagem notificacaoViagem = request.converte(cartao, servletRequest.getRemoteAddr(), servletRequest.getHeader("User-Agent"));

        notificacaoViagemRepository.save(notificacaoViagem);
        return ResponseEntity.ok().build();
    }
}
