package com.likelion.voca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // 롬복의 @Data 어노테이션을 사용하여 Getter 와 Setter 를 자동으로 생성

@Entity // JPA 엔티티임을 나타낸다. 이 클래스는 데이터베이스의 테이블과 매핑
@Data // Lombok 에서 제공하는 어노테이션으로, getter, setter, toString, equals, hashCode 등을 자동으로 생성
public class CnTable {

    @Id // PK 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 주키를 데이터베이스에 위임하고 데이터베이스에서 자동으로 생성되는 값을 사용
    private Integer id; // primary key 인 id의 타입은 Integer 로 지정

    private String word;

    private String meaning;

    private String pronunciation;
}
// 엔티티 클래스는 데이터베이스의 특정 테이블과 매핑