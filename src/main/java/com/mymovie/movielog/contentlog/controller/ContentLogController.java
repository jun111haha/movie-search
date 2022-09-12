package com.mymovie.movielog.contentlog.controller;

import com.mymovie.movielog.common.payload.ApiResponse;
import com.mymovie.movielog.contentlog.dto.ContentLogSaveRequestDto;
import com.mymovie.movielog.contentlog.service.ContentLogService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
