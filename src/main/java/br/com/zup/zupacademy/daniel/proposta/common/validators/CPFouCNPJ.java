package br.com.zup.zupacademy.daniel.proposta.common.validators;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CPFouCNPJ {
    String message() default "CPF ou CNPJ valido deve ser informado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}