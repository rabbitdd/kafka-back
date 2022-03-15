package main.service;

import main.entity.*;
import main.repository.*;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final StatusRepository statusRepository;
    private final TypeOfDocumentRepository typeOfDocumentRepository;
    private final SignatureRepository signatureRepository;
    private final ProductionRepository productionRepository;
    private final PrivilegesRepository privilegesRepository;
    private final ParameterRepository parameterRepository;
    private final BookkeepingRepository bookkeepingRepository;

    public DocumentService(DocumentRepository documentRepository, StatusRepository statusRepository, TypeOfDocumentRepository typeOfDocument, SignatureRepository signatureRepository, ProductionRepository productionRepository, PrivilegesRepository privilegesRepository, ParameterRepository parameterRepository, BookkeepingRepository bookkeepingRepository) {
        this.documentRepository = documentRepository;
        this.statusRepository = statusRepository;
        this.typeOfDocumentRepository = typeOfDocument;
        this.signatureRepository = signatureRepository;
        this.productionRepository = productionRepository;
        this.privilegesRepository = privilegesRepository;
        this.parameterRepository = parameterRepository;
        this.bookkeepingRepository = bookkeepingRepository;
    }

    public Document getDocumentById(Long id) {
        return documentRepository.getDocumentById(id);
    }
    public Status getStatusById(Long id) {
        return statusRepository.getStatusById(id);
    }

    public TypeOfDocument getTypeOfDocumentId(Long id) {
        return typeOfDocumentRepository.getTypeOfDocumentById(id);
    }

    public Signature getSignatureById(Long id) {
        return signatureRepository.getSignatureById(id);
    }

    public Production getProductionById(Long id) {
        return productionRepository.getProductionById(id);
    }

    public Privileges getPrivilegesById(Long id) {
        return privilegesRepository.getPrivilegesById(id);
    }

    public Parameter getParameterById(Long id) {
        return parameterRepository.getParameterById(id);
    }

    public Bookkeeping getBookkeepingById(Long id) {
        return bookkeepingRepository.getBookkeepingById(id);
    }

}
