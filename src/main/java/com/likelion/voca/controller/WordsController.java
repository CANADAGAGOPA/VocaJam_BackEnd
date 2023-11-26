package com.likelion.voca.controller;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import com.likelion.voca.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    // "/words/en 엔드포인트로 GET 요청이 오면 영어 단어 필드들을 반환
    @GetMapping("/en")
    public ResponseEntity<List<EnTable>> getEnTableFields() {
        List<EnTable> enTableFields = vocaService.getAllEnTableFields();

        // 만약 데이터가 없을 경우 NOT_FOUND 상태코드 반환
        if (enTableFields.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 데이터가 존재할 경우 OK 상태코드와 함께 데이터 반환
        return ResponseEntity.ok(enTableFields);
    }

    // "/words/jp 엔드포인트로 GET 요청이 오면 일본어 단어 필드들을 반환
    @GetMapping("/jp")
    public ResponseEntity<List<JpTable>> getJpTableFields() {
        List<JpTable> jpTableFields = vocaService.getAllJpTableFields();

        // 만약 데이터가 없을 경우 NOT_FOUND 상태코드 반환
        if (jpTableFields.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // 데이터가 존재할 경우 OK 상태코드와 함께 데이터 반환
        return ResponseEntity.ok(jpTableFields);
    }

    // "/words/cn" 엔드포인트로 POST 요청이 오면 중국어 단어를 저장
    @PostMapping("/cn")
    public ResponseEntity<Void> updateCnTable(@RequestBody CnTable cnTable) throws IOException {
        // 받아온 중국어 단어 정보를 서비스를 통해 저장
        vocaService.cnWrite(cnTable);
        return ResponseEntity.ok().build();
    }

    // "/words/en" 엔드포인트로 POST 요청이 오면 영어 단어를 저장
    @PostMapping("/en")
    public ResponseEntity<Void> updateEnTable(@RequestBody EnTable enTable) throws IOException {
        // 받아온 영어 단어 정보를 서비스를 통해 저장
        vocaService.enWrite(enTable);
        return ResponseEntity.ok().build();
    }

    // "/words/jp" 엔드포인트로 POST 요청이 오면 일본어 단어를 저장
    @PostMapping("/jp")
    public ResponseEntity<Void> updateJpTable(@RequestBody JpTable jpTable) throws IOException {
        // 받아온 일본어 단어 정보를 서비스를 통해 저장
        vocaService.jpWrite(jpTable);
        return ResponseEntity.ok().build();
    }
}
