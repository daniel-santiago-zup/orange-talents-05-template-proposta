package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AvisoCartao {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validoAte;
    private String destino;

    public AvisoCartao(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }
}
