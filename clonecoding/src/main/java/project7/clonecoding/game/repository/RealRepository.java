package project7.clonecoding.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project7.clonecoding.game.entity.Realtable;

public interface RealRepository extends JpaRepository<Realtable,Long> {

}
