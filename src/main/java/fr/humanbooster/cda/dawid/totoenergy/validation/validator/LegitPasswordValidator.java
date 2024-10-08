package fr.humanbooster.cda.dawid.totoenergy.validation.validator;

import fr.humanbooster.cda.dawid.totoenergy.validation.constrain.LegitPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LegitPasswordValidator implements ConstraintValidator<LegitPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (!password.contains("*")) {
            context.buildConstraintViolationWithTemplate("Le mot de passe doit contenir un *");
            return false;
        }
        if (password.length() < 5) {
            context.buildConstraintViolationWithTemplate("Le mot de passe doit faire au moins 5 caractères");
            return false;
        }
        return true;
    }
}
