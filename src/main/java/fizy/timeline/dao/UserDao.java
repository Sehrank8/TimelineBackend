package fizy.timeline.dao;

import fizy.timeline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}