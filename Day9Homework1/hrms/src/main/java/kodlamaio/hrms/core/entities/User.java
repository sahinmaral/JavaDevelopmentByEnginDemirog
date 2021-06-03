package kodlamaio.hrms.core.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import kodlamaio.hrms.business.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty()
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
            message = "Geçerli bir email giriniz")
    @Column(name = "email")
    private String email;

    @NotEmpty()
    @Pattern(
            regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#?$%^&+=])(?=\\S+$).{8,}",
            message = "Şifreniz en az 8 karakterden oluşmaktadır." +
                    "Şifrenizde en az bir özel karakter , büyük harf , küçük harf , rakam olması gerekir." +
                    "Şifrenizde boşluk olmaması gerekir."
    )
    @Column(name = "password")
    private String password;

    @JsonDeserialize
    @Transient
    @NotEmpty()
    private String passwordRepeat;


}
