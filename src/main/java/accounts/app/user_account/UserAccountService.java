package accounts.app.user_account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.app.account.Dto.AddAccountDto;
import accounts.app.account.Entity.Account;
import accounts.app.account.Repositories.AccountRepository;
import accounts.app.user.entities.User;
import accounts.app.user.repository.UserRepository;
import accounts.app.user_account.Dto.AddAccountUserDto;

@Service
public class UserAccountService {
    UserRepository userRepository;
    AccountRepository accountRepository;

    @Autowired
    UserAccountService(UserRepository userRepository,
    AccountRepository accountRepository){
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public void AddAccountToUser(AddAccountUserDto addAccountUserDto){
        User updateUser = userRepository.findUserById(addAccountUserDto.getUser_id());
        List<Account> userAccounts = updateUser.getAccounts();
        Account updateAccount = accountRepository.findAccountById(addAccountUserDto.getAccount_id());
        userAccounts.add(updateAccount);
        updateUser.setAccounts(userAccounts);
        userRepository.save(updateUser);
    }
    

}
