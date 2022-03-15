package main.repository;

import main.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document getDocumentById(Long id);
    List<Document> getDocumentsByUserId(Long userId);
    Boolean existsDocumentByTypeOfDocumentIdAndUserId(Long typeOfDocumentId, Long userId);
}
