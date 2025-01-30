package accounts.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.account.Dto.AccountReadDto;
import accounts.app.account.Dto.AddAccountDto;
import accounts.app.account.Dto.DeleteAccountDto;
import accounts.app.account.Repositories.AccountRepository;
import accounts.app.jwt.ValidateToken;

@RestController
@RequestMapping(path = "api/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService, AccountRepository accountRepository){
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountReadDto> getAccounts(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer){
        ValidateToken.validate(bearer);
        return accountService.getAccounts();
    }

    @PostMapping
    public void addAccount(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer,
    @RequestBody AddAccountDto account){     
       ValidateToken.validate(bearer);
       accountService.addAccount(account);
    }
   
    @DeleteMapping
    public void deleteAccountById(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer,
    @RequestBody DeleteAccountDto account){
        ValidateToken.validate(bearer);
        accountService.deleteAccountById(account);
    }
}
