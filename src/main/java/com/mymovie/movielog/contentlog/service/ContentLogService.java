package com.mymovie.movielog.contentlog.service;

import com.mymovie.movielog.contentlog.dto.ContentLogSaveRequestDto;
import com.mymovie.movielog.contentlog.entity.ContentLog;
import com.mymovie.movielog.contentlog.exception.ContentLogSaveOverlapException;
import com.mymovie.movielog.contentlog.repository.ContentLogRepository;
import com.mymovie.movielog.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContentLogService {
    private final ContentLogRepository contentLogRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long contentLogInsert(ContentLogSaveRequestDto contentLogSaveRequestDto){

        memberRepository.findByKakaoId(contentLogSaveRequestDto.getKakaoId()).orElseThrow(() ->
                new IllegalArgumentException("사용자를 찾을수 없습니다."));

        Optional<ContentLog> contentLog
                = contentLogRepository.findByMovieId(contentLogSaveRequestDto.getMovieId());

        if(contentLog.isEmpty()){
            return contentLogRepository.save(contentLogSaveRequestDto.toEntity()).getContentSeq();
        } else if(!contentLog.isEmpty()
                && contentLogSaveRequestDto.getMovieId().equals(contentLog.get().getMovieId())){
            throw new ContentLogSaveOverlapException("영화 정보가 중복돼었습니다.");

        }
        return contentLogRepository.save(contentLogSaveRequestDto.toEntity()).getContentSeq();
    }
}
