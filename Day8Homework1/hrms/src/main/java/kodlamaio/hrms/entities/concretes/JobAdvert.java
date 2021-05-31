package kodlamaio.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_adverts")
public class JobAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="min_salary")
    private int minSalary;

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employers;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City cities;

    @ManyToOne()
    @JoinColumn(name="job_position_id")
    private JobPosition jobPositions;

    @Column(name="deadline")
    private LocalDate deadline;

    @Column(name="published_date")
    private LocalDate publishedDate = LocalDate.now();

    @Column(name="count_of_receivable_candidate")
    private int countOfReceivableCandidate;

    @Column(name="job_requirements")
    private String jobRequirements;

    @Column(name="is_active")
    private boolean isActive = true;

    public boolean getActive(){
        return this.isActive;
    }

    public void setActive(boolean isActive){
        this.isActive = isActive;
    }

}
