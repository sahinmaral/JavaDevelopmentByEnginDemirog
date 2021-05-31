package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDto;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertService extends BaseService<JobAdvert> {
    Result add(JobAdvert jobAdvert);
    Result disableById(int jobAdvertId);
    Result enableById(int jobAdvertId);
    DataResult<List<JobAdvert>> getActivatedAdverts();
    DataResult<JobAdvert> getById(int jobAdvertId);
    DataResult<List<JobAdvertDto>> getAllAdsByDetails();
    DataResult<List<JobAdvertDto>> getAllPassiveAdsByDetails();
    DataResult<List<JobAdvertDto>> getAllActiveAdsByDeadline(LocalDate deadline);
    DataResult<List<JobAdvertDto>> getAllActiveAdsByEmployerId(int employerId);
}
