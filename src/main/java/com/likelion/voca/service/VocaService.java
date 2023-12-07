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

    @Autowired // 테이블 리포지토리 객체를 자동으로 연결
    private CnTableRepository cnTableRepository;

    @Autowired
    private EnTableRepository enTableRepository;

    @Autowired
    private JpTableRepository jpTableRepository;

    // 중국어 단어 작성 처리 (테이블에 저장하는 역할을 수행)
    public void cnWrite(CnTable cnTable){

        cnTableRepository.save(cnTable); // JPA 에서 제공하는 기능을 사용
    }

    // 영어 단어 작성 처리
    public void enWrite(EnTable enTable){

        enTableRepository.save(enTable);
    }

    // 일본어 단어 작성 처리
    public void jpWrite(JpTable jpTable){

        jpTableRepository.save(jpTable);
    }

    // 중국어 단어의 필드들을 리스트의 형태로 가져오는 메서드
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

    // 중국어 단어 수정 처리
    public void updateCnWord(Integer id, CnTable updateCnTable) {

        // 기존 중국어 단어를 불러와서 업데이트
        CnTable existingCnTable = cnTableRepository.findById(id).orElse(null);

        // 업데이트할 내용을 기존 데이터에 복사
        existingCnTable.setWord(updateCnTable.getWord());
        existingCnTable.setMeaning(updateCnTable.getMeaning());
        existingCnTable.setPronunciation(updateCnTable.getPronunciation());

        // 업데이트된 데이터를 저장
        cnTableRepository.save(existingCnTable);
    }

    // 영어 단어 수정 처리
    public void updateEnWord(Integer id, EnTable updateEnTable) {

        // 기존 영어 단어를 불러와서 업데이트하는 로직
        EnTable existingEnTable = enTableRepository.findById(id).orElse(null);

        // 업데이트할 내용을 기존 데이터에 복사
        existingEnTable.setWord(updateEnTable.getWord());
        existingEnTable.setMeaning(updateEnTable.getMeaning());

        // 업데이트된 데이터를 저장
        enTableRepository.save(existingEnTable);
    }

    // 일본어 단어 수정 처리
    public void updateJpWord(Integer id, JpTable updateJpTable) {

        // 기존 일본어 단어를 불러와서 업데이트하는 로직
        JpTable existingJpTable = jpTableRepository.findById(id).orElse(null);

        // 업데이트할 내용을 기존 데이터에 복사
        existingJpTable.setWord(updateJpTable.getWord());
        existingJpTable.setMeaning(updateJpTable.getMeaning());
        existingJpTable.setPronunciation(updateJpTable.getPronunciation());

        // 업데이트된 데이터를 저장
        jpTableRepository.save(existingJpTable);
    }
}

// 비즈니스 로직을 처리하고, 이를 통해 데이터베이스와의 상호작용이나 다양한 작업을 수행
