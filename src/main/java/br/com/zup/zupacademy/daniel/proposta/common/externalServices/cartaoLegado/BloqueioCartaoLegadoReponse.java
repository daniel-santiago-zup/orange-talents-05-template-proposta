package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

import br.com.zup.zupacademy.daniel.proposta.bloqueio.StatusBloqueio;
import com.fasterxml.jackson.annotation.JsonCreator;

public class BloqueioCartaoLegadoReponse {
    private String resultado;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BloqueioCartaoLegadoReponse(String resultado) {
        this.resultado = resultado;
    }

    public StatusBloqueio retornaStatusBloqueio() {
        return resultado.equals("BLOQUEADO") ? StatusBloqueio.BLOQUEADO : StatusBloqueio.BLOQUEIO_PENDENTE;
    }
}
