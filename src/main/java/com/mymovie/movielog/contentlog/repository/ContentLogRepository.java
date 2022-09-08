package com.mymovie.movielog.contentlog.repository;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentLogRepository extends JpaRepository<ContentLog, Long> {
}
