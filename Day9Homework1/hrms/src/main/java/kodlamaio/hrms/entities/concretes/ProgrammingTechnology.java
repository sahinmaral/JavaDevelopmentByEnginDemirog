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
@Table(name = "programming_technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","candidateKnowledges"})
public class ProgrammingTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "name" , unique = true , length = 50)
    private String name;

    @OneToMany(mappedBy = "programmingTechnology" , fetch = FetchType.LAZY)
    private List<CandidateKnowledge> candidateKnowledges;
}
