package com.mymovie.movielog.contentlog.dto;

import com.mymovie.movielog.contentlog.entity.ContentLog;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ContentLogResponseDto {
    private Long movieId;

    public ContentLogResponseDto(ContentLog contentLog){
        this.movieId = contentLog.getMovieId();
    }
}
