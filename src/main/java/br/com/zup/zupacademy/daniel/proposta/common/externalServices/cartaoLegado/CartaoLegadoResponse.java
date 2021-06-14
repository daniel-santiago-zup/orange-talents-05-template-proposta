package br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;
import br.com.zup.zupacademy.daniel.proposta.common.externalServices.cartaoLegado.modelo.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class CartaoLegadoResponse {
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private Set<BloqueioCartaoLegado> bloqueios;
    private Set<AvisoCartaoLegado> avisos;
    private Set<CarteiraCartaoLegado> carteiras;
    private Set<ParcelaCartaoLegado> parcelas;
    private BigDecimal limite;
    private RenegociacaoCartaoLegado renegociacao;
    private VencimentoCartaoLegado vencimento;
    private String idProposta;

    public CartaoLegadoResponse(String id,
                                LocalDateTime emitidoEm,
                                String titular,
                                Set<BloqueioCartaoLegado> bloqueios,
                                Set<AvisoCartaoLegado> avisos,
                                Set<CarteiraCartaoLegado> carteiras,
                                Set<ParcelaCartaoLegado> parcelas,
                                BigDecimal limite,
                                RenegociacaoCartaoLegado renegociacao,
                                VencimentoCartaoLegado vencimento,
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

    public Cartao converte() {
        return new Cartao(this.id,this.titular);
    }

    public String getId() {
        return id;
    }
}
