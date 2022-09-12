package com.mymovie.movielog.contentlog.dto;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentLogSaveRequestDto {

    @NotBlank(message = "영화정보가 없습니다.")
    private Long movieId;

    @NotBlank(message = "유저가 없습니다.")
    private String kakaoId;

    public ContentLog toEntity(){
        return ContentLog.builder()
                .movieId(movieId)
                .kakaoId(kakaoId).build();
    }
}
