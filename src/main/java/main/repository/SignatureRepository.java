package main.repository;

import main.entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SignatureRepository extends JpaRepository<Signature, Long> {
    Signature getSignatureById(Long id);

    List<Signature> getSignatureByOfficialId(Long officialId);

    @Transactional
    @Procedure(procedureName = "verification_of_signatures")
    boolean verificationOfSignatures(@Param("parameters_id") Long parametersId);
}
