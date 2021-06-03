package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SchoolDao extends JpaRepository<School,Integer> {

    @Query(value="SELECT new kodlamaio.hrms.entities.dtos.SchoolDto" +
            "(sc.id,sc.name, sc.department,sc.startedDate,sc.graduatedDate," +
            "sc.cv.candidate.firstName,sc.cv.candidate.lastName)" +
            "FROM School sc")
    List<SchoolDto> getAllByCandidateId(int candidateId);
}
