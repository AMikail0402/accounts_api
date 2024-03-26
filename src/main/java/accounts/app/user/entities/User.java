package accounts.app.user.entities;

import java.util.List;

import org.hibernate.annotations.Generated;

import accounts.app.account.Entity.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="user_profile")
@Getter
@Setter
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Account> accounts;
}
