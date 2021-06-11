package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.modelo;

import java.time.LocalDateTime;

public class VencimentoCartao {
    private String id;
    private Integer dia;
    private LocalDateTime dataDeCriacao;

    public VencimentoCartao(String id, Integer dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }
}