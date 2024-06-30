package accounts.app.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import accounts.app.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT a FROM User a WHERE a.surname = :name")
    Optional<User> findAccountUserBySurname(@Param("name") String name);

    @Query("SELECT a FROM User a WHERE a.id = :user_id")
    Optional<User> findUserById(@Param("user_id") Long id);

    @Query("SELECT a FROM User a")
    List<User> findAllUsers();
    
}
