package tn.esprit.samarjandoubi4cce10.repository;

import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.samarjandoubi4cce10.domain.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {

}
