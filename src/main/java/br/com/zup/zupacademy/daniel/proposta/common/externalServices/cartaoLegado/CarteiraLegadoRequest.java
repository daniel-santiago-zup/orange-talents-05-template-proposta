package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

import br.com.zup.zupacademy.daniel.proposta.carteira.CarteiraRequest;

public class CarteiraLegadoRequest {
    private String email;
    private String carteira;

    public CarteiraLegadoRequest(CarteiraRequest request) {
        this.email = request.getEmail();
        this.carteira = request.getCarteira().toString();
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }
}
