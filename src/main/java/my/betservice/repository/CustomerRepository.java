package my.betservice.repository;

import my.betservice.domain.user.Customer;
import my.betservice.registration.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByAppUser(AppUser appUser);
}
