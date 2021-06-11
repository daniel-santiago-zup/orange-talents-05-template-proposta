package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao.modelo;

import java.time.LocalDateTime;

public class CarteiraCartao {
    private String id;
    private String email;
    private LocalDateTime associadaEm;
    private String emissor;

    public CarteiraCartao(String id, String email, LocalDateTime associadaEm, String emissor) {
        this.id = id;
        this.email = email;
        this.associadaEm = associadaEm;
        this.emissor = emissor;
    }
}
