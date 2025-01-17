package br.com.zup.zupacademy.daniel.proposta.proposta;

import br.com.zup.zupacademy.daniel.proposta.common.validators.CPFouCNPJ;
import br.com.zup.zupacademy.daniel.proposta.common.validators.ValorUnico;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PropostaRequest {
    @CPFouCNPJ
    @NotBlank
    @ValorUnico(nomeCampo = "documento",entidade = Proposta.class, status = HttpStatus.UNPROCESSABLE_ENTITY,message = "É permitido apenas uma proposta por CPF fornecido")
    private String documento;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    @Positive
    private BigDecimal salario;

    public PropostaRequest(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Proposta converte(String salt) {
        return new Proposta(salt, this.documento, this.email, this.nome, this.endereco, this.salario);
    }
}
