package com.federal.checklist.controller;

import com.federal.checklist.service.OtherPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OtherPointsController {

    @Autowired
    OtherPointsService otherPointsService;

    @GetMapping("/getOtherPointsData")
    public ResponseEntity<String> getChecklistData(@RequestParam String subConstitution) {
        String responseData = otherPointsService.getOtherPointsData(subConstitution);


        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseData);
    }
}
