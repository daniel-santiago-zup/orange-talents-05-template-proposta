package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.modelo;

import java.time.LocalDateTime;

public class VencimentoCartaoLegado {
    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    public VencimentoCartaoLegado(String id, Integer dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }
}