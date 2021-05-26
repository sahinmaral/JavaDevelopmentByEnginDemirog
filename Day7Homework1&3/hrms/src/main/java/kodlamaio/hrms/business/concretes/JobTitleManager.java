package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.CandidateValidator;
import kodlamaio.hrms.business.validationRules.JobTitleValidator;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobPositionDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(jobPositionDao.findAll());
    }

    @Override
    public Result add(JobTitle entity) {
        var titles = jobPositionDao.findAll();
        for (var tittle : titles)
        {
            if (entity.getTitle().equals(tittle.getTitle()))
                return new ErrorResult(Messages.TitleAlreadyAdded);
        }

        JobTitleValidator validator = new JobTitleValidator();
        Result[] validators = new Result[]{
                validator.isTitleFilled(entity.getTitle()),
        };

        for (var item : validators) {
            if (!item.isSuccess())
                return new ErrorResult(item.getMessage());
        }

        jobPositionDao.save(entity);
        return new SuccessResult(Messages.SuccessfullyAdded);
    }
}
