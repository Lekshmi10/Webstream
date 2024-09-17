package com.federal.checklist.controller;

import com.federal.checklist.model.Documents;

import com.federal.checklist.model.Scheme;
import com.federal.checklist.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DocumentsController {


        @Autowired
        DocumentsService documentsService;



        @PostMapping("/addDocumentsData")
        public Documents addDocumentsData(@RequestBody Documents documents) {
            return documentsService.addDocumentsData(documents);
        }

        @GetMapping("/getDocumentsData")
        public String getMandatoryDocumentsData(@RequestParam String accountType ,@RequestParam String customerType,@RequestParam String subConstitution,@RequestParam String schemeType,@RequestParam String constitutionType ){
            return documentsService.getMandatoryDocumentsData(accountType ,customerType,subConstitution,schemeType,constitutionType);
        }
    }

