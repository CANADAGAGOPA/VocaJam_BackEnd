package com.likelion.voca.service;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import com.likelion.voca.repository.CnTableRepository;
import com.likelion.voca.repository.EnTableRepository;
import com.likelion.voca.repository.JpTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VocaService {

    @Autowired
    private CnTableRepository cnTableRepository;

    @Autowired
    private EnTableRepository enTableRepository;

    @Autowired
    private JpTableRepository jpTableRepository;
    private Object Collections;

    // 중국어 단어 작성 처리
    public void cnWrite(CnTable cnTable){

        cnTableRepository.save(cnTable);
    }

    // 영어 단어 작성 처리
    public void enWrite(EnTable enTable){

        enTableRepository.save(enTable);
    }

    // 일본어 단어 작성 처리
    public void jpWrite(JpTable jpTable){

        jpTableRepository.save(jpTable);
    }

    // 중국어 단어의 필드들을 리스트로 가져오는 메서드
    public List<CnTable> getAllCnTableFields() {
        return cnTableRepository.findAll();
    }

    // 영어 단어의 필드들을 리스트로 가져오는 메서드
    public List<EnTable> getAllEnTableFields() {
        return enTableRepository.findAll();
    }

    // 일본어 단어의 필드들을 리스트로 가져오는 메서드
    public List<JpTable> getAllJpTableFields() {
        return jpTableRepository.findAll();
    }

    // 중국어 단어 삭제 처리
    public void cnDelete(Integer id) {

        cnTableRepository.deleteById(id);
    }

    // 영어 단어 삭제 처리
    public void enDelete(Integer id) {

        enTableRepository.deleteById(id);
    }

    // 일본어 단어 삭제 처리
    public void jpDelete(Integer id) {

        jpTableRepository.deleteById(id);
    }

    public Map<String, String> getRandomJapaneseWordAndMeaning() {
        List<JpTable> allWords = jpTableRepository.findAll();
        JpTable randomWord = allWords.get(new Random().nextInt(allWords.size()));

        Map<String, String> result = new HashMap<>();
        result.put("word", randomWord.getWord());
        result.put("meaning", randomWord.getMeaning());
        return result;
    }

    public List<String> getRandomOtherMeanings(String correctMeaning) {
        List<JpTable> allWords = jpTableRepository.findAll();

        // 랜덤하게 순서를 섞기
        List<JpTable> shuffledWords = getRandomShuffle(allWords);

        List<String> otherMeanings = new ArrayList<>();
        int count = 0;

        for (JpTable word : shuffledWords) {
            // 정답과 같은 의미인 경우 건너뛰기
            if (correctMeaning == null || !correctMeaning.equals(word.getMeaning())) {
                otherMeanings.add(word.getMeaning());
                count++;

                // 세 개의 다른 의미를 찾았다면 종료
                if (count == 3) {
                    break;
                }
            }
        }

        return otherMeanings;
    }

    private List<JpTable> getRandomShuffle(List<JpTable> inputList) {
        List<JpTable> result = new ArrayList<>(inputList);
        Random random = new Random();

        for (int i = result.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            JpTable temp = result.get(index);
            result.set(index, result.get(i));
            result.set(i, temp);
        }

        return result;
    }

}
