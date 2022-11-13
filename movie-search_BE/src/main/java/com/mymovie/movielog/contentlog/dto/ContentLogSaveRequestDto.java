package com.mymovie.movielog.contentlog.dto;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentLogSaveRequestDto {

    @NotBlank(message = "영화정보가 없습니다.")
    private Long contentId;

    @NotBlank(message = "유저가 없습니다.")
    private String kakaoId;

    @NotBlank(message = "타이틀이 없습니다.")
    private String contentTitle;

    private String contentUrl;

    private String contentRating;

    private boolean contentCheck;

    public ContentLog toEntity(){
        return ContentLog.builder()
                .contentId(contentId)
                .kakaoId(kakaoId)
                .contentUrl(contentUrl)
                .contentTitle(contentTitle)
                .contentRating(contentRating)
                .contentCheck(contentCheck)
                .build();
    }
}
