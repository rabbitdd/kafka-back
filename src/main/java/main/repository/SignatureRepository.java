package main.repository;

import main.entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
    Signature getSignatureById(Long id);
    ArrayList<Signature> getSignaturesByParametersId(Long id);

}
