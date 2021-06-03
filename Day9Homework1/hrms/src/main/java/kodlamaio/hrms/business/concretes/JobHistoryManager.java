package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobHistoryService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobHistoryDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobHistory;
import kodlamaio.hrms.entities.dtos.JobHistoryDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryManager implements JobHistoryService {

    @Autowired
    public JobHistoryManager(JobHistoryDao jobHistoryDao) {
        this.jobHistoryDao = jobHistoryDao;
    }

    private JobHistoryDao jobHistoryDao;
    
    @Override
    public Result add(JobHistory jobHistory) {
        var jobHistorys = jobHistoryDao.findAll();
        jobHistoryDao.save(jobHistory);
        return new SuccessResult();
    }

    @Override
    public Result addOneByOne(List<JobHistory> jobHistorys, Cv cv) {
        for (var item : jobHistorys){
            item.setCv(cv);
            jobHistoryDao.save(item);
        }

        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobHistoryDto>> getAllByCandidateId(int candidateId) {
        var result = jobHistoryDao.getAllByCandidateId(candidateId);

        for(var item : result){
            if (item.getFinishedDate() == null)
                item.setStatus("Devam ediyor");
            else
                item.setStatus("İşten çıktı");
        }

        return new SuccessDataResult<>(result);
    }

}
