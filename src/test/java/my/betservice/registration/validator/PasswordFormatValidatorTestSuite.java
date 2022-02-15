package my.betservice.registration.validator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PasswordFormatValidatorTestSuite {
    private PasswordFormatValidator passwordFormatValidator = new PasswordFormatValidator();

    @Test
    void shouldReturnFalseIfPasswordIsNull(){
        //given
        String password = null;
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isFalse();
    }

    @Test
    void shouldReturnFalseIfPasswordIsBlank(){
        //given
        String password = "";
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isFalse();
    }

    @Test
    void shouldReturnFalseIfPasswordHasLengthUnder6(){
        //given
        String password = "Papap";
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isFalse();
    }

    @Test
    void shouldReturnTrueIfPasswordHas6OrMoreSigns(){
        //given
        String password = "Papapa";
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isTrue();
    }
}