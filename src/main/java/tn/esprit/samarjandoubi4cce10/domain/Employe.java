package tn.esprit.samarjandoubi4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long idEmploye;
    String nom;
    String prenom;
    @Enumerated(EnumType.STRING)
    RoleEmploye role;

}
