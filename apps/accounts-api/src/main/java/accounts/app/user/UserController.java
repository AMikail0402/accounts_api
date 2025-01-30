package accounts.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import accounts.app.jwt.ValidateToken;
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
    public List<UserReadDto> getUsers(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer){
        ValidateToken.validate(bearer);
        return userService.findAllUsers();
    }

    @PostMapping
    public void addUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer,
    @RequestBody AddUserDto addUserDto){
        ValidateToken.validate(bearer);
        userService.addUser(addUserDto);
    }

    @DeleteMapping
    public void deleteUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearer,
    @RequestBody DeleteUserDto deleteUserDto){
        ValidateToken.validate(bearer);
        userService.delete(deleteUserDto);
    }

}
