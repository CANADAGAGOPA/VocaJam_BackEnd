package com.likelion.voca.service;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import com.likelion.voca.repository.CnTableRepository;
import com.likelion.voca.repository.EnTableRepository;
import com.likelion.voca.repository.JpTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VocaService {

    @Autowired
    private CnTableRepository cnTableRepository;

    @Autowired
    private EnTableRepository enTableRepository;

    @Autowired
    private JpTableRepository jpTableRepository;

    // 중국어 단어 작성 처리
    public void cnwrite(CnTable cnTable){

        cnTableRepository.save(cnTable);
    }

    // 영어 단어 작성 처리
    public void enwrite(EnTable enTable){

        enTableRepository.save(enTable);
    }

    // 일본어 단어 작성 처리
    public void jpwrite(JpTable jpTable){

        jpTableRepository.save(jpTable);
    }
}
