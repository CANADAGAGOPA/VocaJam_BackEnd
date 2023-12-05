package com.likelion.voca.controller;

import com.likelion.voca.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService GameService;

    private Set<String> usedWords = new HashSet<>(); // 중복된 단어를 방지하기 위한 캐시

    @Autowired
    public GameController(GameService gameService) {
        this.GameService = gameService;
    }

    @GetMapping("/jp")
    public ResponseEntity<Map<String, String>> getJPWordGame() {
        // 중복을 피하기 위해 새로운 단어 가져오기
        String newWord;
        do {
            Map<String, String> randomJPWordAndMeaning = GameService.getRandomJPWordAndMeaning();
            newWord = randomJPWordAndMeaning.get("word");
            // 중복된 단어를 방지하기 위해 사용된 단어 목록에 추가
            usedWords.add(newWord);
        } while (!usedWords.add(newWord)); // 중복된 단어가 나올 때까지 반복

        Map<String, String> wordAndMeaning = GameService.getRandomJPWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = GameService.getRandomOtherJPMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("pronunciation", wordAndMeaning.get("pronunciation"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/cn")
    public ResponseEntity<Map<String, String>> getCNWordGame() {
        // 중복을 피하기 위해 새로운 단어 가져오기
        String newWord;
        do {
            newWord = GameService.getRandomCNWordAndMeaning().get("word");
        } while (!usedWords.add(newWord)); // 중복된 단어가 나올 때까지 반복
        // 랜덤한 중국어 단어와 해당 단어의 의미를 가져오기
        Map<String, String> wordAndMeaning = GameService.getRandomCNWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = GameService.getRandomOtherCNMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("pronunciation", wordAndMeaning.get("pronunciation"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/en")
    public ResponseEntity<Map<String, String>> getENWordGame() {
        // 중복을 피하기 위해 새로운 단어 가져오기
        String newWord;
        do {
            newWord = GameService.getRandomENWordAndMeaning().get("word");
        } while (!usedWords.add(newWord)); // 중복된 단어가 나올 때까지 반복

        // 랜덤한 영어 단어와 해당 단어의 의미를 가져오기
        Map<String, String> wordAndMeaning = GameService.getRandomENWordAndMeaning();

        // 랜덤한 세 개의 다른 의미를 가져오기
        List<String> otherMeanings = GameService.getRandomOtherENMeanings(wordAndMeaning.get("meaning"));

        // 응답에 필요한 데이터 구성
        Map<String, String> response = new HashMap<>();
        response.put("word", wordAndMeaning.get("word"));
        response.put("meaning", wordAndMeaning.get("meaning"));
        response.put("otherMeaning1", otherMeanings.get(0));
        response.put("otherMeaning2", otherMeanings.get(1));
        response.put("otherMeaning3", otherMeanings.get(2));

        return ResponseEntity.ok(response);
    }
}
