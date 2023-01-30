package project7.clonecoding.game.repository;

import project7.clonecoding.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByOrderByIdDesc();

    List<Game> findAllByOrderByStarDesc();
    List<Game> findAllByGamePriceContains(String s);
}
