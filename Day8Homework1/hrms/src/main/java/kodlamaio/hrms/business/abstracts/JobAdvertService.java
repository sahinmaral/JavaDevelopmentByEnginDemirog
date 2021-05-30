package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertService extends BaseService<JobAdvert> {
    Result add(int advertId, short maxSalary, short minSalary, String city,
               LocalDate deadline, short countOfReceivableCandidate,
               String jobRequirements, int jobPositionId, boolean isActive
    );
    Result disableById(int jobAdvertId);
    DataResult<List<JobAdvert>> getActivatedAdverts();
    DataResult<JobAdvert> getById(int jobAdvertId);
}
