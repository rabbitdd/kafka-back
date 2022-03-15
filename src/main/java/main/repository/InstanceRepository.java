package main.repository;

import main.entity.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepository extends JpaRepository<Instance, Long> {

    Instance getInstanceById(Long id);
}
