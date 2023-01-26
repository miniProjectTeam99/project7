package project7.clonecoding.user;

import org.springframework.data.jpa.repository.JpaRepository;
import project7.clonecoding.user.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    List<Users> OrderByIdDesc();
    Users findByUserName(String userName);

    Users findByEmail(String email);
}
