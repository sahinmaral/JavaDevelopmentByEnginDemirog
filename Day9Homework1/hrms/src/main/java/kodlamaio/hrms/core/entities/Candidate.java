package kodlamaio.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;



@Table(name = "candidates")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="candidate_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = true)
public class Candidate extends User {

    @NotEmpty
    @Column(name = "first_name" , length = 100)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name" , length = 100)
    private String lastName;

    @NotBlank
    @NotNull
    @Column(name = "identity_id" , length = 11)
    private String identityId;

    @Positive
    @NotNull
    @Column(name = "birth_year" , length = 4)
    private int birthYear;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Cv> cv;


}
