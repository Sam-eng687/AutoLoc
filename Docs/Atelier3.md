# Notes sur les repositories

## Choix d'interface

Les repositories du projet étendent `JpaRepository<Entité, Long>`
(ex. : `IPaiementRepository extends JpaRepository<Paiement, Long>`).
Cette interface a été préférée à `CrudRepository` car elle ajoute la pagination,
le tri et des opérations en lot (`flush`, `saveAllAndFlush`, `deleteAllInBatch`),
tout en incluant les opérations CRUD de base.

## Anomalies SonarQube for IDE corrigées

| Fichier | Règle | Anomalie | Correction |
|---|---|---|---|
| `Agence.java` | java:S1128 | Imports inutilisés `java.util.List` et `java.util.logging.Level` | Imports supprimés |
| `Contrat.java` | java:S1128 | Import inutilisé `java.util.List` | Import supprimé |
| `Vehicule.java` | java:S116 | Champ `Equipements` non conforme à la convention de nommage `^[a-z][a-zA-Z0-9]*$` | Renommé en `equipements` |
| `IPaiementRepository.java` | java:S1128 | Import inutilisé `org.hibernate.boot.models.JpaAnnotations` | Import supprimé |

## Analyse de l'ensemble du projet

Une analyse complète a été lancée (clic droit sur le projet, puis
*Analyze with SonarQube for IDE*). Rapport du 08/10 à 22:25 :
2 anomalies dans 2 fichiers, 0 Security Hotspot, 0 Taint Vulnerability.

| Fichier | Règle | Anomalie |
|---|---|---|
| `IVehiculeRepository.java` | java:S1128 | Import inutilisé `org.springframework.data.repository.CrudRepository` (ligne 4) |
| `Reservation.java` | java:S1128 | Import inutilisé `org.springframework.cglib.core.Local` (ligne 6) |

Ces deux anomalies restantes sont mineures (maintenabilité) : il suffit de supprimer les imports.
