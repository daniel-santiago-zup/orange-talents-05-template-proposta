package br.com.zup.zupacademy.daniel.proposta.carteira;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Carteira {
    @Id
    private String id;
    @ManyToOne
    @NotNull
    private Cartao cartao;
    @NotBlank
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    @NotNull
    private CarteiraDigitalAceita carteira;

    @Deprecated
    public Carteira() {}

    public Carteira(String id, Cartao cartao, String email, CarteiraDigitalAceita carteira) {
        this.id = id;
        this.cartao = cartao;
        this.email = email;
        this.carteira = carteira;
    }

    public String getId() {
        return id;
    }
}