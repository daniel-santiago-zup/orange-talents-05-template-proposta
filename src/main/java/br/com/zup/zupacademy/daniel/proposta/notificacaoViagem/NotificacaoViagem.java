package br.com.zup.zupacademy.daniel.proposta.notificacaoViagem;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class NotificacaoViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private Cartao cartao;
    @NotBlank
    private String destino;
    @Future
    @NotNull
    private LocalDate dataRetorno;
    @NotNull
    private LocalDateTime notificadoEm = LocalDateTime.now();
    @NotBlank
    private String ipCliente;
    @NotNull
    private String userAgent;

    public NotificacaoViagem(Cartao cartao, String destino, LocalDate dataRetorno, String ipCliente, String userAgent) {
        this.cartao = cartao;
        this.destino = destino;
        this.dataRetorno = dataRetorno;
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public Long getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getDataRetorno() {
        return dataRetorno;
    }
}