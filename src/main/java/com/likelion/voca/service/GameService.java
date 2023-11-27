package com.likelion.voca.service;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import com.likelion.voca.repository.CnTableRepository;
import com.likelion.voca.repository.EnTableRepository;
import com.likelion.voca.repository.JpTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    @Autowired
    private CnTableRepository cnTableRepository;

    @Autowired
    private EnTableRepository enTableRepository;

    @Autowired
    private JpTableRepository jpTableRepository;

    public Map<String, String> getRandomJPWordAndMeaning() {
        List<JpTable> allWords = jpTableRepository.findAll();
        JpTable randomWord = allWords.get(new Random().nextInt(allWords.size()));

        Map<String, String> result = new HashMap<>();
        result.put("word", randomWord.getWord());
        result.put("meaning", randomWord.getMeaning());
        result.put("pronunciation", randomWord.getPronunciation());
        return result;
    }

    public Map<String, String> getRandomCNWordAndMeaning() {
        List<CnTable> allWords = cnTableRepository.findAll();
        CnTable randomWord = allWords.get(new Random().nextInt(allWords.size()));

        Map<String, String> result = new HashMap<>();
        result.put("word", randomWord.getWord());
        result.put("meaning", randomWord.getMeaning());
        result.put("pronunciation", randomWord.getPronunciation());
        return result;
    }

    public Map<String, String> getRandomENWordAndMeaning() {
        List<EnTable> allWords = enTableRepository.findAll();
        EnTable randomWord = allWords.get(new Random().nextInt(allWords.size()));

        Map<String, String> result = new HashMap<>();
        result.put("word", randomWord.getWord());
        result.put("meaning", randomWord.getMeaning());
        return result;
    }

    public List<String> getRandomOtherJPMeanings(String correctMeaning) {
        List<JpTable> allWords = jpTableRepository.findAll();

        // 랜덤하게 순서를 섞기
        List<JpTable> shuffledWords = getJPRandomShuffle(allWords);

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

    public List<String> getRandomOtherCNMeanings(String correctMeaning) {
        List<CnTable> allWords = cnTableRepository.findAll();

        // 랜덤하게 순서를 섞기
        List<CnTable> shuffledWords = getCNRandomShuffle(allWords);

        List<String> otherMeanings = new ArrayList<>();
        int count = 0;

        for (CnTable word : shuffledWords) {
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

    public List<String> getRandomOtherENMeanings(String correctMeaning) {
        List<EnTable> allWords = enTableRepository.findAll();

        // 랜덤하게 순서를 섞기
        List<EnTable> shuffledWords = getENRandomShuffle(allWords);

        List<String> otherMeanings = new ArrayList<>();
        int count = 0;

        for (EnTable word : shuffledWords) {
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

    private List<JpTable> getJPRandomShuffle(List<JpTable> inputList) {
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

    private List<CnTable> getCNRandomShuffle(List<CnTable> inputList) {
        List<CnTable> result = new ArrayList<>(inputList);
        Random random = new Random();

        for (int i = result.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            CnTable temp = result.get(index);
            result.set(index, result.get(i));
            result.set(i, temp);
        }

        return result;
    }

    private List<EnTable> getENRandomShuffle(List<EnTable> inputList) {
        List<EnTable> result = new ArrayList<>(inputList);
        Random random = new Random();

        for (int i = result.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            EnTable temp = result.get(index);
            result.set(index, result.get(i));
            result.set(i, temp);
        }

        return result;
    }
}
