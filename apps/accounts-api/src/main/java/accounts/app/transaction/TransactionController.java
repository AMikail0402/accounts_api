package accounts.app.transaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/transfer")
public class TransactionController {
    
    @GetMapping
    public String test(){
        return "This Endpoint works";
    }
    
}
