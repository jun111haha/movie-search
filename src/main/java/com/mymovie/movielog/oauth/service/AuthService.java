package com.mymovie.movielog.oauth.service;

import com.mymovie.movielog.member.entity.Member;
import com.mymovie.movielog.member.repository.MemberQuerydslRepository;
import com.mymovie.movielog.oauth.payload.AuthResponse;
import com.mymovie.movielog.oauth.token.AuthToken;
import com.mymovie.movielog.oauth.token.AuthTokenProvider;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthTokenProvider authTokenProvider;
    private final MemberQuerydslRepository memberQuerydslRepository;

    public AuthResponse updateToken(AuthToken authToken) {
        Claims claims = authToken.getTokenClaims();

        if (claims == null)
            return null;

        String memberId = claims.getSubject();

        AuthToken updatedAppToken = authTokenProvider.createUserAppToken(memberId);

        return AuthResponse.builder()
                .appToken(updatedAppToken.getToken())
                .build();
    }

    public Long getMemberId(String token) {

        AuthToken authToken = authTokenProvider.convertAuthToken(token);

        Claims claims = authToken.getTokenClaims();

        if (claims == null) {
            return null;
        }

        try {
            Member member = memberQuerydslRepository.findByKakaoId(claims.getSubject());
            return member.getId();
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자가 존재하지 않습니다.");
        }


    }
}
