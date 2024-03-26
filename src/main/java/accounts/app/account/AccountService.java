package accounts.app.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.app.account.Dto.AccountReadDto;
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
    
    public List<AccountReadDto> getAccounts(){
        List<AccountReadDto> accountReading = new ArrayList<>(); 
        List<Account> accounts =  accountRepository.findAll();
        for(Account x : accounts){
            accountReading.add(new AccountReadDto(x.getAccount_id(),x.getAccount_status(),x.getAccount_amount(),x.getCurrency()));
        }
        return accountReading;
    }

    public void addAccount(AddAccountDto account){
        Account accountToBeSaved = account.exportAsAccount();
        accountRepository.save(accountToBeSaved);          
    }

    public void deleteAccountById(DeleteAccountDto account){
        Account associatedAccount = accountRepository.findAccountById(account.getAccount_id()).get();
        accountRepository.delete(associatedAccount);
    }
}
