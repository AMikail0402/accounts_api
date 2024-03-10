package accounts.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.account.Dto.AddAccountDto;
import accounts.app.account.Dto.DeleteAccountDto;
import accounts.app.account.Entity.Account;
import accounts.app.account.Repositories.AccountRepository;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService, AccountRepository accountRepository){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping
    public void addAccount(@RequestBody AddAccountDto account){     
       accountService.addAccount(account);
    }
   
    @DeleteMapping
    public void deleteAccountsByName(@RequestBody DeleteAccountDto account){
        accountService.deleteAccountsByName(account);
    }
}
