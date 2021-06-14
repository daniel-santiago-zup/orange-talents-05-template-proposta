package br.com.zup.zupacademy.daniel.proposta.bimetria;

import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.CartaoLegadoResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    @Autowired
    BiometriaRepository biometriaRepository;
    @Autowired
    CartaoLegadoClient cartaoLegadoClient;

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> cadastraBiometria(@PathVariable String idCartao, @RequestBody @Valid BiometriaRequest request, UriComponentsBuilder uriComponentsBuilder) {
        try {
            CartaoLegadoResponse cartaoLegadoResponse = cartaoLegadoClient.obtemCartaoPorId(idCartao);
        } catch (FeignException.NotFound e) {
            return ResponseEntity.notFound().build();
        }
        Biometria biometria = biometriaRepository.save(request.converte(idCartao));
        URI uri = uriComponentsBuilder.path("/biometria/{id}").buildAndExpand(biometria.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
}
