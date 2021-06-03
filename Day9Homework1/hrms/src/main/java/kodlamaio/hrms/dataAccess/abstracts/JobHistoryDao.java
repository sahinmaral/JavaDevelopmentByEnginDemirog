package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobHistory;
import kodlamaio.hrms.entities.dtos.JobHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobHistoryDao extends JpaRepository<JobHistory,Integer> {

    @Query(value="SELECT new kodlamaio.hrms.entities.dtos.JobHistoryDto" +
            "(jh.id,jh.companyName, jh.jobPosition.title,jh.startedDate,jh.finishedDate," +
            "jh.cv.candidate.firstName,jh.cv.candidate.lastName)" +
            "FROM JobHistory jh"
    )
    List<JobHistoryDto> getAllByCandidateId(int candidateId);
}
