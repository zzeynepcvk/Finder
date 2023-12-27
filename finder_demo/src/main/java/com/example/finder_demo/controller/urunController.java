package com.example.finder_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.finder_demo.service.*;


import java.util.List;

@RestController
@RequestMapping("/urun")

public class urunController {
    private urunService urunService;

    @Autowired
    private urunController(urunService urunService) {
        this.urunService = urunService;
    }
    @GetMapping("/products")
    public ResponseEntity<List<Object[]>> searchAndCompare(@RequestParam String searchKeyword) {
        List<Object[]> result = urunService.searchAndCompareProducts(searchKeyword);
        return new ResponseEntity<>(result, HttpStatus.OK);
}

}



