package main.repository;

import main.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductionRepository extends JpaRepository<Production, Long> {
    Production getProductionById(Long id);
    List<Production> getProductionsByTypeOfDocumentId(Long id);
}
