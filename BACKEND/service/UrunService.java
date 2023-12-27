package com.example.finderproject.projeclass.GenelSınıflar.service;

import com.example.finderproject.projeclass.Decorator.KuponDecorator;
import com.example.finderproject.projeclass.Decorator.TemelUrun;
import com.example.finderproject.projeclass.GenelSınıflar.URUN;
import com.example.finderproject.projeclass.GenelSınıflar.repository.UrunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UrunService {
    @Autowired
    private UrunRepository urunRepository;

    @Autowired
    public UrunService(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    public List<Object[]> searchAndCompareProducts(String searchKeyword) {
        return urunRepository.searchAndCompareProducts(searchKeyword);
    }


    }


