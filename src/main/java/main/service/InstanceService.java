package main.service;

import main.entity.Checker;
import main.entity.Instance;
import main.entity.Official;
import main.entity.Prosecutor;
import main.repository.CheckerRepository;
import main.repository.InstanceRepository;
import main.repository.OfficialRepository;
import main.repository.ProsecutorRepository;
import org.springframework.stereotype.Service;

@Service
public class InstanceService {

    private final ProsecutorRepository prosecutorRepository;
    private final OfficialRepository officialRepository;
    private final InstanceRepository instanceRepository;
    private final CheckerRepository checkerRepository;

    public InstanceService(ProsecutorRepository prosecutorRepository, OfficialRepository officialRepository, InstanceRepository instanceRepository, CheckerRepository checkerRepository) {
        this.prosecutorRepository = prosecutorRepository;
        this.officialRepository = officialRepository;
        this.instanceRepository = instanceRepository;
        this.checkerRepository = checkerRepository;
    }

    public Prosecutor getProsecutorId(Long id) {
        return prosecutorRepository.getProsecutorById(id);
    }
    public Official getOfficialById(Long id) {
        return officialRepository.getOfficialById(id);
    }

    public Instance getInstanceId(Long id) {
        return instanceRepository.getInstanceById(id);
    }

    public Checker getCheckerId(Long id) {
        return checkerRepository.getCheckerById(id);
    }

}
