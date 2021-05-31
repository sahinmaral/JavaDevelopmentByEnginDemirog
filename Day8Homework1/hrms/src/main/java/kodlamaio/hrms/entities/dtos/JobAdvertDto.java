package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private int maxSalary;
    private int minSalary;
    private String cityName;
    private LocalDate deadline;
    private LocalDate publishedDate;
    private int countOfReceivableCandidate;
    private String jobRequirements;
    private String jobPositionName;
    private boolean isActive;
}
