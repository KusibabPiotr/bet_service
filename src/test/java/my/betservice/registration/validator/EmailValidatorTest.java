package my.betservice.registration.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class EmailValidatorTest {
    @Autowired
    private EmailValidator emailValidator;

    @Test
    public void shouldReturnTrueIfEmailHasAtSign() {
        //given
        String email = "adam@gmail.com";
        //when
        boolean test = emailValidator.test(email);
        //then
        assertThat(test).isTrue();
    }

    @Test
    public void shouldReturnFalseIfEmailHasNoAtSign() {
        //given
        String email = "adam#gmail.com";
        //when
        boolean test = emailValidator.test(email);
        //then
        assertThat(test).isFalse();
    }
}