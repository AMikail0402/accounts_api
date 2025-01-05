package accounts.app.code_injection;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accounts.app.code_injection.dto.CommandDto;
import accounts.app.code_injection.dto.OutputDto;

@RestController
@RequestMapping(path = "api/injection")
public class InjectionController {

   

    @Autowired
    public InjectionController(){
        
    }

    @PostMapping
    public OutputDto executeCode(@RequestBody CommandDto command) throws IOException{
       // Internet-Ressource: https://www.baeldung.com/run-shell-command-in-java     
       Process process;
        process = Runtime.getRuntime()
        .exec(command.command());
       String inputStream = new String(process.getInputStream().readAllBytes());
       String output = new String(process.getErrorStream().readAllBytes());
       return new OutputDto(inputStream, output);
    }
   
}
