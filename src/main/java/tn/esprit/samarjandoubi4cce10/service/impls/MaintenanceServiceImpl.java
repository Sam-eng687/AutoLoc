package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Maintenance;
import tn.esprit.samarjandoubi4cce10.repository.IMaintenanceRepository;
import tn.esprit.samarjandoubi4cce10.service.IMaintenanceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {
    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance findById(Long id) {
        return maintenanceRepository.findById(id).orElseThrow(()-> new RuntimeException("Maintenance not found"));
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        maintenanceRepository.deleteById(id);

    }

    @Override
    public Maintenance update(Maintenance m) {
        return maintenanceRepository.save(m);
    }
}
