package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.modelo;

import java.math.BigDecimal;

public class ParcelaCartaoLegado {
    private Long id;
    private Integer quantidade;
    private BigDecimal valor;

    public ParcelaCartaoLegado(Long id, Integer quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
