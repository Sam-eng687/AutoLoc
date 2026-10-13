package tn.esprit.samarjandoubi4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.samarjandoubi4cce10.domain.Employe;
import tn.esprit.samarjandoubi4cce10.repository.IEmployeRepository;
import tn.esprit.samarjandoubi4cce10.service.IEmployeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
    private final IEmployeRepository employeRepository;

    @Override
    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employe not found"));
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        employeRepository.deleteById(id);

    }

    @Override
    public Employe update(Employe e) {
        return employeRepository.save(e);
    }
}
