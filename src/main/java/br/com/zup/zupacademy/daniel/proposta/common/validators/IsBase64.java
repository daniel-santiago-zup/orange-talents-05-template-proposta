package br.com.zup.zupacademy.daniel.proposta.common.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsBase64Validator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsBase64 {
    String message() default "O campo deve estar no formato Base64";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}