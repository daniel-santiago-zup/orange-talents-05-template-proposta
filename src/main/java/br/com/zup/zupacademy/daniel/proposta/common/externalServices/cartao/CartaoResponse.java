package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class CartaoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private Set<BloqueioCartaoLegado> bloqueios;
    private Set<AvisoCartao> avisos;
    private Set<CarteiraCartao> carteiras;
    private Set<ParcelaCartao> parcelas;
    private BigDecimal limite;
    private RenegociacaoCartao renegociacao;
    private VencimentoCartao vencimento;
    private String idProposta;

    public CartaoResponse(String id,
                          LocalDateTime emitidoEm,
                          String titular,
                          Set<BloqueioCartaoLegado> bloqueios,
                          Set<AvisoCartao> avisos,
                          Set<CarteiraCartao> carteiras,
                          Set<ParcelaCartao> parcelas,
                          BigDecimal limite,
                          RenegociacaoCartao renegociacao,
                          VencimentoCartao vencimento,
                          String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.limite = limite;
        this.renegociacao = renegociacao;
        this.vencimento = vencimento;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }
}
