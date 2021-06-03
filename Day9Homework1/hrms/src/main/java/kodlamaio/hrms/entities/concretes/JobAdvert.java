package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.core.entities.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

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

    @NotEmpty
    @Column(name="max_salary" , length = 6)
    private int maxSalary;

    @NotEmpty
    @Column(name="min_salary" , length = 6)
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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @FutureOrPresent
    @Column(name="deadline")
    private LocalDate deadline;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="published_date" )
    private LocalDate publishedDate = LocalDate.now();

    @NotEmpty
    @Column(name="count_of_receivable_candidate" , length = 5)
    private int countOfReceivableCandidate;

    @NotEmpty
    @Column(name="job_requirements" , length = 500)
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
