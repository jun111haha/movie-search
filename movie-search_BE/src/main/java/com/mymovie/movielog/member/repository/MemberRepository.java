package com.mymovie.movielog.member.repository;

import com.mymovie.movielog.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findMemberById (Long memberId);
    Optional<Member> findByKakaoId(String kakaoId);
}
