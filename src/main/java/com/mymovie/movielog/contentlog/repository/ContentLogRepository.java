package com.mymovie.movielog.contentlog.repository;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentLogRepository extends JpaRepository<ContentLog, Long> {

    Optional<ContentLog> findByMovieId(Long movieId);
}
