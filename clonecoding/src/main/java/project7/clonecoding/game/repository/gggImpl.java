//package project7.clonecoding.game.repository;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.stereotype.Repository;
//import project7.clonecoding.game.entity.Game;
//
//import java.util.List;
//
//import static project7.clonecoding.game.entity.QGame.game;
//
//@Repository
//public class gggImpl implements ggg {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public PostCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
//    @Override
//    public List<Game> findAllInnerFetchJoin() {
//        return jpaQueryFactory.selectFrom(game)
//                .innerJoin(game.id)
//                .fetchJoin()
//                .fetch();
//    }
//
//    @Override
//    public List<Post> findAllInnerFetchJoinWithDistinct() {
//        return jpaQueryFactory.selectFrom(game)
//                .distinct()
//                .innerJoin(game.comments)
//                .fetchJoin()
//                .fetch();
//    }
//}
