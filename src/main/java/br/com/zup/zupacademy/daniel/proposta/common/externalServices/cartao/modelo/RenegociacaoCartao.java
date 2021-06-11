package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RenegociacaoCartao {
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataDeCriacao;

    public RenegociacaoCartao(String id, Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }
}
