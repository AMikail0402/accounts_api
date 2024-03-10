package accounts.app.user;

import java.util.List;

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

    @GetMapping
    public List<User> getUsers(){
        return null;
    }

    @PostMapping
    public void addUser(@RequestBody AddUserDto addUserDto){
        System.out.println(addUserDto.toString());
    }

}
