package accounts.app.user.entities;

import java.util.List;

import org.hibernate.annotations.Generated;

import accounts.app.account.Entity.Account;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="account_user")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String family_name;
    @Column
    private String surname;
    @Column
    private String address;
    @Column
    private String phone_number;
    @Column
    private List<Account> accounts;
}
