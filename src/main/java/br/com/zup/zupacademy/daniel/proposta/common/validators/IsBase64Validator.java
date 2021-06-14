package br.com.zup.zupacademy.daniel.proposta.common.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Base64;

public class IsBase64Validator implements ConstraintValidator<IsBase64,String> {

    @Override
    public void initialize(IsBase64 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        byte[] decodedBase64 = Base64.getDecoder().decode(s);
        String reEncodedBase64 = Base64.getEncoder().encodeToString(decodedBase64);

        return reEncodedBase64.equals(s);
    }
}
