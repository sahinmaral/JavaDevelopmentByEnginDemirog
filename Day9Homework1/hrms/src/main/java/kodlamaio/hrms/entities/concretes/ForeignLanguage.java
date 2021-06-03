package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidateForeignLanguages"})
public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "foreignLanguage" , fetch = FetchType.LAZY)
    private List<CandidateForeignLanguage> candidateForeignLanguages;

}
