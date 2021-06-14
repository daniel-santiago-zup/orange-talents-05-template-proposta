package br.com.zup.zupacademy.daniel.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {
    @Id
    private String id;
    @NotBlank
    private String titular;
    @NotNull
    private Boolean bloqueado = false;

    @Deprecated
    public Cartao() {}

    public Cartao(String id, String titular) {
        this.id = id;
        this.titular = titular;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getId() {
        return id;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }
}