package accounts.app.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.user.Dto.AddUserDto;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @PostMapping
    public void addUser(@RequestBody AddUserDto addUserDto){
        System.out.println(addUserDto.toString());
    }

}
