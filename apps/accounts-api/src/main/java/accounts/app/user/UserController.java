package accounts.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.user.Dto.AddUserDto;
import accounts.app.user.Dto.DeleteUserDto;
import accounts.app.user.Dto.UserReadDto;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping
    public List<UserReadDto> getUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody AddUserDto addUserDto){
        userService.addUser(addUserDto);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody DeleteUserDto deleteUserDto){
        userService.delete(deleteUserDto);
    }

}
