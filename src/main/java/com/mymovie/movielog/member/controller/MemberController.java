package com.mymovie.movielog.member.controller;

import com.mymovie.movielog.common.payload.ApiResponse;
import com.mymovie.movielog.member.payload.MemberResponse;
import com.mymovie.movielog.member.service.MemberService;
import com.mymovie.movielog.oauth.util.JwtHeaderUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(value = "사용자 정보 조회", notes = "카카오 통해 저장한 사용자의 정보 반환")
    @GetMapping("/details")
    public ResponseEntity<MemberResponse> getMemberData (HttpServletRequest request) {
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiResponse.success(memberService.getMemberData(token));
    }
}
