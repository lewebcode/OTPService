package fun.justdevelops.otpservice.model.repo;

import fun.justdevelops.otpservice.model.Role;
import fun.justdevelops.otpservice.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
    boolean existsByLogin(String login);
    long deleteByLogin(String login);
    boolean existsByRole(Role role);
}
