package com.federal.checklist.controller;

import com.federal.checklist.model.Constitution;
import com.federal.checklist.service.ConsitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConstitutionController {

    @Autowired
    ConsitutionService consitutionService;

    @PostMapping("/addConstitutionData")
    public Constitution addConstitutionData(@RequestBody Constitution constitution) {
        return consitutionService.addConstitutionData(constitution);
    }

    @GetMapping("/getConstitutionData")
    public String getConstitutionData(@RequestParam String accountType ,@RequestParam String customerType,@RequestParam String specialScheme) {
        return consitutionService.getConstitutionData(accountType,customerType,specialScheme);
    }

    @GetMapping("/getSubConstitutionData")
    public String getSubConstitutionData(@RequestParam String constitution ,@RequestParam String accountType) {
        return consitutionService.getSubConstitutionData(constitution,accountType);
    }
}
