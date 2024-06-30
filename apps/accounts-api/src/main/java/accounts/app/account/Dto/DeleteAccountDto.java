package accounts.app.account.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class DeleteAccountDto {

    @JsonProperty
    private Long account_id;

}
