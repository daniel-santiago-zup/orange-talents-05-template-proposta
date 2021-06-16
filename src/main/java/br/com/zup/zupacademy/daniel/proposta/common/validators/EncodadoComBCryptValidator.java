package br.com.zup.zupacademy.daniel.proposta.common.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EncodadoComBCryptValidator implements ConstraintValidator<EncodadoComBCrypt, String> {
    @Override
    public void initialize(EncodadoComBCrypt constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches("^\\$2[ayb]\\$[0-9]{2}\\$[A-Za-z0-9./]{53}$",s);
    }
}
