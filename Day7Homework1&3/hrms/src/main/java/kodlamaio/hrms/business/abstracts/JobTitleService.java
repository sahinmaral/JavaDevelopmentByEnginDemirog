package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService extends BaseService<JobTitle> {
    Result add(JobTitle jobTitle);
}
