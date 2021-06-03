package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_knowledges")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class CandidateKnowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="programming_technology_id")
    private ProgrammingTechnology programmingTechnology;

    @ManyToOne()
    @JoinColumn(name="cv_id")
    private Cv cv;

}
