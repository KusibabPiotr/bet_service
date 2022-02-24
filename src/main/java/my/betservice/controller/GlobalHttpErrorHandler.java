package my.betservice.controller;

import my.betservice.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsInDatabaseException.class)
    public ResponseEntity<String> handleEmailAlreadyExistsInDatabaseException() {
        return new ResponseEntity<>("Email already exists in database! Try to register using different one!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException() {
        return new ResponseEntity<>("User with given id not exist!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<String> handlePasswordNotMatchException() {
        return new ResponseEntity<>("Password in both fields should match!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BetCardNotFoundException.class)
    public ResponseEntity<String> handleBetCardNotFoundException() {
        return new ResponseEntity<>("Bet cart with given id not found in database!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BetNotFoundException.class)
    public ResponseEntity<String> handleBetNotFoundException() {
        return new ResponseEntity<>("Bet with given id not found in database!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientFetchException.class)
    public ResponseEntity<String> handleClientFetchException() {
        return new ResponseEntity<>("There is problem with fetching information from connected API! Contact with customer service!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyConfirmedException.class)
    public ResponseEntity<String> handleEmailAlreadyConfirmedException() {
        return new ResponseEntity<>("You have confirmed your email already!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailNotValidException.class)
    public ResponseEntity<String> handleEmailNotValidException() {
        return new ResponseEntity<>("You have to provide right email format!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FixtureNotFoundException.class)
    public ResponseEntity<String> handleFixtureNotFoundException() {
        return new ResponseEntity<>("There is no fixture with given id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LeagueNotFoundException.class)
    public ResponseEntity<String> handleLeagueNotFoundException() {
        return new ResponseEntity<>("There is no league with given id", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotEnoughMoneyOnAccountException.class)
    public ResponseEntity<String> handleNotEnoughMoneyOnAccountException() {
        return new ResponseEntity<>("You don't have enough money to process your bet! Bring in some more!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<String> handleTokenExpiredException() {
        return new ResponseEntity<>("Your token already expired! Register again!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<String> handleTokenNotFoundException() {
        return new ResponseEntity<>("Invalid token! Regester again!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException() {
        return new ResponseEntity<>("Authentication Failed", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalPasswordFormatException.class)
    public ResponseEntity<String> handleIllegalPasswordFormatException() {
        return new ResponseEntity<>("Your password should contains at least 6 signs!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException() {
        return new ResponseEntity<>("There is no user with given username!", HttpStatus.BAD_REQUEST);
    }
}
