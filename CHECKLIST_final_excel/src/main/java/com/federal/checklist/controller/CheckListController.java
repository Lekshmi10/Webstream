package com.federal.checklist.controller;

import com.federal.checklist.service.ChecklistService;
import com.federal.checklist.service.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CheckListController {

    @Autowired
    ChecklistService checklistService;
    @Autowired
    LogDataService logDataService;

    @GetMapping("/getChecklistData")
    public ResponseEntity<String> getChecklistData(
            @RequestParam String documentName,
            @RequestParam String subConstitution,
            @RequestParam String customerType
    ) {
        String responseData = checklistService.getChecklistData(documentName, subConstitution, customerType);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseData);
    }

}