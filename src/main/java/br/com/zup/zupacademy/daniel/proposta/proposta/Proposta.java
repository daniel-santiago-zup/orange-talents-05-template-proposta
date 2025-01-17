package br.com.zup.zupacademy.daniel.proposta.proposta;

import br.com.zup.zupacademy.daniel.proposta.cartao.Cartao;
import br.com.zup.zupacademy.daniel.proposta.common.validators.CPFouCNPJ;
import br.com.zup.zupacademy.daniel.proposta.common.validators.EncodadoComBCrypt;
import br.com.zup.zupacademy.daniel.proposta.common.validators.EncodadoComBCryptValidator;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @EncodadoComBCrypt
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
    @Enumerated(EnumType.STRING)
    private StatusAnalise statusAnalise;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @Deprecated
    public Proposta() {}

    public Proposta(String salt,String documento, String email, String nome, String endereco, BigDecimal salario) {
        if (new EncodadoComBCryptValidator().isValid(documento,null)) {
            throw new IllegalArgumentException("Esta classe deve receber um documento não encodado");
        }
        this.documento = BCrypt.hashpw(documento, salt);
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public StatusAnalise getStatusAnalise() {
        return statusAnalise;
    }

    public String getIdCartao() {
        return cartao != null ? cartao.getId() : null;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setStatusAnalise(StatusAnalise statusAnalise) {
        this.statusAnalise = statusAnalise;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}