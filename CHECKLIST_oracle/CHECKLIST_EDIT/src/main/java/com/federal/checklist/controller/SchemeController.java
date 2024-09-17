package com.federal.checklist.controller;

import com.federal.checklist.model.Scheme;
import com.federal.checklist.service.ConsitutionService;
import com.federal.checklist.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class SchemeController {

    @Autowired
    ConsitutionService consitutionService;

    @Autowired
    SchemeService schemeService;

    @PostMapping("/addSchemeData")
    public Scheme addSchemeData(@RequestBody Scheme scheme) {
        return schemeService.addSchemeData(scheme);
    }

    @GetMapping("/getSchemes")
    public String getSchemeData(@RequestParam String sectionName) {
        return schemeService.getSchemeData(sectionName);
    }

}
