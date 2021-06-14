package br.com.zup.zupacademy.daniel.proposta.notificacaoViagem;

import br.com.zup.zupacademy.daniel.proposta.bimetria.Biometria;
import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NotificacaoViagemRequest {

    @NotBlank
    private String destino;
    @Future
    @NotNull
    private LocalDate dataRetorno;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NotificacaoViagemRequest(String destino, @JsonFormat(pattern = "dd-MM-yyyy") LocalDate dataRetorno) {
        this.destino = destino;
        this.dataRetorno = dataRetorno;
    }

    public NotificacaoViagem converte(Cartao cartao, String ipCliente, String userAgent) {
        return new NotificacaoViagem(cartao, destino, dataRetorno, ipCliente, userAgent);
    }

}
