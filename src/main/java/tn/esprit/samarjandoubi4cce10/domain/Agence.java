package tn.esprit.samarjandoubi4cce10.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAgence;
    String nom;
    String ville;
    String addresse;
    String telephone;
  @OneToMany (mappedBy ="agence")
  Set<Vehicule> vehicules = new HashSet<>();

  @OneToMany (mappedBy = "agence")
    Set <Employe>  employes = new HashSet<>();
}
