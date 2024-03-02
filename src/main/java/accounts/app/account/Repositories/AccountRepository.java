package accounts.app.account.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import accounts.app.account.Entity.Account;

@Repository
public interface AccountRepository 
    extends JpaRepository<Account, Long>{

        @Query("SELECT a FROM Account a WHERE a.person_email = ?1")
        List<Account> findAccountsByPersonEmail(String email);

        @Query("SELECT a FROM Account a WHERE a.person_name = ?1")
        List<Account> findAccountsByPersonName(String name);


}
