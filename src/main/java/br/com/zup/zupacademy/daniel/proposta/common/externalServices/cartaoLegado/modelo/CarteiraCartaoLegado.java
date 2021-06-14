package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.modelo;

import java.time.LocalDateTime;

public class CarteiraCartaoLegado {
    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public CarteiraCartaoLegado(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }
}
