package accounts.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.user.Dto.AddUserDto;
import accounts.app.user.entities.User;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUsers(){
        return null;
    }

    @PostMapping
    public void addUser(@RequestBody AddUserDto addUserDto){
        System.out.println(addUserDto.toString());
    }

}
