package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.modelo;

import java.time.LocalDateTime;

public class BloqueioCartaoLegado {
    private String id;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private Boolean ativo;

    public BloqueioCartaoLegado(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, Boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }
}
