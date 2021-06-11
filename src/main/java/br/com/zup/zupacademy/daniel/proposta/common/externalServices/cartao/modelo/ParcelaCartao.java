package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.modelo;

import java.math.BigDecimal;

public class ParcelaCartao {
    private Long id;
    private Integer quantidade;
    private BigDecimal valor;

    public ParcelaCartao(Long id, Integer quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
