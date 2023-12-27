package com.example.finderproject.projeclass.GenelSınıflar.controller;

import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import com.example.finderproject.projeclass.GenelSınıflar.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

//bu anotasyonu ekleyerek belirli bir origin'den gelen isteklere izin verilmiş olur
@CrossOrigin(origins = "http://frontend-domaini.com")
public class UrunController {

    private UrunService urunService;

    @Autowired
    public UrunController(UrunService urunService) {
        this.urunService = urunService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<Object[]>> searchAndCompare(@RequestParam String searchKeyword) {
        List<Object[]> result = urunService.searchAndCompareProducts(searchKeyword);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}

