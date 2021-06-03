package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobHistoryDto {
    private int id;

    private String companyName;

    private String jobPositionName;

    private LocalDate startedDate;

    private LocalDate finishedDate;

    private String status;

    private String candidateName;

    private String candidateLastName;

    public JobHistoryDto(int id, String companyName, String jobPositionName, LocalDate startedDate, LocalDate finishedDate, String candidateName, String candidateLastName) {
        this.id = id;
        this.companyName = companyName;
        this.jobPositionName = jobPositionName;
        this.startedDate = startedDate;
        this.finishedDate = finishedDate;
        this.candidateName = candidateName;
        this.candidateLastName = candidateLastName;
    }
}
