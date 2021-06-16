package br.com.zup.zupacademy.daniel.proposta.common.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EncodadoComBCryptValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EncodadoComBCrypt {
    String message() default "Valor deve ser um hash encodado com BCrypt!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
