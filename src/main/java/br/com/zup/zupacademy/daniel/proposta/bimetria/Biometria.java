package br.com.zup.zupacademy.daniel.proposta.bimetria;

import br.com.zup.zupacademy.daniel.proposta.common.validators.IsBase64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime criadoEm = LocalDateTime.now();
    @NotBlank
    @IsBase64
    private String fingerprint;
    @NotBlank
    private String idCartao;

    public Biometria(String fingerprint, String idCartao) {
        this.fingerprint = fingerprint;
        this.idCartao = idCartao;
    }

    public Long getId() {
        return id;
    }
}