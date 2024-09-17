package com.federal.checklist.controller;

import com.federal.checklist.model.Checklist;
import com.federal.checklist.model.ChecklistLogData;
import com.federal.checklist.model.Constitution;
import com.federal.checklist.service.ChecklistService;
import com.federal.checklist.service.ConsitutionService;
import com.federal.checklist.service.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CheckListController {

    @Autowired
    ChecklistService checklistService;
    @Autowired
    LogDataService logDataService;

    @PostMapping("/addChecklistData")
    public Checklist addChecklistData(@RequestBody Checklist checklist) {
        return checklistService.addChecklistData(checklist);
    }

    @GetMapping("/getChecklistData")
    public String getChecklistData(@RequestParam String documentName,@RequestParam String subConstitution,@RequestParam String customerType) {
        return checklistService.getChecklistData(documentName,subConstitution,customerType);
    }

    @GetMapping("/logChecklistData")
    public void logChecklistData(@RequestParam  String username,@RequestParam String designation,@RequestParam String department) {
         logDataService.saveLogData(username,designation,department);
    }


}