package main.repository;

import main.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Long> {
    Production getProductionById(Long id);
    Production getProductionByBookkeepingIdAndAndTypeOfDocumentId(Long bookkeepingId, Long documentId);
}
