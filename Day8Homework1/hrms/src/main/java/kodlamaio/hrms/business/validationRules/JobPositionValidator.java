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

    public Result isTitleFilled(String title){
        if (title.equals(""))
            return new ErrorResult(Messages.FieldsNull);

        return new SuccessResult();
    }

    public Result isJobPositionExist(int jobPositionId){
        var jobPositions = jobPositionDao.findAll();
        for(var jobPosition : jobPositions){
            if (jobPosition.getId()==jobPositionId)
                return new SuccessResult();
        }

        return new ErrorResult(Messages.JobPositionDoesntExist);
    }

}
