package com.federal.checklist.controller;

import com.federal.checklist.service.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogController {

    @Autowired
    LogDataService logDataService;

    @GetMapping("/logChecklistData")
    public ResponseEntity<Void> logChecklistData(
            @RequestParam String username,
            @RequestParam String designation,
            @RequestParam String department
    ) {
        logDataService.saveLogData(username, designation, department);

        // Create HttpHeaders and add security headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");

        // Return response with headers
        return ResponseEntity.noContent()
                .headers(headers)
                .build();
    }
}
