package com.likelion.voca.repository;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.JpTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnTableRepository extends JpaRepository<CnTable, Integer> {
    // Jpa 레포지토리를 상속, 제네릭<>으로 엔티티와 pk로 지정한 값의 타입을 지정해준다.

    Page<CnTable> findByMeaningContaining(String searchKeyword, Pageable pageable);
    Page<CnTable> findByWordContaining(String searchKeyword, Pageable pageable);
}