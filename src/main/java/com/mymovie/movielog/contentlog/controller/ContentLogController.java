package com.mymovie.movielog.contentlog.controller;

import com.mymovie.movielog.common.payload.ApiResponse;
import com.mymovie.movielog.contentlog.dto.ContentLogMyContentResponseDto;
import com.mymovie.movielog.contentlog.dto.ContentLogSaveRequestDto;
import com.mymovie.movielog.contentlog.service.ContentLogService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ContentLogController {

    private final ContentLogService contentLogService;

    @ApiOperation(value = "로그에 컨텐츠 저장", notes = "로그에 컨텐츠 저장")
    @PostMapping("/content")
    public ResponseEntity contentLogSave(@RequestBody ContentLogSaveRequestDto contentLogSaveRequestDto){
        return ApiResponse.success(contentLogService.contentLogInsert(contentLogSaveRequestDto));
    }

    @ApiOperation(value = "카카오 아이디로 조회", notes = "카카오 아이디로 로그 조회")
    @GetMapping("/content/{id}")
    public ResponseEntity<List<ContentLogMyContentResponseDto>> getMyLogContent(@PathVariable("id") String kakaoId){
        return ApiResponse.success(contentLogService.getContent(kakaoId));
    }
}
