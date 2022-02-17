package my.betservice.registration.controller;

import my.betservice.registration.service.RegistrationService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(RegistrationController.class)
class RegistrationControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegistrationService registrationService;

    @Nested
    class TestConfirmEmail {
//        @Test
//        public void shouldReturnConfirmationMessage() throws Exception {
//            //given
//            String successfulMessage = "Email successfully confirmed!";
//            when(registrationService.confirmToken("token")).thenReturn(successfulMessage);
//            //when & then
//            mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/v1/registration/confirm")
//                        .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(MockMvcResultMatchers.status().is(200))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.is(successfulMessage)));
//
//        }
//        @Test
//        public void shouldThrowEmailNotValidException() throws Exception {
//            //given
//            String message = "Email with confirmation link just send";
//            var registrationRequestDto =
//                    RegistrationRequestDto.builder()
//                            .email("kruk@kruk.pl")
//                            .password("password")
//                            .repeatPassword("password")
//                            .build();
//            when(registrationService.register(any())).thenThrow(new EmailNotValidException());
//            //when & then
//            mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/v1/registration")
//                        .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(MockMvcResultMatchers.status().is(400));
//        }
    }
}