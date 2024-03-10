package accounts.app.account.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountReadDto {
    @JsonProperty
    private Long account_id;
    @JsonProperty
    private int account_status;
    @JsonProperty
    private Long account_amount;
    @JsonProperty
    private String currency;

    public AccountReadDto(Long account_id, int account_status,Long account_amount, String currency){
        this.account_id = account_id;
        this.account_status = account_status;
        this.account_amount = account_amount;
        this.currency = currency;
    }
}
