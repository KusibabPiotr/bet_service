package my.betservice.registration.service;

import lombok.RequiredArgsConstructor;
import my.betservice.exception.EmailAlreadyExistsInDatabase;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByUsername(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,email)));
    }

    public String signUpUser(final AppUser appUser)
            throws EmailAlreadyExistsInDatabase {
        boolean alreadyExists = appUserRepository
                .findByUsername(appUser.getUsername())
                .isPresent();
        if (alreadyExists) throw new EmailAlreadyExistsInDatabase();

        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);

//        TODO: send confirmation token
        return "it works";
    }
}
