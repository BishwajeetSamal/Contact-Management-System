package validator;

import java.util.Arrays;
import java.util.Set;
import com.cms.contactmanagementsystem.response.RestResponse;
import com.cms.contactmanagementsystem.response.StatusResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Validations {

    public RestResponse validate(Object requestDto, String[] array) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Object>> violations = null;

        violations = validator.validate(requestDto);
        for (ConstraintViolation<Object> violation : violations) {
            if (Arrays.asList(array).indexOf(violation.getPropertyPath().toString()) != -1) {
                if (violation.getMessage().toString() != null) {
                    return new StatusResponse(400, violation.getMessage(), requestDto);
                }
            }
        }
        return null;
    }

}

