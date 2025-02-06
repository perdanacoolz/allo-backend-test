package com.allobank.allobackendtest.controller;

 
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.CalegPage;
import com.allobank.allobackendtest.model.CalegSearchCriteria;
import com.allobank.allobackendtest.service.CalegService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calegs")
public class CalegController {

    private final CalegService calegService;
@Autowired
    public CalegController(CalegService calegService) {
        this.calegService = calegService;
    }

    @GetMapping
    public ResponseEntity<Page<Caleg>> getCalegs(CalegPage calegPage,
                                                       CalegSearchCriteria calegSearchCriteria){
        return new ResponseEntity<>(calegService.getCalegs(calegPage, calegSearchCriteria),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Caleg> addCaleg(@RequestBody Caleg employee){
        return new ResponseEntity<>(calegService.addCaleg(employee), HttpStatus.OK);
    }
}