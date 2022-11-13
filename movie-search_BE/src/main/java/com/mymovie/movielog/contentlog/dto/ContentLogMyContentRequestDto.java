package com.mymovie.movielog.contentlog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentLogMyContentRequestDto {

    @NotBlank(message = "유저정보가 없습니다.")
    private Long kakaoId;
}
