package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NotificacaoViagemLegadoResponse {
    private StatusResultadoNotificacao resultado;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NotificacaoViagemLegadoResponse(StatusResultadoNotificacao resultado) {
        this.resultado = resultado;
    }

    public boolean notificadoComSucesso() {
       return this.resultado.equals(StatusResultadoNotificacao.CRIADO);
    }

    private enum StatusResultadoNotificacao {
        CRIADO,
        FALHA
    }
}
