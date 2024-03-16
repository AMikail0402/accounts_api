package accounts.app.user_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.user_account.Dto.AddAccountUserDto;

@RestController
@RequestMapping(path = "api/user/account")
public class UserAccountController {

    UserAccountService userAccountService;
    
    @Autowired
    UserAccountController(UserAccountService userAccountService){
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public void addAccountToUser(@RequestBody AddAccountUserDto accountUserDto ){
       userAccountService.AddAccountToUser(accountUserDto);
    }

}  
