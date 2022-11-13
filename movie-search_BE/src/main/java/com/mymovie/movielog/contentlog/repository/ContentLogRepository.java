package com.mymovie.movielog.contentlog.repository;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContentLogRepository extends JpaRepository<ContentLog, Long> {

    Optional<ContentLog> findByContentId(Long contentId);
    List<ContentLog> findByKakaoId(@Param("id") String kakaoId);
}
