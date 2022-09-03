package com.mymovie.movielog.member.repository;

import com.mymovie.movielog.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findMemberById (Long memberId);

}
