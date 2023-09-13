package com.pet.sitter.notice.repository;

import com.pet.sitter.common.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    //페이징 기능이 있는 질문 목록 조회
    Page<Notice> findAll(Pageable pageable);
}
