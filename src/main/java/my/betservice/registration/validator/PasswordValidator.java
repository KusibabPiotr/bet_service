package my.betservice.registration.validator;

import org.springframework.stereotype.Service;

import java.util.function.BiPredicate;

@Service
public class PasswordValidator implements BiPredicate<String, String> {
    @Override
    public boolean test(String password, String repeatedPassword) {
        return password.equals(repeatedPassword);
    }
}
