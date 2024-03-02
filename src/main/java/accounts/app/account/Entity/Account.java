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
    private String person_name;
    @Column
    private String person_email;

    public Account(){}

    public Account(int account_status,String person_name, String person_email){
        this.account_status = account_status;
        this.person_name = person_name;
        this.person_email = person_email;
    }

    public int getAccountStatus(){
        return this.account_status;
    }

    public Long getAccountId(){
        return this.account_id;
    }

    public String getPersonName(){
        return  this.person_name;
    }

    public String getPersonEmail(){
        return  this.person_email;
    }

    public String toString(){
        return "Account{"+
                "account_status="+this.account_status+
                ", account_id="+this.account_id+
                ", person_name='"+this.person_name+"\'"+
                ", person_email='"+this.person_email+"\' }";
    }
}
