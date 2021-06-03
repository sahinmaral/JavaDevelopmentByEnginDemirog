package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Table(name="job_positions")

public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty
    @Column(name="title" , unique = true , length = 100)
    private String title;

    @Column(name="is_active")
    private boolean isActive = true;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPositions")
    private List<JobAdvert> jobadvert;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition")
    private List<JobHistory> jobHistories;

}
