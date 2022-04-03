package main.controller;


import main.entity.*;
import main.repository.DocumentRepository;
import main.service.DocumentService;
import main.service.PrivilegesService;
import main.service.TypeOfDocumentService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    UserService userService;

    @Autowired
    TypeOfDocumentService typeOfDocumentService;

    @Autowired
    PrivilegesService privilegesService;


    @GetMapping("/document/get")
    String sayDocument(@RequestParam Long id) {
        return documentService.getDocumentById(id).toString();
    }

    @GetMapping("/document/status/get")
    String getStatus(@RequestParam Long id) {
        return documentService.getStatusById(id).toString();
    }

    @GetMapping("/document/type_of_document/get")
    String getTypeOfDocument(@RequestParam Long id) {
        return documentService.getTypeOfDocumentId(id).toString();
    }

    @GetMapping("/document/signatures/get")
    String getSignatures(@RequestParam Long id) {
        return documentService.getSignatureById(id).toString();
    }


    @GetMapping("/document/production/get")
    String getProduction(@RequestParam Long id) {
        return documentService.getProductionById(id).toString();
    }

    @GetMapping("/document/privileges/get")
    String getPrivileges(@RequestParam Long id) {
        return documentService.getPrivilegesById(id).toString();
    }

    @GetMapping("/document/parameter/get")
    String getParameter(@RequestParam Long id) {
        return documentService.getParameterById(id).toString();
    }

    @GetMapping("/document/bookkeeping/get")
    String getBookkeeping(@RequestParam Long id) {
        return documentService.getBookkeepingById(id).toString();
    }

    @GetMapping("/getAll")
    List<BackVals> getDocumentsById(@RequestParam("login") String id) {
        long idd = userService.getUserId(id);
        List<Document> documents = documentService.getAllDocumentsByUserId(idd);
        List<BackVals> backVals = new ArrayList<>();
        if (documents != null) {
            for(int i = 0; i < documents.size(); i++){
                BackVals bv = new BackVals();
                bv.setId(documents.get(i).getId());
                TypeOfDocument typeOfDocument = typeOfDocumentService.getById(documents.get(i).getTypeOfDocumentId());
                bv.setValidity(documents.get(i).getValidity());
                bv.setIssue(documents.get(i).getDateOfIssue());
                bv.setName(typeOfDocument.getName());
                bv.setBywhom(documents.get(i).getIssuedByWhom());
                backVals.add(bv);
            }
            return backVals;
        }
        return backVals;
    }

//    @GetMapping("/getPod")
//    List<BackValsTypes> getPodpicy(@RequestParam("login") String id) {
//
//    }

    @GetMapping("/document/getTypeOfDocumentByUserIdWhichNotExist")
    List<TypeOfDocument> getTypeOfDocumentByUserIdWhichNotExist(@RequestParam Long id) {
        return documentService.getNameTypeOfDocumentsWhichNotExistInDocuments(id);
    }

    @PostMapping ("/addDocument")
    String addDocument(@RequestBody DockumentToAdd document){
        Document document1 = new Document();
        long id = userService.getUserId(document.getLogin());
        long id2 = -1;
        System.out.println(id);
        document1.setDateOfIssue(document.getDate1());
        System.out.println(document.getName());
        document1.setIssuedByWhom(document.getBywhom());
        document1.setParameters_id(null);
        document1.setUserId(id);
        document1.setValidity(document.getDate2());
        List<TypeOfDocument> somelist = typeOfDocumentService.getTypes(1);
        for (TypeOfDocument typeOfDocument : somelist) {
            if (typeOfDocument.getName().equals(document.getName()))
                id2 = typeOfDocument.getId();
        }
        document1.setTypeOfDocumentId(id2);
        return documentService.addDocument(document1);
    }

    @PostMapping ("/addDocumentPrior")
    String addDocumentPrior(@RequestBody DocumentToAddPrior document){
        long id1 = -1;
        long id = userService.getUserId(document.getLogin());
        Document document1 = new Document();
        TypeOfDocument typeOfDocument = new TypeOfDocument();
        Privileges privileges = new Privileges();
        privileges.setCoeffSign((long) 1);
        privileges.setPriority(document.getPrior());
        privileges.setSale(document.getSale());
        typeOfDocument.setInstanceId((long) 1);
        typeOfDocument.setName(document.getName());
        long id3 = -1;
        List<Privileges> priv = privilegesService.getAll(document.getSale());
        for (Privileges  priveleg : priv) {
            if (priveleg.getPriority() == document.getPrior() && privileges.getSale() == document.getSale())
                id3 = priveleg.getId();
        }
        if(id3 == -1){
            privilegesService.addPrivileges(privileges);
            List<Privileges> privv = privilegesService.getAll(document.getSale());
            for (Privileges  priveleg : privv) {
                if (priveleg.getPriority() == document.getPrior() && privileges.getSale() == document.getSale())
                    id3 = priveleg.getId();
            }
        }
        typeOfDocument.setPrivilegesId(id3);
        long id2 = -1;
        List<TypeOfDocument> somelist = typeOfDocumentService.getTypes(1);
        for (TypeOfDocument typeOfDocuments : somelist) {
            if (typeOfDocuments.getName().equals(document.getName()))
                id2 = typeOfDocuments.getId();
        }
        if(id2 == -1){
            typeOfDocumentService.addTypeOfDocument(typeOfDocument);
            List<TypeOfDocument> somelistt = typeOfDocumentService.getTypes(1);
            for (TypeOfDocument typeOfDocuments : somelistt) {
                if (typeOfDocuments.getName().equals(document.getName()))
                    id2 = typeOfDocuments.getId();
            }
        }
        document1.setTypeOfDocumentId(id2);
        document1.setUserId(id);
        document1.setDateOfIssue(document.getDate1());
        System.out.println(document.getName());
        document1.setIssuedByWhom(document.getBywhom());
        document1.setParameters_id(null);
        return documentService.addDocument(document1);
    }




}
