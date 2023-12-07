package com.likelion.voca.controller;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import com.likelion.voca.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/words")
// @CrossOrigin(origins = "https://6754-2001-2d8-f0a1-5886-d110-4dd0-5558-bbd5.ngrok-free.app")
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

        // 데이터가 존재할 경우 OK 상태코드와 함께 역순으로 된 데이터 반환
        Collections.reverse(cnTableFields);

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

        // 데이터가 존재할 경우 OK 상태코드와 함께 역순으로 된 데이터 반환
        Collections.reverse(enTableFields);

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

        // 데이터가 존재할 경우 OK 상태코드와 함께 역순으로 된 데이터 반환
        Collections.reverse(jpTableFields);

        // 데이터가 존재할 경우 OK 상태코드와 함께 데이터 반환
        return ResponseEntity.ok(jpTableFields);
    }

    // "/words/cn" 엔드포인트로 POST 요청이 오면 중국어 단어를 저장
    @PostMapping("/cn")
    public ResponseEntity<Void> addCnTable(@RequestBody CnTable cnTable) throws IOException {
        // 받아온 중국어 단어 정보를 서비스를 통해 저장
        vocaService.cnWrite(cnTable);
        return ResponseEntity.ok().build();
    }

    // "/words/en" 엔드포인트로 POST 요청이 오면 영어 단어를 저장
    @PostMapping("/en")
    public ResponseEntity<Void> addEnTable(@RequestBody EnTable enTable) throws IOException {
        // 받아온 영어 단어 정보를 서비스를 통해 저장
        vocaService.enWrite(enTable);
        return ResponseEntity.ok().build();
    }

    // "/words/jp" 엔드포인트로 POST 요청이 오면 일본어 단어를 저장
    @PostMapping("/jp")
    public ResponseEntity<Void> addJpTable(@RequestBody JpTable jpTable) throws IOException {
        // 받아온 일본어 단어 정보를 서비스를 통해 저장
        vocaService.jpWrite(jpTable);
        return ResponseEntity.ok().build();
    }

    // "/words/cn/{특정 단어 객체의 id 값}" 엔드포인트로 DELETE 요청이 오면 중국어 단어를 삭제
    @DeleteMapping("/cn/{id}")
    public ResponseEntity<Void> deleteCnTable(@PathVariable("id") Integer id) {
        // 넘겨준 중국어 단어의 id 값을 통해 삭제)
        vocaService.cnDelete(id);
        return ResponseEntity.ok().build();
    }

    // "/words/en/{특정 단어 객체의 id 값}" 엔드포인트로 DELETE 요청이 오면 영어 단어를 삭제
    @DeleteMapping("/en/{id}")
    public ResponseEntity<Void> deleteEnTable(@PathVariable("id") Integer id) {
        // 넘겨준 영어 단어의 id 값을 통해 삭제
        vocaService.enDelete(id);
        return ResponseEntity.ok().build();
    }

    // "/words/jp/{특정 단어 객체의 id 값}" 엔드포인트로 DELETE 요청이 오면 일본어 단어를 삭제
    @DeleteMapping("/jp/{id}")
    public ResponseEntity<Void> deleteJpTable(@PathVariable("id") Integer id) {
        // 넘겨준 일본어 단어의 id 값을 통해 삭제
        vocaService.jpDelete(id);
        return ResponseEntity.ok().build();
    }

    // "/words/cn/{id}" 엔드포인트로 PUT 요청이 오면 중국어 단어를 수정
    @PutMapping("/cn/{id}")
    public ResponseEntity<Void> updateCnWord(@PathVariable Integer id, @RequestBody CnTable updateCnTable) {
        // 업데이트된 중국어 단어 정보를 서비스를 통해 업데이트
        vocaService.updateCnWord(id, updateCnTable);
        return ResponseEntity.ok().build();
    }

    // "/words/en/{id}" 엔드포인트로 PUT 요청이 오면 영어 단어를 수정
    @PutMapping("/en/{id}")
    public ResponseEntity<Void> updateEnWord(@PathVariable Integer id, @RequestBody EnTable updateEnTable) {
        // 업데이트된 영어 단어 정보를 서비스를 통해 업데이트
        vocaService.updateEnWord(id, updateEnTable);
        return ResponseEntity.ok().build();
    }

    // "/words/jp/{id}" 엔드포인트로 PUT 요청이 오면 일본어 단어를 수정
    @PutMapping("/jp/{id}")
    public ResponseEntity<Void> updateJpWord(@PathVariable Integer id, @RequestBody JpTable updateJpTable) {
        // 업데이트된 일본어 단어 정보를 서비스를 통해 업데이트
        vocaService.updateJpWord(id, updateJpTable);
        return ResponseEntity.ok().build();
    }
}

// 컨트롤러는 클라이언트(웹 브라우저, 모바일 앱 등)로부터의 HTTP 요청을 받아들이고, 해당 요청을 처리하는 데 필요한 작업을 수행
// 컨트롤러는 사용자 요청을 받아 서비스 계층으로 전달하고, 서비스 계층에서 수행된 비즈니스 로직의 결과를 받아 응답을 생성