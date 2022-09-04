package com.mymovie.movielog.member.repository;

import com.mymovie.movielog.member.entity.Member;
import com.mymovie.movielog.member.entity.QMember;
import com.mymovie.movielog.member.payload.MemberResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static com.mymovie.movielog.member.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberQuerydslRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public Member findByKakaoId(String kakaoId) {
//        QMember member = new QMember(QMember.member);
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        return jpaQueryFactory
                .selectFrom(member)
                .where(member.kakaoId.eq(kakaoId))
                .fetchOne();
    }

    @Transactional(readOnly = true)
    public MemberResponse findByMemberId(Long memberId) {
//        QMember member = new QMember(QMember.member);
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        return jpaQueryFactory
                .select(Projections.fields(MemberResponse.class,
                        member.nickname,
                        member.email,
                        member.profileImageUrl,
                        member.thumbnailImageUrl,
                        member.age))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }

}
