package main.repository;

import main.entity.TypeOfDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeOfDocumentRepository extends JpaRepository<TypeOfDocument, Long> {
    TypeOfDocument getTypeOfDocumentById(Long id);
    List<TypeOfDocument> getTypeOfDocumentsByInstanceId(Long instanceId);
}
