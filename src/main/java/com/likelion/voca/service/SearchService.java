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
public class SearchService {
    private final JpTableRepository jpTableRepository;
    private final EnTableRepository enTableRepository;
    private final CnTableRepository cnTableRepository;

    private List<JpTable> resultByJpWord;
    private List<JpTable> resultByJpMeaning;
    private List<EnTable> resultByEnWord;
    private List<EnTable> resultByEnMeaning;
    private List<CnTable> resultByCnWord;
    private List<CnTable> resultByCnMeaning;

    @Autowired
    public SearchService(JpTableRepository jpTableRepository, EnTableRepository enTableRepository, CnTableRepository cnTableRepository) {
        this.jpTableRepository = jpTableRepository;
        this.enTableRepository = enTableRepository;
        this.cnTableRepository = cnTableRepository;
    }

    public List<JpTable> searchJpWord(String Search_Word) {
        // 빈 문자열 또는 null 체크
        if (Search_Word == null || Search_Word.trim().isEmpty()) {
            return null; // 빈 결과 반환
        }
        // 단어 또는 뜻에서 검색
        resultByJpWord = jpTableRepository.findByWordContaining(Search_Word);

        if (resultByJpWord.isEmpty()) {
            resultByJpMeaning = jpTableRepository.findByMeaningContaining(Search_Word);
            return resultByJpMeaning;
        }
        // 모든 결과 반환
        return resultByJpWord;
    }

    public List<EnTable> searchEnWord(String Search_Word) {
        // 빈 문자열 또는 null 체크
        if (Search_Word == null || Search_Word.trim().isEmpty()) {
            return null; // 빈 결과 반환
        }
        // 단어 또는 뜻에서 검색
        resultByEnWord = enTableRepository.findByWordContaining(Search_Word);

        if (resultByEnWord.isEmpty()) {
            resultByEnMeaning = enTableRepository.findByMeaningContaining(Search_Word);
            return resultByEnMeaning;
        }
        // 모든 결과 반환
        return resultByEnWord;
    }

    public List<CnTable> searchCnWord(String Search_Word) {
        // 빈 문자열 또는 null 체크
        if (Search_Word == null || Search_Word.trim().isEmpty()) {
            return null; // 빈 결과 반환
        }
        // 단어 또는 뜻에서 검색
        resultByCnWord = cnTableRepository.findByWordContaining(Search_Word);

        if (resultByCnWord.isEmpty()) {
            resultByCnMeaning = cnTableRepository.findByMeaningContaining(Search_Word);
            return resultByCnMeaning;
        }
        // 모든 결과 반환
        return resultByCnWord;
    }
}
