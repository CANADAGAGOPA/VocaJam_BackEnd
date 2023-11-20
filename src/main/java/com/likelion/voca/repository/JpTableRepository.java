package com.likelion.voca.repository;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.JpTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpTableRepository extends JpaRepository<JpTable, Integer> {

    Page<JpTable> findByMeaningContaining(String searchKeyword, Pageable pageable);

    Page<CnTable> findByWordContaining(String searchKeyword, Pageable pageable);
}
