package accounts.app.user.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import accounts.app.account.Dto.AccountReadDto;
import accounts.app.account.Entity.Account;

public class UserReadDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String family_name;
    @JsonProperty
    private String surname;
    @JsonProperty
    private String address;
    @JsonProperty
    private String phone_number;
    @JsonProperty
    private List<AccountReadDto> accounts;
    
    public UserReadDto(Long id, String family_name,
    String surname, String address, 
    String phone_number, List<AccountReadDto> accounts){
        this.id = id;
        this.family_name = family_name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.accounts = accounts;
    }
}

