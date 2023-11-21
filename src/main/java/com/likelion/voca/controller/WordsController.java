package com.likelion.voca.controller;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsController {

    @Autowired
    private VocaService vocaService;

    // "/words/cn" 엔드포인트로 GET 요청이 오면 중국어 단어 필드들을 반환
    @GetMapping("/cn")
    public ResponseEntity<List<CnTable>> getCnTableFields() {
        List<CnTable> cnTableFields = vocaService.getAllCnTableFields();

        // 만약 데이터가 없을 경우 NOT_FOUND 상태코드 반환
        if (cnTableFields.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 데이터가 존재할 경우 OK 상태코드와 함께 데이터 반환
        return ResponseEntity.ok(cnTableFields);
    }
}
