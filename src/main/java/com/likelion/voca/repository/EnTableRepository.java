package com.likelion.voca.repository;

import com.likelion.voca.entity.CnTable;
import com.likelion.voca.entity.EnTable;
import com.likelion.voca.entity.JpTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnTableRepository extends JpaRepository<EnTable, Integer> {
    List<EnTable> findByMeaningContaining(String searchKeyword);
    List<EnTable> findByWordContaining(String searchKeyword);
}
