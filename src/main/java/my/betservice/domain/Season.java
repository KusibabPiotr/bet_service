package my.betservice.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "SEASONS")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate start;
    private LocalDate end;
    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    private Coverage coverage;
}
