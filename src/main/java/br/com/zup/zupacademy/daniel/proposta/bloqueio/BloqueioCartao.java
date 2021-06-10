package br.com.zup.zupacademy.daniel.proposta.bloqueio;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class BloqueioCartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String idCartao;
    @NotNull
    private LocalDateTime bloqueadoEm = LocalDateTime.now();
    @NotBlank
    private String ipCliente;
    @NotBlank
    private String userAgent;
    @Enumerated(EnumType.STRING)
    private StatusBloqueio statusBloqueio = StatusBloqueio.BLOQUEIO_PENDENTE;

    @Deprecated
    public BloqueioCartao() {}

    public BloqueioCartao(String idCartao, String ipCliente, String userAgent) {
        this.idCartao = idCartao;
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public Long getId() {
        return id;
    }

    public void setStatusBloqueio(StatusBloqueio statusBloqueio) {
        this.statusBloqueio = statusBloqueio;
    }
}