package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="job_histories")
@AllArgsConstructor
@NoArgsConstructor
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty
    @Column(name="company_name" , length = 150)
    private String companyName;

    @ManyToOne()
    @JoinColumn(name="position_id")
    private JobPosition jobPosition;

    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="started_date")
    private LocalDate startedDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="finished_date")
    private LocalDate finishedDate;

    @Column(name="is_finished")
    private boolean isFinished;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;

}
