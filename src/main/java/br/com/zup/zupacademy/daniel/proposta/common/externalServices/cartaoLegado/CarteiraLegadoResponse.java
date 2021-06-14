package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

public class CarteiraLegadoResponse {
    private StatusCarteiraLegado resultado;
    private String id;

    public CarteiraLegadoResponse(StatusCarteiraLegado resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }

    public boolean carteiraAssociada() {
        return resultado.equals(StatusCarteiraLegado.ASSOCIADA);
    }

    public StatusCarteiraLegado getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

    private enum StatusCarteiraLegado {
        ASSOCIADA
    }
}
