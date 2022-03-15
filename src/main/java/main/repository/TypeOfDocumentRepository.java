package main.repository;

import main.entity.TypeOfDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfDocumentRepository extends JpaRepository<TypeOfDocument, Long> {
    TypeOfDocument getTypeOfDocumentById(Long id);
}
