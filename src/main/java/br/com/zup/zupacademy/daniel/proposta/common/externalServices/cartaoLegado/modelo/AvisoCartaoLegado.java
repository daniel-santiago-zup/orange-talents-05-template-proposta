package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AvisoCartaoLegado {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validoAte;
    private String destino;

    public AvisoCartaoLegado(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }
}
