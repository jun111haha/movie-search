package com.mymovie.movielog.contentlog.entity;

import com.mymovie.movielog.common.BaseTimeEntity;
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

    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "kakao_id")
    private String kakaoId;

    @Column(name = "content_url", nullable = false)
    private String contentUrl;

    @Column(name = "content_title")
    private String contentTitle;

    @Column(name = "content_rating", nullable = false)
    private String contentRating;

    @Column(name = "content_check")
    private boolean contentCheck;

    @Builder
    ContentLog(Long contentSeq, Long contentId, String kakaoId, String contentUrl
            , String contentTitle, String contentRating, boolean contentCheck){
        this.contentSeq = contentSeq;
        this.contentId = contentId;
        this.kakaoId = kakaoId;
        this.contentUrl = contentUrl;
        this.contentTitle = contentTitle;
        this.contentRating = contentRating;
        this.contentCheck = contentCheck;
    }
}
