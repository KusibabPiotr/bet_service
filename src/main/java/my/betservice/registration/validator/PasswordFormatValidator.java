package my.betservice.registration.validator;

import my.betservice.exception.IllegalPasswordFormatException;
import org.springframework.stereotype.Service;

@Service
public class PasswordFormatValidator {
    public void validate(final String password)
            throws IllegalPasswordFormatException {
        if (!test(password)) {
            throw new IllegalPasswordFormatException();
        }
    }
    public boolean test(final String password) {
        return password != null && password.length() > 5;
    }
}
