package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {
    DataResult<JobAdvert> getById(int jobAdvertId);
}
