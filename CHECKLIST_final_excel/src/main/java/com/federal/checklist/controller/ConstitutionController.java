package com.federal.checklist.controller;


import com.federal.checklist.service.ConsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConstitutionController {

    @Autowired
    ConsitutionService constitutionService;

    @GetMapping("/getConstitutionData")
    public ResponseEntity<String> getConstitutionData(
            @RequestParam String accountType,
            @RequestParam String customerType,
            @RequestParam String specialScheme
    ) {
        String responseData = constitutionService.getConstitutionData(accountType, customerType, specialScheme);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseData);
    }

    @GetMapping("/getSubConstitutionData")
    public ResponseEntity<String> getSubConstitutionData(
            @RequestParam String constitution,
            @RequestParam String accountType
    ) {
        String responseData = constitutionService.getSubConstitutionData(constitution, accountType);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseData);
    }
}
