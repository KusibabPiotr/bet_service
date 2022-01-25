package my.betservice.domain.user;

import lombok.*;
import my.betservice.domain.bet.BetCard;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "customer",
                cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;
    private BigDecimal moneyOnAccount;
    @OneToMany(
            targetEntity = BetCard.class,
            cascade = CascadeType.ALL,
            mappedBy = "customer")
    private List<BetCard> betCards = new ArrayList<>();
    @OneToOne
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id != null ? id.equals(customer.id) : customer.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
