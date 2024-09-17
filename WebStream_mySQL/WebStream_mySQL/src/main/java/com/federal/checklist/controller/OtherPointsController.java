package com.federal.checklist.controller;

import com.federal.checklist.model.OtherPoints;
import com.federal.checklist.service.OtherPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OtherPointsController {

    @Autowired
    OtherPointsService otherPointsService;

    @PostMapping("/addOtherPointsData")
    public OtherPoints addOtherPointsData(@RequestBody OtherPoints otherPoints)  {
        return otherPointsService.addOtherPointsData(otherPoints);
    }

    @GetMapping("/getOtherPointsData")
    public String getChecklistData(@RequestParam String subConstitution) {
        return otherPointsService.getOtherPointsData(subConstitution);
    }
}
