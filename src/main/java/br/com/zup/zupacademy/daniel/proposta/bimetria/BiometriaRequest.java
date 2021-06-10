package br.com.zup.zupacademy.daniel.proposta.bimetria;

import br.com.zup.zupacademy.daniel.proposta.common.validators.IsBase64;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class BiometriaRequest {
    @NotBlank
    @IsBase64
    private String fingerprint;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BiometriaRequest(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Biometria converte(String idCartao) {
        return new Biometria(this.fingerprint, idCartao);
    }
}
