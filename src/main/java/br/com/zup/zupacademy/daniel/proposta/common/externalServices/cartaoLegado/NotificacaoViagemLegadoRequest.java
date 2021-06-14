package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

import br.com.zup.zupacademy.daniel.proposta.notificacaoViagem.NotificacaoViagem;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NotificacaoViagemLegadoRequest {
    @NotBlank
    private String destino;
    @NotNull
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validoAte;

    public NotificacaoViagemLegadoRequest(NotificacaoViagem notificacaoViagem) {
        this.destino = notificacaoViagem.getDestino();
        this.validoAte = notificacaoViagem.getDataRetorno();
    }
}
