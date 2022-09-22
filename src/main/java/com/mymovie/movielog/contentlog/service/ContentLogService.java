package com.mymovie.movielog.contentlog.service;

import com.mymovie.movielog.contentlog.dto.ContentLogMyContentResponseDto;
import com.mymovie.movielog.contentlog.dto.ContentLogSaveRequestDto;
import com.mymovie.movielog.contentlog.entity.ContentLog;
import com.mymovie.movielog.contentlog.entity.ContentLogQuerydslRepository;
import com.mymovie.movielog.contentlog.exception.ContentLogSaveOverlapException;
import com.mymovie.movielog.contentlog.repository.ContentLogRepository;
import com.mymovie.movielog.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContentLogService {
    private final ContentLogRepository contentLogRepository;
    private final MemberRepository memberRepository;
    private final ContentLogQuerydslRepository contentLogQuerydslRepository;

    @Transactional
    public Long contentLogInsert(ContentLogSaveRequestDto contentLogSaveRequestDto){

        memberRepository.findByKakaoId(contentLogSaveRequestDto.getKakaoId()).orElseThrow(() ->
                new IllegalArgumentException("사용자를 찾을수 없습니다."));

        Optional<ContentLog> contentLog
                = contentLogRepository.findByContentId(contentLogSaveRequestDto.getContentId());

        if(contentLog.isEmpty()){
            return contentLogRepository.save(contentLogSaveRequestDto.toEntity()).getContentSeq();
        } else if(!contentLog.isEmpty()
                && contentLogSaveRequestDto.getContentId().equals(contentLog.get().getContentId())){
            throw new ContentLogSaveOverlapException();
        }
        return contentLogRepository.save(contentLogSaveRequestDto.toEntity()).getContentSeq();
    }

    @Transactional(readOnly = true)
    public List<ContentLogMyContentResponseDto> getContent(String kakaoId){

        List<ContentLogMyContentResponseDto> contentLogMyContentResponseDto = contentLogRepository.findByKakaoId(kakaoId).stream()
                .map(ContentLogMyContentResponseDto :: new).collect(Collectors.toList());

        if(contentLogMyContentResponseDto == null || contentLogMyContentResponseDto.isEmpty()){
            throw new ContentLogSaveOverlapException("로그에 컨텐츠정보가 존재하지 않습니다! 로그를 추가해주세요.");

        }else if(contentLogMyContentResponseDto != null && !contentLogMyContentResponseDto.isEmpty()){
            return contentLogMyContentResponseDto;

        }
        return contentLogMyContentResponseDto;
    }

    @Transactional
    public void contentDeleteOne(Long contentId){
        contentLogQuerydslRepository.contentLogDeleteOne(contentId);
    }
}
