package com.federal.checklist.controller;

import com.federal.checklist.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DocumentsController {

        @Autowired
        DocumentsService documentsService;

    @GetMapping("/getDocumentsData")
    public ResponseEntity<String> getMandatoryDocumentsData(
            @RequestParam String accountType,
            @RequestParam String customerType,
            @RequestParam String subConstitution,
            @RequestParam String schemeType,
            @RequestParam String constitutionType
    ) {
        String responseData = documentsService.getDocumentsData(accountType, customerType, subConstitution, schemeType, constitutionType);

        // Create HttpHeaders and add security headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");

        // Return response with headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(responseData);
    }
    }

