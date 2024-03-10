package accounts.app.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import accounts.app.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT a FROM User a WHERE a.surname = :name")
    String findAccountUserBySurname(@Param("name") String name);

    @Query("SELECT a FROM User a")
    List<User> findAllUsers();
}
