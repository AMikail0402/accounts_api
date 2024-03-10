package accounts.app.account.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import accounts.app.account.Entity.Account;

@Repository
public interface AccountRepository 
    extends JpaRepository<Account, Long>{

        @Query("SELECT a FROM Account WHERE a.account_id = :id")
        Account findAccountById(@Param("id") Long id);

}
