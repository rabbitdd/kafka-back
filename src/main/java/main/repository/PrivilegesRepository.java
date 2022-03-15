package main.repository;

import main.entity.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegesRepository extends JpaRepository<Privileges, Long> {

    Privileges getPrivilegesById(Long id);
}
