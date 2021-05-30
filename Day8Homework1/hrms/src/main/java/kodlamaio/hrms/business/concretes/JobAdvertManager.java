package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
    }

    private JobAdvertDao jobAdvertDao;

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findAll(),Messages.SuccessfullyRetrieved);
    }


    @Override
    public Result add(int advertId, short maxSalary, short minSalary, String city, LocalDate deadline, short countOfReceivableCandidate, String jobRequirements, int jobPositionId, boolean isActive) {
        JobAdvert jobAdvert = new JobAdvert();
        jobAdvert.setMaxSalary(maxSalary);
        jobAdvert.setMinSalary(minSalary);
        jobAdvert.setMaxSalary(maxSalary);
        jobAdvert.setMaxSalary(maxSalary);
        jobAdvert.setMaxSalary(maxSalary);
        jobAdvertDao.save(jobAdvert);
        return new SuccessResult(Messages.SuccessfullyAdded);
    }

    @Override
    public Result disableById(int jobAdvertId) {
        if (getById(jobAdvertId).getData().equals(null))
            return new ErrorResult(Messages.JobAdvertNotFound);

        var foundAdvert = getById(jobAdvertId).getData();
        foundAdvert.setActive(false);
        jobAdvertDao.save(foundAdvert);
        return new SuccessResult(Messages.JobAdvertDisabled);
    }

    @Override
    public DataResult<List<JobAdvert>> getActivatedAdverts() {
        return null;
    }

    @Override
    public DataResult<JobAdvert> getById(int jobAdvertId) {
        return new SuccessDataResult<JobAdvert>(jobAdvertDao.getById(jobAdvertId).getData());
    }
}
