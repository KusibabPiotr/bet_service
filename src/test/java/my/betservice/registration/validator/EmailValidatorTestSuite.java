package my.betservice.registration.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class EmailValidatorTestSuite {
    private EmailValidator emailValidator = new EmailValidator();

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