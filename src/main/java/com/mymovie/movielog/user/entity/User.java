package com.mymovie.movielog.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mymovie.movielog.common.BaseTimeEntity;
import com.mymovie.movielog.oauth.entity.ProviderType;
import com.mymovie.movielog.oauth.entity.RoleType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User extends BaseTimeEntity {
    @JsonIgnore
    @Id
    @Column(name = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "USER_ID", length = 64, unique = true)
    private String userId;

    @Column(name = "USERNAME", length = 100)
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD", length = 128)
    private String password;

    @Column(name = "EMAIL", length = 512, unique = true)
    private String email;

    @Column(name = "EMAIL_VERIFIED_YN", length = 1)
    private String emailVerifiedYn;

    @Column(name = "PROFILE_IMAGE_URL", length = 512)
    private String profileImageUrl;

    @Column(name = "PROVIDER_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Column(name = "ROLE_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Builder
    public User(String userId, String username, String email, String emailVerifiedYn, String profileImageUrl, ProviderType providerType, RoleType roleType) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.email = email != null ? email : "NO_EMAIL";
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.roleType = roleType;
    }
}
