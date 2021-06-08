package br.com.zup.zupacademy.daniel.proposta.proposta;

import br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira.AnaliseFinanceiraClient;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira.AnaliseFinanceiraRequest;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira.AnaliseFinanceiraResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private AnaliseFinanceiraClient analiseFinanceiraClient;

    @PostMapping
    public ResponseEntity<?> cadastraProposta(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Proposta proposta = propostaRepository.save(request.converte());
        AnaliseFinanceiraResponse respostaAnalise = analiseFinanceiraClient.obtemResultadoSolicitacao(new AnaliseFinanceiraRequest(proposta));
        proposta.setStatusAnalise(respostaAnalise.obtemStatusAnaliseDeResultadoSolicitacao());
        URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).body(proposta);
    }
}
