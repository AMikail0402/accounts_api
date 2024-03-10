package accounts.app.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            usersToBeShown.add(new UserReadDto(x.getId(), x.getFamily_name(), 
            x.getSurname(), x.getAddress(), x.getPhone_number()));
        } 
        return usersToBeShown;
    }
}
