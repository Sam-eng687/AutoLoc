package tn.esprit.samarjandoubi4cce10.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.samarjandoubi4cce10.domain.Equipement;
import tn.esprit.samarjandoubi4cce10.domain.Vehicule;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeRequestDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResponseDTO;
import tn.esprit.samarjandoubi4cce10.web.dto.VehiculeResumeDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(target = "agenceNom", source = "agence.nom")
    @Mapping(target = "equipements", source = "equipements")
    VehiculeResponseDTO toDto(Vehicule vehicule);

    VehiculeResumeDTO toResumeDto(Vehicule vehicule);

    List<VehiculeResumeDTO> toResumeDtoList(List<Vehicule> vehicules);

    @Mapping(target = "idVehicule", ignore = true)
    @Mapping(target = "statut", constant = "DISPONIBLE")
    @Mapping(target = "agence", ignore = true)
    @Mapping(target = "equipements", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Vehicule toEntity(VehiculeRequestDTO dto);

    default String toLibelle(Equipement equipement) {
        return equipement.getLibelle();
    }
}