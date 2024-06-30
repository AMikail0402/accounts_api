package accounts.app.account.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import accounts.app.account.Entity.Account;
import lombok.Getter;

@Getter
public class AddAccountDto {

    @JsonProperty
    private String currency;

    public Account exportAsAccount(){
        return new Account(1,0L,this.currency);
    }

}
