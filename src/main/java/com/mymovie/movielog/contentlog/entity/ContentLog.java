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
public class ContentLog extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_seq")
    private Long contentSeq;

    @Column(name = "movie_id")
    private String movieId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "member_email", name = "member_email")
    private Member member;

    @Builder
    ContentLog(Long contentSeq, String movieId, Member member){
        this.contentSeq = contentSeq;
        this.movieId = movieId;
        this.member = member;
    }
}
