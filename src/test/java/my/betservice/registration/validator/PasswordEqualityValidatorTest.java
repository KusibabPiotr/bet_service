package my.betservice.registration.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class PasswordEqualityValidatorTest {
    @Autowired
    private PasswordEqualityValidator passwordEqualityValidator;

    @Test
    public void shouldReturnTrueIfPassAndRepeatedPassAreEqual() {
        //given
        String pass = "Adamek";
        String repeatedPass = "Adamek";
        //when
        boolean test = passwordEqualityValidator.test(pass, repeatedPass);
        //then
        assertThat(test).isTrue();
    }

    @Test
    public void shouldReturnFalseIfPassAndRepeatedPassAreNotEqual() {
        //given
        String pass = "Adamek";
        String repeatedPass = "Adamek2";
        //when
        boolean test = passwordEqualityValidator.test(pass, repeatedPass);
        //then
        assertThat(test).isFalse();
    }
}