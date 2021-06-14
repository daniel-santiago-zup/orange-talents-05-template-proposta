package br.com.zup.zupacademy.daniel.proposta.carteira;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;
import br.com.zup.zupacademy.daniel.proposta.common.validators.ValorUnico;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraRequest {
    @NotBlank
    @Email
    private String email;
    @ValorUnico(entidade = Carteira.class, nomeCampo = "carteira",message = "Ja existe uma carteira deste tipo associada!")
    @Enumerated(EnumType.STRING)
    private CarteiraDigitalAceita carteira;

    public CarteiraRequest(String email, CarteiraDigitalAceita carteira) {
        this.email = email;
        this.carteira = carteira;
    }

    public Carteira converte(String idCarteira, Cartao cartao) {
        return new Carteira(idCarteira, cartao, email, carteira);
    }

    public String getEmail() {
        return email;
    }

    public CarteiraDigitalAceita getCarteira() {
        return carteira;
    }
}
