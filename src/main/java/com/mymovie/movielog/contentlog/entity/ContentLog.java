package com.mymovie.movielog.contentlog.entity;

import com.mymovie.movielog.common.BaseTimeEntity;
import com.mymovie.movielog.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "content_log")
public class ContentLog extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_seq")
    private Long contentSeq;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "kakao_id")
    private String kakaoId;

    @Builder
    ContentLog(Long contentSeq, Long movieId, String kakaoId){
        this.contentSeq = contentSeq;
        this.movieId = movieId;
        this.kakaoId = kakaoId;
    }
}
