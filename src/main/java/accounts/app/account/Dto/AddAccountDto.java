package accounts.app.account.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import accounts.app.account.Entity.Account;
import lombok.Getter;

@Getter
public class AddAccountDto {

    @JsonProperty
    private String person_name;

    @JsonProperty
    private String person_email;

    public Account exportAsAccount(){
        return new Account(1, person_name, person_email);
    }

}
