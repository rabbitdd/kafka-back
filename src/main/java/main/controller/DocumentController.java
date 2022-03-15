package main.controller;


import main.repository.DocumentRepository;
import main.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

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

}
