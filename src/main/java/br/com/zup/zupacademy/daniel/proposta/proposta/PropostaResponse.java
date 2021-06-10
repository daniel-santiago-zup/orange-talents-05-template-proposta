package br.com.zup.zupacademy.daniel.proposta.proposta;

import java.math.BigDecimal;

public class PropostaResponse {
    private Long id;
    private String documento;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;
    private StatusAnalise statusAnalise;
    private String idCartao;

    public PropostaResponse(Proposta proposta) {
        this.id = proposta.getId();
        this.documento = proposta.getDocumento();
        this.email = proposta.getEmail();
        this.nome = proposta.getNome();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
        this.statusAnalise = proposta.getStatusAnalise();
        this.idCartao = proposta.getIdCartao();
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusAnalise getStatusAnalise() {
        return statusAnalise;
    }

    public String getIdCartao() {
        return idCartao;
    }
}