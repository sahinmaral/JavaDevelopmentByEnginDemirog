package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.JobPositionValidator;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition entity) {
        var positions = jobPositionDao.findAll();
        for (var position : positions)
        {
            if (entity.getTitle().equals(position.getTitle()))
                return new ErrorResult(Messages.PositionAlreadyAdded);
        }

        JobPositionValidator validator = new JobPositionValidator(jobPositionDao);
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
