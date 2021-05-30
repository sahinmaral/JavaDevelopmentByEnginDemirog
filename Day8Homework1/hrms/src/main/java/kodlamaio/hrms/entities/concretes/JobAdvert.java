package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
public class JobAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="advert_id")
    private int id;
    @Column(name="max_salary")
    private int maxSalary;
    @Column(name="min_salary")
    private int minSalary;
    @Column(name="city")
    private String city;
    @Column(name="deadline")
    private LocalDate deadline;
    @Column(name="count_of_receivable_candidate")
    private int countOfReceivableCandidate;
    @Column(name="job_requirements")
    private String jobRequirements;
    @Column(name="job_position_id")
    private int jobPositionId;
    @Column(name="is_active")
    private boolean isActive;
}
