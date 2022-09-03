package com.mymovie.movielog.member.service;

import com.mymovie.movielog.member.payload.MemberResponse;
import com.mymovie.movielog.member.repository.MemberQuerydslRepository;
import com.mymovie.movielog.oauth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final AuthService authService;
    private final MemberQuerydslRepository memberQuerydslRepository;

    public MemberResponse getMemberData (String token) {
        Long memberId = authService.getMemberId(token);
        MemberResponse memberResponse = memberQuerydslRepository.findByMemberId(memberId);

        if (memberResponse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다.");
        }

        return memberResponse;
    }
}
