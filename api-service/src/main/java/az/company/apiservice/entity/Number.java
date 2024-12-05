package az.company.apiservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "numbers")
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    public Number(String number) {
        this.number = number;
    }

}
