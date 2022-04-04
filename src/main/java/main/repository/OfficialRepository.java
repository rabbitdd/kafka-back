package main.repository;

import main.entity.Official;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficialRepository extends JpaRepository<Official, Long> {
    Official getOfficialById(Long id);
//    Official getOfficialByLogin(String login);
}
