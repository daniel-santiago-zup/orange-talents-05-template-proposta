package br.com.zup.zupacademy.daniel.proposta.common.validators;

import br.com.zup.zupacademy.daniel.proposta.common.exceptions.ErroApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object> {

    @Autowired
    private EntityManager entityManager;
    private Class<?> entidade;
    private String nomeCampo;
    private String mensagem;
    private HttpStatus status;

    @Override
    public void initialize(ValorUnico constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        entidade = constraintAnnotation.entidade();
        nomeCampo = constraintAnnotation.nomeCampo();
        mensagem = constraintAnnotation.message();
        status = constraintAnnotation.status();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        List<?> lista = entityManager.createQuery("select c from "+ entidade.getSimpleName() +" c where c."+nomeCampo+"= :pCampo")
                .setParameter("pCampo",s)
                .getResultList();

        if (!lista.isEmpty()) {
            throw new ErroApiException(status,mensagem);
        }

        return true;
    }
}
