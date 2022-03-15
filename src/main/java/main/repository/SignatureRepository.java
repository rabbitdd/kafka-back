package main.repository;

import main.entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
    Signature getSignatureById(Long id);
}
