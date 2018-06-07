package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.User;
import pl.coderslab.model.UserRole;

public interface UserRolerRepository extends JpaRepository<UserRole,Long> {
}
