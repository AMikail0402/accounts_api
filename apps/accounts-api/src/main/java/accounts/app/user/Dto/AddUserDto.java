package accounts.app.user.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserDto {

    @JsonProperty
    String family_name;
    @JsonProperty
    String surname;
    @JsonProperty
    String address;
    @JsonProperty
    String phone_number;
    
    public String toString(){
        return "{ "+this.family_name+",\n"+this.surname+",\n"+this.address+",\n"+this.phone_number+",\n}";
    }
}
