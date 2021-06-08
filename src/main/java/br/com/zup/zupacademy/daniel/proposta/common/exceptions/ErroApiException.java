package br.com.zup.zupacademy.daniel.proposta.common.exceptions;

import org.springframework.http.HttpStatus;

public class ErroApiException extends RuntimeException {

    private final HttpStatus status;
    private final String razao;


    public ErroApiException( HttpStatus status, String razao) {
        super(razao);
        this.status = status;
        this.razao = razao;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getRazao() {
        return razao;
    }
}
