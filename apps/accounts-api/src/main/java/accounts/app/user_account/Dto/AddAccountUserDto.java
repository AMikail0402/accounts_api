package accounts.app.user_account.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAccountUserDto {

    @JsonProperty
    Long user_id;
    @JsonProperty
    Long account_id;

}


