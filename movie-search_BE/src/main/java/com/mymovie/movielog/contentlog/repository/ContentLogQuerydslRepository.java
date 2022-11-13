package com.mymovie.movielog.contentlog.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static com.mymovie.movielog.contentlog.entity.QContentLog.contentLog;


@Repository
@RequiredArgsConstructor
public class ContentLogQuerydslRepository {

    @PersistenceContext
    private EntityManager em;

    public Long contentLogDeleteOne(Long contentId){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        return jpaQueryFactory
                .delete(contentLog)
                .where(contentLog.contentId.eq(contentId))
                .execute();
    }
}
