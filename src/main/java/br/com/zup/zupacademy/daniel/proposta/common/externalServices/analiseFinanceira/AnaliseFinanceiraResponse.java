package br.com.zup.zupacademy.daniel.proposta.common.externalServices.analiseFinanceira;

import br.com.zup.zupacademy.daniel.proposta.proposta.StatusAnalise;

public class AnaliseFinanceiraResponse {

    private String documento;
    private String nome;
    private ResultadoSolicitacao resultadoSolicitacao;
    private String idProposta;

    public AnaliseFinanceiraResponse(String documento, String nome, ResultadoSolicitacao resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public StatusAnalise obtemStatusAnaliseDeResultadoSolicitacao() {
        return this.resultadoSolicitacao.toStatusAnalise();
    }
}
