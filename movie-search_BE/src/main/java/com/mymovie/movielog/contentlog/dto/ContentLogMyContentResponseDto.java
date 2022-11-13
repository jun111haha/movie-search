package com.mymovie.movielog.contentlog.dto;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import lombok.Data;

@Data
public class ContentLogMyContentResponseDto {

    private Long movieId;
    private String title;
    private String imgUrl;
    private String rating;
    private boolean contentCheck;

    public ContentLogMyContentResponseDto(ContentLog contentLog){
        this.movieId = contentLog.getContentId();
        this.title   = contentLog.getContentTitle();
        this.imgUrl  = contentLog.getContentUrl();
        this.rating  = contentLog.getContentRating();
        this.contentCheck = contentLog.isContentCheck();
    }
}
