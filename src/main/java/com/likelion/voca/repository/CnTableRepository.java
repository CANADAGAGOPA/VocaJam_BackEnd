package com.likelion.voca.repository;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.JpTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //  Spring Data JPA 를 사용하여 데이터베이스와 상호작용하는데 사용되는 CnTable 엔티티의 리포지토리를 정의
public interface
CnTableRepository extends JpaRepository<CnTable, Integer> {
    // Jpa 레포지토리를 상속, 제네릭<>으로 엔티티와 pk로 지정한 값의 타입을 지정해준다.
    List<CnTable> findByMeaningContaining(String searchKeyword);
    List<CnTable> findByWordContaining(String searchKeyword);
}
 //  데이터베이스와의 상호작용을 추상화하여 개발자가 직접 SQL을 작성하지 않고도 쉽게 데이터베이스에 접근