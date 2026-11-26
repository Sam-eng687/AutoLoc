package tn.esprit.samarjandoubi4cce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.samarjandoubi4cce10.domain.CategorieVehicule;
import tn.esprit.samarjandoubi4cce10.domain.StatutVehicule;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.web.dto.NbVehiculesAgenceDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByMarque(String marque);
    List<Vehicule> findByCategorieAndStatut(CategorieVehicule categorie, StatutVehicule statut);
    List<Vehicule> findByTarifJournalierBetweenOrderByTarifJournalierAsc(BigDecimal min, BigDecimal max);
    List<Vehicule> findByModelContainingIgnoreCase(String motCle);
    List<Vehicule> findByCategorieIn(List<CategorieVehicule> categories);
    boolean existsByImmatriculation(String immatriculation);
    long countByStatut(StatutVehicule statut);
    List<Vehicule> findTop3ByOrderByTarifJournalierAsc();
    List<Vehicule> findByAgenceIdAgence(Long agenceId);
    List<Vehicule> findByAgenceIsNull();


    @Query("SELECT v FROM Vehicule v JOIN v.agence a WHERE a.ville = :ville")
    List<Vehicule> findByVilleAgence(@Param("ville") String ville);


    @Query("SELECT DISTINCT v FROM Vehicule v JOIN v.equipements e WHERE e.libelle = :libelle")
    List<Vehicule> findByEquipement(@Param("libelle") String libelle);


    @Query("""
            SELECT v FROM Vehicule v JOIN v.equipements e
            GROUP BY v
            HAVING COUNT(e) >= :n
            """)
    List<Vehicule> findAvecAuMoinsNEquipements(@Param("n") long n);


    @Query("""
            SELECT DISTINCT v FROM Vehicule v
            JOIN v.reservations r JOIN r.client c
            WHERE c.idClient = :clientId
            """)
    List<Vehicule> findReservesParClient(@Param("clientId") Long clientId);


    @Query("SELECT v FROM Vehicule v LEFT JOIN v.reservations r WHERE r IS NULL")
    List<Vehicule> findJamaisReserves();


    @Query("""
        SELECT DISTINCT m.vehicule FROM Maintenance m
        WHERE :date BETWEEN m.dateDebut AND m.dateFin
        """)
    List<Vehicule> findEnMaintenanceLe(@Param("date") LocalDate date);


    @Query("""
        SELECT v FROM Vehicule v
        LEFT JOIN FETCH v.agence
        LEFT JOIN FETCH v.equipements
        WHERE v.idVehicule = :id
        """)
    Optional<Vehicule> findByIdAvecEquipements(@Param("id") Long id);

    @Query("""
            SELECT new tn.esprit.samarjandoubi4cce10.web.dto.NbVehiculesAgenceDTO(a.nom, COUNT(v))
            FROM Agence a LEFT JOIN a.vehicules v
            GROUP BY a.idAgence, a.nom
            """)
    List<NbVehiculesAgenceDTO> compterParAgence();
}