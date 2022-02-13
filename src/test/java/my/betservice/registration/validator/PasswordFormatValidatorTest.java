package my.betservice.registration.validator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class PasswordFormatValidatorTest {
    @Autowired
    private PasswordFormatValidator passwordFormatValidator;

    @Test
    public void shouldReturnFalseIfPasswordIsNull(){
        //given
        String password = null;
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isFalse();
    }

    @Test
    public void shouldReturnFalseIfPasswordIsBlank(){
        //given
        String password = "";
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isFalse();
    }

    @Test
    public void shouldReturnFalseIfPasswordHasLengthUnder6(){
        //given
        String password = "Papap";
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isFalse();
    }

    @Test
    public void shouldReturnTrueIfPasswordHas6OrMoreSigns(){
        //given
        String password = "Papapa";
        //when
        boolean test = passwordFormatValidator.test(password);
        //then
        assertThat(test).isTrue();
    }
}