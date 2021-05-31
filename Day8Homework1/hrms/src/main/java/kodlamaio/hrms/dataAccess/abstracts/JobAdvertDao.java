package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {
    JobAdvert getById(int jobAdvertId);
    JobAdvert findById(int jobAdvertId);

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertDto" +
            "(ja.id,e.companyName,ja.maxSalary,ja.minSalary," +
            "c.name,ja.deadline,ja.publishedDate,ja.countOfReceivableCandidate," +
            "ja.jobRequirements,jb.title,ja.isActive)" +
            "FROM JobAdvert ja " +
            "INNER JOIN ja.jobPositions jb " +
            "INNER JOIN ja.cities c " +
            "INNER JOIN ja.employers e")
   List<JobAdvertDto> getAllAdsByDetails();

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertDto" +
            "(ja.id,e.companyName, ja.maxSalary,ja.minSalary," +
            "c.name,ja.publishedDate,ja.deadline,ja.countOfReceivableCandidate,ja.jobRequirements,jb.title,ja.isActive)" +
            "FROM JobAdvert ja " +
            "INNER JOIN ja.jobPositions jb " +
            "INNER JOIN ja.cities c " +
            "INNER JOIN ja.employers e " +
            "WHERE ja.isActive=false")
    List<JobAdvertDto> getAllPassiveAdsByDetails();

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertDto" +
            "(ja.id,e.companyName, ja.maxSalary,ja.minSalary," +
            "c.name,ja.publishedDate,ja.deadline,ja.countOfReceivableCandidate,ja.jobRequirements,jb.title,ja.isActive)" +
            "FROM JobAdvert ja " +
            "INNER JOIN ja.jobPositions jb " +
            "INNER JOIN ja.cities c " +
            "INNER JOIN ja.employers e " +
            "WHERE ja.deadline=:deadline")
    List<JobAdvertDto> getAllActiveAdsByDeadlineIs(LocalDate deadline);

    @Query("SELECT new kodlamaio.hrms.entities.dtos.JobAdvertDto" +
            "(ja.id,e.companyName, ja.maxSalary,ja.minSalary," +
            "c.name,ja.publishedDate,ja.deadline,ja.countOfReceivableCandidate,ja.jobRequirements,jb.title,ja.isActive)" +
            "FROM JobAdvert ja " +
            "INNER JOIN ja.jobPositions jb " +
            "INNER JOIN ja.cities c " +
            "INNER JOIN ja.employers e " +
            "WHERE e.id=:employerId AND ja.isActive=true")
    List<JobAdvertDto> getAllActiveAdsByEmployerId(int employerId);
}
