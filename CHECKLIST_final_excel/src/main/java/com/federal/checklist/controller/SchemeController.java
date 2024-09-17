package com.federal.checklist.controller;

import com.federal.checklist.service.ConsitutionService;
import com.federal.checklist.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class SchemeController {

    @Autowired
    ConsitutionService consitutionService;

    @Autowired
    SchemeService schemeService;

    @GetMapping("/getSchemes")
    public ResponseEntity<String> getSchemeData(@RequestParam String sectionName, HttpServletResponse response) {

        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");

        String responseData = schemeService.getSchemeData(sectionName);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Content-Type-Options", "nosniff");
        headers.add("Strict-Transport-Security", "max-age=31536000");


        return ResponseEntity.ok()
                .headers(headers)
                .body(responseData);
    }
}
