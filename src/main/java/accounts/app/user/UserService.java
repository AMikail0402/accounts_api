package accounts.app.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.app.account.Dto.AccountReadDto;
import accounts.app.account.Entity.Account;
import accounts.app.user.Dto.AddUserDto;
import accounts.app.user.Dto.DeleteUserDto;
import accounts.app.user.Dto.UserReadDto;
import accounts.app.user.entities.User;
import accounts.app.user.repository.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public List<UserReadDto> findAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserReadDto> usersToBeShown = new ArrayList<>();
        for(User x : users){
            System.out.println("ALLE ACCOUNTS"+x.getAccounts().size());
            // Create AccountReadDto for each User
            List<Account> userAccounts = x.getAccounts();
            List<AccountReadDto> accountsToBeShown = new ArrayList();

            for(Account y : userAccounts){
                accountsToBeShown.add(new AccountReadDto(y.getAccount_id(), y.getAccount_status()
                , y.getAccount_amount(), y.getCurrency()));
            }

            usersToBeShown.add(new UserReadDto(x.getId(), x.getFamily_name(), 
            x.getSurname(), x.getAddress(), x.getPhone_number(),accountsToBeShown));
        } 
        return usersToBeShown;
    }

    public void addUser(AddUserDto addUserDto){
        User user = new User();
        user.setAddress(addUserDto.getAddress());
        user.setFamily_name(addUserDto.getFamily_name());
        user.setPhone_number(addUserDto.getPhone_number());
        user.setSurname(addUserDto.getSurname());
        userRepository.save(user);
    }

    public void delete(DeleteUserDto deleteUserDto){
        User userToBeDeleted = userRepository.findUserById(deleteUserDto.user_id());
        userRepository.delete(userToBeDeleted);
    }
}
