package pl.coderslab.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Double> {

    @Override
    public void initialize(Age age) {
    }

    @Override
    public boolean isValid(Double age, ConstraintValidatorContext constraintValidatorContext) {
        if(age==null){
            return false;
        }
        return age > 0.5;
    }
}
