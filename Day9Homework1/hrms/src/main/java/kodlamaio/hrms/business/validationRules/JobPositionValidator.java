package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import org.springframework.beans.factory.annotation.Autowired;

public class JobPositionValidator implements BaseValidator {

    @Autowired
    public JobPositionValidator(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    private JobPositionDao jobPositionDao;


    public Result isJobPositionExist(int jobPositionId){
        if (jobPositionDao.findById(jobPositionId).equals(null))
            return new SuccessResult();
        return new ErrorResult(Messages.JobPositionDoesntExist);
    }

}
