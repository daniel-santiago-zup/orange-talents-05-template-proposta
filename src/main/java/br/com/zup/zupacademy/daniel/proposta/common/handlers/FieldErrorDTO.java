package br.com.zup.zupacademy.daniel.proposta.common.handlers;

public class FieldErrorDTO {
    private String campo;
    private String mensagem;

    public FieldErrorDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
