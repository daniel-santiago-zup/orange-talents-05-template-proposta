package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao;

import javax.validation.constraints.NotBlank;

public class BloqueioCartaoLegadoRequest {
    @NotBlank
    private String sistemaResponsavel;

    public BloqueioCartaoLegadoRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() {
        return sistemaResponsavel;
    }
}
