package accounts.app.user.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    
    public UserReadDto(Long id, String family_name,
    String surname, String address, String phone_number){
        this.id = id;
        this.family_name = family_name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
    }
}

