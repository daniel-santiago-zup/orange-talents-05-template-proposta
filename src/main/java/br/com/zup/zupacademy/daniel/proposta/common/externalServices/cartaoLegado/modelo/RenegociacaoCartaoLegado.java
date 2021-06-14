package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RenegociacaoCartaoLegado {
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataDeCriacao;

    public RenegociacaoCartaoLegado(String id, Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }
}
