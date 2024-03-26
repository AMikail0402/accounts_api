package accounts.app.account.Entity;

import accounts.app.user.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_account")
@Getter
@Setter
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
    private Long account_amount;
    @Column
    private String currency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

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
                ", account_currency="+this.currency+
                ", account_amount="+this.account_amount+
                "\' }";
    }
}
