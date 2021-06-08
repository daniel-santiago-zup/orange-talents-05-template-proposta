package br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira;

import br.com.zup.zupacademy.daniel.proposta.proposta.Proposta;

public class AnaliseFinanceiraRequest {

    private String documento;
    private String nome;
    private Long idProposta;

    public AnaliseFinanceiraRequest(String documento, String nome, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    @Deprecated
    AnaliseFinanceiraRequest() {}

    public AnaliseFinanceiraRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
        this.idProposta = proposta.getId();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdProposta() {
        return idProposta;
    }
}
