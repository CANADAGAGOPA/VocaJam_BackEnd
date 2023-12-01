package com.likelion.voca.controller;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import com.likelion.voca.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/jp")
    public ResponseEntity<List<JpTable>> searchJpWord(@RequestParam String word) {
        try {
            List<JpTable> result = searchService.searchJpWord(word);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/en")
    public ResponseEntity<List<EnTable>> searchEnWord(@RequestParam String word) {
        try {
            List<EnTable> result = searchService.searchEnWord(word);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cn")
    public ResponseEntity<List<CnTable>> searchCnWord(@RequestParam String word) {
        try {
            List<CnTable> result = searchService.searchCnWord(word);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
