package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDto {
    private int id;

    private String name;

    private String department;

    private LocalDate startedDate;

    private LocalDate graduatedDate;

    private String status;

    private String candidateName;

    private String candidateLastName;

    public SchoolDto(int id, String name, String department, LocalDate startedDate, LocalDate graduatedDate, String candidateName, String candidateLastName) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.startedDate = startedDate;
        this.graduatedDate = graduatedDate;
        this.candidateName = candidateName;
        this.candidateLastName = candidateLastName;
    }
}
