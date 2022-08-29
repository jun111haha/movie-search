package com.mymovie.movielog.member.entity;

import com.mymovie.movielog.auth.enumerate.Role;
import com.mymovie.movielog.common.BaseTimeEntity;
import com.mymovie.movielog.member.enumerate.Provider;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "member_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private Provider provider;

    @Builder
    Member(Long id, String accountId, String name, Role role, Provider provider){
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.role = role;
        this.provider = provider;
    }
}
