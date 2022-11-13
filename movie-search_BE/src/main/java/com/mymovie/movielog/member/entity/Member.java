package com.mymovie.movielog.member.entity;

import com.mymovie.movielog.common.BaseTimeEntity;
import com.mymovie.movielog.oauth.enumerate.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq")
    private Long id;

    @Column(name = "member_nickname", length = 30, nullable = false)
    private String nickname;

    @Column(name = "member_email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "profile_image_url", nullable = false)
    private String profileImageUrl;

    @Column(name = "thumbnail_image_url", nullable = false)
    private String thumbnailImageUrl;

    @Column(name = "kakao_id", nullable = false)
    private String kakaoId;

    @Column(name ="kakao_age", nullable = false)
    private String age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;
}

