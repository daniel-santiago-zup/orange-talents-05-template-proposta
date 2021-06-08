package br.com.zup.zupacademy.daniel.proposta.common.validators;

import org.springframework.http.HttpStatus;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValorUnicoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValorUnico {
    String message() default "Valor deve ser único!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> entidade();
    HttpStatus status() default HttpStatus.BAD_REQUEST;
    String nomeCampo();
}
