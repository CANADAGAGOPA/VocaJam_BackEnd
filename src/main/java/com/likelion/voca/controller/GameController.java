package com.likelion.voca.controller;

import com.likelion.voca.service.VocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private VocaService vocaService;



    @GetMapping("/jp")
    public ResponseEntity<Map<String, String>> getJapaneseWordGame() {
        // 랜덤한 일본어 단어와 해당 단어의 의미를 가져오기
        Map<String, String> wordAndMeaning = vocaService.getRandomJapaneseWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = vocaService.getRandomOtherMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }

/*
    @GetMapping("/cn")



    @GetMapping("/en")*/
}
