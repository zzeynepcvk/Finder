package com.example.finder_demo.service;

import com.example.finder_demo.repository.urunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class urunService {
    @Autowired
    private urunRepository urunRepository;

    @Autowired
    public urunService(urunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    public List<Object[]> searchAndCompareProducts(String searchKeyword) {
        return urunRepository.searchAndCompareProducts(searchKeyword);
}


}