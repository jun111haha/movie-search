package com.mymovie.movielog.contentlog.service;

import com.mymovie.movielog.contentlog.repository.ContentLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContentLogService {
    private ContentLogRepository contentLogRepository;
}
