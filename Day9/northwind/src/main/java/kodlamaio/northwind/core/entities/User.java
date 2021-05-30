package kodlamaio.northwind.core.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Email
    @NotNull
    @NotBlank
    @Column(name="email")
    private String email;

    @NotNull
    @NotBlank
    @Column(name="password")
    private String password;
}
