package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobHistory;
import kodlamaio.hrms.entities.dtos.JobHistoryDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;

import java.util.List;

public interface JobHistoryService {
    Result add(JobHistory jobHistory);
    Result addOneByOne(List<JobHistory> jobHistories, Cv cv);
    DataResult<List<JobHistoryDto>> getAllByCandidateId(int candidateId);
}
