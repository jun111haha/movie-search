package com.mymovie.movielog.contentlog.entity;

import com.mymovie.movielog.common.BaseTimeEntity;
import com.mymovie.movielog.user.entity.User;
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
    @JoinColumn(referencedColumnName = "user_id", name = "user_id")
    private User member;

    @Builder
    ContentLog(Long contentSeq, String movieId, User member){
        this.contentSeq = contentSeq;
        this.movieId = movieId;
        this.member = member;
    }
}
