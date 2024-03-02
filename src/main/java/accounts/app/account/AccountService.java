package accounts.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.app.account.Dto.AddAccountDto;
import accounts.app.account.Dto.DeleteAccountDto;
import accounts.app.account.Entity.Account;
import accounts.app.account.Repositories.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public void addAccount(AddAccountDto account){
        Account accountToBeSaved = account.exportAsAccount();
        accountRepository.save(accountToBeSaved);          
    }

    public void deleteAccountsByName(DeleteAccountDto account){
        List<Account> associatedAccounts = accountRepository.findAccountsByPersonName(account.getPerson_name());
        for(Account x : associatedAccounts){
            accountRepository.delete(x);
        } 
    }
}
