package com.mymovie.movielog.oauth.controller;

import com.mymovie.movielog.common.payload.ApiResponse;
import com.mymovie.movielog.oauth.payload.AuthRequest;
import com.mymovie.movielog.oauth.payload.AuthResponse;
import com.mymovie.movielog.oauth.service.AuthService;
import com.mymovie.movielog.oauth.service.KakaoAuthService;
import com.mymovie.movielog.oauth.token.AuthToken;
import com.mymovie.movielog.oauth.token.AuthTokenProvider;
import com.mymovie.movielog.oauth.util.JwtHeaderUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final KakaoAuthService kakaoAuthService;
    private final AuthTokenProvider authTokenProvider;
    private final AuthService authService;

    /*
    카카오 소셜 로그인 기능
    @return ResponseEntity<AuthResponse>
     */
    @ApiOperation(value = "카카오 로그인", notes = "카카오 토큰을 이용해 사용자 저장 앱의 토큰 반환")
    @PostMapping(value = "/kakao")
    public ResponseEntity<AuthResponse> kakaoAuthRequest(@RequestBody AuthRequest authRequest) {
        return ApiResponse.success(kakaoAuthService.login(authRequest)); // body에 appToken 반환(response code 200)
    }

    /*
    appToken 갱신
    @return ResponseEntity<AuthResponse>
     */
    @ApiOperation(value = "appToken 갱신", notes = "appToken 갱신")
    @GetMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(HttpServletRequest request) {
        String appToken = JwtHeaderUtil.getAccessToken(request);
        AuthToken authToken = authTokenProvider.convertAuthToken(appToken);

        if (!authToken.validate()) { // 형식에 맞지 않는 token
            return ApiResponse.forbidden(null); // body에 담은 것 없이, 403 HTTP code return
        }

        AuthResponse authResponse = authService.updateToken(authToken);

        if (authResponse == null) { // token 만료
            return ApiResponse.forbidden(null); // body에 담은 것 없이, 403 HTTP code return
        }

        return ApiResponse.success(authResponse);
    }

}
