package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kodlamaio.hrms.core.entities.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv")
public class Cv {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Pattern(regexp = "^https?://[^/]+/([^/]+)/.*$")
    @Column(name="github_adress")
    private String githubAdress;

    @NotEmpty
    @Pattern(regexp = "^https?://[^/]+/([^/]+)/.*$")
    @Column(name="linkedin_adress")
    private String linkedinAdress;

    @NotEmpty
    @Column(name="covering_letter" , length = 500)
    private String coveringLetter;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @OneToMany(mappedBy = "cv",
            cascade = CascadeType.ALL,
            orphanRemoval = true ,
            fetch = FetchType.LAZY)
    private List<CandidateForeignLanguage> candidateForeignLanguages;

    @OneToMany(mappedBy = "cv",
            cascade = CascadeType.ALL,
            orphanRemoval = true , fetch = FetchType.LAZY)
    private List<CandidateKnowledge> candidateKnowledges;

    @OneToMany(
            mappedBy = "cv",
            cascade = CascadeType.ALL,
            orphanRemoval = true , fetch = FetchType.LAZY)
    private List<JobHistory> jobHistories;

    @OneToMany(
            mappedBy = "cv",
            cascade = CascadeType.ALL,
            orphanRemoval = true , fetch = FetchType.LAZY)
    private List<School> schools;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="image_id" , referencedColumnName = "id")
    private Image image;

}
