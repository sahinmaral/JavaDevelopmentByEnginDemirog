package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition> {
    Result add(JobPosition jobPosition);
}
