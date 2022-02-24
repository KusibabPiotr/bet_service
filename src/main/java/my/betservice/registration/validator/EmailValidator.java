package my.betservice.registration.validator;

import my.betservice.exception.EmailNotValidException;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class EmailValidator {
    public void validate(final String email) throws EmailNotValidException {
        if (!test(email)) {
            throw new EmailNotValidException();
        }
    }
    public boolean test(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }
}
