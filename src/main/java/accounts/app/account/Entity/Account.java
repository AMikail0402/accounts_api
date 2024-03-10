package accounts.app.account.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
    
    @Id
    @SequenceGenerator(
        name = "account_sequence",
        sequenceName = "account_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "account_sequence"
    )
    private Long account_id;
    @Column
    private int account_status;
    @Column
    private long account_amount;
    @Column
    private String currency;

    public Account(){}

    public Account(int account_status, Long account_amount, String currency){
        this.account_status = account_status;
        this.account_amount = account_amount;
        this.currency = currency;
    }
   
    public String toString(){
        return "Account{"+
                "account_status="+this.account_status+
                ", account_id="+this.account_id+
                ", person_name='"+
                "\' }";
    }
}
