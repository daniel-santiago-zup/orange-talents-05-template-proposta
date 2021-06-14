package br.com.zup.zupacademy.daniel.proposta.carteira;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoResponse;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CarteiraLegadoRequest;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CarteiraLegadoResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    CartaoLegadoClient cartaoLegadoClient;
    @Autowired
    CarteiraRepository carteiraRepository;

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> cadastraCarteira(@RequestBody @Valid CarteiraRequest request,
                                              @PathVariable String idCartao,
                                              UriComponentsBuilder uriComponentsBuilder) {
        Cartao cartao;
        try {
            CartaoLegadoResponse cartaoLegadoResponse = cartaoLegadoClient.obtemCartaoPorId(idCartao);
            cartao = cartaoLegadoResponse.converte();
        } catch (FeignException.NotFound e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }

        CarteiraLegadoResponse carteiraLegadoResponse;
        try {
            carteiraLegadoResponse = cartaoLegadoClient.registraCarteiraDigital(new CarteiraLegadoRequest(request), idCartao);
            if (!carteiraLegadoResponse.carteiraAssociada()) {
                return ResponseEntity.unprocessableEntity().build();
            }
        } catch (FeignException.UnprocessableEntity e) {
            System.out.println(e.getMessage());
            return ResponseEntity.unprocessableEntity().build();
        } catch (FeignException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

        Carteira carteira = carteiraRepository.save(request.converte(carteiraLegadoResponse.getId(), cartao));

        URI uri = uriComponentsBuilder.path("/{idCarteira}").buildAndExpand(carteira.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
